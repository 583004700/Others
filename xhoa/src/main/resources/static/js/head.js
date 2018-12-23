/**
 * Created by GZW
 */

//前端地址
// document.writeln(' <base href="http://localhost/" />');

//后端地址，数据请求URL,请求JavaSrping Boot 的服务器地址
var baseUrl = "http://localhost/";
//前端登录url ,没有登录则会自动跳转到该页面,如果不需要自动跳转到登录页面则可以给空字符串
var LOGIN_URL = "http://localhost/login";

// var SOCKET_API = "ws://localhost/ws/${userName}";

function startModal(id) {
    if (id == undefined) {
        Ladda.create(document.querySelector(".ladda-button")).start();
    } else {
        Ladda.create(document.querySelector(id)).start();
    }
}

function getToken() {
    var token = localStorage.getItem("token");
    return token;
}

function setToken(val) {
    localStorage.setItem("token", val);
}


/**
 * 登录超时或者没有权限
 * @param data
 * @returns {boolean}
 */
function getResCode(data) {
    if (data.code == -1) {
        swal({
                title: "登录超时？",
                text: data.msg + ",您没有登录或会话已失效，请重新登录！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定，进入登录页？",
                cancelButtonText: "取消，留在本页！",
                closeOnConfirm: false,
                reverseButtons: true //控制按钮反转
            },
            function (isConfirm) {
                if (isConfirm) {
                    if (LOGIN_URL != "")
                        top.location.href = LOGIN_URL;
                }
            });
        return true;
    }
    if (data.code == -2) {
        swal({
                title: "Token无效！",
                text: data.msg + ",请重新登录！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定，进入登录页？",
                cancelButtonText: "取消，留在本页！",
                closeOnConfirm: false,
                reverseButtons: true //控制按钮反转
            },
            function (isConfirm) {
                if (isConfirm) {
                    if (LOGIN_URL != "")
                        top.location.href = LOGIN_URL;
                }
            });
        return true;
    }
    if (data.code == 403) {
        // swal("没有权限！", data.msg + ",抱歉！您没有该权限！", "warning");
        // return true;
        swal({
                title: "没有权限！",
                text: "抱歉！您没有该权限,请重新登录！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定，进入登录页？",
                cancelButtonText: "取消，留在本页！",
                closeOnConfirm: false,
                reverseButtons: true //控制按钮反转
            },
            function (isConfirm) {
                if (isConfirm) {
                    if (LOGIN_URL != "")
                        top.location.href = LOGIN_URL;
                }
            });
        return true;
    }
    // swal.close();
    //隐藏
    // $("#loadingModal").modal('hide');
    // layer.close(layerIndex);
    // Ladda.stopAll();
    return false;
}

function convert(data, format, rootName) {
    var rootArray = new Array();
    if (rootName == undefined)
        rootName = "品类目录";
    var root = {text: rootName, id: ""};
    var start = new Date().getTime();
    root["nodes"] = loadChilds(data, format);
    rootArray.push(root);
    return rootArray;
}

function loadChilds(data, format) {
    var nodeArray = new Array();
    for (var i in data) {
        if (typeof (data[i]) != "function") {
            nodeArray.push(loadChild(data[i], format));
        }
    }
    return nodeArray;
}

function loadChild(data, format) {
    var json = {};
    for (var key in data) {
        var value = data[key];
        var k = format[key] == undefined ? key : format[key];
        if (value != "" && value != null && value != undefined) {
            if (value instanceof Array) {
                if (value.length > 0) {
                    // 递归调用
                    json[k] = loadChilds(value, format);
                }
            } else if (value instanceof Object) {

                json[k] = loadChild(value, format);
            } else {
                json[k] = value;
            }
        }
    }
    return json;
}


