var Business = {
    alertEdit:function(url,title){
        parent.layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            area: ['70%', '45%'],
            content: url,
            end: function (){
                grid.reflush();
            }
        });
    },
    /**
     *
     * @param artId 稿件ID
     * @param commissionStates 提成状态
     * @param invoiceStates 开票状态
     */
    edit: function(artId, commissionStates, invoiceStates){
        Business.alertEdit("/biz/business_edit?artId="+artId+"&commissionStates="+commissionStates+"&invoiceStates="+invoiceStates,"稿件编辑");
    },
    deleteArt: function(artId){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/article/deleteArticle",
                type: "post",
                data: {artId:artId},
                success: function(resData){
                    if(resData.code == 200){
                        layer.alert("删除成功");
                        grid.reflush();
                    }
                }
            });
        }, function(){

        });
    },
    batchDelete: function(){
        var totalList = grid.getAllPageSelected("artId");
        if(!totalList || totalList.length < 1){
            layer.alert("请选择要删除的数据");
            return;
        }
        var datas = [];
        for(var i = 0;i<totalList.length;i++) {
            var o = totalList[i];
            if (o.issueStates == 4) {
                layer.alert("您选择了已发布的稿件，请重新选择");
                return;
            }
            var temp = {};
            temp.id = o.artId;
            datas.push(temp);
        }
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/article/batchDelete",
                type: "POST",
                data: {datas:JSON.stringify(datas)},
                async: false,
                success: function(respData){
                    layer.closeAll();
                    if(respData.code == 200){
                        layer.alert("删除成功");
                    }else{
                        layer.alert("删除失败");
                    }
                    //重新加载表格
                    grid.reflush();
                }
            });
        }, function(){

        });
    },
    exportArt: function(){
        var totalList = grid.getAllPageSelected("artId");
        if(!totalList || totalList.length <= 0){
            layer.alert("请选择要导出的数据");
            return;
        }
        var datas = [];
        for(var i = 0;i<totalList.length;i++) {
            var o = totalList[i];
            var temp = {};
            temp.id = o.artId;
            datas.push(temp);
        }
        $("[name='datas']").val(JSON.stringify(datas));
        $("#exportForm").submit();
    },
    //设置统计数据
    setArticleResult: function(){
        $.ajax({
            url: "/article/businessResult",
            data: $("#searchForm").serializeJson(),
            type: "post",
            success: function(resData){
                if(resData){
                    for(var o in resData){
                        $("#"+o).text(resData[o]);
                    }
                }else{
                    $("#tj").find(".text-danger").html(0);
                }
            }
        });
    },
    incomeDetail: function(artId){
        parent.layer.open({
            type: 2,
            title: "入账详情",
            shadeClose: false,
            shade: 0.8,
            area: ['70%', '45%'],
            content: "/biz/income_detail?artId="+artId,
            end: function (){

            }
        });
    }
};


