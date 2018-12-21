//查询区域
var searchForm = {
    init: function () {
        searchForm.loadMediaType();
        searchForm.loadWorker();
    },
    //加载媒体类型
    loadMediaType: function () {
        $.ajax({
            url: "/mediaType?parentId=0",
            type: "get",
            success: function (data) {
                if (data) {
                    var mTypeEle = $("[name='artType']");
                    for (var i = 0; i < data.length; i++) {
                        var mType = data[i];
                        mTypeEle.append("<option value='${id}'>${name}</option>".replace("${id}", mType.id).replace("${name}", mType.name));
                    }
                }
            }
        });
    },
    //加载媒介
    loadWorker: function () {
        var ele = $("#mediaUserId");
        //如果没有部门权限，则只加载当前用户
        if(!user.currentDeptQx){
            ele.append("<option value="+user.id+">"+user.name+"</option>");
        }else{
            ele.empty();
            ele.append('<option value="">全部</option>');
            Views.loadDeptUser("","MJ","mediaUserId",searchForm.worker);
        }
    },
    //显示或隐藏发布日期
    showIssuedDate: function (val) {
        if (val == 5) {
            $("#issuedDateFormGroup").show();
        } else {
            $("#issuedDateFormGroup").hide();
        }
    },
    //查询
    search: function () {
        var searchFormData = $("#searchForm").serializeJson();

        if (searchFormData.timeQuantum == 1 || searchFormData.timeQuantum == 2) {
            $("#statisticsResultTable").hide();
            $("#statisticsResultPie").hide();
            $("#statisticsResultChart").attr("class", "col-sm-12");

            $("#supplierResultTable").hide();
            $("#supplierResultPie").hide();
            $("#supplierResultChart").attr("class", "col-sm-12");
        } else {
            $("#statisticsResultTable").show();
            $("#statisticsResultPie").show();
            $("#statisticsResultChart").attr("class", "col-sm-6");

            $("#supplierResultTable").show();
            $("#supplierResultPie").show();
            $("#supplierResultChart").attr("class", "col-sm-6");
        }
        //加载媒介统计结果
        $.ajax({
            url: "/mediaUsereStatistics/mediaUserResult",
            type: "post",
            data: searchFormData,
            success: function (resData) {
                //statisticsResult.reflush([{month:"5月份",saleAmount:50,noIncomeAmount:30,yqIncomeAmount:20,dqysIncomeAmount:80}]);
                statisticsResult.reflush(resData);
            }
        });
        //加载供应商统计结果
        $.ajax({
            url: "/mediaUsereStatistics/supplierResult",
            type: "post",
            data: searchFormData,
            success: function (resData) {
                //supplierResult.reflush([{month:"5月份",artCount:50,payAmount:30,outgoAmount:20,qkAmount:80}]);
                supplierResult.reflush(resData);
            }
        });
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
        "title": {"text": "媒介统计结果", "subtext": "", "x": "left"},
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["登记供应商数量", "合作金额总额", "未支付金额"]},
        "tooltip": {
            "show": true,
            trigger: 'axis'
        },
        calculable: true,
        "xAxis": [{
            "type": "category",
            "data": []
        }],
        "yAxis": [
            {
                "type": "value",
                name: '(单位/元)'
            }
        ],
        "series": [{"name": "登记供应商数量", "type": "bar", "data": []},
            {"name": "合作金额总额", "type": "bar", "data": []},
            {"name": "未支付金额", "type": "bar", "data": []}
        ]
    },
    //饼图的option
    pieOption: {},
    init: function () {
        statisticsResult.chart = echarts.init(document.getElementById('statisticsResultChart'));
        statisticsResult.pie = echarts.init(document.getElementById('statisticsResultPie'));
    },
    load: function () {
        statisticsResult.chart.setOption(statisticsResult.option, true);
    },
    loadPie: function (opt) {
        $.extend(true, statisticsResult.pieOption, statisticsResult.option);
        var val1 = opt.series[0].data[0] || 0;
        var val2 = opt.series[1].data[0] || 0;
        var val3 = opt.series[2].data[0] || 0;
        statisticsResult.pieOption.title = {};
        statisticsResult.pieOption.xAxis = null;
        statisticsResult.pieOption.yAxis = null;
        statisticsResult.pieOption.series = [
            {
                name: '媒介统计结果',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: val1, name: '登记供应商数量'},
                    {value: val2, name: '合作金额总额'},
                    {value: val3, name: '未支付金额'}
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
    loadTable: function (opt) {
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
    reflush: function (dataList) {
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
        for (var i = 0; i < len; i++) {
            statisticsResult.option.series[0].data = [];
            statisticsResult.option.xAxis[0].data = [];
            statisticsResult.option.series[0].data[i] = 0;
            statisticsResult.option.series[1].data[i] = 0;
            statisticsResult.option.series[2].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            statisticsResult.option.xAxis[0].data[i] = dataList[i].month ? dataList[i].month+dw : "";
            statisticsResult.option.series[0].data[i] = dataList[i].djgyssl || 0;
            statisticsResult.option.series[1].data[i] = dataList[i].hzjeze || 0;
            statisticsResult.option.series[2].data[i] = dataList[i].wzfje || 0;
        }

        //加载客户统计结果
        statisticsResult.load();

        if (searchFormData.timeQuantum == 1 || searchFormData.timeQuantum == 2) {

        } else {
            statisticsResult.loadPie(statisticsResult.option);
            statisticsResult.loadTable(statisticsResult.option);
        }
    }
};

//供应商统计结果
var supplierResult = {
    //左边的柱状图
    chart: {},
    //右边的饼图
    pie: {},
    //柱状图的option
    option: {
        "title": {"text": "供应商统计结果", "subtext": "", "x": "left"},
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["稿件总数", "应付金额", "已付金额", "请款金额"]},
        "tooltip": {
            "show": true,
            trigger: 'axis'
        },
        calculable: true,
        "xAxis": [{
            "type": "category",
            "data": []
        }],
        "yAxis": [
            {
                "type": "value",
                name: '(单位/元)'
            }
        ],
        "series": [{"name": "稿件总数", "type": "bar", "data": []},
            {"name": "应付金额", "type": "bar", "data": []},
            {"name": "已付金额", "type": "bar", "data": []},
            {"name": "请款金额", "type": "bar", "data": []}
        ]
    },
    //饼图的option
    pieOption: {},
    init: function () {
        supplierResult.chart = echarts.init(document.getElementById('supplierResultChart'));
        supplierResult.pie = echarts.init(document.getElementById('supplierResultPie'));
    },
    load: function () {
        supplierResult.chart.setOption(supplierResult.option, true);
    },
    loadPie: function (opt) {
        $.extend(true, supplierResult.pieOption, supplierResult.option);
        var val1 = opt.series[0].data[0] || 0;
        var val2 = opt.series[1].data[0] || 0;
        var val3 = opt.series[2].data[0] || 0;
        var val4 = opt.series[3].data[0] || 0;
        supplierResult.pieOption.title = {};
        supplierResult.pieOption.xAxis = null;
        supplierResult.pieOption.yAxis = null;
        supplierResult.pieOption.series = [
            {
                name: '媒介统计结果',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: val1, name: '稿件总数'},
                    {value: val2, name: '应付金额'},
                    {value: val3, name: '已付金额'},
                    {value: val4, name: '请款金额'}
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
        console.log(JSON.stringify(supplierResult.pieOption));
        supplierResult.pie.setOption(supplierResult.pieOption);
    },
    loadTable: function (opt) {
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
        $("#supplierResultTable").html(table);
    },
    reflush: function (dataList) {
        var searchFormData = $("#searchForm").serializeJson();
        var dw = "月";
        if(searchFormData.timeQuantum == 4){
            dw = "日";
        }else if(searchFormData.timeQuantum == 5){
            dw = "";
        }

        supplierResult.init();

        var len = supplierResult.option.series[0].data.length;
        //清空原来的数据
        for (var i = 0; i < len; i++) {
            supplierResult.option.series[0].data = [];
            supplierResult.option.xAxis[0].data = [];
            supplierResult.option.series[0].data[i] = 0;
            supplierResult.option.series[1].data[i] = 0;
            supplierResult.option.series[2].data[i] = 0;
            supplierResult.option.series[3].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            supplierResult.option.xAxis[0].data[i] = dataList[i].month ? dataList[i].month+dw : "";
            supplierResult.option.series[0].data[i] = dataList[i].artCount || 0;
            supplierResult.option.series[1].data[i] = dataList[i].payAmount || 0;
            supplierResult.option.series[2].data[i] = dataList[i].outgoAmount || 0;
            supplierResult.option.series[3].data[i] = dataList[i].qkAmount || 0;
        }

        //加载客户统计结果
        supplierResult.load();

        if (searchFormData.timeQuantum == 1 || searchFormData.timeQuantum == 2) {

        } else {
            supplierResult.loadPie(supplierResult.option);
            supplierResult.loadTable(supplierResult.option);
        }
    }
};
