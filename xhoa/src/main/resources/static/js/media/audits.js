var url="media";
$(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_medias').setGridWidth(width);

    });
    init();
    $.get("/mediaType/parentId/0?isFlag=true", function (data) {
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
        rowNum: 10,//每页显示记录数
        rowList: [10, 20, 30],//分页选项，可以下拉选择每页显示记录数
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
                //     name: 'n1Data',
                //     hidden: true
                // }, {
                //     name: 'n2Data',
                //     hidden: true
                // }, {
                //     name: 'n3Data',
                //     hidden: true
                // }, {
                //     name: 'n4Data',
                //     hidden: true
                // }, {
                //     name: 'n5Data',
                //     hidden: true
                // }, {
                //     name: 'n6Data',
                //     hidden: true
                // }, {
                //     name: 'n7Data',
                //     hidden: true
                // }, {
                //     name: 'n8Data',
                //     hidden: true
                // },
                // {
                //     name: 'user.name',
                //     hidden: true
                // },
                // {
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
                width: 30,
                align: "center",
                formatter: function (v, options, row) {
                    return '<img class="head-img" src="' + v + '"/>';
                }
            },
            {
                name: 'name',
                label: '媒体名称',
                editable: true,
                sortable: false,
                width: 30,
                align: "center"
                // },
                // {
                //     name: 'supplierId',
                //     label: '供应商',
                //     editable: true,
                //     width: 40,
                //     align: "center",
                //     formatter: function (v, options, row) {
                //         return row.supplier ? row.supplier.name : '';
                //     }
            },
            {
                name: 'supplierName',
                label: '供应商',
                editable: true,
                width: 40,
                align: "center"
            },
            // {
            //     name: 'contactor',
            //     label: '联系人',
            //     editable: true,
            //     width: 25,
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
                width: 40,
                align: "center",
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}
            },
            {
                name: 'userId',
                label: '责任人',
                width: 25,
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
                width: 35,
                align: "center",
                formatter: "date",
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}
            },
            {
                name: 'n1',
                label: "媒体类型",
                hidden: true,
                editable: true,
                width: 25,
                sortable: false,
                align: "center",
                formatter: function (v, options, row) {
                    return row.n1Data ? row.n1Data.name : v ? v : "";
                }
                // },
                // {
                //     name: 'n2',
                //     label: "地区",
                //     editable: true,
                //     hidden: true,
                //     width: 25,
                //     align: "center",
                //     sortable: false,
                //     formatter: function (v, options, row) {
                //         return row.n2Data ? row.n2Data.name : v ? v : "";
                //     }
            },
            {
                name: 'state',
                label: "审核状态",
                editable: true,
                // hidden: true,
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    switch (v) {
                        case 0:
                            return '<span>未审核</span>';
                        case 1:
                            return '<span class="text-info">已通过</span>';
                        case 2:
                            return '<span class="text-success">审核中</span>';
                        case -1:
                            return '<span class="text-danger">已驳回</span>';
                        case -999:
                            return '<span class="text-justify">已停用</span>';
                    }
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
            // {
            //     name: 'n4',
            //     label: "资源类别筛选",
            //     hidden: true,
            //     editable: true,
            //     width: 50,
            //     align: "center",
            //     formatter: function (v, options, row) {
            //         return row.n4Data ? row.n4Data.name : v ? v : "";
            //     }
            // },
            // {
            //     name: 'n5',
            //     label: "是否500强",
            //     hidden: true,
            //     editable: true,
            //     width: 30,
            //     align: "center",
            //     formatter: function (v, options, row) {
            //         // return row.n5Data ? row.n5Data.name : v ? v : "";
            //         return row.n5Data ? row.n5Data.name : v == 1 ? '是' : "否";
            //     }
            // },
            // {
            //     name: 'n6',
            //     label: "n6",
            //     editable: true,
            //     hidden: true,
            //     width: 25,
            //     align: "center",
            //     formatter: function (v, options, row) {
            //         return row.n6Data ? row.n6Data.name : v == 1 ? '是' : "否";
            //     }
            // },
            // {
            //     name: 'n7',
            //     label: "粉丝数",
            //     hidden: true,
            //     editable: true,
            //     width: 25,
            //     align: "center",
            //     formatter: function (v, options, row) {
            //         return row.n7Data ? row.n7Data.name : v ;
            //     }
            // },
            // {
            //     name: 'n8',
            //     label: "历史头条阅读量",
            //     hidden: true,
            //     editable: true,
            //     width: 30,
            //     align: "center",
            //     formatter: function (v, options, row) {
            //         return row.n8Data ? row.n8Data.name : v ? v : "";
            //     }
            // },
            // {
            //     name: 'c1',
            //     label: "账号名称",
            //     editable: true,
            //     hidden: true,
            //     width: 50,
            //     align: "center"
            // },
            // {
            //     name: 'c2',
            //     label: "ID",
            //     editable: true,
            //     hidden: true,
            //     width: 50,
            //     align: "center"
            // },
            {
                name: 'c3',
                label: "账号介绍",
                editable: true,
                hidden: true,
                width: 50,
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
                    return v;
                    // return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
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
                    return v;
                    // return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
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
                    return v;
                    // return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
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
                    return v;
                    // return "<input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span>";
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
                    return v;
                    // var html = "<label>${f1}:</label><input name=price_" + row.id + " type='radio' value='" + v + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥ " + v + "</span><br/>";
                }
            },
            {
                label: "价格",
                editable: true,
                // hidden: true,
                width: 80,
                align: "left",
                sortable: false,
                formatter: function (v, options, row) {
                    var f1 = (row.f1 ? row.f1 : '');
                    var f2 = (row.f2 ? row.f2 : '');
                    var f3 = (row.f3 ? row.f3 : '');
                    var f4 = (row.f4 ? row.f4 : '');
                    var f5 = (row.f5 ? row.f5 : '');
                    var f6 = (row.f6 ? row.f6 : '');
                    var html = "";
                    if (f1 != '')
                        html = "<label name='f1'></label><span class='text-red font-bold'>￥" + f1 + "</span>;&nbsp;&nbsp;";
                    if (f2 != '')
                        html += "<label name='f2'></label><span class='text-red font-bold'>￥" + f2 + "</span><br/>";
                    if (f3 != '')
                        html += "<label name='f3'></label><span class='text-red font-bold'>￥" + f3 + "</span>;&nbsp;&nbsp;";
                    if (f4 != '')
                        html += "<label name='f4'></label><span class='text-red font-bold'>￥" + f4 + "</span><br/>";
                    if (f5 != '')
                        html += "<label name='f5'></label><span class='text-red font-bold'>￥" + f5 + "</span>;&nbsp;&nbsp;";
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
                width: 20,
                align: "center",
                formatter: function (v, options, row) {
                    return v ? v + " %" : "100%";
                }
            },
            {
                name: 'commStart',
                label: '星级评分',
                width: 50,
                align: "center",
                formatter: function (v, options, row) {
                    return "<img src='/img/rating/stars-all.gif'/>";
                }
            },
            {
                name: 'operator',
                label: '审核操作',
                width: 60,
                align: "center",
                sortable: false,
                formatter: function (v, options, row) {
                    var html = "<button onclick='pass(" + row.id + ")' class='btn btn-success btn-sm'>通过</button>&nbsp;";
                    html += "<button onclick='reject(" + row.id + ")' class='btn btn-danger btn-sm'>驳回</button>&nbsp;";
                    html += "<button onclick='del(" + row.id + ")' class='btn btn-default btn-sm'>删除</button>";
                    return html;
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
        }
    });
    $("#table_medias").jqGrid('setLabel', 'rn', '序号', {'text-align': 'center'}, '');
    $("#table_medias").setSelection(4, true);
    rating();
}


/**
 * 审核通过
 */
function pass(id) {
    $.get("/media/pass/" + id, function (data) {
        if (data.code == 200) {
            swal("操作成功", "通过操作成功", 'success', 2000);
            reData();
        } else {
            swal("操作失败", "驳回操作失败" + data.msg, 'error', 2000);
        }
    });
}

/**
 * 审核驳回
 */
function reject(id) {
    $.get("/media/reject/" + id, function (data) {
        if (data.code == 200) {
            swal("操作成功", "驳回操作成功", 'success', 2000);
            reData();
        } else {
            swal("操作失败", "驳回操作失败" + data.msg, 'error', 2000);
        }
    });
}

/**
 * 审核删除
 */
function del(id) {
    $.get("/media/del/" + id, function (data) {
        if (data.code == 200) {
            swal("操作成功", "删除成功", 'success', 2000);
            reData();
        } else {
            swal("操作失败", "删除失败", 'error', 2000);
        }
    });
}