function del(id) {
    parent.layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function () {
        $.ajax({
            type: "post",
            url: "/reimburse/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        window.location.href = "/fee/queryReimburse";
                    }, 1000);
                    // layer.msg(data.data.message);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};

function view(id) {
    $("#viewModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/reimburse/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
        }
    });
};
$(document).ready(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#reimburse_table_logs').setGridWidth(width);
    });
    $("#reimburse_table_logs").jqGrid({
        url: '/reimburse/listPg',
        datatype: "json",
        mtype: 'POST',
        postData: $("#queyrReimburse").serializeJson(), //发送数据
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
            {name: 'accountName', label: '账户名称', editable: true, width: 240},
            {name: 'bankNo', label: '银行账号', editable: true, width: 240},
            // {name: 'tradeTime',index: 'tradeTime', label: '进账日期',editable: true,width: 180,formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
            {
                name: 'tradeTime', index: 'tradeTime', label: '进账日期', editable: true, width: 180,
            },
            {name: 'tradeMan', label: '进账人', editable: true, width: 120},
            {name: 'tradeBank', label: '进账银行账号', editable: true, width: 180},
            {name: 'tradeAmount', label: '进账金额', editable: true, width: 120},
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows, state) {
                    var be = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view(" + rows.id + ")'>查看</a>";
                    // var be = '<a href="/fee/viewAccount?id='+rows.id+'" style="color:#f60" >查看</a>';
                    //var se = '<a href="/role/del?id='+rows.id+'" style="color:#f60" >删除</a>';
                    var de = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='del(" + rows.id + ")'>删除</a>";
                    return "     " + be + "     " + de + "        ";
                }
            }
        ],
        pager: jQuery("#reimburse_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            //page('/role/view?id=' + rowid, '角色详情');
            edit(rowid);
            // page('/fee/editReimburse?id=' + rowid, '角色编辑');
        },
        loadComplete: function (data) {
            if (getResCode(data))
                return;
            console.log(JSON.stringify(data))
        }
    });

    $("#reimburseSearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#reimburse_table_logs").emptyGridParam() ;
        $("#reimburse_table_logs").jqGrid('setGridParam', {
            postData: $("#queryReimburse").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#reimburse_table_logs").setSelection(4, true);
    $("#reimburse_table_logs").jqGrid('navGrid', '#reimburse_pager_logs', {
        edit: false,
        add: false,
        del: false,
        search: false

    }, {
        height: 200,
        reloadAfterSubmit: true
    });
    $("#addBtn").click(function () {
        document.getElementById("reimburseForm").reset();
        // $("input").val('');
        $("#editModal").modal('toggle');
        $(".save").show();
        $(".update").hide();
    })

    function edit(id) {
        $("#editModal").modal('toggle');
        $.ajax({
            type: "post",
            url: "/reimburse/editAjax",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                for (var attr in data.data.entity) {
                    $("[name=" + attr + "]").val(data.data.entity[attr]);
                }
            }
        });
        $(".save").hide();
        $(".update").show();
    }

    // =========================================弹框选择账户信息======================================
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#account_table_logs').setGridWidth(width);
    });
    $("#account_table_logs").jqGrid({
        url: '/account/listPgForReimburse',
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
            {name: 'companyName', label: '公司名称', editable: true, width: 180},
            {name: 'name', label: '账户名称', editable: true, width: 120},
            {name: 'bankNo', label: '账号', editable: true, width: 120},
            {name: 'bankName', label: '开户行', editable: true, width: 120},
            {name: 'bankNameDetail', label: '开户行支行', editable: true, width: 180},
            {name: 'owner', label: '联系人', editable: true, width: 120},
            {name: 'deptName', label: '所属部门', editable: true, width: 180}
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

    $("#account_table_logs").setSelection(4, true);
    $("#account_table_logs").jqGrid('navGrid', '#account_pager_logs', {
        edit: false,
        add: false,
        del: false,
        search: false

    }, {
        height: 200,
        reloadAfterSubmit: true
    });

    $(".selAccount").click(function () {
        $("#accountModal").modal('toggle');
    });
    $(".cleanAccount").click(function () {
        $("#accountId").val("");
        $("#accountName").val("");
        $("#bankNo").val("");
    })

    $(".selected").click(function () {
        var rowid = $("#account_table_logs").jqGrid("getGridParam", "selrow");     //获取选中行id
        var rowData = jQuery("#account_table_logs").jqGrid("getRowData", rowid);   //获取选中行信息
        $("#accountId").val(rowid);
        $("#accountName").val(rowData.name);
        $("#bankNo").val(rowData.bankNo);
        $("#accountModal").modal('hide');
        document.getElementById("accountForm").reset();
    });

});

function submitHander(t, url) {
    if ($("#reimburseForm").valid()) {
        // alert($("#form").serialize());
        var param = $("#reimburseForm").serializeJson();
        startModal("#" + t.id);//锁定按钮，防止重复提交
        // startModal("#update");//锁定按钮，防止重复提交
        // alert(JSON.stringify(param));
        $.ajax({
            type: "post",
            url: url,
            data: param,
            dataType: "json",
            success: function (data) {
                Ladda.stopAll();   //解锁按钮锁定
                $("#reimburse_table_logs").jqGrid('setGridParam', {
                    postData: $("#queryForm").serializeJson(), //发送数据
                }).trigger("reloadGrid"); //重新载入
                $("#editModal").modal('hide');
            }
        });
    }
}