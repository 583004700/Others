var common = {
    dateSelect: function (id, value) {
        $("#" + id).find("a").removeClass("hover");
        $(value).addClass("hover");
    }
};

var topOption = {
    init: function () {
        //统计当天信息
        topOption.setValue("artCountBox", "4");
        topOption.setValue("payAmountBox", "4");
        topOption.setValue("outgoAmountBox", "4");
        topOption.setValue("qkAmountBox", "4");
    },
    //设置统计数值
    setValue: function (id, dateSelect) {
        $.ajax({
            url: "/mediaUsereManagerStatistics/topOptionSetValue",
            data: {tjType: id, dateSelect: dateSelect},
            success: function (resData) {
                var obj = resData.length > 0 ? resData[0] : {};
                if (obj == null) {
                    obj = {};
                }
                topOption.set(id, obj);
            }
        })
    },
    set: function (id, obj) {
        var value = obj.value || 0;
        var changeValue = obj.changeValue || 0;

        var colorUp = "rgba(35, 198, 200, 1)";
        var colorDown = "rgb(237, 85, 101)";
        var iconUp = "fa-level-up";
        var iconDown = "fa-level-down";

        var colorValue = colorUp;
        var iconValue = iconUp;
        if (changeValue < 0) {
            colorValue = colorDown;
            iconValue = iconDown;
        }
        changeValue = (changeValue * 100).toFixed(1).replace("-", "") + "%";

        $("#" + id).find(".value").html(value);
        $("#" + id).find(".colorValue").css({"color": colorValue});
        $("#" + id).find(".changeValue").html(changeValue);
        $("#" + id).find(".iconValue").removeClass(iconUp);
        $("#" + id).find(".iconValue").removeClass(iconDown);
        $("#" + id).find(".iconValue").addClass(iconValue);
    }
};

var middleOption = {
    chart: {},
    init: function () {
        middleOption.setValue("middleBox", "4");
    },
    setValue: function (id, dateSelect) {
        $.ajax({
            url: "/mediaUsereManagerStatistics/topOptionSetValue",
            data: {tjType: id, dateSelect: dateSelect},
            success: function (resData) {
                var dw = getDateStr(dateSelect);
                middleOption.reflush(resData,dw);
            }
        });
    },
    option: {
        "title": {"text": "", "subtext": "", "x": "left"},
        "color": ["#e5323e", "#003366", "#006699"],
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["稿件数量", "应付金额"]},
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
                name: '(单位：件、元)'
            }
        ],
        "series": [{"name": "稿件数量", "type": "bar", "data": []},
            {"name": "应付金额", "type": "bar", "data": []}
        ]
    },
    load: function () {
        middleOption.chart = echarts.init(document.getElementById('meddle_chart'));
        middleOption.chart.setOption(middleOption.option, true);
    },
    reflush: function (dataList,dw) {
        var len = middleOption.option.series[0].data.length;
        //清空原来的数据
        for (var i = 0; i < len; i++) {
            middleOption.option.series[0].data = [];
            middleOption.option.xAxis[0].data = [];
            middleOption.option.series[0].data[i] = 0;
            middleOption.option.series[1].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            middleOption.option.xAxis[0].data[i] = dataList[i].sj ? dataList[i].sj+dw : "";
            middleOption.option.series[0].data[i] = dataList[i].artCount || 0;
            middleOption.option.series[1].data[i] = dataList[i].payAmount || 0;
        }
        middleOption.load();
    }
};

