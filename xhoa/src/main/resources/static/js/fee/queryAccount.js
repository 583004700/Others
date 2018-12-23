function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index) ;
        $.ajax({
            type: "post",
            url: "/account/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        DockingPeopleAccount.reflush();
                    }, 1000);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {

    });
};

function view(id) {
    $("#viewModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/account/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            $(".inner").hide();
            for (var attr in data.data.entity) {
                $("[name=" + attr + "1]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
                if(attr=="type"){
                    // console.log()
                    if(data.data.entity[attr]==1){
                        // swal("dfd2")
                        $(".inner").show();
                    }
                }
            }
            var arr = data.data.list ;
            if(arr.length>0){
                $("#selectedDept1").empty() ;
                for(var i=0;i<arr.length;i++){
                    var html = '<tr id="row_' + arr[i].id + '"><td>' +
                        '<input type="hidden"  id="deptId_'+arr[i].id+'" value="'+arr[i].id+'">' +
                        '<input type="hidden"  id="deptName_'+arr[i].id+'" value="'+arr[i].name+'">'+arr[i].name+'' +
                        '</td></tr>';
                    $("#selectedDept1").append(html) ;
                }
            }
        }
    });
};

//得到查询参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  decodeURIComponent(r[2]); return null;
}
//对接人账号操作
DockingPeopleAccount = {
    op:getQueryString("op"),
    init: function(){
        var dockingId = getQueryString("dockingId") || "";
        var companyId = getQueryString("companyId") || "";
        var companyName = getQueryString("companyName") || "";
        var type = 3;
        $("[name='dockingId']").val(dockingId);
        $("[name='type']").val(type);
        $("[name='typeQc']").val(type);
        $("[name='companyName']").val(companyName);
        $("[name='companyNameQc']").val(companyName);
        $("[name='companyId']").val(companyId);
        $(".inner").hide() ;
    },
    reflush:function(){
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    }
};
//供应商账号操作
SupplierAccount = {
    op:getQueryString("op"),
    init: function(){
        var supplierId = getQueryString("supplierId") || "";
        var companyId = getQueryString("companyId") || "";
        var companyName = getQueryString("companyName") || "";
        var type = 2;
        $("[name='type']").val(type);
        $("[name='companyName']").val(companyName);
        $("[name='companyNameQc']").val(companyName);
        $("[name='companyId']").val(companyId);
        $(".inner").hide() ;
    }
};

