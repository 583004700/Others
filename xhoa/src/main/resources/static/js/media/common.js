function initCompany() {
    //iframe中的window对象
    companyWindow = $('#companyFrame').prop('contentWindow');
}

/**
 * 弹出编辑窗口
 */
function alertEdit(url, title) {
    if (title == "新增媒体供应商") {
        parent.layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '50%'],
            content: url, //iframe的url
            end: function () {
                $("#supplierId").reload();
                // if(title.indexOf("对接人")!=-1){
                //     dockingGrid.reflush();
                // }
                // if(title.indexOf("产品")!=-1){
                //     productGrid.reflush();
                // }
                // if(title.indexOf("用户")!=-1){
                //     usersGrid.reflush();
                // }
            }
        });
    } else {
        parent.layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            area: ['80%', '80%'],
            content: url, //iframe的url
            end: function () {
            }
        });
    }
}

/**
 * 根据媒体板块id查询媒体条件
 * @param id 媒体板块id
 * @param t
 */
function loadTerm(id, t) {
    $("#mediaTypeText").text($(t).text());
    $("#mediaTypeVal").val(id);

    if ($(t).hasClass("text-danger")) {
        return;
    }
    // 设置类型ID；
    $("#mediaType").val(id);
    // 清空查询条件；
    $("#state").nextAll().remove();
    $("#mediaTypeUL>li>div>span").each(function (i, item) {
        $(item).removeClass("text-danger");
        if (t == item) {
            $(t).addClass("text-danger");
        }
    });
    //根据媒体板块id查询媒体条件
    $.get("/mediaTerm/" + id, function (data) {
        var html = "";
        $(data).each(function (i, item) {
            switch (item.type) {
                case 0://直接展现
                    var datas = item.datas;
                    html += "<li class='col-md-12'><label class='col-md-1'>" + item.termName + "：</label><div class='col-md-11'>";
                    if (datas != null) {
                        $(datas).each(function (j, it) {
                            html += "<span class='col-md-1' title='" + it.t + "' onclick='loadMedia(\"" + it.k + "\",\"" + it.v + "\",this)'>" + it.t + "</span>"
                            if ((j + 1) % 12 == 0)
                                html += "</div><label class='col-md-1'></label><div class='col-md-11'>"
                        })
                    }
                    html += "</div></li>";
                    break;
                case 1://单选框类型
                    html += "<li class='col-md-12'><label class='col-md-1'>" + item.termName + "：</label><div class='col-md-11'>";
                    switch (item.dataType) {//数据类型：0SQL,1JSON,2HTML
                        case 1:
                            var json = eval(item.json);
                            if (Array.isArray(json))
                                $.each(json, function (i, item) {
                                    var text = item.hasOwnProperty("text") ? item.text : item.value;
                                    html += "<span class='col-md-1 radio-inline i-checks'><input type='radio' name='" + item.name + "' value='" + item.value + "' /> " + text + "</span>";
                                });
                            break;
                        case 2:
                            html += item.html.th('name', item.name);
                            break;
                    }
                    html += "</div></li>";
                    break;
                case 2://复选框类型
                    var json = eval(item.json);
                    html += "<li class='col-md-12'><label class='col-md-1'>" + item.termName + "：</label><div class='col-md-11'>";
                    if (Array.isArray(json))
                        $.each(json, function (i, item) {
                            var text = item.hasOwnProperty("text") ? item.text : item.value;
                            html += "<span class='col-md-1 checkbox-inline i-checks'><input type='checkbox'  name='" + item.name + "' value='" + item.value + "'/> " + text + "</span>";
                        });
                    html += "</div></li>";
                    break;
                case 5://时间
                    html += "<li class='col-md-12'><label class='col-md-1'>" + item.termName + "：</label><div class='col-md-11'>";
                    html += item.html.th('name', item.name);
                    html += "</div></li>";
                    break;
                default://文本框
                    html += "<li class='col-md-12'><label class='col-md-1'>" + item.termName + "：</label><div class='col-md-11'>";
                    html += item.html.th('name', item.name);
                    html += "</div></li>";
                    break;

            }
            if (item.name != null)
                html = html.th('name', item.name);
        });

        $("#mediaTermUL").html(html);
        // 调整样式为居左对齐；
        $(".col-md-1").css({"text-align": "left", "width": "6%", "margin": "10px"});
        $("#mediaTermUL select").each(function () {
            if ($(this).attr("onload"))
                this.onload();
            $(this).change(function (i, sel) {
                loadMedia($(this).attr("name"), $(this).val(), sel);
            });
        });

        $('.i-checks').on('ifChecked', function (event) {
            var input = $(this).find(" input");
            loadMedia(input.attr("name"), input.val(), input);
        });
        //加载板块标题名称列表
        $.get("/mediaForm/list/" + id, function (data) {
            $(data).each(function (i, d) {
                mediaForm[d.code] = d.name;
            });
            reData();
        });

    });
}