var supplier = {
    gridObj: {
        url: '/mediaUsereManagerStatistics/supplierSort',
        postData: {},
        datatype: "json",
        mtype: 'get',
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
        rowNum: 23,
        rowList: [10, 20, 30],
        colNames: ['供应商名称', '应付金额', '已付金额', '变化趋势'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
            {
                name: 'supName',
                index: 'supName',
                editable: false,
                width: 90,
                align: "center",
                sortable: false,
                sorttype: "string"
            },
            {
                name: 'payAmount',
                index: 'payAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'incomeAmount',
                index: 'incomeAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'changePayAmount',
                index: 'changePayAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false,
                formatter: function (a, b, rowdata) {
                    var changeValue = rowdata.changePayAmount || 0;
                    var colorUp = "rgba(35, 198, 200, 1)";
                    var colorDown = "rgb(237, 85, 101)";

                    if (changeValue < 0) {
                        colorValue = colorDown;
                        changeValue = (changeValue * 100).toFixed(1) + "%";
                    } else {
                        colorValue = colorUp;
                        changeValue = "+" + (changeValue * 100).toFixed(1) + "%";
                    }
                    var html = '<span style="color:${colorValue}">${changeValue}</span>';
                    html = html.replace("${colorValue}", colorValue).replace("${changeValue}", changeValue);
                    return html;
                }
            }
        ],
        pager: "",
        viewrecords: true,
        caption: null,
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    grid: {},
    init: function () {
        Views.loadMediaType("artType");
        //默认加载天的数据
        $("#supplierForm").find("[name='dateSelect']").val("4");
        supplier.grid = new dataGrid("supplierTable", supplier.gridObj, "", "supplierForm");
        supplier.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#supplierForm").find("[name='dateSelect']").val(dateSelect);
        supplier.grid.search();
    }
};

var media = {
    gridObj: {
        url: '/mediaUsereManagerStatistics/supplierSort',
        postData: {},
        datatype: "json",
        mtype: 'get',
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
        rowNum: 23,
        rowList: [10, 20, 30],
        colNames: ['媒体名称', '应付金额', '已付金额', '变化趋势'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
            {
                name: 'medName',
                index: 'medName',
                editable: false,
                width: 90,
                align: "center",
                sortable: false,
                sorttype: "string"
            },
            {
                name: 'payAmount',
                index: 'payAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'incomeAmount',
                index: 'incomeAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'changePayAmount',
                index: 'changePayAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false,
                formatter: function (a, b, rowdata) {
                    var changeValue = rowdata.changePayAmount || 0;
                    var colorUp = "rgba(35, 198, 200, 1)";
                    var colorDown = "rgb(237, 85, 101)";

                    if (changeValue < 0) {
                        colorValue = colorDown;
                        changeValue = (changeValue * 100).toFixed(1) + "%";
                    } else {
                        colorValue = colorUp;
                        changeValue = "+" + (changeValue * 100).toFixed(1) + "%";
                    }
                    var html = '<span style="color:${colorValue}">${changeValue}</span>';
                    html = html.replace("${colorValue}", colorValue).replace("${changeValue}", changeValue);
                    return html;
                }
            }
        ],
        pager: "",
        viewrecords: true,
        caption: null,
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    grid: {},
    init: function () {
        //默认加载天的数据
        $("#mediaForm").find("[name='dateSelect']").val("4");
        media.grid = new dataGrid("mediaTable", media.gridObj, "", "mediaForm");
        media.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#mediaForm").find("[name='dateSelect']").val(dateSelect);
        media.grid.search();
    }
};

var outgo = {
    gridObj: {
        url: '/mediaUsereManagerStatistics/outgoSort',
        postData: {},
        datatype: "json",
        mtype: 'get',
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
        rowNum: 23,
        rowList: [10, 20, 30],
        colNames: ['供应商名称', '申请金额', '请款金额', '最近请款时间'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
            {
                name: 'supplierName',
                index: 'supplierName',
                editable: false,
                width: 90,
                align: "center",
                sortable: false,
                sorttype: "string"
            },
            {
                name: 'applyAmount',
                index: 'applyAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'payAmount',
                index: 'payAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'applyTime',
                index: 'applyTime',
                editable: false,
                width: 100,
                align: "center",
                sortable: false,
                formatter: function (d) {
                    return new Date(d).format("yyyy-MM-dd");
                }
            }
        ],
        pager: "",
        viewrecords: true,
        caption: null,
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    },
    grid: {},
    init: function () {
        //默认加载天的数据
        $("#outgoForm").find("[name='dateSelect']").val("4");
        outgo.grid = new dataGrid("outgoTable", outgo.gridObj, "", "outgoForm");
        outgo.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#outgoForm").find("[name='dateSelect']").val(dateSelect);
        outgo.grid.search();
    }
};

var artType = {
    chart:{},
    option: {
        "title": {},
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": []},
        "tooltip": {"show": true, "trigger": "axis"},
        "calculable": true,
        "xAxis": null,
        "yAxis": null,
        "series": []
    },
    init: function () {
        //默认加载当天数据
        artType.loadPie('4');
    },
    loadPie: function (dateSelect) {
        $("#artTypeForm").find("[name='dateSelect']").val(dateSelect);
        artType.option.title = {};
        artType.option.series = [
            {
                name: '',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [

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
        $.ajax({
            url:"/mediaUsereManagerStatistics/artTypeFb",
            data:$("#artTypeForm").serializeJson(),
            success:function(resData){
                artType.option.legend.data = [];
                artType.option.series[0].data = [];
                for(var i=0;i<resData.length;i++){
                    var name = resData[i].name || "";
                    var count = resData[i].count || 0;
                    var obj = {value:count,name:name};
                    artType.option.series[0].data.push(obj);
                    artType.option.legend.data.push(name);
                }
                artType.chart = echarts.init(document.getElementById('artTypeChart'));
                artType.chart.setOption(artType.option, true);
            }
        });
    }
};