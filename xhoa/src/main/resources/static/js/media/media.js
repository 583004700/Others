var url="mediaInfo";
$(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_medias').setGridWidth(width);

    });
    init();
    // $.get("/mediaType/parentId/0?isFlag=true", function (data) {
    $.get("/mediaType/userId", function (data) {
        if (data == null || data == '') {
            swal("没有板块可操作！", "没有查询到板块信息，请联系管理员赋权！", "warning");
            return;
        }
        getResCode(data);
        var html = "";
        $(data).each(function (i, item) {
            html += "<span class='col-md-1' title='" + item.name + "' onclick='loadTerm(" + item.id + ",this)'>" + item.name + "</span>";
        });
        $("#mediaTypeUL>li>div").html(html);
        $("#mediaTypeUL>li>div>span:first-child").click();
    }, "json");

});
/**
 * 初始化数据
 */
function init() {
    var mediaTypeId = $("#mediaTypeVal").val();
    $("#table_medias").jqGrid({//2600
        // url: '/mediaInfo',
        datatype: "json",
        postData: $("#termForm").serializeJson(),
        mtype: 'get',
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: true,
        setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselectWidth: 25, //设置多选列宽度
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        // multiselect: true,
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 15,//每页显示记录数
        rowList: [15, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },
        colModel: [
            {
                name: 'id',
                label: 'id',
                editable: true,
                hidden: true,
                sorttype: "int",
                search: true
            }, {
                name: 'n1Data',
                hidden: true
            }, {
                name: 'n2Data',
                hidden: true
            }, {
                name: 'n3Data',
                hidden: true
            }, {
                name: 'n4Data',
                hidden: true
            }, {
                name: 'n5Data',
                hidden: true
            }, {
                name: 'n6Data',
                hidden: true
            }, {
                name: 'n7Data',
                hidden: true
            }, {
                name: 'n8Data',
                hidden: true
            },
            {
                name: 'user.name',
                hidden: true
            },
            {
                name: 'supplier.id',
                hidden: true
            },
            {
                name: 'supplier.name',
                hidden: true
            },
            {
                name: 'picPath',
                label: '媒体图标',
                editable: true,
                width: 40,
                align: "center",
                formatter: function (v, options, row) {
                    return '<img class="head-img" src="' + v + '"/>';
                }
            },
            {
                name: 'name',
                label: '媒体名称',
                editable: true,
                width: 50,
                align: "center"
            },
            {
                name: 'supplierId',
                label: '供应商',
                editable: true,
                width: 40,
                align: "center",
                formatter: function (v, options, row) {
                    return row.supplier ? row.supplier.name : '';
                }
            },
            // {
            //     name: 'contactor',
            //     label: '联系人',
            //     editable: true,
            //     width: 50,
            //     align: "center"
            // },
            // {
            //     name: 'phone',
            //     label: '联系电话',
            //     editable: true,
            //     width: 50,
            //     align: "center"
            // },
            // {
            //     name: 'qqwechat',
            //     label: 'QQ/微信',
            //     editable: true,
            //     width: 50,
            //     align: "center"
            // },
            {
                name: 'remarks',
                label: '描述',
                editable: true,
                width: 60,
                align: "center"
            },
            {
                name: 'updateDate',
                label: '更新时间',
                width: 50,
                align: "center",
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}
            },
            {
                name: 'userId',
                label: '责任人',
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    return row.user ? row.user.name : '';
                }
            },
            {
                name: 'd1',
                label: "价格有效期间",
                hidden: true,
                editable: true,
                width: 50,
                align: "center",
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}
            },
            {
                name: 'n1',
                label: "媒体类型",
                hidden: true,
                editable: true,
                width: 40,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n1Data ? row.n1Data.name : v ? v : "";
                }
            },
            {
                name: 'n2',
                label: "地区",
                editable: true,
                hidden: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n2Data ? row.n2Data.name : v ? v : "";
                }
            },
            {
                name: 'n3',
                label: "行业类型",
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    // console.log(row.n3Data);
                    return row.n3Data ? row.n3Data.name : v ? v : "";
                }
            },
            {
                name: 'n4',
                label: "资源类别筛选",
                hidden: true,
                editable: true,
                width: 50,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n4Data ? row.n4Data.name : v ? v : "";
                }
            },
            {
                name: 'n5',
                label: "是否500强",
                hidden: true,
                editable: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    // return row.n5Data ? row.n5Data.name : v ? v : "";
                    return row.n5Data ? row.n5Data.name : v == 0 ? '是' : "否";
                }
            },
            {
                name: 'n6',
                label: "n6",
                editable: true,
                hidden: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n6Data ? row.n6Data.name : v == 0 ? '是' : "否";
                }
            },
            {
                name: 'n7',
                label: "粉丝数",
                hidden: true,
                editable: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n7Data ? row.n7Data.name : v;
                }
            },
            {
                name: 'n8',
                label: "历史头条阅读量",
                hidden: true,
                editable: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n8Data ? row.n8Data.name : v ? v : "";
                }
            },
            {
                name: 'c1',
                label: "账号名称",
                editable: true,
                hidden: true,
                width: 50,
                align: "center"
            },
            {
                name: 'c2',
                label: "ID",
                editable: true,
                hidden: true,
                width: 50,
                align: "center"
            },
            {
                name: 'c3',
                label: "账号介绍",
                editable: true,
                hidden: true,
                width: 40,
                align: "center"
            },
            {
                name: 'f1',
                label: "撰稿发布",
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    if (!v)
                        return "";
                    return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
                }
            },
            {
                name: 'f2',
                label: "撰稿价格",
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    if (!v)
                        return "";
                    return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
                }
            },
            {
                name: 'f3',
                label: "头条刊例价",
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    if (!v)
                        return "";
                    return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
                }
            },
            {
                name: 'f4',
                label: "次条刊例价",
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    if (!v)
                        return "";
                    return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
                }
            },
            {
                name: 'f5',
                label: "其他刊例价",
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    if (!v)
                        return "";
                    var html = "<label>${f1}:</label><input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span><br/>";
                }
            },
            {
                label: "价格",
                editable: true,
                // hidden: true,
                width: 95,
                align: "left",
                formatter: function (v, options, row) {
                    var f1 = (row.f1 ? row.f1 : '');
                    var f2 = (row.f2 ? row.f2 : '');
                    var f3 = (row.f3 ? row.f3 : '');
                    var f4 = (row.f4 ? row.f4 : '');
                    var f5 = (row.f5 ? row.f5 : '');
                    var f6 = (row.f6 ? row.f6 : '');
                    var html = "";
                    if (f1 != '')
                        html = "<label name='f1'></label><span class='text-red font-bold'>￥" + f1 + "</span>;";
                    if (f2 != '')
                        html += "<label name='f2'></label><span class='text-red font-bold'>￥" + f2 + "</span><br/>";
                    if (f3 != '')
                        html += "<label name='f3'></label><span class='text-red font-bold'>￥" + f3 + "</span>;";
                    if (f4 != '')
                        html += "<label name='f4'></label><span class='text-red font-bold'>￥" + f4 + "</span><br/>";
                    if (f5 != '')
                        html += "<label name='f5'></label><span class='text-red font-bold'>￥" + f5 + "</span>;";
                    if (f6 != '')
                        html += "<label name='f6'></label><span class='text-red font-bold'>￥" + f6 + "</span>";
                    // console.log(html);
                    return html;
                }
            },
            {
                name: 'f6',
                label: '折扣率',
                editable: true,
                hidden: true,
                width: 30,
                align: "center",
            },
            {
                name: 'discount',
                label: '折扣率',
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return v ? v + " %" : "100%";
                }
            }
        ],
        pager: "#pager_medias",
        viewrecords: true,
        caption: "媒体列表",
        hidegrid: false,
        loadComplete: function (data) {
            if (getResCode(data))
                return;
            // reData();
        }, ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            page('/media/modifyMedia?id=' + rowid, '媒体修改' + rowid);
        }
    });
    $("#table_medias").jqGrid('setLabel', 'rn', '序号', {'text-align': 'center'}, '');
    $("#table_medias").setSelection(4, true);
    // $('#table_medias').setGridHeight(360);
}
