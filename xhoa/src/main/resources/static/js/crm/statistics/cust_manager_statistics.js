//查询区域
var searchForm = {
    init:function(){

    },
    //显示或隐藏发布日期
    showIssuedDate: function(val){
        if(val == 5){
            $("#issuedDateFormGroup").show();
        }else{
            $("#issuedDateFormGroup").hide();
            searchForm.search();
        }
    },
    //查询
    search: function(){
        topBox.reflush();
        custRanking.reflush();
        custRanking.loadTable();
    }
};

var topBox = {
    reflush:function(){
        var params = $("#searchForm").serializeJson();
        $.ajax({
            url: "/custManagerStatistics/topStatistics",
            data: params,
            success: function(resData){
                $(".val-content").each(function(i,ele){
                   var val = resData[ele.id] || 0;
                   $(ele).text(val);
                });
            }
        });

        var arr = user.dept.depts;
        var deptsStr = "";
        for(var i = 0;i<arr.length;i++){
            deptsStr += (arr[i].id+",");
        }

        $.ajax({
            url: "/custManagerStatistics/everyDeptUserCount",
            data: {list:deptsStr},
            success: function(resData){
                $("#usersContent").empty();
                for(var i=0;i<resData.length;i++){
                    var html = '<div style="width:100%;text-align:left;">'+
                        '<span style="margin-left:15px;"><span style="display:inline-block;width:100px;">${deptName}</span>'+
                        '<span class="icon fa fa-venus" style=";margin-left: 15px;font-size: 17px;color: rgb(255, 64, 129)">'+
                        '</span>'+
                        '<span>${nan}人</span>'+
                        '<span class="icon fa fa-mars" style="margin-left: 15px;font-size: 17px;color: rgb(0, 150, 136)">'+
                        '</span>'+
                        '<span>${nv}人</span>'+
                        '</span>'+
                        '</div>';
                    html = html.replace("${deptName}",(resData[i].deptName || ""));
                    html = html.replace("${nan}",(resData[i].nan || ""));
                    html = html.replace("${nv}",(resData[i].nv || ""));
                    $("#usersContent").append(html);
                }
            }
        });
    }
};

