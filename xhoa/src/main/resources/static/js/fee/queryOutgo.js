function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/outgo/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        window.location.href = "/fee/queryOutgo";
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
//审批记录查看
function history(id) {
    //process详见IProcess
    $("#historyModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/process/history",
        data: {dataId: id,process: 3},
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
        url: "/outgo/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "1]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
            $("#borrowInfo1").empty() ;
            if(data.data.list.length>0){
                html = '<div><h3>备用金扣除详情</h3></div><table class="table table-bordered" style="text-align: center"><thead>' +
                    '<th style="text-align:center;vertical-align:middle;">借款编号</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款标题</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款类型</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款人</th>' +
                    '<th style="text-align:center;vertical-align:middle;">所属部门</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">实付金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">未还金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">备用金还款金额</th>' +
                    '</thead>' ;
                for(var i=0;i<data.data.list.length;i++){
                    html += '<tr><td>' + data.data.list[i]['code'] + '</td>' +
                        '<td>'+data.data.list[i]['title']+'</td>' +
                        '<td>'+data.data.list[i]['type']+'</td>' +
                        '<td>'+data.data.list[i]['apply_name']+'</td>' +
                        '<td>'+data.data.list[i]['dept_name']+'</td>' +
                        '<td>'+data.data.list[i]['apply_amount']+'</td>' +
                        '<td>'+data.data.list[i]['pay_amount']+'</td>' +
                        '<td>'+data.data.list[i]['remain_amount']+'</td>' +
                        '<td>'+data.data.list[i]['amount']+'</td></tr>' ;
                }
                html += '</tbody></table>';
                $("#borrowInfo1").append(html) ;
            }
        }
    });
    $("#selected_article_table_logs1").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs1").jqGrid({
        url: '/outgo/listPgForSelectedArticle',
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
            {name: 'userName', label: '业务员', editable: true, width: 120},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介姓名', editable: true, width: 120},
            {name: 'title', label: '标题', editable: true, width: 180},
            {name: 'link', label: '链接', editable: true, width: 180},
            {name: 'saleAmount', label: '报价', editable: true, width: 120},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 120},
            {name: 'payAmount', label: '应付金额', editable: true, width: 120}
            // {name: 'owner', label: '联系人', editable: true, width: 120},
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
    $("#editModal").modal('toggle');
    document.getElementById("editForm").reset();
    edit1(id) ;
}
function edit1(id) {
    $(".firstDiv").hide();
    $(".secondDiv").hide();
    $(".thirdDiv").show();
    $("#thirdStep").click();
    $.ajax({
        type: "post",
        url: "/outgo/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            // $("#borrowDetail").empty() ;
            $("#borrowInfo").empty() ;
            for (var attr in data.data.entity) {
                $("[name=" + attr + "]").val(data.data.entity[attr]);
            }
            $("#applyAmount").val(data.data.sumAmount);
            if(data.data.list.length>0){
                html = '<div><h3>备用金扣除详情</h3></div><table class="table table-bordered" style="text-align: center"><thead>' +
                    '<th style="text-align:center;vertical-align:middle;">借款编号</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款标题</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款类型</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款人</th>' +
                    '<th style="text-align:center;vertical-align:middle;">所属部门</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">实付金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">未还金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">备用金还款金额</th>' +
                    '</thead>' ;
                for(var i=0;i<data.data.list.length;i++){
                    html += '<tr><td>' + data.data.list[i]['code'] + '</td>' +
                        '<td>'+data.data.list[i]['title']+'</td>' +
                        '<td>'+data.data.list[i]['type']+'</td>' +
                        '<td>'+data.data.list[i]['apply_name']+'</td>' +
                        '<td>'+data.data.list[i]['dept_name']+'</td>' +
                        '<td>'+data.data.list[i]['apply_amount']+'</td>' +
                        '<td>'+data.data.list[i]['pay_amount']+'</td>' +
                        '<td>'+data.data.list[i]['remain_amount']+'</td>' +
                        '<td>'+data.data.list[i]['amount']+'</td></tr>' ;
                }
                html += '</tbody></table>';
                $("#borrowInfo").append(html) ;
            }
        }
    });
    $("#query_table_logs").jqGrid('setGridParam', {
        postData: $("#queryForm").serializeJson(), //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs").jqGrid({
        url: '/outgo/listPgForSelectedArticle',
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
            {name: 'userName', label: '业务员', editable: true, width: 120},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介姓名', editable: true, width: 120},
            {name: 'title', label: '标题', editable: true, width: 180},
            {name: 'link', label: '链接', editable: true, width: 180},
            {name: 'saleAmount', label: '报价', editable: true, width: 120},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 120},
            {name: 'payAmount', label: '应付金额', editable: true, width: 120}
            // {name: 'owner', label: '联系人', editable: true, width: 120},
        ],
        pager: jQuery("#SelectedArticle_pager_logs"),
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });

}

