function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/user/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};

/**
 * 判断选择所属角色不为空
 * @returns {boolean}
 */
function checkEmpty() {
    var obj = $(".i-checks");
    var j = 0;
    for (var i = 0; i < obj.length; i++) {
        if (obj[i].checked) {
            j++;
        }
    }
    if (j == 0) {
        swal("角色编辑不能为空！！！");
        return false;
    } else {
        return true;
    }
}

saveUserRole = function (t, url) {
    //页面判断选择所属角色不为空
    if (checkEmpty()) {
        var obj = document.getElementsByName("groupId");
        var checkId = "";
        var userId = $("#id2").val();
        for (var i in obj) {
            if (obj[i].checked) {
                checkId += obj[i].value + ","
            }
        }
        if (checkId.substr(checkId.length - 1) == ',') {
            checkId = checkId.substr(0, checkId.length - 1);
        }
        layer.confirm("请确认角色选择？", {
            btn: ["确认", "取消"],
            shade: false,
        }, function (index) {
            layer.close(index);
            startModal("#" + t.id);
            $.ajax({
                type: "post",
                url: url,
                data: {"checkId": checkId, "userId": userId},
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#query_table_logs").jqGrid("setGridParam", {
                            postData: $("#queryForm").serializeJson()
                        }).trigger("reloadGrid");
                        $("#editUserRoleModal").modal("hide");
                    } else {
                        layer.msg(data.msg);
                        $("#editUserRoleModal").modal("hide");
                    }
                },
                error: function (data) {
                    Ladda.stopAll();
                    layer.msg(data.msg);
                }
            }, function () {
                return;
            });
        });
    }
}

function editUserRole(id) {
    $("#editUserRoleModal").modal("toggle");
    $.ajax({
        type: "post",
        url: "/user/editUserRole",
        data: {"id": id},
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                $("#groupDiv").empty();
                $("input[name='id']").val(data.data.userId);
                for (var i = 0; i < data.data.allRole.length; i++) {
                    var str = '<div  class="col-sm-3"><label><input class="i-checks" type="checkbox" value="' + data.data.allRole[i].id + '" name="groupId"><span>' + data.data.allRole[i].name + '</span></label> </div>';
                    document.getElementById("editUserRoleForm").reset();
                    for (var j = 0; j < data.data.userRole.length; j++) {
                        // console.log("checkedName="+data.data.allRole[i].name);
                        if (data.data.allRole[i].id == data.data.userRole[j].id) {
                            str = '<div  class="col-sm-3"><label><input class="i-checks" type="checkbox" value="' + data.data.allRole[i].id + '" name="groupId" checked="checked"><span>' + data.data.allRole[i].name + '</span></label> </div>';
                        }
                    }
                    $("#groupDiv").append(str);
                }
            } else {
                layer.msg(data.msg);
                $("#editUserRoleModal").modal("hide");
            }
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        }
    });
};

function viewUserRole(id) {
    $("#viewUserRoleModal").modal("toggle");
    $.ajax({
        type: "post",
        url: "/user/editUserRole",
        data: {"id": id},
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                $("#groupDiv2").empty();
                for (var i = 0; i < data.data.allRole.length; i++) {
                    var str = '<div  class="col-sm-3"><label><input type="checkbox" value="' + data.data.allRole[i].id + '" name="groupId2" disabled="disabled"><span>' + data.data.allRole[i].name + '</span></label> </div>';
                    for (var j = 0; j < data.data.userRole.length; j++) {
                        if (data.data.allRole[i].id == data.data.userRole[j].id) {
                            str = '<div  class="col-sm-3"><label><input type="checkbox" value="' + data.data.allRole[i].id + '" name="groupId2" checked="checked" disabled="disabled"><span>' + data.data.allRole[i].name + '</span></label> </div>';
                        }
                    }
                    $("#groupDiv2").append(str);
                }
            } else {
                layer.msg(data.msg);
                $("#editUserRoleModal").modal("hide");
            }
        }
    });
};

function resetPassword(id) {
    //清除验证标签
    $("#resetForm").find("input").removeClass('error');
    $("#resetForm").validate().resetForm();
    $("#myModal").modal('toggle');
    $("#id").val(id);
};

/**
 * 赋权媒体板块不为空
 * @returns {boolean}
 */
function checkMediaEmpty() {
    var obj = $(".i-checks");
    var k = 0;
    for (var i = 0; i < obj.length; i++) {
        if (obj[i].checked) {
            k++;
        }
    }
    if (k == 0) {
        swal("赋权媒体板块不能为空！");
        return false;
    } else {
        return true;
    }
}

/**
 * 加载媒体类型列表
 */
