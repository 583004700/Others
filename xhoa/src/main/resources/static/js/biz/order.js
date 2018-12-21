$(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_orders').setGridWidth(width);
    });
    init();
    $("#companyId").change();
    // $("#custId").change();
    // setTax($("#taxes"));
    // $.get("/order/", function (data) {
    //     var html = "";
    //     $(data).each(function (i, item) {
    //         html += "<span class='col-md-1' title='" + item.name + "' onclick='loadTerm(" + item.id + ",this)'>" + item.name + "</span>";
    //     });
    //     $("#mediaTypeUL>li>div").html(html);
    //     $("#mediaTypeUL>li>div>span:first-child").click();
    //     init();
    // }, "json");
});

// function texPoint() {
//     var html = '&nbsp;<select></select>';
//     $.ajax({
//         url: baseUrl + 'dict/list',
//         type: 'get',
//         data: {'typeCode': 'tax'},
//         success: function (data) {
//             $(data).each(function (i, d) {
//                 console.log(d)
//                 html += '<option value="' + d.code + '">' + d.name + '</option>';
//             })
//             html += '</select>';
//             return html;
//         }
//     });
//     return html;
// }

function init() {

    $("#table_orders").jqGrid({//2600
        url: '/article/list/' + $("#orderId").val(),
        datatype: "json",
        // postData: $("#termForm").serializeJson(),
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
            },
            {
                name: "filePath",
                hidden: true
            },
            {
                name: 'mediaType.name',
                label: '稿件类别',
                editable: true,
                width: 20,
                align: "center"
            },
            {
                name: 'mediaName',
                label: '媒体名称',
                editable: true,
                width: 40,
                align: "center"
            },
            {
                name: 'priceType',
                hidden: true,
                label: '价格类型'
            },
            {
                name: 'supplierName',
                label: '供应商名称',
                editable: true,
                width: 40,
                align: "center"

            },
            {
                name: 'payAmount',
                label: '成本价',
                editable: true,
                width: 20,
                align: "center",
                classes: 'text-danger',
                formatter: "currency",
                formatoptions: {thousandsSeparator: ",", decimalSeparator: ".", prefix: "￥"},

            },
            {
                name: 'mediaUserId',
                hidden: true,
            },
            {
                name: 'mediaId',
                hidden: true,
            },
            {
                name: 'mediaUserName',
                label: '媒介',
                editable: true,
                width: 36,
                align: "center",
                formatter: function (v, options, row) {
                    return v;
                }
            },
            {
                name: 'saleAmount',//应收
                label: '客户报价',
                editable: true,
                width: 20,
                align: "center",
                classes: 'text-danger',
                formatter: "currency",
                formatoptions: {thousandsSeparator: ",", decimalSeparator: ".", prefix: "￥"},

            },
            {
                name: 'taxeType',
                label: '税种' + $("#taxesDiv").html(),
                editable: true,
                width: 26,
                sortable: false,
                align: "center",
                formatter: function (v, options, row) {
                    var sel = $("#taxes").html();
                    $("#taxesDiv").remove();
                    return "<select name='tax' class='form-control' onchange='setTax(" + row.id + ",this.value)'>" + sel + "</select>";
                }
            },
            {
                name: 'taxes',
                label: '税金',
                editable: true,
                width: 20,
                align: "center",
                classes: 'text-danger',
                formatter: function (v, options, row) {
                    return "￥" + (v ? v : (row.saleAmount * $("#taxes").val()).toFixed(3));
                }
            },
            {
                name: 'taxPoint',
                label: '税点',
                editable: true,
                width: 20,
                align: "center",
                classes: 'text-danger',
                formatter: function (v, options, row) {
                    return v ? v : $("#taxes").val();
                }
            },
            {
                name: 'amount',
                label: '含税价',
                editable: true,
                width: 23,
                align: "center",
                classes: 'text-danger',
                formatter: function (v, options, row) {
                    return "￥" + (v ? v : (row.saleAmount + row.saleAmount * $("#taxes").val()).toFixed(3));
                }
            },
            {
                name: 'promiseDate',
                label: '答应到款时间',
                width: 30,
                // hidden: true
            },
            {
                name: 'custName',
                label: '客户公司名称',
                editable: true,
                width: 50,
                align: "center",
                formatter: function (v, options, row) {
                    return $("#companyId").find("option:selected").text();
                }
            },
            {
                name: 'dockingPeople',
                label: '客户对接人',
                width: 25,
                align: "center",
                formatter: function (v, options, row) {
                    return $("#custId").find("option:selected").text();
                }
            },
            {
                name: 'link',
                label: '链接',
                width: 60,
                align: "center",
                formatter: function (v, options, row) {
                    return v ? v : '';
                }
            },
            {
                name: 'title',
                label: '标题',
                width: 60,
                align: "center",
                formatter: function (v, options, row) {
                    return '<a href="' + (row.link ? row.link : "") + '">' + (v ? v : "") + '</a>';
                    // return (v ? v : "");
                    // return "www.baidu.com";
                }
            }

        ],
        pager: "#pager_orders",
        viewrecords: true,
        caption: "媒体列表",
        hidegrid: false,
        loadComplete: function (data) {
            if (getResCode(data))
                return;
        }, ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            // page('/media/modifyMedia?id=' + rowid, '媒体修改' + rowid);
        }, onSelectRow: function (rowId, row, col, e) {
            $("#articleId").val(rowId);
            // $("#articleTitle").removeAttrs("disabled");
            // $("#link").removeAttrs("disabled");
            // $("#file").removeAttrs("disabled");
            // $("#amountDate").removeAttrs("disabled");
            $("input:disabled,select:disabled").removeAttrs("disabled");
            var a = $("#table_orders").getCell(rowId, "title");
            $("#articleTitle").attr("data-href", $(a).attr("href"));
            $("#articleTitle").val($(a).text());
            $("#link").val($("#table_orders").getCell(rowId, "link"));
            var htmlPath = $("#table_orders").getCell(rowId, "filePath");
            // $("#file").val(htmlPath);
            if (htmlPath) {
                $.ajax({
                    url: baseUrl + "/article/loadHtml",
                    type: 'get',
                    data: {"htmlPath": htmlPath},
                    success: function (data) {
                        if (data.code == 200)
                            $("#articleContent").code(data.data.stream);
                        else {
                            $("#articleContent").code("");
                        }
                    }
                });
            } else {
                $("#articleContent").code("");
            }
            var mediaId = $("#table_orders").getCell(rowId, "mediaId");
            var mediaUserId = $("#table_orders").getCell(rowId, "mediaUserId");

            $("#mediaUserId").empty();
            $.get(baseUrl + "user/listMJByMediaId/" + mediaId, function (data) {
                if (data.code == 200) {
                    var list = data.data.listMJByMediaId;
                    $(list).each(function (i, item) {
                        var sel = item.id == mediaUserId ? "selected='selected'" : "";
                        $("#mediaUserId").append('<option value="' + item.id + '" ' + sel + '>' + item.name + '</option>');
                    });
                }
            });
        }
    });
    $("#table_orders").jqGrid('setLabel', 'rn', '序号', {'text-align': 'center'}, '');
    $("#table_orders").setSelection(4, true);

}

