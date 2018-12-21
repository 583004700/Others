//查询区域
var searchForm = {
    //业务员
    worker:getQueryString("worker"),
    //对接人
    dockingId:getQueryString("dockingId"),
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
                async: false,
                data: {worker:worker},
                success:function(docPeoList){
                    var ele = $("#docPeo");
                    ele.empty();
                    ele.append('<option value="">全部</option>');
                    if(docPeoList.list){
                        for(var i = 0;i < docPeoList.list.length; i++){
                            var docPeo = docPeoList.list[i];
                            if(docPeo.id == searchForm.dockingId){
                                ele.append("<option selected='selected' value="+docPeo.id+">"+docPeo.custName+"</option>");
                                continue;
                            }
                            ele.append("<option value="+docPeo.id+">"+docPeo.custName+"</option>");
                        }
                    }
                }
            }
        );
    },
    //显示或隐藏发布日期
    showIssuedDate: function(val){
        if(val == 5){
            $("#issuedDateFormGroup").show();
        }else{
            $("#issuedDateFormGroup").hide();
        }
    },
    //查询
    search: function(){
        var searchFormData = $("#searchForm").serializeJson();

        if(searchFormData.timeQuantum == 1 || searchFormData.timeQuantum == 2){
            $("#statisticsResultTable").hide();
            $("#statisticsResultPie").hide();
            $("#statisticsResultChart").attr("class","col-sm-12");
        }else{
            $("#statisticsResultTable").show();
            $("#statisticsResultPie").show();
            $("#statisticsResultChart").attr("class","col-sm-6");
        }
        //加载客户统计结果
        $.ajax({
            url: "/statistics/statisticsResult",
            type: "post",
            data: searchFormData,
            success:function(resData){
                // statisticsResult.reflush([{month:"5月份",saleAmount:50,noIncomeAmount:30,yqIncomeAmount:20,dqysIncomeAmount:80}]);
                statisticsResult.reflush(resData);
            }
        });
        custRanking.search();
    }
};