function loadMediaType() {
    $.get("/mediaType/parentId/0", function (data) {
        getResCode(data);
        var html = "";
        $(data).each(function (i, item) {
            html += "<span class='col-md-2'><input type='checkbox' class='i-checks' name='typeId' data-id='" + item.id + "' value='" + item.id + "' />" + item.name + "</span>";
        });
        $("#mediaType").html(html);
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    }, "json");
}

/**
 * 保存用户媒体板块
 */
function saveMediaType() {
    if (checkMediaEmpty()) {
        var data = $("#mediaTypeForm").serializeJson();
        $.ajax({
            type: "post",
            url: "/user/mediaType",
            data: {"param": JSON.stringify(data)},
            dataType: "json",
            // contentType: "application/json",
            success: function (data) {
                if (data.code == 200) {
                    swal("更新成功", "板块分配成功!", "success");
                    $("#query_table_logs").jqGrid("setGridParam", {
                        postData: $("#queryFrom").serializeJson()
                    }).trigger("reloadGrid");
                    $("#mediaTypeModal").modal("hide");
                } else {
                    swal("板块分配失败", "板块分配成功!", "warning");
                }
            }
        });
    }
}

/**
 * 显示媒体类型弹框
 * @param id UserId
 * @param id deptId
 */
function showMediaType(id, deptId) {
    $(".i-checks").iCheck("uncheck");
    $("#mediaTypeModal").modal('toggle');
    $("#userId").val(id);
    $("#departId").val(deptId);
    $.ajax({
        type: "post",
        url: "/mediaType/listByUserId",
        data: {"userId": id},
        dataType: "json",
        // contentType: "application/json",
        success: function (data) {
            // console.log(JSON.stringify(data))
            $(data).each(function (j, type) {
                // console.log(JSON.stringify(type))
                $("#mediaType>span").each(function (i, d) {
                    var dataId = $(d).find("input").attr("data-id");
                    if (type.id == dataId) {
                        $(d).find("input").iCheck('check');
                        return true;
                    }
                });
            });
        }
    });
};