/**
 * 设置答应到款时间
 * @param v
 */
function setDate(v) {
    var rowId = $("#articleId").val();
    $("#table_orders").setCell(rowId, "promiseDate", v);
}

/**
 * 更改媒介人员
 * @param v
 */
function setMediaUserId(t) {
    var rowId = $("#articleId").val();
    $("#table_orders").setCell(rowId, "mediaUserId", $(t).val());
    $("#table_orders").setCell(rowId, "mediaUserName", $(t).find("option:selected").text());
}

/**
 * 选择客户公司名称
 * @param t
 */
function onloadCompany(t) {
    $("#companyName").val($(t).find("option:selected").text());
    $.ajax({
        url: baseUrl + "dockingPeople/listByCustId/" + $(t).val(),
        type: "get",
        success: function (data) {
            console.log(data)
            $("#custId").html("");
            $(data).each(function (i, d) {
                var user = d.user;
                $("#custId").append("<option value='" + d.id + "' data-user-id='" + user.id + "' data-user-name='" + user.name + "' data-dept-id='" + user.dept.id + "'>" + d.custName + "</option>");
            });
            setCustId($("#custId"));
            var ids = $("#table_orders").getDataIDs();
            var rowNum = ids.length;
            for (var i = 0; i < rowNum; i++) {
                $("#table_orders").setCell(ids[i], "custName", $(t).find("option:selected").text());
                $("#table_orders").setCell(ids[i], "dockingPeople", $("#custId").find("option:selected").text());
            }
        }
    });
}

/**
 * 选择客户
 * @param t
 */
function setCustId(t) {
    var sel = $(t).find("option:selected");
    $("#custName").val(sel.text());
    var userId = sel.attr("data-user-id");
    var userName = sel.attr("data-user-name");
    var deptId = sel.attr("data-dept-id");
    $("#userId").val(userId);
    $("#userName").val(userName);
    $("#deptId").val(deptId);
    var ids = $("#table_orders").getDataIDs();
    var rowNum = ids.length;
    for (var i = 0; i < rowNum; i++) {
        $("#table_orders").setCell(ids[i], "dockingPeople", sel.text());
    }
}

