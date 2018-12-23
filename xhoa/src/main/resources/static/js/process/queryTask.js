$(document).ready(function () {
    // 查询表格的校验；
    $("#queryForm").validate({
        rules: {
            urgencyLevel: {digits: true},
            dateStart: {date: true},
            dateEnd: {date: true}
        }, message: {
            urgencyLevel: {digits: "请输入正确的紧急程度。"},
            dateStart: {date: "请输入正确的开始日期。"},
            dateEnd: {date: "请输入正确的结束日期。"}
        }
    });

    // 时间控件；
    var dateStart = {
        elem: '#dateStart',
        format: 'YYYY/MM/DD ',
        // min: laydate.now(), //设定最小日期为当前日期
        max: laydate.now(),//最大日期
        istime: true,
        istoday: false,
        choose: function (datas) {
            dateEnd.min = datas; //开始日选好后，重置结束日的最小日期
            dateEnd.start = datas //将结束日的初始值设定为开始日
        }
    };
    var dateEnd = {
        elem: '#dateEnd',
        format: 'YYYY/MM/DD ',
        //min: laydate.now(),
        max: laydate.now(),
        istime: true,
        istoday: false,
        choose: function (datas) {
            dateStart.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    laydate(dateStart);
    laydate(dateEnd);

    // 设置表格默认的UI样式；
    $.jgrid.defaults.styleUI = 'Bootstrap';

    // 窗口拖拽绑定事件；
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#taskTable').setGridWidth(width);
    });

    // 查询按钮；
    $("#dataSearch").click(function () {
        if ($("#queryForm").valid()) {
            reloadTaskData();
        }
    });

    // 批量同意按钮；
    $("#dataAgree").click(function () {
        approveData(true);
    });

    // 批量拒绝按钮；
    $("#dataReject").click(function () {
        approveData(false);
    });

    // 修改查询条件表单的Lable右间距；
    $(".control-label").css({"padding": "7px 0 0 0", "margin-right": "-10px", "width": "65px"});

    // 初始化数据；
    $("#taskTable").jqGrid({
        url: baseUrl + "process/list",
        datatype: "json",
        mtype: 'POST',
        postData: $("#queyrForm").serializeJson(),
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,
        rownumbers: false,
        //setLabel: "序号",
        autowidth: true,
        gridview: true,
        cellsubmit: "clientArray",
        viewrecords: true,
        multiselect: true,
        multiselectWidth: 50,
        sortable: "true",
        sortname: "taskId",
        sortorder: "taskId",
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,
        rowList: [10, 25, 50],
        jsonReader: {
            root: "list", page: "pageNum", total: "pages", records: "total", repeatitems: false, id: "taskId"
        },
        colModel: [
            {name: 'taskId', label: 'taskId', hidden: true, width: 60},
            {name: 'index', label: '序号', width: 60},
            {name: 'processName', label: '审批项目', width: 120},
            {name: 'dataName', label: '项目名称', width: 120},
            {
                name: 'urgencyLevel', label: '紧急程度', width: 120, formatter: function (a, b, rowdata) {
                    var level = rowdata.urgencyLevel;
                    if (level == 1) {
                        return "<b style='color:red;'>紧急</b>";
                    } else if (level == 2) {
                        return "<b style='color:darkorange;'>较急</b>";
                    } else {
                        return "<b style='color:green;'>普通</b>";
                    }
                }
            },
            {name: 'userName', label: '提交人员', width: 120},
            {name: 'initiatorDeptName', label: '提交部门', width: 120},
            {
                name: 'processDate', label: '提交日期', width: 120, formatter: function (a, b, rowdata) {
                    return new Date(rowdata.processDate).format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows) {
                    var html = "";
                    html += "<a href='";
                    html += rows.processUrl;
                    html += "' style='height:22px;width:40px;'>审批&nbsp;&nbsp;</a>";
                    return html;
                },
            }
        ],
        pager: jQuery("#taskTableNav"),
        viewrecords: true,
        caption: "审批列表",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        gridComplete: function () {
            // 单选框居中；
            $(".cbox").addClass("icheckbox_square-green");
        }
    });
});

// 重新载入数据；
function reloadTaskData() {
    $("#taskTable").emptyGridParam();
    $("#taskTable").jqGrid('setGridParam', {
        postData: $("#queryForm").serializeJson()
    }).trigger("reloadGrid");
}

// 批量操作数据；
function approveData(flag) {
    var ids = $("#taskTable").jqGrid("getGridParam",
        "selarrrow");
    if (ids.length > 0) {
        layer.msg("系统处理中，请稍候。");
        startModal("#dataAgree");
        $.post(baseUrl + "process/apply", {
            taskIds: ids.toString(),
            agree: flag,
            desc: $("#desc").val()
        }, function (data) {
            Ladda.stopAll();
            if (data.data == null) {
                layer.msg(data.msg);
            } else {
                layer.msg(data.data.message);
            }
            reloadTaskData();
        }, "json")
    } else {
        layer.msg("请选择要操作的数据。");
    }
}