//各板块标题信息
var mediaForm = new Array();

function loadMedia(k, v, t, max) {
    var target = $(t);
    // 重复点击视为取消；
    // 按钮；
    if (target.hasClass("btn-success")) {
        target.removeClass("btn-success");
        target.addClass("btn-danger");

        // 先删除原有的同name条件；
        $("#termForm > input[name='" + k + "']").remove();
        $("#termForm > input[name='" + k + "_max']").remove();

        reData();
        return;
    }
    // 文字点击；
    if (target.hasClass("text-danger")) {
        target.removeClass("text-danger");

        // 先删除原有的同name条件；
        $("#termForm > input[name='" + k + "']").remove();
        $("#termForm > input[name='" + k + "_max']").remove();

        reData();
        return;
    }
    // 必须有值才进行刷新；
    if (v || max) {
        // 先删除原有的同name条件；
        $("#termForm > input[name='" + k + "']").remove();
        $("#termForm > input[name='" + k + "_max']").remove();
        // 按钮；
        if (target.hasClass("btn")) {
            // 移除同类型的选中的样式；
            target.closest("div").find(".btn-success").each(function () {
                $(this).removeClass("btn-success");
                $(this).addClass("btn-danger");
            });

            target.removeClass("btn-danger");
            target.addClass("btn-success");
        }
        // 文字点击；
        if (target.hasClass("col-md-1")) {
            // 移除同类型的选中的样式；
            target.closest("li").find(".text-danger").each(function () {
                $(this).removeClass("text-danger");
            });
            target.addClass("text-danger");
        }

        // 拼接查询条件；
        if (v) {
            var input = "<input name='" + k + "' value='" + v + "'/>";
        }
        if (max) {
            input += "<input name='" + k + "_max' value='" + max + "'/>";
        }
        $("#termForm").append(input);
        reData();
    } else {
        // 下拉框；
        if (target.prop(("tagName")) == undefined) {
            // 先删除原有的同name条件；
            $("#termForm > input[name='" + k + "']").remove();
            $("#termForm > input[name='" + k + "_max']").remove();

            reData();
        } else {
            layer.msg("请输入查询内容。");
        }
    }
}

/**
 * 刷新数据
 */
function reData() {
    if (url == undefined)
        url = "mediaInfo";
    $("#table_medias").emptyGridParam();
    var colModel = $("#table_medias").jqGrid('getGridParam', 'colModel');
    $(colModel).each(function (j, d) {
        if (j > 7 && d.name && d.name.indexOf('f') < 0 && d.name.lastIndexOf("Data") < 0) {
            var name = mediaForm[d.name];
            var flag = true;
            if (name) {
                $("#table_medias").jqGrid('setLabel', d.name, name);
                flag = false;
            }
            if (flag && d.name != 'operator' && d.name != 'state')
                $("#table_medias").setGridParam().hideCol(d.name);//.trigger("reloadGrid");
            else
                $("#table_medias").setGridParam().showCol(d.name);//.trigger("reloadGrid");
        }

    });
    var params = $("#termForm").serializeJson();
    $("#table_medias").jqGrid('setGridParam', {
        url: baseUrl + url,
        postData: params,
        loadComplete: function (gridData) {
            if (getResCode(gridData))
                return;
            for (var key in mediaForm) {
                if (key.indexOf('f') > -1) {
                    $("#table_medias label[name=" + key + "]").each(function () {
                        $(this).text(mediaForm[key] + ":");
                        $(this).attr("column", key);
                    });
                }
            }
        }
    }).trigger("reloadGrid");
    var width = $('.jqGrid_wrapper').width();
    $('#table_medias').setGridWidth(width);
    $("#table_medias").closest(".ui-jqgrid-bdiv").css({"overflow-x": "scroll"});
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
}