function setTaxes(t) {
    var ids = $("#table_orders").getDataIDs();
    var rowNum = ids.length;
    var tax = $(t).val();
    for (var i = 0; i < rowNum; i++) {
        $("#table_orders").setCell(ids[i], "taxPoint", tax);
        var saleAmount = $("#table_orders").getCell(ids[i], "saleAmount");//报价
        var taxes = parseFloat(saleAmount) * tax;//计算税金
        $("#table_orders").setCell(ids[i], 'taxes', parseFloat(taxes).toFixed(3));
        $("#table_orders").setCell(ids[i], "amount", (parseFloat(saleAmount) + taxes).toFixed(3));//含税价
    }
    $("select[name='tax']").val(tax);
    // var text = $(t).find("option:selected").text();
    // $("select[name='tax']").find("option[text='" + text + "']").attr("selected", true);
    // // $("select[name='tax']").text(text);
    // alert(JSON.stringify($("select[name='tax']").find("option[text='" + text + "']")));
}

function setTax(rowId, v) {
    $("#table_orders").setCell(rowId, "taxPoint", v);
    var saleAmount = $("#table_orders").getCell(rowId, "saleAmount");//报价
    var taxes = parseFloat(saleAmount) * v;//计算税金
    $("#table_orders").setCell(rowId, 'taxes', parseFloat(taxes).toFixed(3));
    $("#table_orders").setCell(rowId, "amount", (parseFloat(saleAmount) + taxes).toFixed(3));//含税价
}

function setArticleTitle(t) {
    // var rowId = $(t).attr("data-rowId");
    var rowId = $("#articleId").val();
    $("#table_orders").setCell(rowId, "title", $(t).val());
}

function setLink(t) {
    // var rowId = $(t).attr("data-rowId");
    var rowId = $("#articleId").val();
    $("#table_orders").setCell(rowId, "link", $(t).val());
    // var title = $("#table_orders").getCell(rowId, "title");
    // title = $(title).attr("href", $(t).val());
    // $("#table_orders").getCell(rowId, "title", title);
}

/**
 * 提交订单
 */
function saveOrder() {
    var ids = $("#table_orders").getDataIDs();
    var json = [];
    var orderAmount = 0;
    for (var i = 0, rowNum = ids.length; i < rowNum; i++) {
        var taxes = $("#table_orders").getCell(ids[i], "taxes");//税金
        var amount = $("#table_orders").getCell(ids[i], "amount");//saleAmount 含税价
        var taxPoint = $("#table_orders").getCell(ids[i], "taxPoint");
        var title = $("#table_orders").getCell(ids[i], "title");
        var link = $("#table_orders").getCell(ids[i], "link");
        var promiseDate = $("#table_orders").getCell(ids[i], "promiseDate");
        var mediaUserId = $("#table_orders").getCell(ids[i], "mediaUserId");
        var mediaUserName = $("#table_orders").getCell(ids[i], "mediaUserName");
        // var custId = $("#custId").val();
        // var companyId = $("#companyId").val();
        json[i] = {
            id: ids[i],
            taxes: taxes.replace('￥', ''),
            saleAmount: amount.replace('￥', ''),
            taxPoint: taxPoint.replace('￥', ''),
            title: $(title).text(),
            link: link,
            promiseDate: promiseDate,
            mediaUserId: mediaUserId,
            mediaUserName: mediaUserName,
        };
        orderAmount += parseFloat(amount.replace('￥', ''));
    }
    var order = $("#orderForm").serializeJson();
    order.articles = json;
    order.amount = orderAmount;
    // order.custId = custId;
    // order.companyId = custId;
    // console.log(JSON.stringify(order));
    $.ajax({
        url: baseUrl + '/order/update',
        type: 'put',
        data: JSON.stringify(order),
        contentType: "application/json",
        success: function (data) {
            if (data.code == 200) {
                swal("提交成功！", data.msg, "success", 2000);
            } else {
                swal("提交失败！", data.msg, "warning", 2000);
            }
        }
    });
}

function upFile() {
    // $("#articleContent").html("asdfasdf");
    // $('#articleContent').code("asdfasdf");
    // uploadForm();
    if ($("#file").val()) {
        $.ajax({
            url: baseUrl + '/article/upload',
            type: 'POST',
            cache: false,
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false,
            dataType: "json",
            // beforeSend: function () {
            //     uploading = true;
            // },
            success: function (data) {
                if (data.code == 200) {
                    swal('提示！', '上传成功！', 'success', 1000);
                    // console.log(data.data.stream);
                    $("#articleContent").code(data.data.stream);
                } else {
                    swal('提示！', '上传失败！', 'error', 1000);
                }
            }
        });
    }

}

/**
 * 取消订单
 */
function cancelOrder() {
    $.get(baseUrl + "order/del/" + $("#orderId").val(), function (data) {
        if (getResCode(data))
            return false;
        if (data.code == 200) {
            swal("订单取消成功!");
        }
    })
}