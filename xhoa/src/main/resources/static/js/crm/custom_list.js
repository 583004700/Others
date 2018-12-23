var DockingPeople = {
    init:function(){
        DockingPeople.setTransferDept();
    },
    //用来保存页码与每页选中的行的对应关系，所有页面的选中数据
    listMap:{},
    //取消绑定
    cancelBind: function(id){
        commonDockingPeople.cancelBind(id,custGrid);
    },
    //认领
    bind: function(id){
        commonDockingPeople.bind(id,custGrid);
    },
    //启用和停用
    stopOrOpen: function(id,bz){
        commonDockingPeople.stopOrOpen(id,bz,custGrid);
    },
    //如果不传rowId，则是批量指派，如果传rowId，则根据行ID指派
    assign: function(rowId){
        var totalList = custGrid.getAllPageSelected("dockingId");
        if(rowId){
            totalList = [];
            totalList.push(custGrid.getOneRow(rowId));
        }
        if(totalList.length < 1){
            layer.alert("请选择联系人");
            return;
        }
        for(var i = 0; i < totalList.length; i++){
            if(totalList[i].worker){
                layer.alert("您选择的联系人中已经包含有负责人的联系人，请重新选择");
                return;
            }
        }
        DockingPeople.transfer(totalList,2);
    },
    //批量交接
    batchTransfer: function(){
        var totalList = custGrid.getAllPageSelected("dockingId");
        if(totalList.length < 1){
            layer.alert("请选择联系人");
            return;
        }
        for(var i = 0; i < totalList.length; i++){
            if(totalList[i].worker != user.id){
                layer.alert("您选择的联系人中包含不是您负责的联系人，请重新选择");
                return;
            }
        }
        DockingPeople.transfer(totalList,1);
    },
    //开始交接
    transfer:function(totalList,bz){
        $("#transferCount").val(totalList.length);
        $("#transferWorker").val($(totalList[0].workerName).text());
        layer.open({
            type: 1,
            title: "客户批量交接",
            skin: 'layui-layer-rim', //加上边框
            area: ['740px', '380px'], //宽高
            content: $("#batchTransfer")
        });
        DockingPeople.totalList = totalList;
        DockingPeople.bz = bz;
    },
    //批量交接确认
    batchTransferq: function(){
        $("#transferCountq").text($("#transferCount").val());
        $("#transferWorkerq").text($("#transferWorker").val());
        $("#transferTransferWorkerq").text($("#transferTransferWorker option:selected").text());
        $("#transferCommentq").val($("#transferComment").val());
        layer.open({
            type: 1,
            title: "客户批量交接确认",
            skin: 'layui-layer-rim', //加上边框
            area: ['740px', '300px'], //宽高
            content: $("#batchTransferq")
        });
    },
    //执行交接或指派
    batchBindDocking: function(totalList){
        var datas = [];
        for(var i=0;i<totalList.length;i++){
            var temp = {};
            temp.id = totalList[i].dockingId;
            temp.worker = totalList[i].worker;
            datas.push(temp);
        }
        var newWorker = $("#transferTransferWorker").val();
        var comment = $("#transferComment").val();
        $.ajax({
            url: "/cust/batchBindDocking",
            type: "POST",
            data: {newWorker: newWorker,comment: comment,datas:JSON.stringify(datas),bz:DockingPeople.bz},
            async: false,
            success: function(respData){
                layer.closeAll();
                layer.alert(respData.data.status);
                //重新加载表格
                custGrid.reflush();
            }
        });
    },
    //设置对接人
    setSelectPeople:function(){
        $("#transferTransferWorker").empty();
        var dept = $("#transferDepartment option:selected").val();
        Views.loadDeptUser(dept,"YW","transferTransferWorker");
    },
    //设置交接部门
    setTransferDept:function(){
        Views.loadDept("transferDepartment");
        DockingPeople.setSelectPeople();
    }
};
// var createStart = {
//     elem: '#createStart',
//     format: 'YYYY/MM/DD hh:mm:ss',
//     min: laydate.now(), //设定最小日期为当前日期
//     max: '2099-06-16 23:59:59', //最大日期
//     istime: true,
//     istoday: false,
//     choose: function (datas) {
//         createEnd.min = datas; //开始日选好后，重置结束日的最小日期
//         createEnd.start = datas //将结束日的初始值设定为开始日
//     }
// };
// var createEnd = {
//     elem: '#createEnd',
//     format: 'YYYY/MM/DD hh:mm:ss',
//     min: laydate.now(),
//     max: '2099-06-16 23:59:59',
//     istime: true,
//     istoday: false,
//     choose: function (datas) {
//         createStart.max = datas; //结束日选好后，重置开始日的最大日期
//     }
// };
// laydate(createStart);
// laydate(createEnd);



