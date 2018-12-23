function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index) ;
        $.ajax({
            type: "post",
            url: "/borrow/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};
//审批记录查看
function history(id) {
    //process详见IProcess
    $("#historyModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/process/history",
        data: {dataId: id,process: 2},
        dataType: "json",
        success: function (data) {
            if(data.code==200){
                $("#history").empty() ;
                if(data.data.data!=null){
                    html="<div class='form-control'>" +
                        "<div class='col-sm-3 text-center'>节点</div>" +
                        "<div class='col-sm-3 text-center'>审批人</div>" +
                        "<div class='col-sm-3 text-center'>审批意见</div>" +
                        "<div class='col-sm-3 text-center'>审批时间</div>" ;
                    $("#history").append(html) ;
                    for(var i=0;i<data.data.data.length;i++){
                        html = "<div class='form-control'>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].name+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].user+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].desc+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].time+"</div>" +
                            "</div>" ;
                        $("#history").append(html) ;
                    }
                    html="</div>"
                    $("#history").append(html) ;
                }
            }else{
                layer.msg(data.msg) ;
            }
        }
    });
};
//flag=1审批页面，flag=0查看页面
function view(id,flag) {
    if(flag==1){
        $("#auditTrue").show();
        $("#auditFalse").hide();
    }else{
        $("#auditTrue").hide();
        $("#auditFalse").show();
    }
    $("#viewModal").modal('toggle');
    $("input[name='type1']").removeAttr("checked");
    $("input[name='type1']").parent().removeClass("checked") ;
    $.ajax({
        type: "post",
        url: "/borrow/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                // $("[name=" + attr + "1]").val(data.data.entity[attr]);
                $("[name=" + attr + "1][type!='radio']").val(data.data.entity[attr]);
                if(attr=="type"){
                    $("input[name='type1'][value='"+data.data.entity[attr]+"']").attr("checked","checked");
                    $("input[name='type1'][value='"+data.data.entity[attr]+"']").parent().addClass("checked");
                }
                if(attr=="affixName"){
                    $("#affixName1").html(data.data.entity[attr]) ;
                }
                if(attr=="affixLink"){
                    $("#affixLink1").attr("href",data.data.entity[attr]) ;
                }
            }
        }
    });
};
function approval(id) {
    $("#confirmModal").modal('toggle');
    $("input[name='type1']").removeAttr("checked");
    $("input[name='type1']").parent().removeClass("checked") ;
    $.ajax({
        type: "post",
        url: "/borrow/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "2][type!='radio']").val(data.data.entity[attr]);
                if(attr=="type"){
                    $("input[name='type2'][value='"+data.data.entity[attr]+"']").attr("checked","checked");
                    $("input[name='type2'][value='"+data.data.entity[attr]+"']").parent().addClass("checked");
                }
                if(attr=="affixName"){
                    $("#affixName2").html(data.data.entity[attr]) ;
                }
                if(attr=="affixLink"){
                    $("#affixLink2").attr("href",data.data.entity[attr]) ;
                }
            }
        }
    });
};
function repay(id){
    $("#repayModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/borrow/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "5][type!='radio']").val(data.data.entity[attr]);
            }
        }
    });
}
function repayConfirm(id){
    $("#repayConfirmModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/borrow/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "6][type!='radio']").val(data.data.entity[attr]);
            }
        }
    });
}
$(document).ready(function () {
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#editForm").validate({
        rules:{
            applyAmount:{number:true}
        },message:{
            applyAmount:{required: e + "请输入正确的借款金额"}
        }
    });
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
        $('#account_table_logs').setGridWidth(width);
    });

    //flag=1审批，否则查看
    if(getQueryString("id")==null||getQueryString("id")==""||getQueryString("id")==undefined){

    }else{
        view(getQueryString("id"),getQueryString("flag")) ;
    }

    $("#query_table_logs").jqGrid({
        url: '/borrow/listPg',
        datatype: "json",
        mtype: 'POST',
        postData: $("#queyrForm").serializeJson(), //发送数据
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
            {name: 'code', label: '借款编号', editable: true, width: 120},
            {name: 'title', label: '标题', editable: true, width: 180},
            {name: 'applyName', label: '申请人', editable: true, width: 60},
            {name: 'deptName', label: '所属部门', editable: true, width: 80},
            {name: 'type', label: '类型', editable: true, width: 60,
                formatter: function (value, grid, rows) {
                    if(rows.type==0){
                        return "<span style=''>备用金</span>" ;
                    }else if(rows.type==1){
                        return "<span style=''>其它</span>"  ;
                    }else{
                        return "" ;
                    }
                }},
            {name: 'applyAmount', label: '申请金额', editable: true, width: 60},
            {name: 'applyTime', label: '申请日期', editable: true, width: 120},
            {name: 'payAmount', label: '实付金额', editable: true, width: 60},
            {name: 'payTime', label: '支付日期', editable: true, width: 120},
            {name: 'taskId', label: 'taskId', editable: true,hidden:true, width: 80},
            {name: 'repayFlag', label: 'repayFlag', editable: true,hidden:true, width: 80},
            {name: 'state', label: 'state', editable: true,hidden:true, width: 80},
            {name: 'repaying', label: 'repaying', editable: true,hidden:true, width: 80},
            {name: 'repayFlag', label: 'repayFlag', editable: true,hidden:true, width: 80},
            {name: 'remark', label: '借款原因', editable: true, width: 150},
            {name: 'repayAmount', label: '已还金额', editable: true, width: 60},
            {name: 'state1', label: '状态', editable: true, width: 80,
                formatter:function (value, grid, rows) {
                    switch (rows.state) {
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
                name: 'operate', label: "操作", index: '', width: 180,
                formatter: function (value, grid, rows) {
                    var html = "" ;
                    if(rows.taskId!=null){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='history(" + rows.id + ")'>审批详情&nbsp;&nbsp;</a>";
                    }
                    html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view(" + rows.id + ",0)'>查看&nbsp;&nbsp;</a>";
                    if(rows.state==0||rows.state==-1){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='del(" + rows.id + ")'>删除&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==2){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='approval(" + rows.id + ")'>确认&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==1 && rows.repayFlag!=1 && rows.repaying!=1){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='repay(" + rows.id + ")'>还款&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==1 && rows.repaying==1){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='repayConfirm(" + rows.id + ")'>确认还款</a>";
                    }
                    return html ;
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
            var rowData = jQuery("#query_table_logs").jqGrid("getRowData", rowid);
            if(rowData.state==0||rowData.state==-1){
                //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
                edit(rowid);
            }
        }
    });

    $("#querySearch").click(function () {
        $("#query_table_logs").emptyGridParam() ;
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });
    $("#addBtn").click(function () {
        $("input[name='type']").removeAttr("checked");
        $("input[name='type']").parent().removeClass("checked") ;
        document.getElementById("editForm").reset();
        // $("input").val('');
        $("#editModal").modal('toggle');
        $(".save").show();
        $(".update").hide();
    })

    function edit(id) {
        $("#editModal").modal('toggle');
        $("input[name='type']").removeAttr("checked");
        $("input[name='type']").parent().removeClass("checked") ;
        $.ajax({
            type: "post",
            url: "/borrow/editAjax",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                for (var attr in data.data.entity) {
                    $("[name=" + attr + "][type!='radio']").val(data.data.entity[attr]);
                    if(attr=="type"){
                        $("input[name='type'][value='"+data.data.entity[attr]+"']").attr("checked","checked");
                        $("input[name='type'][value='"+data.data.entity[attr]+"']").parent().addClass("checked");
                    }
                    if(attr=="affixName"){
                        $("#affixName").html(data.data.entity[attr]) ;
                    }
                    if(attr=="affixLink"){
                        $("#affixLink").attr("href",data.data.entity[attr]) ;
                    }
                }
            }
        });
        $(".save").hide();
        $(".update").show();
    }

    // =========================================弹框选择账户信息======================================
    $("#account_table_logs").jqGrid({
        url: '/account/queryInnerAccountForUser',
        datatype: "json",
        mtype: 'POST',
        postData: $("#accountForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: false,
        autowidth: true,//自动匹配宽度
        //setLabel: "序号",
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: true,
        multiboxonly: true,
        beforeSelectRow: beforeSelectRow,
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
            {name: 'companyName', label: '公司名称', editable: true, width: 240},
            {name: 'name', label: '账户名称', editable: true, width: 240},
            {name: 'bankNo', label: '账号', editable: true, width: 240},
            {name: 'bankName', label: '开户行', editable: true, width: 240},
            {name: 'owner', label: '联系人', editable: true, width: 180},
        ],
        pager: jQuery("#account_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });

    //实现单选
    function beforeSelectRow() {
        $("#account_table_logs").jqGrid('resetSelection');
        return (true);
    }


    $("#accountSearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#account_table_logs").emptyGridParam() ;
        $("#account_table_logs").jqGrid('setGridParam', {
            postData: $("#accountForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#selAccount").click(function () {
        $("#accountModal").modal('toggle');
    });
    $(".cleanAccount").click(function () {
        $("#accountId").val("");
        $("#accountName").val("");
        $("#accountBankNo").val("");
        $("#accountBankName").val("");
    })

    $("#selectAccount").click(function () {
        var rowid = $("#account_table_logs").jqGrid("getGridParam", "selrow");     //获取选中行id
        var rowData = jQuery("#account_table_logs").jqGrid("getRowData", rowid);   //获取选中行信息
        $("#accountId").val(rowid);
        $("#accountName").val(rowData.name);
        $("#accountBankNo").val(rowData.bankNo);
        $("#accountBankName").val(rowData.bankName);
        $("#accountModal").modal('hide');
        document.getElementById("accountForm").reset();
    });

    //出账银行账户
    $("#selAccount2").click(function () {
        $("#accountModal2").modal('toggle');
    });
    loadAccountInfo2()
    function loadAccountInfo2() {
        $("#account_table_logs2").jqGrid({
            url: '/account/queryInnerAccount',
            datatype: "json",
            mtype: 'POST',
            postData: $("#innerAccount").serializeJson(), //发送数据
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
            multiselect: true,
            multiboxonly: true,
            beforeSelectRow: beforeSelectRow,
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
                {name: 'name', label: '账户名称', editable: true, width: 240},
                {name: 'owner', label: '账户户主', editable: true, width: 240},
                {name: 'bankNo', label: '银行账号', editable: true, width: 240},
                {name: 'bankName', label: '账号开户行', editable: true, width: 360},
                // {name: 'balance', label: '账号开户行', editable: true, width: 240},
                {name: 'id', label: 'id', editable: true, hidden: true, width: 0},
            ],
            pager: jQuery("#account_pager_logs2"),
            viewrecords: true,
            caption: "",
            add: false,
            edit: true,
            addtext: 'Add',
            edittext: 'Edit',
            hidegrid: false,
        });

        //实现单选
        function beforeSelectRow() {
            $("#account_table_logs2").jqGrid('resetSelection');
            return (true);
        }

        $("#accountSearch2").click(function () {
            $("#account_table_logs2").emptyGridParam() ;
            $("#account_table_logs2").jqGrid('setGridParam', {
                postData: $("#innerAccount").serializeJson(), //发送数据
            }).trigger("reloadGrid"); //重新载入
        });

        $(".cleanAccount2").click(function () {
            $("#outAccountId2").val("");
            $("#outAccountName2").val("");
        })

        $("#selectAccount2").click(function () {
            var rowid = $("#account_table_logs2").jqGrid("getGridParam", "selrow");     //获取选中行id
            var rowData = jQuery("#account_table_logs2").jqGrid("getRowData", rowid);   //获取选中行信息
            $("#outAccountId2").val(rowData.id);
            $("#outAccountName2").val(rowData.name);
            $("#accountModal2").modal('hide');
        });
    }

});


/*回车进行搜索*/
$(function () {
    $('body').bind('keyup', function (event) {
        if (event.keyCode == "13") {
            //回车执行查询
            $("#accountSearch2").click();
            $("#querySearch").click();
            $("#accountSearch").click();

        }
    });
});


// function checkRadio(){
//     var  radios = $("input:radio:checked").val();
//     if(radios==null || radios==""){
//         swal("未选中单选按钮");
//         return false;
//     }
//     return true;
// }


function submitHander(t, url) {
    if ($("#editForm").valid()) {
        layer.confirm('请确认借款信息？提交后不能取消！', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index);
            startModal("#" + t.id);//锁定按钮，防止重复提交
            //有图片添加传参
            var formData = new FormData($("#editForm")[0])
            $.ajax({
                type: "post",
                url: url,
                data: formData,
                dataType: "json",
                async: true,
                cache: false,
                contentType: false,
                processData: false,
                success: function(data) {
                    Ladda.stopAll() ;
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        $("#query_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#editModal").modal('hide');
                    }else{
                        layer.msg(data.msg) ;
                        $("#editModal").modal('hide');
                    }
                },
                error: function (data) {
                    Ladda.stopAll() ;
                    layer.msg(data.msg) ;
                }
            });
        }, function () {
            return;
        });

    }
}

function submitHander2(t, url) {
    if ($("#confirmForm").valid()) {
        var formData = {id:$("#id2").val(),
            outAccountId:$("#outAccountId2").val(),
            outAccountName:$("#outAccountName2").val(),
            payAmount:$("#payAmount2").val(),
            payTime:$("#payTime2").val()
        }

        layer.confirm('请确认借款信息？提交后不能取消！', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index);
            startModal("#" + t.id);//锁定按钮，防止重复提交
            $.ajax({
                type: "post",
                url: url,
                data: formData,
                dataType: "json",
                success: function(data) {
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        $("#query_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#confirmModal").modal('hide');
                    }else{
                        layer.msg(data.msg) ;
                        $("#confirmModal").modal('hide');
                    }
                }
            });
        }, function () {
            return;
        });
    }
}
//还款
function submitHander5(t, url) {
    var payAmount = $("#payAmount5").val() ;
    var repayAmount = $("#repayAmount5").val() ;
    var amount = $("#amount5").val() ;
    if(amount>(payAmount-repayAmount)){
        swal("还款金额过大！")
        return ;
    }
    if ($("#repayForm").valid()) {
        var formData = {id:$("#id5").val(),
            amount:$("#amount5").val(),
            repayRemark:$("#repayRemark5").val()
        };
        $.ajax({
            type: "post",
            url: url,
            data: formData,
            dataType: "json",
            success: function(data) {
                $("#repayModal").modal('hide');
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon:6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }
}
//还款确认
function submitHander6(t, url) {
    parent.layer.confirm('请确认还款信息？确认后不能取消！', {
        btn: ['确认', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        parent.layer.close(index) ;
        var formData = {id:$("#id6").val(),amount:$("#amount6").val()
        };
        $.ajax({
            type: "post",
            url: url,
            data: formData,
            dataType: "json",
            success: function(data) {
                $("#repayConfirmModal").modal('hide');
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon:6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }, function () {
        return;
    });
}
//还款驳回
function submitHander7(t, url) {
    parent.layer.confirm('请确认还款信息？确认后不能取消！', {
        btn: ['确认', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        parent.layer.close(index) ;
        var formData = {id:$("#id6").val()
        };
        $.ajax({
            type: "post",
            url: url,
            data: formData,
            dataType: "json",
            success: function(data) {
                $("#repayConfirmModal").modal('hide');
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon:6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }, function () {
        return;
    });
}
//审批通过
function approve(t){
    approveTask($("#taskId1").val(),1,t.id)
}

//审批驳回
function reject(t){
    approveTask($("#taskId1").val(),0,t.id)
}