function approve(id) {
    $("#confirmModal").modal('toggle');
    document.getElementById("confirmForm").reset();
    $(".firstDiv").hide();
    $(".secondDiv").hide();
    $(".thirdDiv").show();
    $("#thirdStep").click();
    $.ajax({
        type: "post",
        url: "/outgo/editAjax",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            var amount = 0 ;
            var amount1 = 0 ;
            // console.log(data)
            $("#borrowInfo2").empty() ;
            for (var attr in data.data.entity) {
                $("[name=" + attr + "2]").val(data.data.entity[attr]);
                if(attr=="applyAmount"){
                    amount = data.data.entity[attr] ;
                }
                if(attr=="fundAmount"){
                    amount1 = data.data.entity[attr] ;
                }
            }
            $("#payAmount2").val(parseFloat(amount)-parseFloat(amount1)) ;
            if(data.data.list.length>0){
                html = '<div><h3>备用金扣除详情</h3></div><table class="table table-bordered" style="text-align: center"><thead>' +
                    '<th style="text-align:center;vertical-align:middle;">借款编号</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款标题</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款类型</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款人</th>' +
                    '<th style="text-align:center;vertical-align:middle;">所属部门</th>' +
                    '<th style="text-align:center;vertical-align:middle;">借款金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">实付金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">未还金额</th>' +
                    '<th style="text-align:center;vertical-align:middle;">备用金还款金额</th>' +
                    '</thead>' ;
                for(var i=0;i<data.data.list.length;i++){
                    html += '<tr><td>' + data.data.list[i]['code'] + '</td>' +
                        '<td>'+data.data.list[i]['title']+'</td>' +
                        '<td>'+data.data.list[i]['type']+'</td>' +
                        '<td>'+data.data.list[i]['apply_name']+'</td>' +
                        '<td>'+data.data.list[i]['dept_name']+'</td>' +
                        '<td>'+data.data.list[i]['apply_amount']+'</td>' +
                        '<td>'+data.data.list[i]['pay_amount']+'</td>' +
                        '<td>'+data.data.list[i]['remain_amount']+'</td>' +
                        '<td>'+data.data.list[i]['amount']+'</td></tr>' ;
                }
                html += '</tbody></table>';
                $("#borrowInfo2").append(html) ;
            }
        }
    });
    $("#selected_article_table_logs2").jqGrid('setGridParam', {
        postData: {id:id}, //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#selected_article_table_logs2").jqGrid({
        url: '/outgo/listPgForSelectedArticle',
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
            {name: 'userName', label: '业务员', editable: true, width: 120},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'mediaUserName', label: '媒介姓名', editable: true, width: 120},
            {name: 'title', label: '标题', editable: true, width: 180},
            {name: 'link', label: '链接', editable: true, width: 180},
            {name: 'saleAmount', label: '报价', editable: true, width: 120},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 120},
            {name: 'payAmount', label: '应付金额', editable: true, width: 120}
            // {name: 'owner', label: '联系人', editable: true, width: 120},
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
        startModal("#selectArticle");//锁定按钮，防止重复提交
        $.ajax({
            type: "post",
            url: "/outgo/saveStepOne",    //向后端请求数据的url
            data: $("#secondForm").serializeJson(),
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    Ladda.stopAll();   //解锁按钮锁定
                    edit1(data.data.entity.id) ;
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
    var e = "<i class='fa fa-times-circle'></i>";
    $("#queryForm").validate({
        rules:{
            applyAmountQc:{number:true},
            payAmountQc:{number:true}
        },message:{
            applyAmountQc:{required: e + "请输入正确的申请金额"},
            payAmountQc:{required: e + "请输入正确的实付金额"}
        }
    });
    var arrayNewList = new Array();
    var borrowList = new Array();
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
        $('#select_supplier_table_logs').setGridWidth(width);
        $('#select_article_table_logs').setGridWidth(width);
        $('#selected_article_table_logs').setGridWidth(width);
        $('#selected_article_table_logs1').setGridWidth(width);
        $('#selected_article_table_logs2').setGridWidth(width);
        $('#account_table_logs').setGridWidth(width);
        $('#account_table_logs2').setGridWidth(width);
    });

    //flag=1审批，否则查看
    if(getQueryString("id")==null||getQueryString("id")==""||getQueryString("id")==undefined){

    }else{
        view(getQueryString("id"),getQueryString("flag")) ;
    }

    $("#query_table_logs").jqGrid({
        url: '/outgo/listPg',
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
            {name: 'code', label: '请款编号', editable: true, width: 120},
            {name: 'applyName', label: '请款人', editable: true, width: 80},
            {name: 'deptName', label: '所在部门', editable: true, width: 80},
            {name: 'applyTime', label: '请款日期', editable: true, width: 120},
            {name: 'title', label: '请款标题', editable: true, width: 120},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
            {name: 'accountName', label: '收款人', editable: true, width: 80},
            {name: 'accountBankNo', label: '收款账号', editable: true, width: 120},
            {name: 'accountBankName', label: '收款银行', editable: true, width: 120},
            {name: 'applyAmount', label: '请款金额', editable: true, width: 80},
            {name: 'expertPayTime', label: '期望付款日期', editable: true, width: 120},
            {name: 'outAccountName', label: '财务出款账号', editable: true,hidden:true, width: 120},
            {name: 'payAmount', label: '实际出款金额', editable: true, width: 80},
            {name: 'payTime', label: '实际出款日期', editable: true, width: 120},
            {name: 'taskId', label: 'taskId', editable: true,hidden:true, width: 80},
            {name: 'state', label: 'state', editable: true,hidden:true, width: 80},
            {name: 'state1', label: '状态', editable: true, width: 120,
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
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;color: red'  onclick='del(" + rows.id + ")'>删除&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==2){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: blue'  onclick='approve(" + rows.id + ")'>确认</a>";
                    }
                    return html;
                },
            },

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
        },
    });

    $("#querySearch").click(function () {
        $("#query_table_logs").emptyGridParam() ;
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#addBtn").click(function () {
        $("#supplierId").val("");
        $("#supplierName").val("");
        $("#order").empty();
        $(".firstDiv").show();
        $(".secondDiv").hide();
        $(".thirdDiv").hide();
        $("#firstStep").click();
        document.getElementById("editForm").reset();
        $("#editModal").modal('toggle');
        // $("#article_table_logs").resetSelection();
        // $("#article_table_logs").emptyGridParam().jqGrid('clearGridData');
        $("#article_table_logs").jqGrid('clearGridData');
        loadSupplierInfo();
        arrayNewList.length=0 ;//清空选中的稿件id
    })

    //点击添加按钮后加载选择供应商页面
    function loadSupplierInfo(){
        $("#select_supplier_table_logs").jqGrid({
            url: '/supplier/querySupplierList',
            datatype: "json",
            mtype: 'POST',
            postData: {supplierNameQc:$("#supplierNameQc1").val()}, //发送数据
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
                {name: 'name', label: '供应商名称', editable: true, width: 240},
                {name: 'desc', label: '公司描述', editable: true,  width: 240},
                {name: 'contactor', label: '联系人', editable: true, width: 120},
                {name: 'phone', label: '电话', editable: true, width: 120},
                {name: 'qqwechat', label: 'QQ微信', editable: true, width: 240},
                {name: 'contactorDesc', label: '联系人描述', editable: true, width: 240},
                {name: 'id', label: 'id', editable: true,hidden:true, width: 0},
                // {name: 'owner', label: '联系人', editable: true, width: 120},
            ],
            pager: jQuery("#select_supplier_pager_logs"),
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
            $("#select_supplier_table_logs").jqGrid('resetSelection');
            return (true);
        }
        $("#supplierSearch").click(function () {
            $("#select_supplier_table_logs").jqGrid('setGridParam', {
                postData: {supplierNameQc:$("#supplierNameQc1").val()}, //发送数据
            }).trigger("reloadGrid"); //重新载入
        });

        $("#selectSupplier").click(function () {
            var rowid = $("#select_supplier_table_logs").jqGrid("getGridParam", "selrow");     //获取选中行id
            var rowData = jQuery("#select_supplier_table_logs").jqGrid("getRowData", rowid);   //获取选中行信息
            if(rowData.id==null||rowData.id==undefined||rowData.id==""){
                swal("请先选中供应商") ;
            }else{
                $("#supplierId").val(rowData.id);
                $("#supplierName").val(rowData.name);
                $("#select_article_table_logs").jqGrid('setGridParam', {
                    postData: $("#secondForm").serializeJson(), //发送数据
                }).trigger("reloadGrid"); //重新载入
                $(".firstDiv").hide();
                $(".secondDiv").show();
                $("#secondStep").click();
                //加载稿件信息
                loadArticleInfo(rowData.id,rowData.name);
            }
        });
    }

    //加载稿件信息
    //稿件信息
    function loadArticleInfo(supplierId,supplierName){
        $("#supplierIdSec").val(supplierId) ;
        $("#supplierNameSec").val(supplierName) ;
        $("#select_article_table_logs").jqGrid({
            url: '/outgo/listPgForSelectArticle',
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
                {name: 'userName', label: '业务员', editable: true, width: 120},
                {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
                {name: 'id', label: 'id', editable: true, hidden:true, width: 60},
                {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
                {name: 'mediaUserName', label: '媒介姓名', editable: true, width: 120},
                {name: 'title', label: '标题', editable: true, width: 180},
                {name: 'link', label: '链接', editable: true, width: 180},
                {name: 'saleAmount', label: '报价', editable: true, width: 120},
                {name: 'incomeAmount', label: '进账金额', editable: true, width: 120},
                {name: 'payAmount', label: '应付金额', editable: true, width: 120}
                // {name: 'bankNameDetail', label: '开户行支行', editable: true, width: 180},
                // {name: 'owner', label: '联系人', editable: true, width: 120},
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
                var rowIds = $("#select_article_table_logs").jqGrid('getGridParam','selarrrow');
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
                        if(!(arrayNewList.indexOf(item) > -1)){
                            saveData(item);
                        }
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
            // var ids = $("jqgridtableid").jqGrid('getGridParam','selarrrow');
            var rowData = jQuery("#select_article_table_logs").jqGrid("getRowData", obj);   //获取选中行信息
            // console.log(rowData)
            html = '<tr id="row' + rowData.id + '"><td >' + rowData.no + '</td>' +
                '<td>' + rowData.userName + '</td><td>'+rowData.supplierName+'</td>' +
                '<td>'+rowData.mediaName+'</td><td>'+rowData.mediaUserName+'</td>' +
                '<td>'+rowData.title+'</td>' +
                '<td>'+rowData.link+'</td><td>'+rowData.saleAmount+'</td>' +
                '<td>'+rowData.incomeAmount+'</td><td>'+rowData.payAmount+'</td></tr>';
            $("#order").append(html) ;
        }
        function deleteIndexData(obj){
            //获取obj在arrayNewList数组中的索引值
            for(i = 0; i < arrayNewList.length; i++){
                $("#row"+obj).remove()
                if (arrayNewList[i] == obj){
                    //根据索引值删除arrayNewList中的数据
                    arrayNewList.splice(i,1);
                    // i--;
                }
            }
        }
        $("#articleSearch").click(function () {
            $("#select_article_table_logs").jqGrid('setGridParam', {
                postData: $("#secondForm").serializeJson(), //发送数据
            }).trigger("reloadGrid"); //重新载入
        });
        $("#selectArticle").unbind("click").click(function () {
            if(arrayNewList.length==0){
                swal("请先选择稿件！") ;
            }else{
                $("#articleIdsSec").val(arrayNewList.toString()) ;
                saveStepOne() ;
            }
        }) ;
    }


    //银行账户
    function loadAccountInfo(supplierId) {
        $("#account_table_logs").jqGrid({
            url: '/account/querySupplierAccount',
            datatype: "json",
            mtype: 'POST',
            postData: {supplierId:supplierId,
                ownerQc:$("#ownerQc2").val(),
                bankNameQc:$("#bankNameQc2").val(),
                bankNoQc:$("#bankNoQc2").val()}, //发送数据
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


        $("#accountSearch").click(function () {
            $("#account_table_logs").jqGrid('setGridParam', {
                postData: {supplierId:supplierId}, //发送数据
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

    if($("#supplierId").val()!=null){
        $("#selAccount").unbind("click").click(function () {
            //加载银行账户
            loadAccountInfo($("#supplierId").val())
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
    //关联借款信息
    $("#selBorrow").click(function () {
        if($("#fundAmount").val()==0){
            borrowList.length = 0 ;
            $("#borrowDetail").empty() ;

            $("#borrow_table_logs").jqGrid('setGridParam', {
                postData: $("#borrowForm").serializeJson(), //发送数据
            }).trigger("reloadGrid"); //重新载入
            $("#borrowModal").modal('toggle');
        }else{
            swal("已选择了备用金信息，不支持修改，只支持删除后重新选择备用金!")
        }
    });
    $(".cleanBorrow").click(function () {
        layer.confirm('删除该请款单的备用金信息？', {
            btn: ['删除', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            $.ajax({
                type: "post",
                url: "/outgo/cleanOutgoBorrow",    //向后端请求数据的url
                data: {id: $("#id").val()},
                dataType: "json",
                success: function (data) {
                    layer.close(index);
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#fundAmount").val(0) ;
                        $("#borrowDetail").empty() ;
                        $("#borrowInfo").empty() ;
                    } else {
                        layer.msg(data.msg);
                    }
                }
            });
        }, function () {
            return;
        });

    });
    $("#borrow_table_logs").jqGrid({
        url: '/borrow/listPgForOutgo',
        datatype: "json",
        mtype: 'POST',
        postData: $("#borrowForm").serializeJson(), //发送数据
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
            {name: 'id', label: 'id', editable: true,hidden:true, width: 60},
            {name: 'code', label: '借款编号', editable: true, width: 120},
            {name: 'title', label: '借款标题', editable: true, width: 180},
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
            {name: 'applyName', label: '借款人', editable: true, width: 80},
            {name: 'deptName', label: '所在部门', editable: true, width: 80},
            {name: 'applyAmount', label: '申请金额', editable: true, width: 80},
            {name: 'payAmount', label: '实付金额', editable: true, width: 80},
            {name: 'repayAmount', label: '已还金额', editable: true, width: 80},
            {name: 'remainAmount', label: '未还金额', editable: true, width: 80},
            {name: 'payTime', label: '实际支付日期', editable: true, width: 140},
            {name: 'remark', label: '借款原因', editable: true, width: 180}
        ],
        pager: jQuery("#borrow_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        gridComplete:function(){
            // tb_init("a.thickbox, area.thickbox, input.thickbox");
            var rowIds = jQuery("#borrow_table_logs").jqGrid('getGridParam','selarrrow');
            for(var k=0; k<rowIds.length; k++) {
                var curRowData = jQuery("#borrow_table_logs").jqGrid('getRowData', rowIds[k]);
                var curChk = $("#"+rowIds[k]+"").find(":checkbox");
                curChk.attr('name', 'checkboxname');   //给每一个checkbox赋名字
                curChk.attr('value', curRowData['code']);   //给checkbox赋值

            }
        },
        loadComplete:function(xhr){
            var array = xhr.list;
            if (borrowList.length > 0) {
                $.each(array, function (i, item) {
                    if (borrowList.indexOf(item.id.toString()) > -1) {
                        //判断borrowList中存在item.code值时，选中前面的复选框，
                        $("#jqg_borrow_table_logs_" + item.id).attr("checked", true);
                    }
                });
            }

        },
        onSelectAll:function(aRowids,status){
            if(status==true){
                //循环aRowids数组，将code放入borrowList数组中
                $.each(aRowids,function(i,item){
                    if(!(borrowList.indexOf(item) > -1)){
                        saveData1(item);
                    }
                })
            }else{
                //循环aRowids数组，将code从borrowList中删除
                $.each(aRowids,function(i,item){
                    deleteIndexData1(item);
                })
            }
        },
        onSelectRow:function(rowid,status){
            if(status==true){
                saveData1(rowid);
            }else{
                deleteIndexData1(rowid);

            }
        }
    });
    function saveData1(obj){
        borrowList.push(obj);
        // console.log(borrowList) ;
        var rowData = $("#borrow_table_logs").jqGrid("getRowData", obj);   //获取选中行信息
        // console.log(rowData)
        html = '<tr id="rows' + rowData.id + '"><td>' + rowData.code + '</td><td>'+rowData.title+'</td>' +
            '<td>'+rowData.type+'</td><td>'+rowData.applyName+'</td>' +
            '<td>'+rowData.deptName+'</td><td>'+rowData.applyAmount+'</td>' +
            '<td>'+rowData.payAmount+'</td><td>'+rowData.payTime+'</td>' +
            '<td><input type="hidden" name="pay_'+rowData.id+'" id="pay_'+rowData.id+'" value="'+rowData.repayAmount+'">'+rowData.repayAmount+'</td>' +
            '<td><input type="hidden" name="remain_'+rowData.id+'" id="remain_'+rowData.id+'" value="'+rowData.remainAmount+'">'+rowData.remainAmount+'</td>' +
            '<td><input type="text" name="fund_'+rowData.id+'" id="fund_'+rowData.id+'" value="'+rowData.remainAmount+'"></td></tr>';
        $("#borrowDetail").append(html) ;
    }
    function deleteIndexData1(obj){
        //获取obj在borrowList数组中的索引值
        // console.log(borrowList) ;
        for(i = 0; i < borrowList.length; i++){
            $("#rows"+obj).remove()
            if (borrowList[i] == obj){
                //根据索引值删除borrowList中的数据
                borrowList.splice(i,1);
                // i--;
            }
        }
    }

    $("#selectBorrow").click(function () {
        $("#outgoId").val($("#id").val())
        $("#borrowIds").val(borrowList.toString())
        // console.log($("#id").val() + "\t" + borrowList.toString())
        layer.confirm('请确认抵消的借款信息？提交后不能取消！', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index);
            var param = $("#borrowForm").serializeJson();
            startModal("#selectBorrow");//锁定按钮，防止重复提交
            $.ajax({
                type: "post",
                data: param,
                url: "/outgo/saveOutgoBorrow",
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();   //解锁按钮锁定
                    if(data.code==200){
                        $("#borrowInfo").empty() ;
                        if(data.data.list.length>0){
                            html = '<div><h3>备用金扣除详情</h3></div><table class="table table-bordered" style="text-align: center"><thead>' +
                                '<th style="text-align:center;vertical-align:middle;">借款编号</th>' +
                                '<th style="text-align:center;vertical-align:middle;">借款标题</th>' +
                                '<th style="text-align:center;vertical-align:middle;">借款类型</th>' +
                                '<th style="text-align:center;vertical-align:middle;">借款人</th>' +
                                '<th style="text-align:center;vertical-align:middle;">所属部门</th>' +
                                '<th style="text-align:center;vertical-align:middle;">借款金额</th>' +
                                '<th style="text-align:center;vertical-align:middle;">实付金额</th>' +
                                '<th style="text-align:center;vertical-align:middle;">未还金额</th>' +
                                '<th style="text-align:center;vertical-align:middle;">备用金还款金额</th>' +
                                '</thead>' ;
                            for(var i=0;i<data.data.list.length;i++){
                                html += '<tr><td>' + data.data.list[i]['code'] + '</td>' +
                                    '<td>'+data.data.list[i]['title']+'</td>' +
                                    '<td>'+data.data.list[i]['type']+'</td>' +
                                    '<td>'+data.data.list[i]['apply_name']+'</td>' +
                                    '<td>'+data.data.list[i]['dept_name']+'</td>' +
                                    '<td>'+data.data.list[i]['apply_amount']+'</td>' +
                                    '<td>'+data.data.list[i]['pay_amount']+'</td>' +
                                    '<td>'+data.data.list[i]['remain_amount']+'</td>' +
                                    '<td>'+data.data.list[i]['amount']+'</td></tr>' ;
                            }
                            html += '</tbody></table>';
                            $("#borrowInfo").append(html) ;
                        }
                        // layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#fundAmount").val(data.data.amount) ;
                        $("#borrow_table_logs").jqGrid('setGridParam', {
                            postData: $("#borrowForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#borrowModal").modal('hide');
                    }else{
                        layer.msg(data.msg) ;
                        $("#borrowModal").modal('hide');
                    }

                }
            });
        }, function () {
            return;
        });
    });

    $("#borrowSearch").click(function () {
        $("#borrow_table_logs").jqGrid('setGridParam', {
            postData: $("#borrowForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });
});

function submitHander(t, url) {
    if ($("#editForm").valid()) {
        layer.confirm('确认提交？提交后不能修改', {
            btn: ['确定', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index) {
            layer.close(index) ;
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
                        layer.msg(data.data.message)
                        $("#query_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                        $("#editModal").modal('hide');
                    }else{
                        layer.msg(data.msg) ;
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
        layer.confirm('请确认请款信息？提交后不能取消！', {
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

//审批通过
function pass(t){
    approveTask($("#taskId1").val(),1,t.id)
}

//审批驳回
function reject(t){
    approveTask($("#taskId1").val(),0,t.id)
}