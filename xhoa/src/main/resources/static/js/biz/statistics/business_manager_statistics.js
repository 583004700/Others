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
        topOption.setValue("saleAmountBox", "4");
        topOption.setValue("incomeAmountBox", "4");
        topOption.setValue("cjPeoBox", "4");
    },
    //设置统计数值
    setValue: function (id, dateSelect) {
        $.ajax({
            url: "/businessManagerStatistics/topOptionSetValue",
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
            url: "/businessManagerStatistics/topOptionSetValue",
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
        "legend": {"y": "8px", "data": ["稿件数量", "应收金额", "入账金额"]},
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
                name: '(单位：件、元、元)'
            }
        ],
        "series": [{"name": "稿件数量", "type": "bar", "data": []},
            {"name": "应收金额", "type": "bar", "data": []},
            {"name": "入账金额", "type": "line", "data": []}
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
            middleOption.option.series[2].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            middleOption.option.xAxis[0].data[i] = dataList[i].sj ? dataList[i].sj+dw : "";
            middleOption.option.series[0].data[i] = dataList[i].artCount || 0;
            middleOption.option.series[1].data[i] = dataList[i].saleAmount || 0;
            middleOption.option.series[2].data[i] = dataList[i].incomeAmount || 0;
        }
        middleOption.load();
    }
};

var orderSort = {
    gridObj: {
        url: '/businessManagerStatistics/orderSort',
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
        rowNum: 19,
        rowList: [10, 20, 30],
        colNames: ['客户名称', '订单金额', '稿件数量', '业务员名称'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
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
                name: 'amount',
                index: 'amount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'artCount',
                index: 'artCount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'userName',
                index: 'userName',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
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
        $("#orderSortForm").find("[name='dateSelect']").val("4");
        orderSort.grid = new dataGrid("orderSortTable", orderSort.gridObj, "", "orderSortForm");
        orderSort.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#orderSortForm").find("[name='dateSelect']").val(dateSelect);
        orderSort.grid.search();
    }
};

var saleAmountSort = {
    gridObj: {
        url: '/businessManagerStatistics/articleSort',
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
        rowNum: 19,
        rowList: [10, 20, 30],
        colNames: ['客户名称', '应收金额', '到款金额', '变化趋势'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
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
                name: 'incomeAmount',
                index: 'incomeAmount',
                editable: false,
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'changeValue',
                index: 'changeValue',
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
        $("#saleAmountSortForm").find("[name='dateSelect']").val("4");
        saleAmountSort.grid = new dataGrid("saleAmountSortTable", saleAmountSort.gridObj, "", "saleAmountSortForm");
        saleAmountSort.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#saleAmountSortForm").find("[name='dateSelect']").val(dateSelect);
        saleAmountSort.grid.search();
    }
};

var noIncomeSort = {
    gridObj: {
        url: '/businessManagerStatistics/articleSort',
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
        rowNum: 19,
        rowList: [10, 20, 30],
        colNames: ['客户名称', '应收金额', '未到款金额', '变化趋势'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
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
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'changeValue',
                index: 'changeValue',
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
        $("#noIncomeSortForm").find("[name='dateSelect']").val("4");
        noIncomeSort.grid = new dataGrid("noIncomeSortTable", noIncomeSort.gridObj, "", "noIncomeSortForm");
        noIncomeSort.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#noIncomeSortForm").find("[name='dateSelect']").val(dateSelect);
        noIncomeSort.grid.search();
    }
};

var noIncomeSort1 = {
    gridObj: {
        url: '/businessManagerStatistics/articleSort',
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
        rowNum: 19,
        rowList: [10, 20, 30],
        colNames: ['业务员名称', '应收金额', '未到款金额', '变化趋势'],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: false
        },
        colModel: [
            {
                name: 'userName',
                index: 'userName',
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
                width: 100,
                align: "center",
                sortable: false
            },
            {
                name: 'changeValue',
                index: 'changeValue',
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
        $("#noIncomeSortForm1").find("[name='dateSelect']").val("4");
        noIncomeSort1.grid = new dataGrid("noIncomeSortTable1", noIncomeSort1.gridObj, "", "noIncomeSortForm1");
        noIncomeSort1.grid.loadGrid();
    },
    reflush: function (dateSelect) {
        $("#noIncomeSortForm1").find("[name='dateSelect']").val(dateSelect);
        noIncomeSort1.grid.search();
    }
};

//部门业务量
var deptBusiness = {
    //下钻功能需要保存的数组,保存当前展示的多个部门
    depts: [],
    //返回上一级需要保存的数组
    deptStack: [],
    dateSelect: '4',
    dept:{},
    init:function(){
        $("#deptBusiness").show();
        //默认加载天
        deptBusiness.setValue(user.dept,deptBusiness.dateSelect);
    },
    chart: {},
    setValue: function (dept,dateSelect) {
        deptBusiness.dept = dept;
        deptBusiness.dateSelect = dateSelect;
        deptBusiness.depts = [];
        var ds = "";
        for(var i = 0;i<dept.depts.length;i++){
            deptBusiness.depts.push(dept.depts[i]);
            ds += (","+dept.depts[i].id);
        }
        $.ajax({
            url: "/businessManagerStatistics/everyDeptBusiness",
            data:{list:ds,dateSelect:dateSelect},
            success: function (resData) {
                deptBusiness.reflush(resData);
            }
        });
    },
    clickEvent:function(param){
        var dept = deptBusiness.depts[param.dataIndex];
        console.log(user);
        if(!dept.depts || dept.depts.length < 1){
            parent.layer.alert("该部门下没有子部门");
            return;
        }
        $("#returnS").show();
        deptBusiness.deptStack.push(deptBusiness.dept);
        deptBusiness.setValue(dept,deptBusiness.dateSelect);
    },
    //返回上一级
    returnS:function(){
        var dept = deptBusiness.deptStack.pop();
        if(deptBusiness.deptStack.length == 0){
            $("#returnS").hide();
        }
        deptBusiness.setValue(dept,deptBusiness.dateSelect);
    },
    option: {
        "title": {"text": "", "subtext": "", "x": "left"},
        "color": ["#e5323e", "#003366", "#006699"],
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["应收金额", "利润"]},
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
                name: '(单位：元、元)'
            }
        ],
        "series": [{"name": "应收金额", "type": "bar", "data": []},
            {"name": "利润", "type": "bar", "data": []}
        ]
    },
    load: function () {
        deptBusiness.chart = echarts.init(document.getElementById('deptBusiness_chart'));
        deptBusiness.chart.setOption(deptBusiness.option, true);
        deptBusiness.chart.on("click", deptBusiness.clickEvent);
    },
    reflush: function (dataList) {
        var len = deptBusiness.option.series[0].data.length;
        //清空原来的数据
        for (var i = 0; i < len; i++) {
            deptBusiness.option.series[0].data = [];
            deptBusiness.option.xAxis[0].data = [];
            deptBusiness.option.series[0].data[i] = 0;
            deptBusiness.option.series[1].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            deptBusiness.option.xAxis[0].data[i] = dataList[i].deptName || "";
            deptBusiness.option.series[0].data[i] = dataList[i].saleAmount || 0;
            deptBusiness.option.series[1].data[i] = dataList[i].profit || 0;
        }
        deptBusiness.load();
    }
};

//本部门的销售额排名
var deptSaleAmountSort = {
    chart: {},
    init: function () {
        $("#deptSaleAmountSort").show();
        deptSaleAmountSort.setValue("deptSaleAmountSortBox", "4");
    },
    setValue: function (id, dateSelect) {
        $.ajax({
            url: "/businessManagerStatistics/businessTop",
            data: {deptId:user.deptId,tjType: id, dateSelect: dateSelect},
            success: function (resData) {
                deptSaleAmountSort.reflush(resData);
            }
        });
    },
    option: {
        "title": {"text": "业务量前5名", "subtext": "", "x": "left"},
        "color": ["#e5323e", "#003366", "#006699"],
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["应收金额"]},
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
                name: '(单位：元)'
            }
        ],
        "series": [
            {"name": "应收金额", "type": "bar", "data": []}
        ]
    },
    load: function () {
        deptSaleAmountSort.chart = echarts.init(document.getElementById('deptSaleAmountSort_chart'));
        deptSaleAmountSort.chart.setOption(deptSaleAmountSort.option, true);
    },
    reflush: function (dataList) {
        var len = deptSaleAmountSort.option.series[0].data.length;
        //清空原来的数据
        for (var i = 0; i < len; i++) {
            deptSaleAmountSort.option.series[0].data = [];
            deptSaleAmountSort.option.xAxis[0].data = [];
            deptSaleAmountSort.option.series[0].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            deptSaleAmountSort.option.xAxis[0].data[i] = dataList[i].userName || "";
            deptSaleAmountSort.option.series[0].data[i] = dataList[i].saleAmount || 0;
        }
        deptSaleAmountSort.load();
    }
};

