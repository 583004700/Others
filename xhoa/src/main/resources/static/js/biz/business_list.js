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
    }
};


var gridObject = {
    url: '/article/businessList',
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
    colNames: ['订单ID', '订单编号', '客户公司', '对接人信息','业务员','订单标题', '订单金额',
        '支付状态','稿件ID', '类别',"媒体" ,"稿件标题","品牌", "链接","发布日期","应收金额","入账金额", "客户答应到款日期","实际到款日期", "媒介" ,
         "提成状态","开票状态","发布状态","操作"],
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
            width: 90,
            align: "center",
            sortable: false,
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='orderno" + rowId + "'";
            }
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
            name: 'saleman',
            index: 'saleman',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='saleman" + rowId + "'";
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
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='amount" + rowId + "'";
            }
        },
        {
            name: 'state',
            index: 'state',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='state" + rowId + "'";
            },
            formatter:function (d) {
                var html = d == 1 ? "已下单" : "未下单";
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
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'brand',
            index: 'brand',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden:false
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
            name: 'saleAmount',
            index: 'saleAmount',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            classes: 'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"},
        },
        {
            name: 'incomeAmount',
            index: 'incomeAmount',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'promiseDate',
            index: 'promiseDate',
            editable: false,
            width: 120,
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
            name: 'incomeDate',
            index: 'incomeDate',
            editable: false,
            width: 120,
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
            name: 'mediaUserName',
            index: 'mediaUserName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
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
            hidden: false,
            formatter:function (value) {
                switch (value) {
                    case 0 :
                        return "未下单" ;
                    case 1 :
                        return "已下单" ;
                    case 2 :
                        return "进行中" ;
                    case 3 :
                        return "已驳回" ;
                    case 4 :
                        return "已发布" ;
                }
            }
        },
        {
            name: 'option',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                if(rowdata.issueStates != 4 && rowdata.issueStates != 2) {
                    html += "<a href='javascript:Business.edit(" + rowdata.artId + "," + rowdata.commissionStates + "," + rowdata.invoiceStates + ")' style='margin-right:3px;color:#337ab7'>编辑</a>";
                }
                if(rowdata.issueStates != 4 && rowdata.issueStates != 2){
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
        grid.mergerCell('saleman',primaryKey);
        //跨页面选择
        grid.getPageSelectedSet("artId");
    },
    pager: "#pager",
    viewrecords: true,
    caption: "业务查询",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};
