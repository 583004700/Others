function del(id) {
    parent.layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        parent.layer.close(index);
        $.ajax({
            type: "post",
            url: "/role/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        $("#query_table_logs").jqGrid('setGridParam', {
                            postData: $("#queryForm").serializeJson(), //发送数据
                        }).trigger("reloadGrid"); //重新载入
                    }, 1000);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};

// function editRoleResource(id) {
//     window.location.href = "/role/editRoleResource?id=" + id;
// };
//加载角色类型列表
loadType();

function loadType() {
    $("#type").empty();
    $("#type2").empty();
    $.get("/dict/listByTypeCode2?typeCode=ROLE_TYPE", function (data) {
        // console.log("data0="+data)
        getResCode(data);
        var html = "<option value='' ></option>";
        $(data).each(function (i, item) {
            html += "<option value='" + item.code + "' >" + item.name + "</option>";
        });
        $("#type").html(html);
        $("#type2").html(html);
    }, "json");
}

//加载职位列表
loadCode();

function loadCode() {
    $("#code").empty();
    $("#code2").empty();
    $.get("/dict/listByTypeCode2?typeCode=ROLE_CODE", function (data) {
        // console.log("data1="+data)
        getResCode(data);
        var html = "<option value='' ></option>";
        $(data).each(function (i, item) {
            html += "<option value='" + item.code + "' >" + item.name + "</option>";
        });
        $("#code").html(html);
        $("#code2").html(html);
    }, "json");
}