//客户排名
var custRanking = {
    pie1: {},
    pie2: {},
    pie3: {},
    pie4: {},
    grid:{},
    option1: {
        "title":{},
        "backgroundColor":"#fff",
        "legend":{"y":"8px","data":["大型客户","中型客户","小型客户"]},
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        "calculable":true,
        "xAxis":null,
        "yAxis":null,
        "series":[
            {"name":"客户类型","type":"pie","radius":"55%","center":["50%","60%"],
                "data":[
                    {"value":0,"name":"大型客户"},
                    {"value":0,"name":"中型客户"},
                    {"value":0,"name":"小型客户"}],
                "itemStyle":{"emphasis":{"shadowBlur":10,"shadowOffsetX":0,"shadowColor":"rgba(0, 0, 0, 0.5)"}}}]},
    option2: {
        "title": {},
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["VIP客户","会员客户","普通客户"]},
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        "calculable": true,
        "xAxis": null,
        "yAxis": null,
        "series":[
            {"name":"客户级别","type":"pie","radius":"55%","center":["50%","60%"],
                "data":[
                    {"value":0,"name":"VIP客户"},
                    {"value":0,"name":"会员客户"},
                    {"value":0,"name":"普通客户"}],
                "itemStyle":{"emphasis":{"shadowBlur":10,"shadowOffsetX":0,"shadowColor":"rgba(0, 0, 0, 0.5)"}}}]
    },
    option3: {
        "title": {},
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["待开发","有效","流失"]},
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        "calculable": true,
        "xAxis": null,
        "yAxis": null,
        "series":[
            {"name":"客户状态","type":"pie","radius":"55%","center":["50%","60%"],
                "data":[
                    {"value":0,"name":"待开发"},
                    {"value":0,"name":"有效"},
                    {"value":0,"name":"流失"}],
                "itemStyle":{"emphasis":{"shadowBlur":10,"shadowOffsetX":0,"shadowColor":"rgba(0, 0, 0, 0.5)"}}}]
    },
    tableObject:{
        url: '/cust/getCustDockingPeopleVo',
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
        rowNum: 18,
        rowList: [10, 20, 30],
        colNames: ['客户名称', '对接人', '地区公司','客户状态ID','客户状态','客户级别ID','客户级别','客户类型ID','客户类型','负责人'],
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
                name: 'area',
                index: 'area',
                editable: false,
                width: 100,
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
                name: 'custLevel',
                index: 'custLevel',
                editable: false,
                width: 30,
                align: "center",
                sortable: false,
                hidden: true
            },
            {
                name: 'custLevelName',
                index: 'custLevelName',
                editable: false,
                width: 60,
                align: "center",
                sortable: false,
                formatter:function (a,b,rowdata) {
                    var d = rowdata.custLevel;
                    if(d == 1){
                        return "VIP客户";
                    }else if(d == 2){
                        return "会员客户";
                    }else if(d == 3){
                        return "普通客户";
                    }
                }
            },
            {
                name: 'custType',
                index: 'custType',
                editable: false,
                width: 30,
                align: "center",
                sortable: false,
                hidden: true
            },
            {
                name: 'custTypeName',
                index: 'custTypeName',
                editable: false,
                width: 60,
                align: "center",
                sortable: false,
                formatter:function (a,b,rowdata) {
                    var d = rowdata.custType;
                    if(d == 1){
                        return "大型客户";
                    }else if(d == 2){
                        return "中型客户";
                    }else if(d == 3){
                        return "小型客户";
                    }
                }
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
        caption: "最近新建客户",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    initChart:function(){
        custRanking.pie1 = echarts.init(document.getElementById('statisticsPie1'));
        custRanking.pie2 = echarts.init(document.getElementById('statisticsPie2'));
        custRanking.pie3 = echarts.init(document.getElementById('statisticsPie3'));
    },
    init: function(){
        custRanking.initChart();
        custRanking.grid = new dataGrid("table", custRanking.tableObject , "pager", "searchForm");
        custRanking.grid.loadGrid();
    },
    load: function(){
        custRanking.initChart();
        custRanking.pie1.setOption(custRanking.option1);
        custRanking.pie2.setOption(custRanking.option2);
        custRanking.pie3.setOption(custRanking.option3);
    },
    reflushPie1:function(dataMap){
        var searchFormData = $("#searchForm").serializeJson();
        var len = custRanking.option1.series[0].data.length;
        //清空原来的数据
        for(var i=0;i<len;i++){
            custRanking.option1.series[0].data[i].value = 0;
        }

        custRanking.option1.series[0].data[0].value = dataMap.dxkh || 0;
        custRanking.option1.series[0].data[1].value = dataMap.zxkh || 0;
        custRanking.option1.series[0].data[2].value = dataMap.xxkh || 0;
    },
    reflushPie2:function(dataMap){
        var searchFormData = $("#searchForm").serializeJson();
        var len = custRanking.option2.series[0].data.length;
        //清空原来的数据
        for(var i=0;i<len;i++){
            custRanking.option2.series[0].data[i].value = 0;
        }

        custRanking.option2.series[0].data[0].value = dataMap.vipkh || 0;
        custRanking.option2.series[0].data[1].value = dataMap.hykh || 0;
        custRanking.option2.series[0].data[2].value = dataMap.ptkh || 0;
    },
    reflushPie3:function(dataMap){
        var searchFormData = $("#searchForm").serializeJson();
        var len = custRanking.option3.series[0].data.length;
        //清空原来的数据
        for(var i=0;i<len;i++){
            custRanking.option3.series[0].data[i].value = 0;
        }

        custRanking.option3.series[0].data[0].value = dataMap.dkf || 0;
        custRanking.option3.series[0].data[1].value = dataMap.yx || 0;
        custRanking.option3.series[0].data[2].value = dataMap.ls || 0;
    },
    reflush:function(){
        var params = $("#searchForm").serializeJson();
        $.ajax({
            url: "/custManagerStatistics/custPie",
            data: params,
            success: function(resData){
                custRanking.reflushPie1(resData);
                custRanking.reflushPie2(resData);
                custRanking.reflushPie3(resData);
                custRanking.load();
            }
        });
    },
    //加载左边的表格
    loadTable:function(){
        //加载表格
        custRanking.grid.search();
    }
};