function mergerData(gridName) {
    //得到显示到界面的id集合
    var ids = $("#" + gridName).getDataIDs();
    //当前显示多少条
    var length = ids.length;
    for (var i = 0; i < length; i++) {
        //从上到下获取一条信息
        var before = $("#" + gridName).jqGrid('getRowData', ids[i]);
        //定义合并行数
        var rowSpanTaxCount = 1;
        for (var j = 1; j <= length; j++) {
            //和上边的信息对比 如果值一样就合并行数+1 然后设置rowspan 让当前单元格隐藏
            var end = $("#" + gridName).jqGrid('getRowData', ids[j]);
            var bf = "", ed = "";
            $.each(arguments, function (ii, d) {
                if (ii > 0) {
                    bf += before[d];
                    ed += end[d];
                }
            });
            if (bf == ed) {
                rowSpanTaxCount++;
                $.each(arguments, function (ii, d) {
                    if (ii > 0) {
                        $("#" + gridName).setCell(ids[j], d, '', {display: 'none'});
                    }
                });
            } else {
                rowSpanTaxCount = 1;
                break;
            }
            $.each(arguments, function (ii, d) {
                if (ii > 0) {
                    $("#" + d + ids[i]).attr("rowspan", rowSpanTaxCount);
                }
            });
        }
    }
}

Views = {
    /**
     * 根据id值加载媒体
     * @param attr
     * @param idVal
     */
    loadMediaType: function (attr, idVal) {
        var attribute = attr || 'mType';
        $.ajax({
            url: "/mediaType?parentId=0",
            type: "get",
            success: function (data) {
                if (data) {
                    var mTypeEle = $("[name=" + attribute + "]").length == 0 ? $("#" + attribute) : $("[name=" + attribute + "]");
                    for (var i = 0; i < data.length; i++) {
                        var mType = data[i];
                        if (mType.id == idVal) {
                            mTypeEle.append("<option selected='selected' value='${id}'>${name}</option>".replace("${id}", mType.id).replace("${name}", mType.name));
                            continue;
                        }
                        mTypeEle.append("<option value='${id}'>${name}</option>".replace("${id}", mType.id).replace("${name}", mType.name));
                    }
                }
            }
        });
    },
    //加载地区，带搜索功能,要引入layui
    loadDistrict: function (attr, idVal) {
        var attribute = attr || 'area';
        layui.use(['form'], function () {
            Views.layuiForm = layui.form;
            $.ajax({
                url: "/district/all",
                type: "get",
                success: function (data) {
                    if (data) {
                        var ele = $("[name=" + attribute + "]").length == 0 ? $("#" + attribute) : $("[name=" + attribute + "]");
                        for (var i = 0; i < data.length; i++) {
                            var obj = data[i];
                            if (obj.id == idVal) {
                                ele.append("<option selected='selected' value='${id}'>${name}</option>".replace("${id}", obj.id).replace("${name}", obj.name));
                                continue;
                            }
                            ele.append("<option value='${id}'>${name}</option>".replace("${id}", obj.id).replace("${name}", obj.name));
                        }
                        Views.layuiForm.render();
                    }
                }
            });
        });
    },
    //加载行业
    loadIndustry: function (attr, idVal) {
        var attribute = attr || 'industry';
        layui.use(['form'], function () {
            Views.layuiForm = layui.form;
            $.ajax(
                {
                    url: "/cust/hySelect",
                    type: "post",
                    success: function (data) {
                        if (data) {
                            var ele = $("[name=" + attribute + "]").length == 0 ? $("#" + attribute) : $("[name=" + attribute + "]");
                            for (var i = 0; i < data.length; i++) {
                                var obj = data[i];
                                if (obj.hy_id == idVal) {
                                    ele.append("<option selected='selected' value='${id}'>${name}</option>".replace("${id}", obj.hy_id).replace("${name}", obj.hymc));
                                    continue;
                                }
                                ele.append("<option value='${id}'>${name}</option>".replace("${id}", obj.hy_id).replace("${name}", obj.hymc));
                            }
                            Views.layuiForm.render();
                        }
                    }
                }
            );
        });
    },
    //加载部门
    loadDept: function (attr, idVal, type) {
        var attribute = attr || 'dept';
        $.ajax(
            {
                url: "/dept/listByType",
                async: false,
                type: "post",
                data: {type: type},
                success: function (data) {
                    if (data) {
                        var ele = $("[name=" + attribute + "]").length == 0 ? $("#" + attribute) : $("[name=" + attribute + "]");
                        for (var i = 0; i < data.length; i++) {
                            var obj = data[i];
                            if (obj.id == idVal) {
                                ele.append("<option selected='selected' value='${id}'>${name}</option>".replace("${id}", obj.id).replace("${name}", obj.name));
                                continue;
                            }
                            ele.append("<option value='${id}'>${name}</option>".replace("${id}", obj.id).replace("${name}", obj.name));
                        }
                    }
                }
            }
        );
    },
    /**
     * 加载部门下的某种角色用户
     * @param currentDeptId
     * @param roleType
     * @param attr
     * @param idVal
     */
    loadDeptUser: function (currentDeptId, roleType, attr, idVal) {
        var attribute = attr || 'users';
        var ele = $("[name=" + attribute + "]").length == 0 ? $("#" + attribute) : $("[name=" + attribute + "]");
        $.ajax(
            {
                url: "/statistics/deptUsers",
                type: "post",
                data: {currentDeptId: currentDeptId, roleType: roleType},
                async: false,
                success: function (users) {
                    for (var i = 0; i < users.length; i++) {
                        if (users[i].id == idVal) {
                            ele.append("<option value=" + users[i].id + " selected=selected>" + users[i].name + "</option>");
                            continue;
                        }
                        ele.append("<option value=" + users[i].id + ">" + users[i].name + "</option>");
                    }
                }
            }
        );
    }
};

