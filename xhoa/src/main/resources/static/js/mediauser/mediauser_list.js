var Business = {
    alertEdit:function(url,title){
        parent.layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '40%'],
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
        Business.alertEdit("/mediauser/mediauser_edit?artId="+artId+"&commissionStates="+commissionStates+"&invoiceStates="+invoiceStates,"稿件编辑");
    },
    returnDown: function(artId){
        layer.confirm('您确定要驳回该稿件吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/mediauser/turnDown",
                type: "post",
                data: {id:artId},
                success: function(resData){
                    if(resData.code == 200){
                        layer.alert("驳回成功");
                        grid.reflush();
                    }else{
                        layer.alert("驳回失败");
                    }
                }
            });
        }, function(){

        });
    },
    arrange:function(artId){
        layer.confirm('您确定要安排该稿件吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/mediauser/arrange",
                type: "post",
                data: {id:artId},
                success: function(resData){
                    if(resData.code == 200){
                        layer.alert("安排成功");
                        grid.reflush();
                    }else{
                        layer.alert("安排失败");
                    }
                }
            });
        }, function(){

        });
    },
    /**
     * 弹出发布框
     * @param artId
     * @param link
     * @param issuedDate
     * @param title
     */

    publish:function(artId,link,issuedDate,title){
        //清除验证标签
        $("#publishEditForm").find("input").removeClass('error');
        $("#publishEditForm").validate().resetForm();

        $("#publishEditModal").modal('toggle');
        document.getElementById("publishEditForm").reset();
        var publishEditForm = $("#publishEditForm");
        publishEditForm.find("[name='id']").val(artId);
        publishEditForm.find("[name='link']").val("undefined" == link ? "" : link);
        issuedDate = ("undefined" == issuedDate ? "" : issuedDate);
        if(issuedDate){
            var d = new Date(issuedDate).format("yyyy/MM/dd");
            publishEditForm.find("[name='issuedDate']").val(d);
        }
        publishEditForm.find("[name='title']").val("undefined" == title ? "" : title);
        //如果发布稿件时单价比对应媒体类型的价格单价浮动超过5%时，则询问是否同时修改媒体价格的审批
        //如果确定则发起修改媒体价格的审批
        $.ajax({
            url: "mediauser/priceFloat",
            data: {id:artId},
            success: function(resData){
                //不能更新报价
                if(!resData.data.b){
                    $("[name='updatePrice']").attr("disabled","disabled");
                }else{
                    $("[name='updatePrice']").removeAttrs("disabled");
                }
            }
        });
    },
    /**
     * 执行发布操作
     */
    zxPublish:function(){
        var formData = $("#publishEditForm").serializeJson();
        if($("#publishEditForm").valid()){
            $.ajax({
                url: "/mediauser/publish",
                type: "post",
                data: formData,
                success: function(resData){
                    if(resData.code == 200){
                        layer.alert("发布成功");
                        grid.reflush();
                    }else{
                        layer.alert("发布失败");
                    }
                    setTimeout("$('#publishEditModal').modal('toggle');",1000);
                }
            });
        }
    },
    //设置对接人
    setSelectPeople:function(){
        $("#mediaUserId").empty();
        var dept = $("#transferDepartment option:selected").val();
        Views.loadDeptUser(dept,"MJ","mediaUserId");
    },
    //设置交接部门
    setTransferDept:function(){
        Views.loadDept("transferDepartment");
        Business.setSelectPeople();
    },
    //移交
    yj:function(artId){
        $("[name='artId']").val(artId);
        Business.setTransferDept();
        layer.open({
            type: 1,
            title: "稿件移交",
            skin: 'layui-layer-rim', //加上边框
            area: ['740px', '300px'], //宽高
            content: $("#batchTransfer")
        });
    },
    //确认移交,执行移交操作
    yjqr:function(){
        $.ajax({
            url:"/mediauser/yj",
            data:$("#transferForm").serializeJson(),
            success:function(resData){
                if(resData.code == 200){
                    layer.alert("移交成功");
                    grid.reflush();
                }else{
                    layer.alert("移交失败");
                }
                setTimeout(function(){
                    layer.closeAll();
                    $("#batchTransfer").hide();
                },1000);
            }
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
        layer.confirm('您确定要驳回该稿件吗？', {
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
    url: '/mediauser/list',
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
    colNames: ['订单ID', '订单编号', '客户公司', '标题', '金额',
        '支付状态','稿件ID', '类别',"媒体" ,"标题","品牌", "链接","发布日期","客户报价", "媒介" ,"供应商" ,"业务员" ,
        "提成状态","开票状态","状态","操作"],
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
            },
            classes: 'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator: ",", decimalSeparator: ".", prefix: "￥"}
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
            },
            hidden: true
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
                return new Date(d).format("yyyy-MM-dd hh:mm:ss");
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
            formatoptions: {thousandsSeparator: ",", decimalSeparator: ".", prefix: "￥"}

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
            name: 'supplierName',
            index: 'supplierName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'saleman',
            index: 'saleman',
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
            formatter:function (a,b,rowdata) {
                var html = "";
                if(rowdata.issueStates == 0){
                    html = "未下单";
                }
                if(rowdata.issueStates == 1){
                    html = "待安排";
                }
                if(rowdata.issueStates == 2){
                    html = "进行中";
                }
                if(rowdata.issueStates == 3){
                    html = "已驳回";
                }
                if(rowdata.issueStates == 4){
                    html = "已发布";
                }
                return html;
            }
        },
        {
            name: 'option',
            editable: false,
            width: 130,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                if(rowdata.issueStates == 1){
                    html += "<a href='javascript:Business.returnDown("+rowdata.artId+")' style='margin-right:3px;color:#337ab7'>驳回</a>";
                    html += "<a href='javascript:Business.arrange("+rowdata.artId+")' style='margin-right:3px;color:#337ab7'>安排</a>";
                    html += "<a href='javascript:Business.yj("+rowdata.artId+")' style='margin-right:3px;color:#337ab7'>移交</a>";
                }else if(rowdata.issueStates == 2){
                    html += "<a href='javascript:Business.edit("+rowdata.artId+","+rowdata.commissionStates+","+rowdata.invoiceStates+")' style='margin-right:3px;color:#337ab7'>编辑</a>";
                    html += "<a href='javascript:Business.publish("+rowdata.artId+",\""+rowdata.link+"\","+rowdata.issuedDate+",\""+rowdata.title+"\")' style='margin-right:3px;color:#337ab7'>发布</a>";
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
    },
    pager: "#pager",
    viewrecords: true,
    caption: "媒介查询",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};
