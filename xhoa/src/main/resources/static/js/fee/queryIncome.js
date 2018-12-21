function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index)
        $.ajax({
            type: "post",
            url: "/income/del",    //向后端请求数据的url
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

function checkNumber(theObj) {
    var reg = /^[1-9](\d+)?(\.\d{1,4})?$/;
    if (reg.test(theObj)) {
        return true;
    }
    return false;
}
function receiveIncome(id,tradeAmount,unclaimedAmount) {
    $("#id2").val(id) ;
    $("#tradeAmount2").val(tradeAmount) ;
    $("#unclaimedAmount2").val(unclaimedAmount) ;
    $("#receiveModel").modal('toggle');
};
function returnIncome(id) {
    parent.layer.confirm('您确定要退回请款？', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        parent.layer.close(index)
        $.ajax({
            type: "post",
            url: "/income/returnIncome",    //向后端请求数据的url
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
function view(id) {
    $("#viewModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/income/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "1]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
            $("#selected_article_table_logs1").jqGrid('setGridParam', {
                postData: {id:id}, //发送数据
            }).trigger("reloadGrid"); //重新载入
            $("#selected_article_table_logs1").jqGrid({
                url: '/income/listPgForSelectedArticle',
                datatype: "json",
                mtype: 'POST',
                postData: {id:id}, //发送数据
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
                // multiboxonly: true,
                // beforeSelectRow: beforeSelectRow,
                multiselectWidth: 25, //设置多选列宽度
                sortable: "true",
                sortname: "id",
                sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
                shrinkToFit: true,
                prmNames: {rows: "size"},
                rowNum: 10,//每页显示记录数
                rowList: [10, 20, 50],//分页选项，可以下拉选择每页显示记录数
                jsonReader: {
                    root: "list", page: "pageNum", total: "pages",
                    records: "total", repeatitems: false, id: "id"
                },
                // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
                colModel: [
                    {name: 'code', label: '进款编号', editable: true, width: 120},
                    {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
                    {name: 'no', label: '订单编号', editable: true, width: 120},
                    {name: 'userName', label: '业务员', editable: true, width: 60},
                    {name: 'mediaUserName', label: '媒介', editable: true, width: 60},
                    {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
                    {name: 'mediaName', label: '媒体名称', editable: true, width: 80},
                    {name: 'title', label: '标题', editable: true, width: 120},
                    {name: 'link', label: '链接', editable: true, width: 120},
                    {name: 'saleAmount', label: '报价', editable: true, width: 80},
                    {name: 'incomeAmount', label: '分款金额', editable: true, width: 80}
                ],
                pager: jQuery("#selected_article_pager_logs1"),
                caption: "",
                add: false,
                edit: true,
                addtext: 'Add',
                edittext: 'Edit',
                hidegrid: false,
            });
            $("#income_user_table_logs").jqGrid('setGridParam', {
                postData: {id:id}, //发送数据
            }).trigger("reloadGrid"); //重新载入
            $("#income_user_table_logs").jqGrid({
                url: '/income/listPgIncomeUserByIncomeId',
                datatype: "json",
                mtype: 'POST',
                postData: {id:id}, //发送数据
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
                // multiboxonly: true,
                // beforeSelectRow: beforeSelectRow,
                multiselectWidth: 25, //设置多选列宽度
                sortable: "true",
                sortname: "id",
                sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
                shrinkToFit: true,
                prmNames: {rows: "size"},
                rowNum: 10,//每页显示记录数
                rowList: [10, 20, 50],//分页选项，可以下拉选择每页显示记录数
                jsonReader: {
                    root: "list", page: "pageNum", total: "pages",
                    records: "total", repeatitems: false, id: "id"
                },
                // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
                colModel: [
                    {name: 'name', label: '领款人姓名', editable: true, width: 120},
                    {name: 'deptName', label: '部门', editable: true, width: 120},
                    {name: 'receiveAmount', label: '领款金额', editable: true, width: 120},
                    {name: 'assignAmount', label: '已分款金额', editable: true, width: 120},
                    {name: 'remainAmount', label: '剩余金额', editable: true, width: 120},
                    {name: 'receiveTime', label: '领款日期', editable: true, width: 240,
                        formatter:function (d) {
                            return new Date(d).format("yyyy-MM-dd hh:mm:ss");
                        }
                    },
                ],
                pager: jQuery("#income_user_pager_logs"),
                caption: "",
                add: false,
                edit: true,
                addtext: 'Add',
                edittext: 'Edit',
                hidegrid: false,
            });
        }
    });

};
$(document).ready(function () {
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#queryForm").validate({
        rules:{
            tradeAmountQc:{number:true}
        },message:{
            tradeAmountQc:{required: e + "请输入正确的进款金额"}
        }
    });
    $("#editForm").validate({
        rules:{
            tradeAmount:{number:true}
        },message:{
            tradeAmount:{required: e + "请输入正确的进款金额"}
        }
    });
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
        $('#account_table_logs').setGridWidth(width);
        $('#assign_table_logs').setGridWidth(width);
        $('#selected_article_table_logs1').setGridWidth(width);
        $('#income_user_table_logs').setGridWidth(width);
    });
    $("#query_table_logs").jqGrid({
        url: '/income/listPg',
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
            {name: 'id', label: 'id', editable: true, hidden:true,width: 60},
            {name: 'code', label: '进账编号', editable: true, width: 120},
            {name: 'account_name', label: '账户名称', editable: true, width: 180},
            {name: 'bank_no', label: '银行账号', editable: true, width: 160},
            // {name: 'tradeTime',index: 'tradeTime', label: '进账日期',editable: true,width: 180,formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
            {name: 'trade_time', index: 'tradeTime', label: '进账日期', editable: true, width: 120,formatter: function (d) {
                    return new Date(d).format("yyyy-MM-dd hh:mm");
                }},
            {name: 'trade_man', label: '进账人', editable: true, width: 80},
            {name: 'trade_bank', label: '进账银行账号', editable: true, width: 160},
            {name: 'trade_amount', label: '进账金额', editable: true, width: 80},
            {name: 'unclaimed_amount', label: '未领金额', editable: true, width: 80},
            {name: 'preclaimed_amount', label: '预领金额', editable: true, width: 80},
            {name: 'receiveInfo', label: '领款人姓名', editable: true, width: 240},
            {
                name: 'operate', label: "操作", index: '', width: 180,
                formatter: function (value, grid, rows) {
                    var html = "" ;
                    html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view(" + rows.id + ")'>查看&nbsp;&nbsp;</a>";
                    if(rows.unclaimed_amount>0){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;color: blue;'  onclick='receiveIncome(" + rows.id + ","+rows.trade_amount+","+rows.unclaimed_amount+")'>领款&nbsp;&nbsp;</a>";
                    }
                    if(rows.preclaimed_amount>0){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;color: blue;'  onclick='returnIncome(" + rows.id + ")'>领款退回&nbsp;&nbsp;</a>";
                    }
                    if(rows.preclaimed_amount==0||rows.preclaimed_amount==0.0){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;color: red;'  onclick='del(" + rows.id + ")'>删除&nbsp;&nbsp;</a>";
                    }
                    return html;
                },
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
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            edit(rowid);
        },
    });



    $("#receive").click(function () {
        var id = $("#id2").val() ;
        var unclaimedAmount = $("#unclaimedAmount2").val() ;
        var preclaimedAmount = $("#preclaimedAmount2").val() ;
        if(checkNumber(preclaimedAmount)){
            if(parseFloat(unclaimedAmount)<parseFloat(preclaimedAmount)){
                swal("金额过大！") ;
                return ;
            }else{
                $.ajax({
                    type: "post",
                    url: "/income/receive",    //向后端请求数据的url
                    data: {id: id,amount:preclaimedAmount},
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 200) {
                            layer.msg(data.data.message, {time: 1000, icon: 6});
                            $("#query_table_logs").jqGrid('setGridParam', {
                                postData: $("#queryForm").serializeJson(), //发送数据
                            }).trigger("reloadGrid"); //重新载入
                            $("#receiveModel").modal('hide');
                            document.getElementById("receiveForm").reset() ;
                        } else {
                            layer.msg(data.msg);
                        }
                    }
                });
            }
        }else{
            swal("请输入数字！")
            return ;
        }
    })
    $("#querySearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#query_table_logs").emptyGridParam() ;
        $("#query_table_logs").jqGrid('setGridParam', {
        postData: $("#queryForm").serializeJson(), //发送数据
    }).trigger("reloadGrid"); //重新载入
    });
    $("#addBtn").click(function () {
        document.getElementById("editForm").reset();
        // $("input").val('');
        $("#editModal").modal('toggle');
        $(".save").show();
        $(".update").hide();
    })



    function edit(id) {
        $("#editModal").modal('toggle');
        $.ajax({
            type: "post",
            url: "/income/editAjax",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                //data.data.entity==ResponseData.data.entity
                for (var attr in data.data.entity) {
                    $("[name=" + attr + "]").val(data.data.entity[attr]);
                }
            }
        });
        $(".save").hide();
        $(".update").show();
    }

    // =========================================弹框选择账户信息======================================
    $("#account_table_logs").jqGrid({
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
            {name: 'id', label: 'id', editable: true,hidden: true, width: 0},
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
        $("#account_table_logs").emptyGridParam() ;
        $("#account_table_logs").jqGrid('setGridParam', {
            postData: $("#innerAccount").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#selAccount").click(function () {
        $("#accountModal").modal('toggle');
    });
    $(".cleanAccount").click(function () {
        $("#accountId").val("");
        $("#accountName").val("");
        $("#bankNo").val("");
    })

    $("#selectAccount").click(function () {
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
    if ($("#editForm").valid()) {
        var param = $("#editForm").serializeJson();
        startModal("#" + t.id);//锁定按钮，防止重复提交
        $.ajax({
            type: "post",
            url: url,
            data: param,
            dataType: "json",
            success: function (data) {
                Ladda.stopAll();   //解锁按钮锁定
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon: 6}) ;
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