$(document).ready(function () {
    //来源于对接人的账号添加
    if(DockingPeopleAccount.op == "docking"){
        DockingPeopleAccount.init();
    }
    //来源于对接人的账号添加
    if(SupplierAccount.op == "supplier"){
        SupplierAccount.init();
    }

    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
    });


    $("#accountForm").validate({
        rules:{
            phone: {checkPhone: true},
        }

    });
    $.validator.addMethod("checkPhone", function (value, element, params) {
        var checkPhone = /^(([0]\d{2,3}-\d{7,8})|([1]\d{10}))$/;
        return this.optional(element) || (checkPhone.test(value));
    }, "请输入正确的手机号码！");



    $("#query_table_logs").jqGrid({
        url: '/account/listPg',
        datatype: "json",
        mtype: 'POST',
        postData: $("#queryForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: false,
        //setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: false,
        multiselectWidth: 25, //设置多选列宽度
        sortable: "true",
        sortname: "id",
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,//每页显示记录数
        rowList: [10, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },
        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'type', label: '账户类型', editable: true, width: 60,
                formatter:function(a, b, rowdata){
                    var tmp = rowdata.type;
                    if(tmp==0){
                        return "<span style=''>未指定</span>"
                    }else if(tmp==1){
                        return "<span style='color: red;'>公司账户</span>"
                    }else if(tmp==2){
                        return "<span style='color: blue;'>供应商账户</span>"
                    }else if(tmp==3){
                        return "<span style=''>客户账户</span>"
                    }else if(tmp==4){
                        return "<span style=''>个人账户</span>"
                    }
                }
            },
            {name: 'companyName', label: '公司名称', editable: true, width: 120},
            {name: 'name', label: '账户名称', editable: true, width: 120},
            {name: 'bankNo', label: '账号', editable: true, width: 120},
            {name: 'bankName', label: '开户行', editable: true, width: 120},
            {name: 'owner', label: '户主', editable: true, width: 60},
            {name: 'deptNames', label: '所属部门', editable: true, width: 180},
            {name: 'state', label: '状态', editable: true, width: 120,
                formatter:function (value) {
                    switch (value) {
                        case -1 :
                            return "<span style='color:red'>审核驳回</span>";
                        case 0 :
                            return "<span style=''>已保存</span>";
                        case 1 :
                            return "<span style=''>已完成</span>";
                        case 2 :
                            return "<span style='color:red'>审核通过</span>";
                        case 3 :
                            return "<span style='color:red'>组长审核</span>";
                        case 4 :
                            return "<span style='color:red'>部长审核</span>";
                        case 5 :
                            return "<span style='color:red'>总监审核</span>";
                        case 6 :
                            return "<span style='color:red'>财务总监审核</span>";
                        case 7 :
                            return "<span style='color:red'>副总经理审核</span>";
                        case 8 :
                            return "<span style='color:red'>总经理审核</span>";
                        case 9 :
                            return "<span style='color:red'>会计审核</span>";
                        case 10 :
                            return "<span style='color:red'>业务员确认</span>";
                    }
                }
            },
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows, state) {
                    var html = "" ;
                    html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view(" + rows.id + ")'>查看&nbsp;&nbsp;</a>";
                    // if(rows.type==1){
                    //     html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: blue'  onclick='approve(" + rows.id + ")'>账户详情</a>";
                    // }
                    // if(rows.type==1){
                    //     html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: blue'  onclick='relate(" + rows.id + ")'>关联部门</a>";
                    // }
                    html+="<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='del(" + rows.id + ")'>删除</a>";
                    return html;
                }
            }
        ],
        pager: jQuery("#query_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            edit(rowid);
            // page('/account/edit?id=' + rowid, '账户编辑');
        },
    });

    // $.validator.addMethod("checkPhone", function (value, element, params) {
    //     var checkPhone = /^(([0]\d{2,3}-\d{7,8})|([1]\d{10}))$/;
    //     return this.optional(element) || (checkPhone.test(value));
    // }, "请输入正确的手机号码！");

    $("#search").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#query_table_logs").emptyGridParam() ;
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });


    // $("#save").click(function () {
    //     var phone=$("#phone").val();
    //     if (phone==""){
    //         $("#tip").html("提示")
    //     }
    //     else{
    //         if(telRuleCheck(phone)){
    //             $("#tip").html("")
    //             return;
    //         }
    //         else {
    //             $("#tip").html("格式不正确");
    //             return;
    //         }
    //     }
    //
    // });

    $("#addBtn").click(function () {
        document.getElementById("accountForm").reset();
        $("[name='type']").val(1);
        $("[name='companyName']").val("祥和文化传播有限公司");
        $("[name='companyNameQc']").val("祥和文化传播有限公司");
        $("[name='companyId']").val(0);
        if(DockingPeopleAccount.op == "docking"){
            DockingPeopleAccount.init();
        }
        if(SupplierAccount.op == "supplier"){
            SupplierAccount.init();
        }
        // $("input").val('');
        $("#editModal").modal('toggle');
        $("#save").show();
        $("#update").hide();
        $(".inner").hide();
    })

    function edit(id) {
        $("#editModal").modal('toggle');
        $.ajax({
            type: "post",
            url: "/account/editAjax",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                $(".inner").hide();
                for (var attr in data.data.entity) {
                    $("[name=" + attr + "]").val(data.data.entity[attr]);
                    if(attr=="type"){
                        if($("#type").val()==1){
                            // swal("dfd2")
                            $(".inner").show();
                        }
                    }

                }
                var arr = data.data.list
                $("#selectedDept").empty() ;
                if(arr.length>0){
                    for(var i=0;i<arr.length;i++){
                        var html = '<tr id="row_' + arr[i].id + '"><td>' +
                            '<input type="hidden"  id="deptId_'+arr[i].id+'" value="'+arr[i].id+'">' +
                            '<input type="hidden"  id="deptName_'+arr[i].id+'" value="'+arr[i].name+'">'+arr[i].name+'' +
                            '&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" id="button_"+'+arr[i].id+'  onclick="delDept('+arr[i].id+')">x</button></td></tr>';
                        $("#selectedDept").append(html) ;
                    }
                }
            }
        });
        $("#save").hide();
        $("#update").show();
    }


    $(".selCompany").click(function () {
        $("#companyModal").modal('toggle');
    });


    $("#selDept").click(function () {
        $("#deptModal").modal('toggle') ;
    })
    $("#cleanDept").click(function () {
        $("#deptId").val("") ;
        $("#deptName").val("") ;
    })
    $('#treeview').treeview({
        data: [getTreeData()],
        onNodeSelected: function(event, data) {
            // console.log(data);
            $.ajax({
                type: "post",
                url: "/account/insertAccountDept",
                data: {accountId: $("#id").val(),deptId:data.id},
                dataType: "json",
                success: function (retData) {
                    if(retData.code==200){
                        // $("#selectedDept").empty() ;
                        var html = '<tr id="row_' + data.id + '"><td>' +
                            '<input type="hidden"  id="deptId_'+data.id+'" value="'+data.id+'">' +
                            '<input type="hidden"  id="deptName_'+data.id+'" value="'+data.text+'">'+data.text+'' +
                            '&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" id="button_"+'+data.id+'  onclick="delDept('+data.id+')">x</button></td></tr>';
                        $("#selectedDept").append(html) ;
                        $("#deptModal").modal('hide') ;
                        $("#query_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                    }else{
                        layer.msg(retData.msg) ;
                    }

                }
            });
        }
    });
});
function delDept(deptId){
    // console.log("#row_"+deptId)
    $.ajax({
        type: "post",
        url: "/account/deleteAccountDept",
        data: {accountId: $("#id").val(),deptId:deptId},
        dataType: "json",
        success: function (data) {
            if(data.code==200){
                $("#row_"+deptId).remove() ;
                $("#query_table_logs").jqGrid('setGridParam', {
                    postData: $("#queryForm").serializeJson(), //发送数据
                }).trigger("reloadGrid"); //重新载入
            }else{
                layer.msg(data.data.msg) ;
            }

        }
    });

}
function submitHander(t,url) {
    if ($("#accountForm").valid()) {
        // alert($("#form").serialize());
        var param = $("#accountForm").serializeJson();
        startModal("#"+t.id);//锁定按钮，防止重复提交
        // startModal("#update");//锁定按钮，防止重复提交
        // alert(JSON.stringify(param));
        $.ajax({
            type: "post",
            url: url,
            data: param,
            dataType: "json",
            success: function (data) {
                Ladda.stopAll();   //解锁按钮锁定
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon: 6}) ;
                    document.getElementById("queryForm").reset() ;
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                    $("#editModal").modal('hide');
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }
}

function getTreeData() {
    var deptTreeData = {};
    $.ajax({
        type: "POST",
        url:"/dept/listForTreeView",
        dataType:"json",
        async: false,
        success:function(result) {
            var arrays= result.data.list;
            deptTreeData = arrays[0];
        }
    });
    // console.log(JSON.stringify(deptTreeData))
    return deptTreeData;
}


// telRuleCheck=function(String){
//     var pattern=/^1[34578]\d{9}$/;
//     if (pattern.test(String)){
//         return true;
//     }
//     console.log('check moble phone'+String+'failed')
// };