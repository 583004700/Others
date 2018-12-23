
function view(id) {
    $("#viewModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/income/assignAjax",
        data: {incomeId: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "1]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
            $("#selectedArticle_table_logs").jqGrid('setGridParam', {
                postData: {id:id}, //发送数据
            }).trigger("reloadGrid"); //重新载入
            $("#selectedArticle_table_logs").jqGrid({
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
                // multiselectWidth: 25, //设置多选列宽度
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
                    {name: 'no', label: '订单编号', editable: true, width: 120},
                    {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
                    {name: 'userName', label: '业务员', editable: true, width: 60},
                    {name: 'supplierName', label: '供应商名称', editable: true, width: 120},
                    {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
                    // {name: 'tradeTime',index: 'tradeTime', label: '进账日期',editable: true,width: 180,formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: 'mediaUserName', label: '媒介', editable: true, width: 120},
                    {name: 'title', label: '标题', editable: true, width: 120},
                    {name: 'link', label: '链接', editable: true, width: 120},
                    {name: 'issuedDate', label: '发布日期', editable: true, width: 120,
                        formatter: function (d) {
                            if(d==null){
                                return "" ;
                            }else{
                                return new Date(d).format("yyyy-MM-dd hh:mm");
                            }
                        }
                    },
                    {name: 'saleAmount', label: '销售收入', editable: true, width: 60},
                    {name: 'assignAmount', label: '分款金额', editable: true, width: 60},
                    {name: 'assignDate', label: '分款日期', editable: true, width: 120}
                ],
                pager: jQuery("#selectedArticle_pager_logs"),
                viewrecords: true,
                caption: "",
                add: false,
                edit: true,
                addtext: 'Add',
                edittext: 'Edit',
                hidegrid: false
            });
        }
    });

};
function assignIncome(id) {
    // $("#incomeId").val(id) ;
    $("#selectArticleModel").modal('toggle');
    $.ajax({
        type: "post",
        url: "/income/assignAjax",
        data: {incomeId: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "]").val(data.data.entity[attr]);
            }
        }
    });
};
$(document).ready(function () {
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#assignForm").validate({
        rules:{
            tradeAmountQc:{number:true}
        },message:{
            tradeAmountQc:{required: e + "请输入正确的进款金额"}
        }
    });
    var arrayNewList = new Array();
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#assign_table_logs').setGridWidth(width);
    });
    $("#assign_table_logs").jqGrid({
        url: '/income/listPgForAssign',
        datatype: "json",
        mtype: 'POST',
        postData: $("#assignForm").serializeJson(), //发送数据
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
            {name: 'incomeId', label: 'incomeId', editable: true,hidden:true, width: 60},
            {name: 'code', label: '进账编号', editable: true, width: 120},
            {name: 'accountName', label: '账户名称', editable: true, width: 120},
            {name: 'bankNo', label: '银行账号', editable: true, width: 120},
            // {name: 'tradeTime',index: 'tradeTime', label: '进账日期',editable: true,width: 180,formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
            {
                name: 'tradeTime', index: 'tradeTime', label: '进账日期', editable: true, width: 120,
            },
            {name: 'tradeMan', label: '进账人', editable: true, width: 120},
            {name: 'tradeBank', label: '进账银行账号', editable: true, width: 120},
            {name: 'tradeAmount', label: '进账金额', editable: true, width: 120},
            {name: 'receiveTime', label: '领款日期', editable: true, width: 120},
            {name: 'receiveAmount', label: '已领金额', editable: true, width: 120},
            {name: 'assignAmount', label: '已分款金额', editable: true, width: 80},
            {name: 'remainAmount', label: '可用金额', editable: true, width: 80},
            {
                name: 'operate', label: "操作", index: '',width: 180,
                formatter: function (value, grid, rows, state) {
                    var be = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view(" + rows.incomeId + ")'>查看</a>";
                    // var be = '<a href="/fee/viewAccount?id='+rows.id+'" style="color:#f60" >查看</a>';
                    //var se = '<a href="/role/del?id='+rows.id+'" style="color:#f60" >删除</a>';
                    var de = "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='assignIncome(" + rows.incomeId + ")'>分款</a>";
                    return "     " + be + "     " + de + "        ";
                }
            }
        ],
        pager: jQuery("#assign_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    $("#assignSearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#assign_table_logs").emptyGridParam() ;
        $("#assign_table_logs").jqGrid('setGridParam', {
            postData: $("#assignForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });
    $("#selectArticle_table_logs").jqGrid({
        url: '/income/listPgForAssignAjax',
        datatype: "json",
        mtype: 'POST',
        postData: $("#selectArticleForm").serializeJson(), //发送数据
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
            {name: 'no', label: '订单编号', editable: true, width: 120},
            {name: 'companyName', label: '客户公司名称', editable: true, width: 120},
            {name: 'custName', label: '对接人', editable: true, width: 60},
            {name: 'userName', label: '业务员', editable: true, width: 60},
            {name: 'supplier_name', label: '供应商名称', editable: true, width: 120},
            {name: 'media_name', label: '媒体名称', editable: true, width: 60},
            // {name: 'tradeTime',index: 'tradeTime', label: '进账日期',editable: true,width: 180,formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
            {name: 'media_user_name', label: '媒介', editable: true, width: 60},
            {name: 'title', label: '标题', editable: true, width: 120},
            {name: 'link', label: '链接', editable: true, width: 120},
            {name: 'issued_date', label: '发布日期', editable: true, width: 120,
                formatter: function (d) {
                    if(d==null){
                        return "" ;
                    }else{
                        return new Date(d).format("yyyy-MM-dd hh:mm");
                    }
                }
            },
            {name: 'sale_amount', label: '报价', editable: true, width: 60},
            {name: 'income_amount', label: '已分款', editable: true, width: 60}
        ],
        pager: jQuery("#selectArticle_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        gridComplete:function(){
            // tb_init("a.thickbox, area.thickbox, input.thickbox");
            var rowIds = jQuery("#assign_table_logs").jqGrid('getGridParam','selarrrow');
            for(var k=0; k<rowIds.length; k++) {
                var curRowData = jQuery("#assign_table_logs").jqGrid('getRowData', rowIds[k]);
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
                        $("#jqg_assign_table_logs_" + item.id).attr("checked", true);
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
        $("#selectArticleSearch").click(function () {
            // alert(JSON.stringify($("#role").serializeJson()));
            $("#selectArticle_table_logs").emptyGridParam() ;
            $("#selectArticle_table_logs").jqGrid('setGridParam', {
                postData: $("#selectArticleForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    /*回车进行搜索*/
    $(function () {
        $('body').bind('keyup', function (event) {
            if (event.keyCode == "13") {
                //回车执行查询
                $("#assignSearch").click();
                $("#selectArticleSearch").click();

            }
        });
    });


    function saveData(obj){
        arrayNewList.push(obj);
        var rowData = jQuery("#selectArticle_table_logs").jqGrid("getRowData", obj);   //获取选中行信息
        // console.log(rowData)
        var income = parseFloat(rowData.sale_amount).toFixed(2) - parseFloat(rowData.income_amount).toFixed(2) ;
        html = '<tr id="row' + rowData.id + '"><td  class="hide">' + rowData.id + '</td>' +
            '<td>' + rowData.no + '</td><td>' + rowData.companyName + '</td><td>' + rowData.custName + '</td>' +
            '<td>' + rowData.userName + '</td><td>'+rowData.supplier_name+'</td>' +
            '<td>'+rowData.media_name+'</td><td>'+rowData.media_user_name+'</td>' +
            '<td>'+rowData.title+'</td><td>'+rowData.link+'</td>' +
            '<td>'+rowData.issued_date+'</td>' +
            '<td><input type="hidden" name="sale_'+rowData.id+'" id="sale_'+rowData.id+'" value="'+rowData.sale_amount+'">'+rowData.sale_amount+'</td>' +
            '<td><input type="hidden" name="incomed_'+rowData.id+'" id="incomed_'+rowData.id+'" value="'+rowData.income_amount+'">'+rowData.income_amount+'</td>' +
            '<td><input type="text" style="width: 80px" onkeyup="this.value=this.value.toString().match(/^\\d+(?:\\.\\d{0,2})?/)" name="income_'+rowData.id+'" id="income_'+rowData.id+'" value="'+parseFloat(income).toFixed(2)+'"></td></tr>';
        $("#order").append(html) ;
    }
    function deleteIndexData(obj){
        //获取obj在arrayNewList数组中的索引值
        // console.log($("#row"+obj))
        for(i = 0; i < arrayNewList.length; i++){
            $("#row"+obj).remove()
            if (arrayNewList[i] == obj){
                //根据索引值删除arrayNewList中的数据
                arrayNewList.splice(i,1);
                // i--;
            }
        }
    }
    function checkNumber(theObj) {
        var reg = /^[0-9](\d+)?(\.\d{1,4})?$/;
        if (reg.test(theObj)) {
            return true;
        }
        return false;
    }
    $(".selectAssign").unbind("click").click(function () {
        // $("#selectArticleModal").modal('toggle');
        var total = 0 ;
        for(var i=0;i<arrayNewList.length;i++){
            var index = arrayNewList[i];
            var sale = $("#sale_"+index).val() ;//报价
            var incomed = $("#incomed_"+index).val() ;//已付
            var income = $("#income_"+index).val() ;//分款金额
            // console.log(index)
            if(checkNumber(income)){
                if((Math.round(parseFloat(sale)*100)/100)<(Math.round(parseFloat(income)*100)/100+Math.round(parseFloat(incomed)*100)/100)){
                    swal("金额不正确！", "实付金额："+parseFloat(income).toFixed(2)+" + 已付金额："+parseFloat(incomed).toFixed(2)+"不能大于报价"+parseFloat(sale).toFixed(2)+",请核实后分款。", "warning");
                    return ;
                }
            }else{
                swal("格式不正确！", "只能输入数字。输入的类型为："+income+"+:+"+typeof (income), "warning");
               return ;
            }
            total = parseFloat(total) + parseFloat(income) ;
        }
        if(parseFloat($("#remainAmount").val())<Math.round(parseFloat(total)*100)/100){
            swal("金额不足","可用余额为"+$("#remainAmount").val()+",分配金额为"+parseFloat(total).toFixed(2)+"，分配金额不能大于可用余额","warning") ;
            return ;
        }
        $("#ids").val(arrayNewList.toString()) ;
        $.ajax({
            type: "post",
            url: "/income/assignIncome",
            data: $("#selectArticleForm").serializeJson(),
            dataType: "json",
            success: function (data) {
                if(data.code=200){
                    layer.msg(data.data.message) ;
                    $("#order").empty();
                    arrayNewList.length=0 ;//清空选中的稿件id
                    // document.getElementById("selectArticleForm").reset();
                    $("#selectArticleModel").modal('hide');

                    $("#assign_table_logs").jqGrid('setGridParam', {
                        postData: $("#assignForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                    $("#selectArticle_table_logs").jqGrid('clearGridData');
                    $("#selectArticle_table_logs").jqGrid('setGridParam', {
                        postData: $("#selectArticleForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入

                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    }) ;

});