$(document).ready(function () {
    loadMediaType();//加载媒体类型
    loadRoles($("#roleId"));//加载角色
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#editForm").validate({
        rules: {
            no: {maxlength: 20},
            userName: {
                required: !0, checkUserName: true,
                remote: {
                    url: "/user/checkUserName", // 后台处理程序
                    type: "post", // 数据发送方式
                    dataType: "json", // 接受数据格式
                    data: { // 要传递的数据
                        "id": function () {
                            return $("#id").val();
                        },
                        "userName": function () {
                            return $("#userName").val();
                        }
                    },
                    message: "用户名重复！",
                    dataFilter: function (data) {
                        //返回值是string，需要转换成json
                        var obj = JSON.parse(data);
                        if (obj.data.flag) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            },
            name: {required: !0, minlength: 2, maxlength: 50},
            email: {email: true},
            qq: {checkQQ: true},
            phone: {checkPhone: true},
            // sex: {required: true},
        },
        messages: {
            no: {maxlength: e + "工号长度必须小于{0}个字符"},
            userName: {
                required: e + "请输入用户名",
                minlength: e + "用户名长度必须大于{0}个字符",
                maxlength: e + "用户名长度必须小于{0}个字符",
                remote: e + "用户名重复"
            },
            name: {required: e + "请输入姓名", minlength: e + "姓名长度必须大于{0}个字符", maxlength: e + "姓名长度必须小于{0}个字符"},
            // sex: {required: e + "请选择性别"}
        }
    });
    //自定义正则表达式验证方法
    $.validator.addMethod("checkUserName", function (value, element, params) {
        var checkUserName = /^[a-zA-Z]{1}\w{1,49}$/;
        return this.optional(element) || (checkUserName.test(value));
    }, "请输入正确的用户名，首个字符为字母，其他为字母、数字和下划线，长度2-50！");
    $.validator.addMethod("checkPhone", function (value, element, params) {
        var checkPhone = /^(([0]\d{2,3}-\d{7,8})|([1]\d{10}))$/;
        return this.optional(element) || (checkPhone.test(value));
    }, "请输入正确的手机号码！");
    $.validator.addMethod("checkQQ", function (value, element, params) {
        var checkQQ = /^[1-9][0-9]{4,19}$/;
        return this.optional(element) || (checkQQ.test(value));
    }, "请输入正确的QQ号码！");

    $.jgrid.defaults.styleUI = 'Bootstrap';
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
    });
    $('body').bind('keyup', function (event) {
        if (event.keyCode == "13") {
            //回车执行查询
            $("#search").click();
        }
    });
    $("#query_table_logs").jqGrid({
        url: '/user/listPg',
        datatype: "json",
        // postData:$("#user").serializeJson(), //发送数据
        mtype: "post",
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: false,
        //setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: false,
        multiselectWidth: 25, //设置多选列宽度
        sortable: "true",
        sortname: "id",
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,//每页显示记录数
        rowList: [10, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },
        // colNames: ['用户名','姓名', '岗位', '电话', '操作'],
        colModel: [
            {name: 'id', label: '编号', editable: true, hidden: true, width: 60},
            {
                name: 'image', label: '头像', width: 30,
                formatter: function (value, grid, rows, state) {
                    return '<img style="width: 38px;height: 38px" src="' + baseUrl + value + '"/>';
                }
            },
            {name: 'no', label: '工号', editable: true, width: 40},
            {name: 'mJ', label: '是否媒介', hidden: true},
            {name: 'userName', label: '账号', editable: true, width: 40},
            {name: 'name', label: '姓名', editable: true, width: 30},
            {name: 'phone', label: '电话', editable: true, width: 40},
            {name: 'qq', label: 'QQ', editable: true, width: 35},
            {name: 'wechat', label: '微信', editable: true, width: 40},
            {name: 'deptName', label: '部门', editable: true, width: 30},
            {
                name: 'roles', label: '角色', editable: true, width: 50,
                formatter: function (value, grid, rows, state) {
                    // console.log(value);
                    var html = "";
                    $(value).each(function (i, role) {
                        html += role.name + "/";
                    });
                    if (html.length > 0)
                        html = html.substr(0, html.length - 1);
                    // alert(JSON.stringify(value));
                    return html;
                }
            },
            {
                name: 'state', label: '状态', editable: true, width: 25,
                formatter: function (value, grid, rows, state) {
                    //状态,0有效启用，1失效禁用 -1删除
                    switch (value) {
                        case 1:
                            return '<span class="text-success">有效</span>';
                        // case -1:
                        //     return '<span class="text-danger">删除</span>';
                        // default:
                        //     return '<span class="text-success">有效</span>';
                    }
                }
            },
            {name: 'createTime', label: '创建时间', editable: true, width: 60},
            {name: 'updateTime', label: '最后更新时间', editable: true, width: 60},
            {name: 'loginTime', label: '最后登录时间', editable: true, width: 60},
            {name: 'loginIp', label: '最后登录Ip', editable: true, width: 45},
            {name: 'deptId', label: 'deptId', hidden: true},
            // {name: 'user.name', label: '上级姓名',editable: true,width: 60},
            {
                name: 'operate', label: "操作", index: '', width: 120,
                formatter: function (value, grid, rows, state) {
                    // var html = "<a class='text-success' onclick='view(" + rows.id + ")' >查看</a>&nbsp;&nbsp;";
                    var html = "<a class='text-muted' onclick='del(" + rows.id + ")'>删除</a>&nbsp;&nbsp;";
                    html += "<a class='text-warning' onclick='resetPassword(" + rows.id + ")'>重置密码</a>&nbsp;&nbsp;";
                    html += "<a class='text-danger' onclick='editUserRole(" + rows.id + ")'>角色编辑</a>&nbsp;&nbsp;";
                    // html += "<a class='text-info' onclick='viewUserRole(" + rows.id + ")'>角色查看</a>&nbsp;&nbsp;";
                    if (rows.mJ) {
                        // html += "<a class='text-navy' data-toggle='modal' data-target='#mediaTypeModal' >编辑媒体板块权限</a>";
                        html += "<a class='text-navy' onclick='showMediaType(" + rows.id + "," + rows.deptId + ")' >媒体板块赋权</a>";
                    }
                    return html;
                }
            }
        ],
        pager: jQuery("#query_pager_logs"),
        viewrecords: true,
        caption: "用户列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            edit(rowid);
        },
    });

    $("#search").click(function () {
        // alert(JSON.stringify($("#user").serializeJson()));
        $("#query_table_logs").emptyGridParam();
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $("#addBtn").click(function () {
        //清除验证标签
        $("#editForm").find("input").removeClass('error');
        $("#editForm").validate().resetForm();
        $("input:radio").removeAttr("checked");
        $("input:radio").parent().removeClass("checked");
        // document.getElementById("editForm").reset();
        $("#editModal").modal("toggle");
        $(".save").show();
        $(".update").hide();
    });

    function edit(id) {
        $("input:radio").removeAttr("checked");
        $("input:radio").parent().removeClass("checked");
        $.ajax({
            type: "post",
            url: "/user/view",
            data: {"id": id},
            dataType: "json",
            success: function (data) {
                $("#editModal").modal("toggle");
                $(".save").hide();
                $(".update").show();
                for (var attr in data.data.user) {
                    $("input[name=" + attr + "][type!='radio']").val(data.data.user[attr]);
                    if (attr = "sex") {
                        $("input[name='sex'][value='" + data.data.user[attr] + "']").attr("checked", "checked");
                        $("input[name='sex'][value='" + data.data.user[attr] + "']").parent().addClass("checked");
                    }
                    if (attr = "isMgr") {
                        $("input[name='isMgr'][value='" + data.data.user[attr] + "']").attr("checked", "checked");
                        $("input[name='isMgr'][value='" + data.data.user[attr] + "']").parent().addClass("checked");
                    }
                    if (attr = "remark") {
                        $("#remark").val(data.data.user[attr]);
                    }
                }
            }
        });
    }

    view = function (id) {
        $("input:radio").removeAttr("checked");
        $("input:radio").parent().removeClass("checked");
        $("#viewModal").modal("toggle");
        $.ajax({
            type: "post",
            url: "/user/view",
            data: {"id": id},
            dataType: "json",
            success: function (data) {
                for (var attr in data.data.user) {
                    $("input[name='" + attr + "2'][type!='radio']").val(data.data.user[attr]);
                    if (attr = "sex") {
                        $("input[name='sex2']").attr("disabled", "disabled");
                        $("input[name='sex2'][value='" + data.data.user[attr] + "']").attr("checked", "checked");
                        $("input[name='sex2'][value='" + data.data.user[attr] + "']").parent().addClass("checked");
                    }
                    if (attr = "isMgr") {
                        $("input[name='isMgr2']").attr("disabled", "disabled");
                        $("input[name='isMgr2'][value='" + data.data.user[attr] + "']").attr("checked", "checked");
                        $("input[name='isMgr2'][value='" + data.data.user[attr] + "']").parent().addClass("checked");
                    }
                    if (attr = "remark") {
                        $("#remark2").val(data.data.user[attr]);
                    }
                }
            }
        });
    }

    submitHander = function (t, url) {
        if ($("#editForm").valid()) {
            layer.confirm("请确认用户信息", {
                btn: ["确定", "取消"],
                shade: false
            }, function (index) {
                layer.close(index);
                startModal("#" + t.id);//锁定按钮，防止重复提交
                var formData = $("#editForm").serializeJson();
                $.ajax({
                    type: "post",
                    url: url,
                    data: formData,
                    dataType: "json",
                    success: function (data) {
                        Ladda.stopAll();
                        if (data.code == 200) {
                            layer.msg(data.data.message, {time: 1000, icon: 6});
                            $("#query_table_logs").jqGrid("setGridParam", {
                                postData: $("#queryForm").serializeJson()
                            }).trigger("reloadGrid");
                            $("#editModal").modal("hide");
                        } else {
                            layer.msg(data.msg);
                            $("#editModal").modal("hide");
                        }
                    },
                    error: function (data) {
                        Ladda.stopAll();
                        layer.msg(data.msg);
                    }
                });
            }, function () {
                return;
            })
        }
    }

    $("#resetForm").validate({
        rules: {
            password: {required: !0, minlength: 6, maxlength: 16},
        },
        messages: {
            password: {required: e + "请输入密码", minlength: e + "密码长度必须大于{0}个字符", maxlength: e + "密码长度必须小于{0}个字符"},
        }
    });
    $(".resetPwd").click(function () {
        if ($("#resetForm").valid()) {
            // console.log(JSON.stringify($("#deptForm").serializeJson()))
            $.ajax({
                type: "post",
                url: "/user/resetPassword",
                data: $("#resetForm").serializeJson(),
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        $("#myModal").modal('hide');
                        $("#password").val();
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        // $("#myModal").modal('toggle');
                    } else {
                        // $("#password").val() ;
                        layer.msg(data.msg);
                        $("#myModal").modal('hide');
                    }
                }
            });
        }
    });
    $("#selDept").click(function () {
        $("#deptModal").modal('toggle');
    })
    $("#cleanDept").click(function () {
        $("#deptId").val("");
        $("#deptName").val("");
    })
    $('#treeview').treeview({
        data: [getTreeData()],
        onNodeSelected: function (event, data) {
            // console.log(data);
            $("#deptId").val(data.id);
            $("#deptName").val(data.text);
            $("#deptModal").modal('hide');
        }
    });

    $("#selDeptQc").click(function () {
        $("#deptModalQc").modal('toggle');
    })
    // $("#cleanDept").click(function () {
    //     $("#deptId").val("");
    //     $("#deptName").val("");
    // })
    $('#treeviewQc').treeview({
        data: [getTreeData()],
        onNodeSelected: function (event, data) {
            // console.log(data);
            // $("#deptIdQc").val(data.id);
            $("#deptNameQc").val(data.text);
            $("#deptModalQc").modal('hide');
        }
    });

});

function getTreeData() {
    var deptTreeData = {};
    $.ajax({
        type: "POST",
        url: "/dept/listForTreeView",
        dataType: "json",
        async: false,
        success: function (result) {
            var arrays = result.data.list;
            if (arrays != null && arrays.length > 0)
                deptTreeData = arrays[0];
        }
    });
    // console.log(JSON.stringify(deptTreeData))
    return deptTreeData;
}