var gridObject = {
    url: '/article/articleListManager',
    postData: $("#searchForm").serializeJson(),
    datatype: "json",
    mtype: 'get',
    // data: mydata,
    height: "auto",
    page: 1,//第一页
    autowidth: true,
    rownumbers: true,
    gridview: true,
    viewrecords: true,
    multiselect: true,
    shrinkToFit: true,
    prmNames: {rows: "size"},
    rowNum: 10,
    rowList: [10, 20, 30],
    colNames: ['订单ID', '订单编号', '客户公司', '对接人信息','订单标题', '订单金额',
        '订单状态','稿件ID', '类别',"业务员","媒介员","媒体名称" ,"稿件标题","品牌", "发布日期","链接","数量","应收金额","税金","入账金额","备注", "客户答应到款日期",
         "入账详情","提成状态","开票状态","发布状态","支付单价","支付金额","发稿渠道商","利润率","支付日期","支付账号","备注","提成","退款","操作"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'id',
            index: 'id',
            editable: false,
            width: 30,
            align: "center",
            sortable: false,
            sorttype: "int",
            search: true,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                //合并单元格
                return "id='id" + rowId + "'";
            },
            hidden:true
        },
        {
            name: 'orderNo',
            index: 'orderNo',
            editable: false,
            width: 120,
            align: "center",
            sortable: false,
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='orderno" + rowId + "'";
            },
            hidden: true
        },
        {
            name: 'companyName',
            index: 'companyName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='companyname" + rowId + "'";
            }
        },
        {
            name: 'dockingName',
            index: 'dockingName',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='dockingname" + rowId + "'";
            },
            hidden: false
        },
        {
            name: 'orderTitle',
            index: 'orderTitle',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='ordertitle" + rowId + "'";
            }
        },
        {
            name: 'amount',
            index: 'amount',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            classes:'text-danger',
            sorttype: "string",
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='amount" + rowId + "'";
            }
        },
        {
            name: 'state',
            index: 'state',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='state" + rowId + "'";
            },
            formatter:function (d) {
                var html = d == 1 ? "<span class='text-success'>已下单</span>" : "<span class='text-info'>未下单</span>";
                return html;
            }
        },
        {
            name: 'artId',
            index: 'artId',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            hidden: true
        },
        {
            name: 'mTypeName',
            index: 'mTypeName',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'saleman',
            index: 'saleman',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'mediaUserName',
            index: 'mediaUserName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'mediaName',
            index: 'mediaName',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            hidden: false
        },
        {
            name: 'title',
            index: 'title',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'brand',
            index: 'brand',
            editable: false,
            width: 60,
            align: "center",
            sortable: false,
            hidden:false
        },
        {
            name: 'issuedDate',
            index: 'issuedDate',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden:false,
            formatter:function (d) {
                if(!d){
                    return "";
                }
                return new Date(d).format("yyyy-MM-dd");
            }
        },
        {
            name: 'link',
            index: 'link',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'num',
            index: 'num',
            editable: false,
            width: 50,
            align: "center",
            sortable: false
        },
        {
            name: 'saleAmount',
            index: 'saleAmount',
            editable: false,
            width: 70,
            align: "center",
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            sortable: false
        },
        {
            name: 'taxes',
            index: 'taxes',
            editable: false,
            width: 50,
            align: "center",
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            sortable: false
        },
        {
            name: 'incomeAmount',
            index: 'incomeAmount',
            editable: false,
            width: 70,
            align: "center",
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            sortable: false
        },
        {
            name: 'remarks',
            index: 'remarks',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'promiseDate',
            index: 'promiseDate',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                if(!d){
                    return "";
                }
                return new Date(d).format("yyyy-MM-dd");
            }
        },
        {
            name: 'incomeDetail',
            index: 'incomeDetail',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var url = "javascript:Business.incomeDetail("+rowdata.artId+")";
                var a = "<a href="+url+">入账详情</a>";
                return a;
            }
        },
        {
            name: 'commissionStates',
            index: 'commissionStates',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: true
        },
        {
            name: 'invoiceStates',
            index: 'invoiceStates',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: true
        },
        {
            name: 'issueStates',
            index: 'issueStates',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: true
        },
        {
            name: 'priceColumn',
            index: 'priceColumn',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            hidden: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"$"},
            formatter:function (a,b,rowdata) {
                var html = rowdata[rowdata.priceColumn] ? (rowdata[rowdata.priceColumn]).toFixed(2) : "";
                return html;
            }
        },
        {
            name: 'payAmount',
            index: 'payAmount',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            hidden: false
        },
        {
            name: 'supplierName',
            index: 'supplierName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: false
        },
        {
            name: 'lrl',
            index: 'lrl',
            editable: false,
            width: 50,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            hidden: false
        },
        {
            name: 'payTime',
            index: 'payTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: false,
            formatter:function (d) {
                if(!d){
                    return "";
                }
                return new Date(d).format("yyyy-MM-dd");
            }
        },
        {
            name: 'outAccountName',
            index: 'outAccountName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: false
        },
        {
            name: 'payRemark',
            index: 'payRemark',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: false
        },
        {
            name: 'commission',
            index: 'commission',
            editable: false,
            width: 60,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            hidden: false
        },
        {
            name: 'rePayAmount',
            index: 'rePayAmount',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
            hidden: false
        },
        {
            name: 'option',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                html += "<a href='javascript:Business.edit("+rowdata.artId+","+rowdata.commissionStates+","+rowdata.invoiceStates+")' style='margin-right:3px;color:#337ab7'>编辑</a>";
                if(rowdata.issueStates != 4){
                    html += "<a href='javascript:Business.deleteArt("+rowdata.artId+")' style='margin-right:3px;color:#337ab7'>删除</a>";
                }
                return html;
            }
        }
    ],
    /**
     * 翻页时保存当前页面的选中数据
     * @param pageBtn
     */
    onPaging:function(pageBtn){
        //跨页面选择
        grid.setPageSelected("artId");
    },
    gridComplete: function () {
        var primaryKey = "id";
        grid.mergerCell('id',primaryKey);
        grid.mergerCell('orderno',primaryKey);
        grid.mergerCell('companyname',primaryKey);
        grid.mergerCell('dockingname',primaryKey);
        grid.mergerCell('ordertitle',primaryKey);
        grid.mergerCell('amount',primaryKey);
        grid.mergerCell('state',primaryKey);
        //跨页面选择
        grid.getPageSelectedSet("artId");

        Business.setArticleResult();
    },
    pager: "#pager",
    viewrecords: true,
    caption: "业务查询",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false,
    shrinkToFit:false,
    autoScroll: true
};