//部门回款排名
var deptIncomeSort = {
    chart: {},
    init: function () {
        deptIncomeSort.setValue("deptIncomeSortBox", "4");
    },
    setValue: function (id, dateSelect) {
        $.ajax({
            url: "/businessManagerStatistics/businessTop",
            data: {deptId:user.deptId,tjType: id, dateSelect: dateSelect},
            success: function (resData) {
                deptIncomeSort.reflush(resData);
            }
        });
    },
    option: {
        "title": {"text": "回款前5名", "subtext": "", "x": "left"},
        "color": ["#e5323e", "#003366", "#006699"],
        "backgroundColor": "#fff",
        "legend": {"y": "8px", "data": ["入账金额"]},
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
                name: '(单位：元)'
            }
        ],
        "series": [
            {"name": "入账金额", "type": "bar", "data": []}
        ]
    },
    load: function () {
        deptIncomeSort.chart = echarts.init(document.getElementById('deptIncomeSort_chart'));
        deptIncomeSort.chart.setOption(deptIncomeSort.option, true);
    },
    reflush: function (dataList) {
        var len = deptIncomeSort.option.series[0].data.length;
        //清空原来的数据
        for (var i = 0; i < len; i++) {
            deptIncomeSort.option.series[0].data = [];
            deptIncomeSort.option.xAxis[0].data = [];
            deptIncomeSort.option.series[0].data[i] = 0;
        }

        for (var i = 0; i < dataList.length; i++) {
            deptIncomeSort.option.xAxis[0].data[i] = dataList[i].userName || "";
            deptIncomeSort.option.series[0].data[i] = dataList[i].incomeAmount || 0;
        }
        deptIncomeSort.load();
    }
};