$(document).ready(function () {
    /**
     * 下拉框的change事件
     */
    $("#changeRole").change(function () {
        var rid = $(this).val();
        roleInfo(rid);
    })

    var roleName = "";
    var type = "";
    var code = "";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
        $('#user_table_logs').setGridWidth(width);
    });
    $("#query_table_logs").jqGrid({
        url: '/role/listPg',
        datatype: "json",
        mtype: 'POST',
        postData: $("#queryForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        rownumbers: false,
        page: 1,//第一页
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
        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'id', label: '角色编号', editable: true, hidden: true, width: 60},
            {name: 'type', label: '角色类型', editable: true, width: 60},
            {name: 'code', label: '角色编码', editable: true, width: 60},
            {name: 'name', label: '角色名称', editable: true, width: 120},
            {name: 'createTime', label: '创建时间', editable: true, width: 80},
            {name: 'user.name', label: '创建人', editable: true, width: 50},
            {
                name: 'state', label: '状态', editable: true, width: 30, formatter: function (v, grid, rows, state) {
                    return v > -1 ? "<span class='text-success'>有效</span>" : (v == -9 ? "<span class='text-danger'>删除</span>" : "<span class='text-muted'>无效</span>");
                }
            },
            {name: 'remark', label: '角色描述', editable: true, width: 100},
            {name: 'updateTime', label: '最后修改时间', editable: true, width: 80},
            // {name: 'leader_flag', label: '是否是领导', editable: true, width: 280},
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows, state) {
                    var be = "<a class='text-info' onclick='view(" + rows.id + ")'>查看</a>";
                    var de = "<a class='text-muted'  onclick='del(" + rows.id + ")'>删除</a>";
                    // var se = "<a class='text-danger' data-toggle='modal' data-target='#roleModal' onclick='editRoleResource(" + rows.id + ")'>赋权</a>";
                    var se = "<a class='text-danger' data-toggle='modal' data-target='#roleModal' onclick='roleInfo(" + rows.id + ")'>赋权</a>";
                    return "     " + be + "     " + de + "    " + se + "    ";
                }
            }
        ],
        pager: jQuery("#query_pager_logs"),
        viewrecords: true,
        caption: "角色列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            edit(rowid);
        }
    });

    // //赋权保存
    // $("#submit").click(function () {
    //
    // });
    //赋权关闭
    $("#cance3").click(function () {
        $("#roleModal").modal("hide");
        // window.location.href = "/system/queryRole";
    });

    $("#search").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#query_table_logs").emptyGridParam();
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });


    $("#add").click(function () {
        document.getElementById("editForm").reset();
        $("#type option").removeAttr("selected");
        $("#code option").removeAttr("selected");
        $("#editModal").modal("toggle");
        $(".save").show();
        $(".update").hide();
        selChange();
    })

    edit = function (id) {
        $.ajax({
            type: "post",
            url: "/role/editAjax",
            data: {"id": id},
            dataType: "json",
            success: function (data) {
                $("#type option").removeAttr("selected");
                $("#code option").removeAttr("selected");
                $("#editModal").modal("toggle");
                $(".save").hide();
                $(".update").show();
                for (var attr in data.data.role) {
                    $("[name=" + attr + "]").val(data.data.role[attr]);
                    if (attr == "type") {
                        $("#type option[value='" + data.data.role[attr] + "']").attr("selected", "selected");
                    }
                    if (attr = "code") {
                        $("#code option[value='" + data.data.role[attr] + "']").attr("selected", "selected");
                    }
                }
                type = $("#type").find("option:selected").text();
                code = $("#code").find("option:selected").text();
                selChange();
            }
        });
    }
    view = function (id) {
        $("#user_table_logs").emptyGridParam();
        $.ajax({
            type: "post",
            url: "/role/editAjax",
            data: {"id": id},
            dataType: "json",
            success: function (data) {
                $("#viewModal").modal("toggle");
                for (var attr in data.data.role) {
                    $("[name=" + attr + "2" + "]").val(data.data.role[attr]);
                    if (attr == "type") {
                        $("#type2 option[value='" + data.data.role[attr] + "']").attr("selected", "selected");
                    }
                    if (attr = "code") {
                        $("#code2 option[value='" + data.data.role[attr] + "']").attr("selected", "selected");
                    }
                }
                $("#roleId").val(data.data.role['id']);
                // console.log(data.data.role['id'])
                // console.log($("#roleId").val())
                // console.log(JSON.stringify($("#userForm").serializeJson()))

                $("#user_table_logs").jqGrid("setGridParam", {
                    postData: $("#userForm").serializeJson()
                }).trigger("reloadGrid");
            }
        });
    }

    $("#user_table_logs").jqGrid({
        url: '/role/queryUserByRoleId',
        datatype: "json",
        mtype: 'POST',
        postData: $("#userForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        rownumbers: false,
        page: 1,//第一页
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
        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'userName', label: '用户名', editable: true, width: 80},
            {name: 'name', label: '姓名', editable: true, width: 80},
            {name: 'deptName', label: '部门', editable: true, width: 120},
            {name: 'phone', label: '电话', editable: true, width: 120},
            {name: 'qq', label: 'qq', editable: true, width: 120},
            {name: 'wechat', label: '微信', editable: true, width: 120},
            {name: 'createTime', label: '创建时间', editable: true, width: 120},
            {name: 'loginTime', label: '最近一次登录时间', editable: true, width: 120},
            {name: 'remark', label: '备注', editable: true, width: 240},
            {name: 'updateTime', label: '最后修改时间', editable: true, width: 120},
        ],
        pager: jQuery("#user_pager_logs"),
        viewrecords: true,
        caption: "该角色用户列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });
    $("#userSearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#user_table_logs").emptyGridParam();
        $("#user_table_logs").jqGrid('setGridParam', {
            postData: $("#userForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    function selChange() {
        $("#type").change(function () {
            type = $("#type").find("option:selected").text();
            if ($("#type").val() != "" && $("#code").val() != "") {
                roleName = type + code;
                $("#name").val(roleName);
            }
        })

        $("#code").change(function () {
            code = $("#code").find("option:selected").text();
            if ($("#type").val() != "" && $("#code").val() != "") {
                roleName = type + code;
                $("#name").val(roleName);
            }
        })
    }

    loadRoleList();
    $('#all').on('ifChanged', function (event) {
        $(".i-checks").iCheck($(this).is(':checked') ? 'check' : 'uncheck');
    });

});

submitHander = function (t, url) {
    if ($("#editForm").valid()) {
        layer.confirm("请确认角色信息", {
            btn: ["确定", "取消"],
            shade: false
        }, function (index) {
            layer.close(index);
            startModal("#" + t.id);//锁定按钮，防止重复提交
            $.ajax({
                type: "post",
                url: "/role/checkName",
                data: {id: $("#id").val(), name: $("#name").val()},
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();
                    //判断角色名是否重复
                    if (data.data.flag) {
                        var formData = $("#editForm").serializeJson();
                        $.ajax({
                            type: "post",
                            url: url,
                            data: formData,
                            dataType: "json",
                            success: function (data) {
                                // alert(getResCode(data))
                                if (data.code == 200) {
                                    layer.msg(data.data.message, {time: 1000, icon: 6});
                                    $("#query_table_logs").jqGrid("setGridParam", {
                                        postData: $("queryForm").serializeJson()
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
                    } else {
                        swal("角色名重复！")
                    }

                },
                error: function (data) {
                    Ladda.stopAll();
                    layer.msg(data.msg);
                }
            });
        }, function () {
            return;
        });
    }
}

/**
 * 设置默认选中角色
 * @param id
 */
function roleInfo(id) {
    $.get(baseUrl + "role/view?id=" + id, function (data) {
        if (getResCode(data))
            return;
        if (data.code == 200) {
            $("#changeRole").val(data.data.role.id);
            $("[name='roleId']").val(data.data.role.id);
            $("[name='roleId1']").val(data.data.role.id);
            $("[name='checkId']").val(data.data.role.id);
        }
    });
    loadAllRoles(id);
}

/**
 * 查询角色列表给赋权页面赋值
 */
function loadRoleList() {
    $.get(baseUrl + "role/list", function (data) {
        if (data != null && data != '') {
            $(data).each(function (i, item) {
                // console.log(item);
                $("#changeRole").append("<option value='" + item.id + "'>" + item.name + "</option>");
            });
        }
    })
}


/**
 * 加载所有权限信息
 * @param id
 */
function loadAllRoles(id) {
    // console.log(">>>>>>>>>>id="+id)
    $.get(baseUrl + "role/allGroupsAndResources/" + id, function (data) {
        if (data != null && data != '') {
            var html = '';
            $("#groups").empty();
            // 定义map用来保存选择的数据；
            var mapData = {};
            $(data).each(function (i, item) {
                // console.log(item)
                var parent = item.parentList;
                var resourceList = item.resourceList;
                html += ' <div class="col-sm-12  level2Div f_line " style="height: 180px">\n' +
                    ' <div class="col-sm-2"style="height: 40px">\n' +
                    '     <input type="hidden" name="resourceId" class="form-control" value="' + parent.id + '">\n' +
                    '     <input type="checkbox" class="i-checks level2" style="position: relative"  value="' + parent.id + '">\n' +
                    '     <b style="font-size: 16px;">' + parent.name + '</b>\n' +
                    '     <input type="hidden" readonly="readonly" id="name"\n' +
                    '            name="name" class="form-control"></div>\n' +
                    ' <div class="col-sm-10">\n';
                mapData[parent.id] = 1;
                $(resourceList).each(function (i, d) {
                    if (d != undefined) {
                        var checked = d.checkInfo ? 'checked="checked"' : "";
                        if (checked.length <= 0) {
                            mapData[parent.id] = 0;
                        }
                        html += '     <div class="col-sm-2 level3Div">\n' +
                            '         <input type="hidden" name="resourceId" class="form-control" value="' + d.id + '">\n' +
                            '         <input type="checkbox" class="i-checks level3" name="resourceName" value="' + d.id + '" ' + checked + '>\n' +
                            '         <i></i><span>' + d.name + '</span></div>\n';
                        $(".level3").iCheck(d.checkInfo ? 'check' : 'uncheck');
                    }
                });
                html += ' </div></div>';
            });
            $("#groups").append(html);
            var dataValue;
            for (var key in mapData) {
                dataValue = mapData[key];
                if (dataValue == 1) {
                    $("input[type='checkbox'][value='" + key + "']").attr("checked", true);
                }
            }
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            $('.level2').on('ifChanged', function (event) {
                var dom = $(this).parent().parent().next();
                dom.find(" .level3").iCheck($(this).is(':checked') ? 'check' : 'uncheck');
            });
        }
    });
}

function save() {
    if ($("#form").valid()) {
        startModal("#saveRoleResource");//锁定按钮，防止重复提交
        var roleId1 = $("#roleId1").val();
        var checkId = "";
        $('input:checkbox[name="resourceName"]:checked').each(function () {
            checkId += this.value + "|";
        });
        $.ajax({
            type: "post",
            url: "/role/submitRoleresource",
            data: {roleId: roleId1, checkId: checkId},
            dataType: "json",
            success: function (data) {
                Ladda.stopAll();
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    setTimeout(function () {
                        return;
                        // window.location.href = "/role/editRoleResource?id="+data.data.roleId;
                    }, 1000);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }
}