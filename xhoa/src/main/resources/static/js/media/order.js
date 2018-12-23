var url = "mediaInfo";
$(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_medias').setGridWidth(width);

    });
    init();
    $.get("/mediaType/parentId/0", function (data) {
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
                width: 50,
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
                width: 40,
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
                width: 40,
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
                width: 30,
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
                width: 30,
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
                width: 80,
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
                        html = "<label name='f1'></label><input name=price_" + row.id + " type='radio' value='" + f1 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f1 + "</span><br/>";
                    if (f2 != '')
                        html += "<label name='f2'></label><input name=price_" + row.id + " type='radio' value='" + f2 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f2 + "</span><br/>";
                    if (f3 != '')
                        html += "<label name='f3'></label><input name=price_" + row.id + " type='radio' value='" + f3 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f3 + "</span><br/>";
                    if (f4 != '')
                        html += "<label name='f4'></label><input name=price_" + row.id + " type='radio' value='" + f4 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f4 + "</span><br/>";
                    if (f5 != '')
                        html += "<label name='f5'></label><input name=price_" + row.id + " type='radio' value='" + f5 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f5 + "</span>";
                    if (f6 != '')
                        html += "<label name='f6'></label><input name=price_" + row.id + " type='radio' value='" + f6 + "' onchange='setPrice(" + JSON.stringify(row) + ",this)'/><span class='text-red font-bold'>￥" + f6 + "</span>";
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
                width: 60,
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
            // }, ondblClickRow: function (rowid, iRow, iCol, e) {
            //     //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            //     page('/mediaInfo/modifyMedia?id=' + rowid, '媒体修改' + rowid);
        }
    });
    $("#table_medias").jqGrid('setLabel', 'rn', '序号', {'text-align': 'center'}, '');
    $("#table_medias").setSelection(4, true);
    $('#table_medias').setGridHeight(360);
}


var ids = {};

/**
 * 设置价格
 * @param row
 * @param t
 */
function setPrice(row, t) {
    var id = row.id;
    var html = ids[id];
    var priceName = $(t).prev().text().replace(":", "");
    var priceColumn = $(t).prev().attr("column");
    var value = t.value != undefined ? t.value : 0;
    var name = (row.user != undefined ? row.user.name ? row.user.name : '' : '');
    var lr = $('#lr').val();
    var discount = (row.discount ? row.discount : 100);
    var price = value;
    if (ids[id] == null) {
        // html = '<tr id="row' + id + '"><td>' + id + '</td><td>' + (row.n1Data != undefined ? row.n1Data.name : '无') +
        html = '<tr id="row' + id + '"><td>' + id + '</td><td>' + $("#mediaTypeText").text() +
            '<input type="hidden" name="mediaId" value="' + row.id + '"/>' +
            '<input type="hidden" name="mediaName" value="' + row.name + '"/>' +
            '<input type="hidden" name="priceType" value="' + priceName + '"/>' +
            '<input type="hidden" name="priceColumn" value="' + priceColumn + '"/>' +
            '<input type="hidden" name="payAmount" value="' + (price * discount / 100) + '"/>' +
            '<input type="hidden" name="supplierId" value="' + row.supplier.id + '"/>' +
            '<input type="hidden" name="supplierName" value="' + row.supplier.name + '"/>' +
            '<input type="hidden" name="mediaUserId" value="' + row.userId + '"/>' +
            '<input type="hidden" name="mediaUserName" value="' + row.user.name + '"/>' +
            '<input type="hidden" name="industryId" value="' + row.n3 + '"/>' +
            '</td><td>' + row.name + '</td><td>' + name + '</td><td><img class="head-img" src="' + row.picPath + '"/></td><td>' + priceName + '</td><td>￥ <label>' +
            value + '</label></td><td><label>' + (discount) + '</label> %</td><td>' + row.supplier.name + '</td><td>' + row.updateDate + '</td>' +
            '<td><input name="num" onkeypress="return inNum(event)" size="5" value="1" onkeyup="updatePrice(this)"/></td><td><span class="text-red font-bold ">￥</span>' +
            '<input size="3" maxlength="5" name="price" value="' + price + '"/></td></tr>';
        ids[id] = html;//
        $("#order").append(html);
    } else {
        $("#row" + id).find("td:nth-child(6)").html(priceName);
        $("#row" + id).find("td:nth-child(7)").html('￥ <label>' + value + '</label>');
    }
    pushPrice($("#lr"));//更新价格
    sum()
}