//统计结果
var statisticsResult = {
    //左边的柱状图
    chart: {},
    //右边的饼图
    pie: {},
    //柱状图的option
    option: {
        title : {
            text: '客户统计结果',
            subtext: '',
            x:'left'
        },
        color: ['#e5323e','#003366','#006699','#4cabce'],
        backgroundColor: "#fff",
        legend: {
            y: "8px",
            data : ["成交总额","未到款额","逾期未到款额","到期应收金额"]
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
    //饼图的option
    pieOption: {},
    init: function(){
        statisticsResult.chart = echarts.init(document.getElementById('statisticsResultChart'));
        statisticsResult.pie = echarts.init(document.getElementById('statisticsResultPie'));
    },
    load: function(){
        statisticsResult.chart.setOption(statisticsResult.option,true);
    },
    loadPie: function(opt){
        $.extend(true,statisticsResult.pieOption,statisticsResult.option);
        var val1 = opt.series[0].data[0] || 0;
        var val2 = opt.series[1].data[0] || 0;
        var val3 = opt.series[2].data[0] || 0;
        var val4 = opt.series[3].data[0] || 0;
        statisticsResult.pieOption.title = {};
        statisticsResult.pieOption.xAxis = null;
        statisticsResult.pieOption.yAxis = null;
        statisticsResult.pieOption.series = [
            {
                name: '客户统计结果',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:val1, name:'成交总额'},
                    {value:val2, name:'未到款额'},
                    {value:val3, name:'逾期未到款额'},
                    {value:val4, name:'到期应收金额'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ];
        statisticsResult.pie.setOption(statisticsResult.pieOption);
    },
    loadTable: function(opt){
        var series = opt.series;
        var table = '<table style="width:100%;text-align:center;margin:60px 0 0 -20px;" class="ui-jqgrid-htable ui-common-table table table-bordered"><tbody><tr class="ui-jqgrid-labels">'
            + '<td>类型</td>'
            + '<td>' + '总额(数)' + '</td>'
            + '</tr>';
        for (var i = 0; i < opt.legend.data.length; i++) {
            var e = series[i].data[0] || "";
            table += '<tr class="ui-jqgrid-labels">'
                + '<td>' + opt.legend.data[i] + '</td>'
                + '<td>' + e + '</td>'
                + '</tr>';
        }
        table += '</tbody></table>';
        $("#statisticsResultTable").html(table);
    },
    reflush: function(dataList){
        var searchFormData = $("#searchForm").serializeJson();
        var dw = "月";
        if(searchFormData.timeQuantum == 4){
            dw = "日";
        }else if(searchFormData.timeQuantum == 5){
            dw = "";
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
        }

        for(var i=0;i<dataList.length;i++){
            statisticsResult.option.xAxis[0].data[i] = dataList[i].month ? dataList[i].month+dw : "";
            statisticsResult.option.series[0].data[i] = dataList[i].saleAmount || 0;
            statisticsResult.option.series[1].data[i] = dataList[i].noIncomeAmount || 0;
            statisticsResult.option.series[2].data[i] = dataList[i].yqIncomeAmount || 0;
            statisticsResult.option.series[3].data[i] = dataList[i].dqysIncomeAmount || 0;
        }

        //加载客户统计结果
        statisticsResult.load();

        if(searchFormData.timeQuantum == 1 || searchFormData.timeQuantum == 2){

        }else{
            statisticsResult.loadPie(statisticsResult.option);
            statisticsResult.loadTable(statisticsResult.option);
        }
    }
};

//客户排名
var custRanking = {
    chart: {},
    grid:{},
    option: {
        title : {
            text: '',
            subtext: '',
            x:'center'
        },
        color: ['#3398DB'],
        backgroundColor: "#fff",
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : [],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'',
                type:'bar',
                data:[]
            }
        ]
    },
    tableObject:{
        url: '/statistics/statisticsRanking',
        postData: $("#searchForm").serializeJson(),
        datatype: "json",
        mtype: 'post',
        // data: mydata,
        height: "auto",
        page: 1,//第一页
        autowidth: true,
        rownumbers: true,
        gridview: true,
        viewrecords: true,
        multiselect: false,
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 5,
        rowList: [10, 20, 30],
        colNames: ['客户名称', '对接人', '成交金额', '未到款额','逾期未到款额', '到期应收额'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
            {
                name: 'companyName',
                index: 'companyName',
                editable: false,
                width: 100,
                align: "center",
                sortable: false,
                search: true,
                hidden:false
            },
            {
                name: 'custName',
                index: 'custName',
                editable: false,
                width: 90,
                align: "center",
                sortable: false,
                sorttype: "string"
            },
            {
                name: 'saleAmount',
                index: 'saleAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'noIncomeAmount',
                index: 'noIncomeAmount',
                editable: false,
                width: 80,
                align: "center",
                sortable: false
            },
            {
                name: 'yqIncomeAmount',
                index: 'yqIncomeAmount',
                editable: false,
                width: 80,
                align: "center",
                sortable: false
            },
            {
                name: 'dqysIncomeAmount',
                index: 'dqysIncomeAmount',
                editable: false,
                width: 80,
                align: "center",
                sortable: false
            }
        ],
        /**
         * 翻页时保存当前页面的选中数据
         * @param pageBtn
         */
        onPaging:function(pageBtn){
            //跨页面选择

        },
        gridComplete: function () {

        },
        pager: "#pager",
        viewrecords: true,
        caption: "客户排名",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    initChart:function(){
        custRanking.chart = custRanking.chart = echarts.init(document.getElementById('statisticsRankingChart'));
    },
    init: function(){
        custRanking.initChart();
        custRanking.grid = new dataGrid("table", custRanking.tableObject , "pager", "searchForm");
        custRanking.grid.loadGrid();
    },
    load: function(){
        custRanking.initChart();
        custRanking.chart.setOption(custRanking.option);
    },
    //加载右边的表格
    loadTable:function(){
        //加载表格
        custRanking.grid.search();
    },
    reflush: function(dataList){

        var tit = $("#khpm_select").find("option:selected").text();
        var v = $("#khpm_select").val();
        custRanking.option.title.text = tit;
        custRanking.option.series[0].name = tit;

        custRanking.option.xAxis[0].data = [];

        var len = custRanking.option.series[0].data.length;
        //清空数据
        for(var i=0;i<len;i++){
            custRanking.option.xAxis[0].data = [];
            custRanking.option.series[0].data[i] = 0;
        }

        dataList = dataList.list || [];

        for(var i = 0;i<dataList.length;i++){
            var custName = dataList[i].custName || "";
            var saleAmount = dataList[i].saleAmount || 0;
            var dqysIncomeAmount = dataList[i].dqysIncomeAmount || 0;
            var noIncomeAmount = dataList[i].noIncomeAmount || 0;
            var yqIncomeAmount = dataList[i].yqIncomeAmount || 0;
            custRanking.option.xAxis[0].data[i] = custName;
            if(v == 1){
                custRanking.option.series[0].data[i] = saleAmount;
            }else if(v == 2){
                custRanking.option.series[0].data[i] = noIncomeAmount;
            }else if(v == 3){
                custRanking.option.series[0].data[i] = yqIncomeAmount;
            }else if(v == 4){
                custRanking.option.series[0].data[i] = dqysIncomeAmount;
            }
        }
        custRanking.load();
        custRanking.loadTable();
    },
    /**
     * 初始化或者下拉框的change事件触发
     */
    search: function(){
        var searchFormData = $("#searchForm").serializeJson();
        $.ajax({
            url: "/statistics/statisticsRanking",
            type: "post",
            data: searchFormData,
            success:function(resData){
                // custRanking.reflush([{custName:"张三",saleAmount:100},{custName:"李四",saleAmount:200}]);
                custRanking.reflush(resData);
            }
        });
    }
};