APPUtil = {
    /**
     * 获取用户
     * @param deptId
     */
    getUser: function (deptId) {
        $.ajax({
            url: "/user/queryUserByDeptId",
            data: {deptId: deptId},
            success: function (resData) {
                // console.log(resData);
            }
        });
    }
};


/**
 * 加载地区
 * @param t
 */
function loadDistrict(t) {
    // alert($(t).attr("hideVal"));
    $.get("/district/all", function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            // var value = media != undefined ? media[name] : "";
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载媒体类型
 * @param t
 */
function loadMediaType(t) {
    // alert($(t).attr("hideVal"));
    $.get("/mediaType/parentId/" + $("#mType").val(), function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            // var value = media != undefined ? media[name] : "";
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载行业类型
 * @param t
 */
function loadIndustry(t) {
    // alert($(t).attr("hideVal"));
    $.get("/industry/list?mediaTypeId=" + $("#mType").val(), function (data) {
        $(data).each(function (i, d) {
            // var name = $(t).attr("name");
            // var value = media != undefined ? media[name] : "";
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载所有用户
 * @param t
 */
function loadAllUser(t) {
    $.get("/user/list", function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载所有媒介用户列表
 * @param t
 */
function loadAllMJ(t) {
    $.get("/user/listByType/MJ", function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载所有业务用户列表
 * @param t
 */
function loadAllYW(t) {
    $.get("/user/listByType/YW", function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载查询某种角色类型和岗位类型 如媒介部长 下拉框对象,MJ,BZ
 * @param t
 */
function listByTypeAndCode(t, type, code) {
    $.get("/user/listByTypeAndCode/" + type + "/" + code, function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载部门
 * @param t
 */
function loadDepart(t) {
    // $.get("/user/all", function (data) {
    //     $(data.list).each(function (i, d) {
    //         $(t).append("<option value='" + d.userId + "'>" + d.userName + "</option>");
    $(t).append("<option value='1'>业务部1部</option>");
    $(t).append("<option value='2'>媒介部</option>");
    //     });
    // }, "json");
}

/**
 * 加载资源类别
 * @param t
 */
function loadScreen(t, media) {
    $.get("/mediaScreen/listByMediaTypeId/" + $("#mType").val(), function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载媒体名称
 * @param t
 */
function loadMediaName(t, media) {
    $.get("/mediaName/list", {mediaTypeId: $("#mType").val()}, function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}


/**
 * 加载所有媒体供应商
 * @param t
 * */
function loadSupplier(t, supplier) {
    $.get("/supplier/list", {mediaTypeId: $("#mType").val()}, function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

function selSupplier(t) {
    $("#supplierName").val($(t).find("option:selected").text());
}

/**
 * 加载所有媒体板块
 * @param t
 * */
function loadMediaModeType(t) {
    $.get("/mediaType/parentId/0", function (data) {
        $(data).each(function (i, d) {
            var value = $(t).attr("data-value");
            var selected = value == d.id ? "selected=selected" : "";
            $(t).append("<option value='" + d.id + "' " + selected + ">" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 加载角色
 */
function loadRoles(t) {
    $.get("/role/list", function (data) {
        $(data).each(function (i, d) {
            $(t).append("<option value='" + d.id + "'>" + d.name + "</option>");
        });
    }, "json");
}

/**
 * 当前菜单颜色高亮；
 */
function setMenuStyle(obj) {
    // 先查询是否已存在高亮的菜单；
    var element = $(".currentMenu");
    // 移除父菜单高亮；
    var parentMenu = element.closest("ul");
    // 设置父菜单样式；
    if (parentMenu.hasClass("nav-second-level")) {
        parentMenu.parent().children("a").css("color", "#A7B1C2");
    }
    if (element) {
        element.css("color", "#A7B1C2");
        element.removeClass("currentMenu");
    }

    // 当前菜单高亮；
    var currentMenu = $(obj);
    currentMenu.addClass("currentMenu");
    currentMenu.css("color", "#FFFFFF");

    // 设置父菜单高亮；
    parentMenu = currentMenu.closest("ul");
    // 设置父菜单样式；
    if (parentMenu.hasClass("nav-second-level")) {
        parentMenu.parent().children("a").css("color", "#FFFFFF");
    }
}

/**
 * 与标签对应；
 */
function matchTab(obj) {
    // 获取标签的链接；
    var currentUrl = $(obj).attr("data-id");
    var currentMenu;
    var parentMenu;
    // 先清除所有一级和二级菜单的展开样式；
    $(".J_menuItem").each(function () {
        // 二级菜单；
        parentMenu = $(this).closest("ul");
        if (parentMenu.hasClass("in")) {
            parentMenu.removeClass("in");
        }
        // 一级菜单；
        if (parentMenu.parent().hasClass("active")) {
            parentMenu.parent().removeClass("active");
            parentMenu.parent().children("a").css("color", "#A7B1C2");
        }
    });

    // 开始设置属性；
    $(".J_menuItem").each(function () {
        currentMenu = $(this);
        // 判断是否为当前标签的菜单；
        if (currentMenu.attr("href") == currentUrl) {
            currentMenu.addClass("currentMenu");
            currentMenu.css("color", "#FFFFFF");

            // 判断当前菜单的级别；
            parentMenu = currentMenu.closest("ul");
            // 设置父菜单样式；
            if (parentMenu.hasClass("nav-second-level")) {
                parentMenu.parent().children().addClass("in")
                parentMenu.parent().addClass("active");
                parentMenu.parent().children("a").css("color", "#FFFFFF");
            } else {
                currentMenu.parent().children().addClass("in")
                currentMenu.parent().addClass("active");
            }
        } else {
            currentMenu.css("color", "#A7B1C2");
            currentMenu.removeClass("currentMenu");
        }
    });
}

$(document).ready(function(){
    var width = window.screen.width;
    if(width < 1500){
        $("body").css({zoom:0.8});
    }
});