var gridObject = {
    url: '/cust/getCustDockingPeopleVo',
            postData: $("#cust").serializeJson(),
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
            colNames: ['编号', '客户名称', '地区公司', '对接人信息','产品信息', '用户信息',
                '对接人姓名id','对接人姓名', '职位',"状态id" ,"状态","创建人id", "创建人","负责人id","负责人", "创建日期", "更新日期" ,
                "删除标志", "操作"],
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
                    name: 'companyName',
                    index: 'companyName',
                    editable: false,
                    width: 90,
                    align: "center",
                    sortable: false,
                    sorttype: "string",
                    cellattr: function (rowId, tv, rawObject, cm, rdata) {
                        return "id='companyName" + rowId + "'";
                    },
                    formatter:function (a,b,rowdata) {
                        var url = "javascript:page('/crm/company_all?companyId=${id}&companyName=${companyName}&op=edit','${title}')";
                        url = url.replace("${id}",rowdata.id).replace("${companyName}",rowdata.companyName).replace("${title}","编辑客户信息");
                        var a = "<a href="+url+">"+rowdata.companyName+"</a>";
                        return a;
                    }
                },
                {
                    name: 'area',
                    index: 'area',
                    editable: false,
                    width: 60,
                    align: "center",
                    sortable: false,
                    cellattr: function (rowId, tv, rawObject, cm, rdata) {
                        return "id='area" + rowId + "'";
                    }
                },
                {
                    name: 'dockingPeople',
                    index: 'dockingPeople',
                    editable: false,
                    width: 80,
                    align: "center",
                    sortable: false,
                    cellattr: function (rowId, tv, rawObject, cm, rdata) {
                        return "id='dockingPeople" + rowId + "'";
                    },
                    formatter:function (a,b,rowdata) {
                        var url = "javascript:page('/crm/company_docking?companyId=${id}&companyName=${companyName}','${title}')";
                        url = url.replace("${id}",rowdata.id).replace("${companyName}",rowdata.companyName).replace("${title}","对接人信息详情");
                        var a = "<a href="+url+">对接人信息详情</a>";
                        return a;
                    }
                },
                {
            name: 'product',
            index: 'product',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='product" + rowId + "'";
            },
            formatter:function (a,b,rowdata) {
                var url = "javascript:page('/crm/company_product?companyId=${id}&companyName=${companyName}','${title}')";
                url = url.replace("${id}",rowdata.id).replace("${companyName}",rowdata.companyName).replace("${title}","产品信息详情");
                var a = "<a href="+url+">产品信息详情</a>";
                return a;
            }
        },
        {
            name: 'custUsers',
            index: 'custUsers',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            cellattr: function (rowId, tv, rawObject, cm, rdata) {
                return "id='custUsers" + rowId + "'";
            },
            formatter:function (a,b,rowdata) {
                var url = "javascript:page('/crm/company_users?companyId=${id}&companyName=${companyName}','${title}')";
                url = url.replace("${id}",rowdata.id).replace("${companyName}",rowdata.companyName).replace("${title}","用户信息详情");
                var a = "<a href="+url+">用户信息详情</a>";
                return a;
            }
        },
        {
            name: 'dockingId',
            index: 'dockingId',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            hidden: true,
        },
        {
            name: 'custName',
            index: 'custName',
            editable: false,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            formatter:function (a,b,rowdata) {
                var html = '<a href="${href}" style="margin-right:3px;">${content}</a>';
                html = html.replace("${href}","javascript:page('/crm/statistics/cust_statistics?dockingId="+rowdata.dockingId+"','客户统计')");
                html = html.replace("${content}",rowdata.custName);
                return html;
            }
        },
        {
            name: 'job',
            index: 'job',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'status',
            index: 'status',
            editable: false,
            width: 30,
            align: "center",
            sortable: false,
            hidden: true
        },
        {
            name: 'statusName',
            index: 'statusName',
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
        {
            name: 'createWorker',
            index: 'createWorker',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden:true
        },
        {
            name: 'createWorkerName',
            index: 'createWorkerName',
            editable: false,
            width: 70,
            align: "center",
            sortable: false
        },
        {
            name: 'worker',
            index: 'worker',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden:true
        },
        {
            name: 'workerName',
            index: 'workerName',
            editable: false,
            width: 70,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                if(!rowdata.workerName){
                    return "";
                }
                var html = '<a href="${href}" style="margin-right:3px;">${content}</a>';
                html = html.replace("${href}","javascript:page('/crm/statistics/cust_statistics?worker="+rowdata.worker+"','客户统计')");
                html = html.replace("${content}",rowdata.workerName);
                return html;
            }
        },
        {
            name: 'createTime',
            index: 'createTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                return new Date(d).format("yyyy-MM-dd hh:mm:ss");
            }
        },
        {
            name: 'updateTime',
            index: 'updateTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                return new Date(d).format("yyyy-MM-dd hh:mm:ss");
            }
        },
        {
            name: 'deleteFlag',
            index: 'deleteFlag',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            hidden: true
        },
        {
            name: 'option',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                //如果负责人是自己
                if(user.id == rowdata.worker){
                    html += "<a href='javascript:DockingPeople.cancelBind("+rowdata.dockingId+")' style='margin-right:3px;color:#337ab7'>解绑</a>";
                }
                if(user.id == rowdata.worker){
                    if(rowdata.deleteFlag != 1){
                        html += "<a href='javascript:DockingPeople.stopOrOpen("+rowdata.dockingId+",1)' style='margin-right:3px;color:#337ab7'>停用</a>";
                    }else{
                        html += "<a href='javascript:DockingPeople.stopOrOpen("+rowdata.dockingId+",0)' style='margin-right:3px;color:#337ab7'>启用</a>";
                    }
                }
                if(!rowdata.worker){
                    html += "<a href='javascript:DockingPeople.bind("+rowdata.dockingId+")' style='margin-right:3px;color:#337ab7'>认领</a>";
                    html += "<a href='javascript:DockingPeople.assign("+b.rowId+")' style='margin-right:3px;color:#337ab7;'>指派</a>";
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
        custGrid.setPageSelected("dockingId");
    },
    gridComplete: function () {
        var primaryKey = "id";
        custGrid.mergerCell('id',primaryKey);
        custGrid.mergerCell('companyName',primaryKey);
        custGrid.mergerCell('area',primaryKey);
        custGrid.mergerCell('product',primaryKey);
        custGrid.mergerCell('custUsers',primaryKey);
        custGrid.mergerCell('dockingPeople',primaryKey);
        //跨页面选择
        custGrid.getPageSelectedSet("dockingId");
    },
    pager: "#custPager",
    viewrecords: true,
    caption: "客户列表",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};
