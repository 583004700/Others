function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/refund/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_refund_table_logs").jqGrid('setGridParam', {
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
        data: {dataId: id,process: 4},
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
    $.ajax({
        type: "post",
        url: "/refund/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "1]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
        }
    });
    $("#selected_article_table_logs1").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs1").jqGrid({
        url: '/refund/listPgForSelectedArticle',
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
            {name: 'no', label: '订单编号', editable: true, width: 120},
            {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
            {name: 'userName', label: '业务员', editable: true, width: 60},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介', editable: true, width: 60},
            {name: 'title', label: '标题', editable: true, width: 120},
            {name: 'link', label: '链接', editable: true, width: 120},
            {name: 'saleAmount', label: '报价', editable: true, width: 60},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 60},
            {name: 'outgoAmount', label: '成本', editable: true, width: 60},
            {name: 'refundAmount', label: '退款', editable: true, width: 60},
            {name: 'otherPay', label: '其它支出', editable: true, width: 60}
        ],
        pager: jQuery("#selected_article_pager_logs1"),
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });
};
function edit(id) {
    document.getElementById("editForm").reset();
    $("#editModal").modal('toggle');
    edit1(id) ;
}
function edit1(id){
    $(".firstDiv").hide();
    $(".secondDiv").hide();
    $(".thirdDiv").show();
    $("#thirdStep").click();
    $.ajax({
        type: "post",
        url: "/refund/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "][type!=\"radio\"]").val(data.data.entity[attr]);
            }
            $("#amount").val(data.data.total) ;
        }
    });
    $("#query_refund_table_logs").jqGrid('setGridParam', {
        postData: $("#queryForm").serializeJson(), //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs").jqGrid({
        url: '/refund/listPgForSelectedArticle',
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
            {name: 'no', label: '订单编号', editable: true, width: 120},
            {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
            {name: 'userName', label: '业务员', editable: true, width: 60},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介', editable: true, width: 60},
            {name: 'title', label: '标题', editable: true, width: 120},
            {name: 'link', label: '链接', editable: true, width: 120},
            {name: 'saleAmount', label: '报价', editable: true, width: 60},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 60},
            {name: 'outgoAmount', label: '成本', editable: true, width: 60},
            {name: 'refundAmount', label: '退款', editable: true, width: 60},
            {name: 'otherPay', label: '其它支出', editable: true, width: 60}
        ],
        pager: jQuery("#selected_article_pager_logs"),
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });
}

