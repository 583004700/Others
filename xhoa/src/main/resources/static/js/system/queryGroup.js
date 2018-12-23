function del(id){
    layer.confirm('确认删除？', {
        btn: ['删除','取消'], //按钮
        shade: false //不显示遮罩
    }, function(){
        $.ajax({
            type: "post",
            url: "/group/del",    //向后端请求数据的url
            data: {id:id},
            dataType:"json",
            success: function (data) {
                if(data.code=200){
                    layer.msg(data.data.message, {time: 1000, icon:6});
                    setTimeout(function(){
                        window.location.href="/system/queryGroup" ;
                    },1000);
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }, function(){
        return ;
    });
};
//选中行启用行编辑
// function EditSelectRow(id)
// {
//     //原选中行ID
//     var oldSelectRowId = $("#selectRowId").val();
//     if (oldSelectRowId != null && oldSelectRowId != "" && oldSelectRowId.length > 0) {
//         $("#fieldGrid").jqGrid('saveRow', oldSelectRowId);//保存上一行
//     }
//
//     //当前选中行
//     $("#selectRowId").val(id);//临时存储当前选中行
//     //$("#fieldGrid").jqGrid('editRow', id);
//     $("#fieldGrid").jqGrid('editRow', id, { keys: true, focusField: 1 });
// }

function edit(id) {
    $("#editModal").modal('toggle');
    $(".update").show();
    $(".save").hide();
    $.ajax({
        type: "post",
        url: "/group/edit",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            if(data.code=200){
                for (var attr in data.data.group) {
                    $("[name=" + attr + "]").val(data.data.group[attr]);
                }
            }else{
                layer.msg(data.msg);
            }
        }
    });

}

$(document).ready(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_logs').setGridWidth(width);
    });


    $("#table_logs").jqGrid({
        url: '/group/listPg',
        datatype: "json",
        mtype: 'post',
        postData:$("#group").serializeJson(), //发送数据
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
        sortname: "id" ,
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
            {name: 'name',label: '组名称',editable: true,edittype:"text",width: 60},
            {name: 'operate',label:"操作", index: '',
                formatter: function (value, grid, rows, state) {
                    var be = '<a style="color:#f60" onclick="ck(${id})">查看</a>';
                    be = be.replace("${id}",rows.id);
                    //var se = '<a href="/role/del?id='+rows.id+'" style="color:#f60" >删除</a>';
                    var se = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='del(" + rows.id + ")'>删除</a>";

                    return "     "+be +"     "+ se +"    ";
                }
            }
        ],
        pager: jQuery("#pager_logs"),
        viewrecords: true,
        caption: "权限组列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            //page('/role/view?id=' + rowid, '角色详情');
            edit(rowid)
        },
        // $("#fieldGrid").jqGrid({
        //     onSelectRow: EditSelectRow,
        //     pager: "#fieldGridPager",
        // });
    });

    $("#search").click(function(){
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#table_logs").emptyGridParam() ;
        $("#table_logs").jqGrid('setGridParam',{
            postData:$("#group").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    tijiao = function(t,url){
        if ($("#form").valid()) {
            layer.confirm('确认权限组信息？', {
                btn: ['确定', '取消'], //按钮
                shade: false //不显示遮罩
            }, function (index) {
                layer.close(index);
                startModal("#"+t.id);
                $.ajax({
                    type: "post",
                    url: url,
                    data: $("#form").serializeJson(),
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 200) {
                            Ladda.stopAll();
                            layer.msg(data.data.message, {time: 1000, icon: 6});
                            $("#table_logs").jqGrid('setGridParam',{
                                postData:$("#group").serializeJson(), //发送数据
                            }).trigger("reloadGrid"); //重新载入
                            $("#editModal").modal("hide");
                        } else {
                            layer.msg(data.msg);
                            $("#editModal").modal("hide");
                        }
                    },
                    error:function (data) {
                        Ladda.stopAll();
                        layer.msg(data.msg);
                    }
                });
            }, function () {
                return;
            });
        }

    }
});

function ck(id){
    view(id);
}

function add() {
    //清除验证标签
    $("#form").find("input").removeClass('error');
    $("#form").validate().resetForm();
    $("#editModal").modal('toggle');
    $(".save").show();
    $(".update").hide();
    document.getElementById("form").reset();
}

function view(id) {
    $("#viewModal").modal('toggle');
        $.ajax({
            type: "post",
            url: "/group/edit",
            data: {id: id},
            dataType: "json",
            success: function (recData) {
                for (var attr in recData.data.group) {
                    $("[name=" + attr + "2]").val(recData.data.group[attr]);
                }
            }
        });
}
// 验证
/*$.validator.setDefaults({
    highlight: function (e) {
        $(e).closest(".form-group").removeClass("has-success").addClass("has-error")
    }, success: function (e) {
        e.closest(".form-group").removeClass("has-error").addClass("has-success")
    }, errorElement: "span", errorPlacement: function (e, r) {
        e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent())
    }, errorClass: "help-block m-b-none", validClass: "help-block m-b-none"
}),*/
