function del(id) {
    parent.layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        parent.layer.close(index);
        $.ajax({
            type: "post",
            url: "/supplier/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        window.location.href = "/media/supplier_manage";
                    }, 1000);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};

function accountManage(id, companyId, companyName) {
    alertEdit("/fee/queryAccount?op=supplier&supplierId=" + id + "&companyId=" + companyId + "&companyName=" + companyName, "账户管理");
};
$(document).ready(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_suppliers').setGridWidth(width);
    });
    $('body').bind('keyup', function (event) {
        if (event.keyCode == "13") {
            //回车执行查询
            $("#search").click();
        }
    });
    $("#table_suppliers").jqGrid({
        url: '/supplier/listall',
        datatype: "json",
        mtype: 'POST',
        postData: $("#supplier").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: true,
        setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: false,
        multiselectWidth: 25, //设置多选列宽度
        sortable: "true",
        sortname: "updateTime",
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,//每页显示记录数
        rowList: [10, 20, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },
        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'id', label: 'id', editable: false, width: 60, hidden: true},
            {name: 'mediaTypeId', label: '媒体类型', editable: false, width: 60},
            {name: 'name', label: '供应商名称', editable: true, width: 150},
            {name: 'desc', label: '供应商描述', editable: true, width: 100},
            {name: 'contactor', label: '联系人', editable: true, width: 100},
            {name: 'phone', label: '联系电话', editable: true, width: 100},
            {name: 'qqwechat', label: '联系QQ/微信', editable: true, width: 100},
            {name: 'contactorDesc', label: '联系人描述', editable: true, width: 100},
            {name: 'creator', label: '登记者', editable: true, width: 100},
            {name: 'createTime', label: '登记时间', editable: true, width: 100},
            //{name: 'updateUser', label: '更新者', editable: true, width: 100},
            {name: 'updateTime', label: '更新时间', editable: true, width: 100},
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows, state) {
                    var sName = rows.name;
                    var de = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='del(" + rows.id + ")'>删除</a>";
                    var le = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='accountManage(" + rows.id + "," + rows.id + ",\"" + sName + "\")'>账户管理</a>";
                    return "     " + de + "    " + le + "    ";
                }
            }
        ],
        pager: jQuery("#pager_suppliers"),
        viewrecords: true,
        caption: "供应商列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            //page('/role/view?id=' + rowid, '角色详情');
            // var rowid = $("#supplier_table_logs").jqGrid("getGridParam", "selrow");     //获取选中行id
            var rowData = jQuery("#table_suppliers").jqGrid("getRowData", rowid);   //获取选中行信息
            //page('/media/supplier_edit?op=edit&supplierId=' + rowData.id+"&mediaTypeId="+rowData.mediaTypeId, '供应商编辑'+rowid);
            alertEdit('/media/supplier_edit?op=edit&supplierId=' + rowData.id + "&mediaTypeId=" + rowData.mediaTypeId, '供应商编辑' + rowid);
        },
    });

    $("#search").click(function () {
        //alert(JSON.stringify($("#supplier").serializeJson()));
        $("#table_suppliers").emptyGridParam();
        $("#table_suppliers").jqGrid('setGridParam', {
            postData: $("#supplier").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#table_suppliers").setSelection(4, true);
    $("#table_suppliers").jqGrid('navGrid', '#pager_suppliers', {
        edit: false,
        add: false,
        del: false,
        search: false

    }, {
        height: 200,
        reloadAfterSubmit: true
    });
    $("#addSupplier").click(function () {
        alertEdit('/media/supplier_edit?op=create', '新增媒体供应商');
        //$("#search").click();
    })

});

// 重新载入数据；
function reloadSupplierData() {
    $("#table_suppliers").emptyGridParam();
    $("#table_suppliers").jqGrid('setGridParam', {
        postData: $("#supplier").serializeJson()
    }).trigger("reloadGrid");
}