function confirmRefund(id) {
    $("#confirmModal").modal('toggle');
    document.getElementById("confirmForm").reset();
    $(".firstDiv").hide();
    $(".secondDiv").hide();
    $(".thirdDiv").show();
    $("#thirdStep").click();
    $.ajax({
        type: "post",
        url: "/refund/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            var amount = 0 ;
            for (var attr in data.data.entity) {
                $("[name=" + attr + "2]").val(data.data.entity[attr]);
                if(attr=="applyAmount"){
                    amount = data.data.entity[attr] ;
                }
            }
            $("#payAmount2").val(amount) ;
        }
    });
    $("#selected_article_table_logs2").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs2").jqGrid({
        url: '/refund/listPgForSelectedArticle',
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
            {name: 'no', label: '订单编号', editable: true, width: 120},
            {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
            {name: 'userName', label: '业务员', editable: true, width: 60},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介', editable: true, width: 60},
            {name: 'title', label: '标题', editable: true, width: 120},
            {name: 'link', label: '链接', editable: true, width: 120},
            {name: 'saleAmount', label: '报价', editable: true, width: 60},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 60},
            {name: 'outgoAmount', label: '成本', editable: true, width: 60},
            {name: 'refundAmount', label: '退款', editable: true, width: 60},
            {name: 'otherPay', label: '其它支出', editable: true, width: 60}
        ],
        pager: jQuery("#selected_article_pager_logs2"),
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });

}
function saveStepOne() {
    layer.confirm('已选定稿件和供应商？确定后不能更改！', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        startModal("#save2");//锁定按钮，防止重复提交
        $.ajax({
            type: "post",
            url: "/refund/saveStepOne",    //向后端请求数据的url
            data: $("#secondForm").serializeJson(),
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    Ladda.stopAll();   //解锁按钮锁定
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        edit1(data.data.entity.id) ;
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
$(document).ready(function () {
    var arrayNewList = new Array();
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_refund_table_logs').setGridWidth(width);
        $('#select_cust_table_logs').setGridWidth(width);
        $('#select_article_table_logs').setGridWidth(width);
        $('#selected_article_table_logs1').setGridWidth(width);
        $('#account_table_logs').setGridWidth(width);
        $('#account_table_logs2').setGridWidth(width);
    });

    //flag=1审批，否则查看
    if(getQueryString("id")==null||getQueryString("id")==""||getQueryString("id")==undefined){

    }else{
        view(getQueryString("id"),getQueryString("flag")) ;
    }

    $("#addBtn").click(function () {
        $("#custCompanyId").val("");
        $("#custCompanyName").val("");
        $("#custId").val("");
        $("#custName").val("");
        $("#order").empty();
        $(".firstDiv").show();
        $(".secondDiv").hide();
        $(".thirdDiv").hide();
        $("#firstStep").click();
        document.getElementById("editForm").reset();
        $("#editModal").modal('toggle');
        $("#select_article_table_logs").jqGrid('clearGridData');
        loadCustInfo();
        arrayNewList.length=0 ;//清空选中的稿件id
    })
    $("#query_refund_table_logs").jqGrid({
        url: '/refund/listPg',
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
            {name: 'code', label: '申请编号', editable: true, width: 120},
            {name: 'title', label: '退款标题', editable: true, width: 120 },
            {name: 'applyName', label: '申请人', editable: true, width: 60 },
            {name: 'applyTime', label: '申请时间', editable: true, width: 120 },
            {name: 'deptName', label: '申请部门', editable: true, width: 60 },
            {name: 'custCompanyName', label: '客户公司名称', editable: true, width: 120},
            {name: 'custName', label: '客户联系人名称', editable: true, width: 80},
            {name: 'accountName', label: '收款人', editable: true, width: 60},
            {name: 'accountBankNo', label: '收款账号', editable: true, width: 120},
            {name: 'accountBankName', label: '收款银行', editable: true, width: 80},
            {name: 'refundAmount', label: '退款金额', editable: true, width: 80},
            {name: 'otherPay', label: '其他支出', editable: true, width: 80},
            {name: 'applyAmount', label: '合计', editable: true, width: 80},
            {name: 'outAccountName', label: '出账账号', editable: true, width: 120},
            {name: 'payAmount', label: '实际出账金额', editable: true, width: 80},
            {name: 'payTime', label: '出账日期', editable: true, width: 120},
            {name: 'taskId', label: 'taskId', editable: true,hidden:true, width: 80},
            {name: 'state', label: 'state', editable: true,hidden:true, width: 80},
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
                name: 'operate', label: "操作", index: '',width: 180,
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
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='confirmRefund(" + rows.id + ")'>批准</a>";
                    }
                    return html;
                }
            },
        ],
        pager: jQuery("#query_refund_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            var rowData = jQuery("#query_refund_table_logs").jqGrid("getRowData", rowid);
            if(rowData.state==0||rowData.state==-1){
                //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
                edit(rowid);
            }
        },
        // loadComplete: function (data) {
        //     if (getResCode(data))
        //         return;
        //     // console.log(JSON.stringify(data))
        // }
    });

    $("#querySearch").click(function () {
        $("#query_refund_table_logs").emptyGridParam() ;
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#query_refund_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });



    //点击添加按钮后加载选择供应商页面
    function loadCustInfo(){
        $("#select_cust_table_logs").jqGrid({
            url: '/cust/getCustDockingPeople',
            datatype: "json",
            mtype: 'POST',
            postData: $("#firstForm").serializeJson(), //发送数据
            altRows: true,
            altclass: 'bgColor',
            height: "auto",
            page: 1,//第一页
            rownumbers: false,
            setLabel: "序号",
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
            rowList: [10, 20, 50],//分页选项，可以下拉选择每页显示记录数
            jsonReader: {
                root: "list", page: "pageNum", total: "pages",
                records: "total", repeatitems: false, id: "id"
            },
            // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
            colModel: [
                {name: 'id', label: 'id', editable: true,hidden:true, width: 240},
                {name: 'custCompanyId', label: 'custCompanyId', editable: true,hidden:true, width: 240},
                {name: 'custCompanyName', label: '客户公司名称', editable: true, width: 240},
                {name: 'custId', label: 'custId', editable: true,hidden:true, width: 240},
                {name: 'custName', label: '客户对接人姓名', editable: true,  width: 240},
                {name: 'createWorkerName', label: '创建人', editable: true, width: 120},
                {name: 'workerName', label: '负责人', editable: true, width: 120},
                {
                    name: 'createTime',
                    label: '创建人',
                    editable: false,
                    width: 100,
                    align: "center",
                    sortable: false,
                    formatter: function (d) {
                        return new Date(d).format("yyyy-MM-dd hh:mm");
                    }
                },
                {
                    name: 'updateTime',
                    label: '负责人',
                    editable: false,
                    width: 100,
                    align: "center",
                    sortable: false,
                    formatter:function (d) {
                        return new Date(d).format("yyyy-MM-dd hh:mm");
                    }
                },
                {
                    name: 'statusName',
                    label: '状态',
                    editable: false,
                    width: 60,
                    align: "center",
                    sortable: false,
                    formatter:function (a,b,rowdata) {
                        var d = rowdata.status;
                        if(d == 0){
                            return "<span style='color:red'>有效</span>"
                        }else if(d == 1){
                            return "待开发";
                        }else if(d == 2){
                            return "<span style='color:#3f51b5'>流失</span>"
                        }
                    }
                },
            ],
            pager: jQuery("#select_cust_pager_logs"),
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
            $("#select_cust_table_logs").jqGrid('resetSelection');
            return (true);
        }
        $("#custSearch").click(function () {
            $("#select_cust_table_logs").emptyGridParam() ;
            $("#select_cust_table_logs").jqGrid('setGridParam', {
                postData: $("#firstForm").serializeJson(), //发送数据
            }).trigger("reloadGrid"); //重新载入
        });

        $("#selectSupplier").click(function () {
            var rowid = $("#select_cust_table_logs").jqGrid("getGridParam", "selrow");     //获取选中行id
            var rowData = jQuery("#select_cust_table_logs").jqGrid("getRowData", rowid);   //获取选中行信息
            if(rowData.id==null||rowData.id==undefined||rowData.id==""){
                swal("请先选择一个客户!") ;
            }else{
                $("#custCompanyId").val(rowData.custCompanyId);
                $("#custCompanyName").val(rowData.custCompanyName);
                $("#custId").val(rowData.custId);
                $("#custName").val(rowData.custName);
                $("#select_article_table_logs").jqGrid('setGridParam', {
                    postData: $("#secondForm").serializeJson(), //发送数据
                }).trigger("reloadGrid"); //重新载入
                $(".firstDiv").hide();
                $(".secondDiv").show();
                $("#secondStep").click();
                //加载稿件信息
                loadArticleInfo(rowData.custCompanyId,rowData.custCompanyName,rowData.custId,rowData.custName);
            }
        });
    }

    //稿件信息
    function loadArticleInfo(custCompanyId,custCompanyName,custId,custName){
        $("#custCompanyIdSec").val(custCompanyId) ;
        $("#custCompanyNameSec").val(custCompanyName) ;
        $("#custIdSec").val(custId) ;
        $("#custNameSec").val(custName) ;
        $("#select_article_table_logs").jqGrid({
            url: '/refund/listPgForSelectArticle',
            datatype: "json",
            mtype: 'POST',
            postData: $("#secondForm").serializeJson(), //发送数据
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
                {name: 'no', label: '订单编号', editable: true, width: 120},
                {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
                {name: 'userName', label: '业务员', editable: true, width: 60},
                {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
                {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
                {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
                {name: 'mediaUserName', label: '媒介', editable: true, width: 60},
                {name: 'title', label: '标题', editable: true, width: 120},
                {name: 'link', label: '链接', editable: true, width: 120},
                {name: 'saleAmount', label: '报价', editable: true, width: 60},
                {name: 'incomeAmount', label: '进账金额', editable: true, width: 60},
                {name: 'outgoAmount', label: '成本', editable: true, width: 60}
            ],
            pager: jQuery("#select_article_pager_logs"),
            viewrecords: true,
            caption: "",
            add: false,
            edit: true,
            addtext: 'Add',
            edittext: 'Edit',
            hidegrid: false,
            gridComplete:function(){
                // tb_init("a.thickbox, area.thickbox, input.thickbox");
                var rowIds = jQuery("#select_article_table_logs").jqGrid('getGridParam','selarrrow');
                for(var k=0; k<rowIds.length; k++) {
                    var curRowData = jQuery("#select_article_table_logs").jqGrid('getRowData', rowIds[k]);
                    var curChk = $("#"+rowIds[k]+"").find(":checkbox");
                    curChk.attr('name', 'checkboxname');   //给每一个checkbox赋名字
                    curChk.attr('value', curRowData['code']);   //给checkbox赋值

                }
            },
            loadComplete:function(xhr){
                var array = xhr.list;
                if (arrayNewList.length > 0) {
                    $.each(array, function (i, item) {
                        if (arrayNewList.indexOf(item.id.toString()) > -1) {
                            //判断arrayNewList中存在item.code值时，选中前面的复选框，
                            $("#jqg_article_table_logs_" + item.id).attr("checked", true);
                        }
                    });
                }

            },
            onSelectAll:function(aRowids,status){
                if(status==true){
                    //循环aRowids数组，将code放入arrayNewList数组中
                    $.each(aRowids,function(i,item){
                        //已选中的先排除
                        if(!(arrayNewList.indexOf(item) > -1)){
                            saveData(item);
                        }
                        // saveData(item);
                    })
                }else{
                    //循环aRowids数组，将code从arrayNewList中删除
                    $.each(aRowids,function(i,item){
                        deleteIndexData(item);
                    })
                }

            },
            onSelectRow:function(rowid,status){
                if(status==true){
                    saveData(rowid);
                }else{
                    deleteIndexData(rowid);

                }
            }
        });

        function saveData(obj){
            arrayNewList.push(obj);
            var rowData = jQuery("#select_article_table_logs").jqGrid("getRowData", obj);   //获取选中行信息
            // console.log(rowData)
            html = '<tr id="row' + rowData.id + '"><td>'+rowData.no+'</td>' +
                '<td>'+rowData.companyName+'</td><td>'+rowData.userName+'</td>' +
                '<td>'+rowData.supplierName+'</td><td>'+rowData.mediaName+'</td><td>'+rowData.mediaUserName+'</td>' +
                '<td>'+rowData.title+'</td><td>'+rowData.link+'</td>' +
                '<td><input type="text" name="refund_'+rowData.id+'" id="refund_'+rowData.id+'" value="0" onkeyup="value=value.replace(/[^\\d]/g,\'\')"></td>' +
                '<td><input type="text" name="other_'+rowData.id+'" id="other_'+rowData.id+'" value="0" onkeyup="value=value.replace(/[^\\d]/g,\'\')"></td></tr>';
            $("#order").append(html) ;
        }
        function deleteIndexData(obj){
            //获取obj在arrayNewList数组中的索引值
            // console.log($("#row"+obj))
            for(i = 0; i < arrayNewList.length; i++){
                $("#row"+obj).remove()
                if (arrayNewList[i] == obj){
                    //根据索引值删除arrayNewList中的数据
                    arrayNewList.splice(i,i);
                    // i--;
                }
            }
        }
        $("#articleSearch").click(function () {
            $("#select_article_table_logs").emptyGridParam() ;
            $("#select_article_table_logs").jqGrid('setGridParam', {
                postData: $("#secondForm").serializeJson(), //发送数据
            }).trigger("reloadGrid"); //重新载入
        });
        $("#selectArticle").unbind("click").click(function () {
            // console.log(arrayNewList)
            if(arrayNewList.length==0){
                swal("请先选择稿件！") ;
            }else{
                $("#articleIdsSec").val(arrayNewList.toString()) ;
                saveStepOne() ;
            }
        }) ;
    }

    //银行账户
    function loadAccountInfo(custId) {
        // console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+custId)
        $("#account_table_logs").jqGrid({
            url: '/account/queryCustAccount',
            datatype: "json",
            mtype: 'POST',
            postData: {custId:custId,
                    ownerQc:$("#ownerQc2").val(),
                    bankNameQc:$("#bankNameQc2").val(),
                    bankNoQc:$("#bankNoQc2").val()
             }, //发送数据
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
                {name: 'companyName', label: '供应商名称', editable: true, width: 240},
                {name: 'name', label: '账户名称', editable: true, width: 180},
                {name: 'owner', label: '账户户主', editable: true, width: 240},
                {name: 'bankNo', label: '银行账号', editable: true, width: 240},
                {name: 'bankName', label: '账号开户行', editable: true, width: 240},
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


        $("#supplierSearch2").click(function () {
            $("#account_table_logs").emptyGridParam() ;
            $("#account_table_logs").jqGrid('setGridParam', {
                postData: {custId:custId,
                        ownerQc:$("#ownerQc2").val(),
                        bankNameQc:$("#bankNameQc2").val(),
                        bankNoQc:$("#bankNoQc2").val()
                }, //发送数据
            }).trigger("reloadGrid"); //重新载入
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
            $("#accountId").val(rowData.id);
            $("#accountName").val(rowData.owner);
            $("#accountBankNo").val(rowData.bankNo);
            $("#accountBankName").val(rowData.bankName);
            $("#accountModal").modal('hide');
            document.getElementById("accountForm").reset();
        });
    }

    if($("#custCompanyId").val()!=null){
        $("#selAccount").unbind("click").click(function () {
            //加载银行账户
            loadAccountInfo($("#custCompanyId").val())
            $("#accountModal").modal('toggle');
        });
    }

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
                {name: 'id', label: 'id', editable: true,hidden: true, width: 0},
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
function checkNumber(theObj) {
    var reg = /^[0-9](\d+)?(\.\d{1,4})?$/;
    if (reg.test(theObj)) {
        return true;
    }
    return false;
}
function submitHander(t, url) {
    if ($("#editForm").valid()) {
        layer.confirm('请确认提交退款信息？提交后不能取消！', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index);
            var param = $("#editForm").serializeJson();
            startModal("#" + t.id);//锁定按钮，防止重复提交
            $.ajax({
                type: "post",
                data: param,
                url: url,
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();   //解锁按钮锁定
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#query_refund_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#query_refund_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#account_table_logs").jqGrid('setGridParam', {
                            postData: {supplierId:$("#supplierId").val(),
                                ownerQc:$("#ownerQc2").val(),
                                bankNameQc:$("#bankNameQc2").val(),
                                bankNoQc:$("#bankNoQc2").val()
                            }, //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#editModal").modal('hide');
                    } else {
                        layer.msg(data.msg);
                        $("#editModal").modal('hide');
                    }
                }
            });
        }, function () {
            return;
        });
    }
}

function submitHanderCW(t, url) {
    if ($("#confirmForm").valid()) {
        layer.confirm('请确认退款信息？提交后不能取消！', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index);
            var param = $("#confirmForm").serializeJson();
            startModal("#" + t.id);//锁定按钮，防止重复提交
            $.ajax({
                type: "post",
                data: {id:$("#id2").val(),
                    outAccountId:$("#outAccountId2").val(),
                    outAccountName:$("#outAccountName2").val(),
                    payAmount:$("#payAmount2").val(),
                    payTime:$("#payTime2").val()
                },
                url: url,
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();   //解锁按钮锁定
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#query_refund_table_logs").jqGrid('setGridParam', {
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

//审批通过
function approve(t){
    approveTask($("#taskId1").val(),1,t.id)
}

//审批驳回
function reject(t){
    approveTask($("#taskId1").val(),0,t.id)
}
