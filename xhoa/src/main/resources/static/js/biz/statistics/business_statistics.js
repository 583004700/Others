//查询区域
var searchForm = {
    init:function(){
        searchForm.loadMediaType();
        searchForm.loadWorker();
    },
    //加载媒体类型
    loadMediaType: function(){
        $.ajax({
            url: "/mediaType?parentId=0",
            type: "get",
            success: function(data){
                if(data){
                    var mTypeEle = $("[name='artType']");
                    for(var i=0;i<data.length;i++){
                        var mType = data[i];
                        mTypeEle.append("<option value='${id}'>${name}</option>".replace("${id}",mType.id).replace("${name}",mType.name));
                    }
                }
            }
        });
    },
    //加载业务员
    //加载此部门下的业务员
    loadWorker: function(){
        var ele = $("#worker");
        //如果没有部门权限，则只加载当前用户
        if(!user.currentDeptQx){
            ele.append("<option value="+user.id+">"+user.name+"</option>");
        }else {
            ele.empty();
            ele.append('<option value="">全部</option>');
            Views.loadDeptUser("","YW","worker",searchForm.worker);
        }
        var ywyVal = $("#worker option:selected").val();
        //根据业务员加载对接人
        searchForm.loadDockingPeople(ywyVal);
    },
    //根据负责人加载对接人
    loadDockingPeople: function(worker){
        $.ajax(
            {
                url: "/dockingPeople/listDockingPeople",
                type: "post",
                data: {worker:worker},
                success:function(docPeoList){
                    var ele = $("#docPeo");
                    ele.empty();
                    ele.append('<option value="">全部</option>');
                    if(docPeoList.list){
                        for(var i = 0;i < docPeoList.list.length; i++){
                            var docPeo = docPeoList.list[i];
                            ele.append("<option value="+docPeo.id+">"+docPeo.custName+"</option>");
                        }
                    }
                }
            }
        );
    },
    //查询
    search: function(){
        var searchFormData = $("#searchForm").serializeJson();
        //加载客户统计结果
        $.ajax({
            url: "/businessStatistics/statisticsResult",
            type: "post",
            data: searchFormData,
            success:function(resData){
                //statisticsResult.reflush([{month:"5月份",custCount:100,artCount:3,saleAmount:50,noIncomeAmount:30,yqIncomeAmount:20,dqysIncomeAmount:80}]);
                statisticsResult.reflush(resData);
            }
        });

        //重新加载下面的表格
        custRanking.grid.search();
    }
};

//统计结果
var statisticsResult = {
    //左边的柱状图
    chart: {},
    //柱状图的option
    option: {
        title : {
            text: '业务统计结果',
            subtext: '',
            x:'left'
        },
        backgroundColor: "#fff",
        legend: {
            y: "8px",
            data : ["登记客户数量","稿件数量","成交总额","未到款额","逾期未到款额","到期应收金额"]
        },
        tooltip: {
            show: true,
            trigger: 'axis'
        },
        xAxis : [
            {
                type : 'category',
                data : []
            }
        ],
        yAxis : [
            {
                type : 'value',
                name: '(单位/元)'
            }
        ],
        series : [
            {
                "name":"登记客户数量",
                "type":"bar",
                "data":[]
            },
            {
                "name":"稿件数量",
                "type":"bar",
                "data":[]
            },
            {
                "name":"成交总额",
                "type":"bar",
                "data":[]
            },
            {
                "name":"未到款额",
                "type":"bar",
                "data":[]
            },
            {
                "name":"逾期未到款额",
                "type":"bar",
                "data":[]
            },
            {
                "name":"到期应收金额",
                "type":"bar",
                "data":[]
            }
        ]
    },

    init: function(){
        statisticsResult.chart = echarts.init(document.getElementById('statisticsResultChart'));
    },
    load: function(){
        statisticsResult.chart.setOption(statisticsResult.option,true);
    },
    reflush: function(dataList){
        var searchFormData = $("#searchForm").serializeJson();
        var dw = "";
        if(searchFormData.timeQuantum == 1){
            dw = "月";
        }else if(searchFormData.timeQuantum == 2){
            dw = "年";
        }
        statisticsResult.init();
        var len = statisticsResult.option.series[0].data.length;
        //清空原来的数据
        for(var i=0;i<len;i++){
            statisticsResult.option.series[0].data = [];
            statisticsResult.option.xAxis[0].data = [];
            statisticsResult.option.series[0].data[i] = 0;
            statisticsResult.option.series[1].data[i] = 0;
            statisticsResult.option.series[2].data[i] = 0;
            statisticsResult.option.series[3].data[i] = 0;
            statisticsResult.option.series[4].data[i] = 0;
            statisticsResult.option.series[5].data[i] = 0;
        }

        for(var i=0;i<dataList.length;i++){
            statisticsResult.option.xAxis[0].data[i] = dataList[i].month ? dataList[i].month+dw : "";
            statisticsResult.option.series[0].data[i] = dataList[i].custCount || 0;
            statisticsResult.option.series[1].data[i] = dataList[i].artCount || 0;
            statisticsResult.option.series[2].data[i] = dataList[i].saleAmount || 0;
            statisticsResult.option.series[3].data[i] = dataList[i].noIncomeAmount || 0;
            statisticsResult.option.series[4].data[i] = dataList[i].yqIncomeAmount || 0;
            statisticsResult.option.series[5].data[i] = dataList[i].dqysIncomeAmount || 0;
        }
        //加载客户统计结果
        statisticsResult.load();
    }
};

//客户排名
var custRanking = {
    grid:{},
    tableObject:{
        url: '/cust/getCustDockingPeopleVo',
        postData: {latelyNot:3},
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
            "删除标志"],
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
                sorttype: "string"
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
                sortable: false
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
            }
        ],
        /**
         * 翻页时保存当前页面的选中数据
         * @param pageBtn
         */
        onPaging:function(pageBtn){

        },
        gridComplete: function () {
            var primaryKey = "id";
            custRanking.grid.mergerCell('id',primaryKey);
            custRanking.grid.mergerCell('companyName',primaryKey);
            custRanking.grid.mergerCell('area',primaryKey);
            custRanking.grid.mergerCell('product',primaryKey);
            custRanking.grid.mergerCell('custUsers',primaryKey);
            custRanking.grid.mergerCell('dockingPeople',primaryKey);
        },
        pager: "#pager",
        viewrecords: true,
        caption: "近三个月未成交客户",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    init: function(){
        custRanking.grid = new dataGrid("table", custRanking.tableObject , "pager", "");
        custRanking.grid.loadGrid();
    },
    reflush: function(){
        custRanking.grid.reflush();
    }
};