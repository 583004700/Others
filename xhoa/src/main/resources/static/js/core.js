(function ($) {
    $.fn.extend({
        serializeJson: function () {
            var o = {};
            $.each(this.serializeArray(), function () {
                if (this.value) {
                    if (o[this.name]) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                }
            });
            return o;
        },
        toJSON: function () {
            var json = {};
            $.each(this.serializeArray(), function () {
                var name = this.name;
                var value = this.value;
                if (value && value != 0) {
                    var paths = this.name.split(".");
                    var len = paths.length;
                    var obj = json;
                    $.each(paths, function (i, e) {
                        if (i == len - 1) {
                            if (obj[e]) {
                                if (!obj[e].push) {
                                    obj[e] = [obj[e]];
                                }
                                obj[e].push(value || '');
                            } else {
                                obj[e] = value || '';
                            }
                        } else {
                            if (!obj[e]) {
                                obj[e] = {};
                            }
                        }
                        obj = json[e];
                    });
                }
            });
            return json;
        },
        //搜索前清空jqGrid参数
        emptyGridParam: function () {
            $(this).jqGrid('clearGridData');  //清空表格  数据
            var postData = $(this).jqGrid("getGridParam", "postData");
            if (postData != null && postData != "") {
                $.each(postData, function (k, v) {
                    delete postData[k];
                });
            }
        }
    })

})(jQuery);

function page(url, title) {
    var tabs = $('#page-tabs-content', parent.document);
    var main = $('#content-main', parent.document);
    if (tabs == null || tabs == undefined || tabs.length == 0) {
        location.href = url;
    } else {
        //在xml或html中，&会被转成&amp;
        if (main.html().replace(/&amp;/g, "&").indexOf(url) < 0) {
            tabs.find("a").each(function (i, d) {
                $(d).removeClass("active");
            });
            main.find("iframe").each(function (i, d) {
                $(d).hide();
            });
            if ($(tabs).html().indexOf(url) < 0) {
                var tab = $("<a href='javascript:;' class='active J_menuTab' data-id='" + url + "'>" + title + " <i class=\"fa fa-times-circle\"></i></a>");
                tabs.append(tab);
            } else {
                tabs.find("a").each(function (i, d) {
                    if ($(this).attr("data-id") == url) {
                        $(this).addClass("active");
                    }
                });
            }
            var frame = '<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="' + url + '" frameborder="0" data-id="' + url + '" seamless="seamless"></iframe>';
            main.append(frame);
        } else {
            swal("该链接已经开启一个窗口，请关闭后再打开！")
        }
    }
}

Date.prototype.format = function (fmt) {
    if (this == undefined || this == null) {
        console.error("时间出错");
        return;
    }
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
Array.prototype.contains = function (needle) {
    for (i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}
String.prototype.th = function (old, d) {
    return this.replace(new RegExp("\\${" + old + "}", "g"), d);
}

$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r == null) {
        r = parent.location.search.substr(1).match(reg);
    }
    if (r != null) return unescape(r[2]);
    return null;
}

function upload(t, fileId) {
    var value = $(t).val();
    if (value != null && value != undefined && value != '') {
        var formData = new FormData();
        var image = $(t).get(0).files[0];
        formData.append("image", image);
        $.ajax({
            url: "/upload",
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
            type: "post",
            success: function (data) {
                // $("#headimgThum").attr("src", data.data.src);
                $(t).next(".uploader").html("<img src='" + data.data.src + "' width='200px' height='120px'/>");
                $(t).next(".uploader").css("padding-top", 0);
                $("#" + fileId).val(data.data.src);
            }
        });
    }
}

/**
 * 只可以输入数字 包括小数点
 * @param e
 * @returns {boolean}
 */
function inNum(evt) {
    evt = (evt) ? evt : ((window.event) ? window.event : "");
    var curKey = evt.keyCode ? evt.keyCode : evt.which;
    return curKey >= 46 && curKey < 58;
}

/**
 * 只可以输入金额 包括小数点
 * @param e
 * @returns {boolean}
 */
function inPrice(evt) {
    evt = (evt) ? evt : ((window.event) ? window.event : "");
    var curKey = evt.keyCode ? evt.keyCode : evt.which;
    return curKey >= 46 && curKey < 58;
}

function msgCenter() {
    // $("#msgPlan").modal("show");
}

// 解决四维运算,js计算失去精度的问题

/**
 * 加法
 * @param arg
 * @returns {number}
 */
Number.prototype.add = function (arg) {
    var r1, r2, m;
    try {
        r1 = this.toString().split(".")[1].length
    } catch (e) {
        r1 = 0
    }
    try {
        r2 = arg.toString().split(".")[1].length
    } catch (e) {
        r2 = 0
    }
    m = Math.pow(10, Math.max(r1, r2))
    return (this * m + arg * m) / m
}
/**
 * 减法
 * @param arg
 * @returns {*}
 */
Number.prototype.sub = function (arg) {
    return this.add(-arg);
}
/**
 * 乘法
 * @param arg
 * @returns {number}
 */
Number.prototype.mul = function (arg) {
    var m = 0, s1 = this.toString(), s2 = arg.toString();
    try {
        m += s1.split(".")[1].length
    } catch (e) {
    }
    try {
        m += s2.split(".")[1].length
    } catch (e) {
    }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}
/**
 * 除法
 * @param arg
 * @returns {number}
 */
Number.prototype.div = function (arg) {
    var t1 = 0, t2 = 0, r1, r2;
    try {
        t1 = this.toString().split(".")[1].length
    } catch (e) {
    }
    try {
        t2 = arg.toString().split(".")[1].length
    } catch (e) {
    }
    with (Math) {
        r1 = Number(this.toString().replace(".", ""))
        r2 = Number(arg.toString().replace(".", ""))
        return (r1 / r2) * pow(10, t2 - t1);
    }
}