/**
 * 推送数量
 * @param t
 */
function pushNum(t) {
    $("#order>tr>td:nth-child(11)>input").val(t.value);
    var lr = $('#lr').val();//利润率
    lr = parseInt(lr);
    var sum = 0;
    $("#order>tr").each(function (i, d) {
        var price = $(d).find("td:nth-child(7)>label").text();//成本价
        var discount = $(d).find("td:nth-child(8)>label").text();//折扣
        // console.log(discount);
        var num = $(d).find("td:nth-child(11)>input").val();//数量
        var amount = (price * num * (100 + lr) * discount) / 10000;
        sum += amount;
        $(d).find("td:nth-child(12)>input").val(amount);
    });
    $("#amount").val(sum);
    // sum()
}

/**
 * 推送价格
 * @param t
 */
function pushPrice(t) {
    var lr = $('#lr').val();//利润率+
    lr = parseInt(lr);
    var sum = 0;
    $("#order>tr>td:nth-child(12)>input").val(100 * t.value);//
    $("#order>tr").each(function (i, d) {
        var price = $(d).find("td:nth-child(7)>label").text();//成本价
        var discount = $(d).find("td:nth-child(8)>label").text();//折扣率
        var num = $(d).find("td:nth-child(11)>input").val();//数量
        var amount = (price * num * (100 + lr) * discount) / 10000;
        sum += amount;
        $(d).find("td:nth-child(12)>input").val(amount);
    });
    $("#amount").val(sum);
    // sum();
}

/**
 * 更新价格
 * @param t
 */
function updatePrice(t) {
    var num = $(t).val();
    var tr = $(t).parent().parent();
    var lr = $('#lr').val();//利润率+
    lr = parseInt(lr);
    var price = tr.find("td:nth-child(7)>label").text();//成本价
    var discount = tr.find("td:nth-child(8)>label").text();//折扣率
    var amount = (price * num * (100 + lr) * discount) / 10000;
    tr.find("td:nth-child(12)>input").val(amount);
    sum();
}

/**
 * 计算总量
 */
function sum() {
    var sum = 0;
    $("#order>tr").each(function (i, d) {
        var amount = $(d).find("td:nth-child(12)>input").val();//数量
        sum += parseInt(amount);
    });
    $("#amount").val(sum);
}

/**
 * 验证订单信息
 * @returns {boolean}
 */
function checkOrderInfo() {
    var flag = true;
    var lr1 = $("#lr").val();
    if (lr1 == null || lr1 == undefined || lr1 == 0) {
        swal("请输入利润率");
        $("#lr").focus();
        $("#lr").css("border", "1px solid red");
        flag = false;
    }
    $("input[name='price']").each(function (i, item) {
        var lr = $(item).val();
        if (lr == null || lr == undefined || lr == 0) {
            swal("请输入利润率");
            $(item).focus();
            $(item).css("border", "1px solid red");
            flag = false;
        }
    });
    $("input[name='num']").each(function (i, item) {
        var num = $(item).val();
        if (num == null || num == undefined || num == 0) {
            swal("请输入数量");
            $(item).focus();
            $(item).css("border", "1px solid red");
            flag = false;
        }
    });
    return flag;
}

/**
 * 提交订单
 */
function save() {
    if (checkOrderInfo()) {
        var json = $("#articleForm").serializeJson();
        $.ajax({
            // url: baseUrl + "order/add",
            url: baseUrl + "order",
            type: "post",
            data: {"param": JSON.stringify(json)},
            // data: JSON.stringify(json),
            // contentType:"application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                // alert(JSON.stringify(data));
                if (data.code == 200) {
                    // location.href = "/order/getById/" + data.data.orderId;
                    page("/order/getById/" + data.data.orderId, "媒体下单-订单详情");
                } else {
                    swal(data.msg);
                }
            }
        });
    }
}