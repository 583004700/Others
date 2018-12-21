function chooseOne(chk) {
    //先取得同name的chekcBox的集合物件
    var obj = $("input[name='parentId']");
    $("input[name='parentId']").each(function (i, item) {
        if (item != chk) $(item).iCheck('uncheck');
        else $(item).iCheck('check');
    });
}

function del(id) {
    layer.confirm('确认删除？', {
        btn: ['删除', '取消'], //按钮
        shade: false //不显示遮罩
    }, function () {
        $.ajax({
            type: "post",
            url: "/resource/del",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#table_logs").jqGrid("setGridParam", {
                        postData: $("#queryForm").serializeJson()
                    }).trigger("reloadGrid");

                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });

};

$(document).ready(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_logs').setGridWidth(width);
    });
    $("#table_logs").jqGrid({
        url: '/resource/listPg',
        datatype: "json",
        mtype: 'post',
        postData: $("#queryForm").serializeJson(), //发送数据
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
        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'id', label: '角色编号', editable: true, hidden: true, width: 60},
            {name: 'name', label: '菜单名称', editable: true, width: 80},
            {name: 'createTime', label: '创建时间', editable: true, width: 80},
            {name: 'user.name', label: '创建人', editable: true, width: 60},
            {
                name: 'isMenu', label: '是否菜单', editable: true, width: 40, formatter: function (v, grid, rows, state) {
                    return v == 0 ? '<span class=\'text-success\'>是</span>' : '<span class=\'text-danger\'>否</span>';
                }
            },
            {name: 'updateTime', label: '最后修改时间', editable: true, width: 80},
            {name: 'updateUser.name', label: '最后更新人员', editable: true, width: 60},
            {
                name: 'parent.name',
                label: '上级菜单',
                editable: true,
                width: 80,
                formatter: function (v, grid, rows, state) {
                    return v == "" || v == undefined ? '<span class=\'text-danger\'>一级菜单</span>' : v;
                }
            },
            {name: 'url', label: '菜单路径', editable: true, width: 180},
            {
                name: 'state', label: '状态', editable: true, width: 40, formatter: function (v, grid, rows, state) {
                    return v == 0 ? "<span class='text-success'>有效</span>" : (v == -1 ? "<span class='text-danger'>删除</span>" : "<span class='text-muted'>无效</span>");
                }
            },
            {
                name: 'operate', label: "操作", index: '', width: 100,
                formatter: function (value, grid, rows, state) {
                    var be = '<a class="text-danger" onclick="viewResurce(' + rows.id + ')">编辑</a>';
                    be = be.replace("${id}", rows.id);
                    //var se = '<a href="/role/del?id='+rows.id+'" style="color:#f60" >删除</a>';
                    var se = "<a class='text-muted'  onclick='del(" + rows.id + ")'>删除</a>";
                    return "  " + be + "  " + se + " ";
                }
            }
        ],
        pager: jQuery("#pager_logs"),
        viewrecords: true,
        caption: "菜单列表",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        ondblClickRow: function (rowid, iRow, iCol, e) {
            //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
            //page('/role/view?id=' + rowid, '角色详情');
            // edit(rowid);
            viewResurce(rowid, 'show');
        },
    });
    $("#search").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#table_logs").emptyGridParam();
        $("#table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });
    // $("#addRole").click(function () {
    //window.location.href="/system/editResource" ;
    // })


    /**
     * 加载菜单列表
     */
    $.ajax({
        type: "post",
        url: baseUrl + "/resource/listAllMenus",
        dataType: "json",
        success: function (resData) {
            this.resData = resData;
            if (getResCode(resData)) return;
            $("#parentId").append('<option value="">请选择父级菜单</option>');
            $("#parentId").append('<option value="0">一级菜单</option>');
            $(resData.data.resources).each(function (i, item) {
                var option = '<option value="' + item.id + '">' + item.name + '</option>';
                $("#parentId").append(option);
            });
        }
    });
});

function viewResurce(id, isShow) {
    $("#editModal .update").hide();
    $("#editModal .view").hide();
    $("#editModal .add").hide();
    $("#editModal").modal("toggle");
    // $("#editForm").reset();
    var dis = "";
    if (isShow == 'show') {
        dis = 'disabled="disabled"';
    } else {
        $("#id").val(id);
    }
    $.ajax({
        type: "post",
        url: "/resource/view",
        data: {id: id},
        dataType: "json",
        success: function (resData) {
            if (resData.code == 200) {
                var data = resData.data;
                var resource = data.resource;
                document.getElementById("editForm").reset();
                for (var attr in resource) {
                    $("#editForm input[name=" + attr + "]:text").val(resource[attr]);
                    $("#editForm input[name=" + attr + "]:text").attr("disabled", isShow == 'show');
                }
                var parentId = resource.parentId;
                if (parentId == 0) {
                    $('#parentDiv').parent().hide();
                    $("#parentDiv .i-checks").iCheck('uncheck');
                    // $('#editForm input[name="parentId"]').val(0);
                    $('#url').removeAttr("required");
                    $('#url').removeAttr("aria-required");
                } else {
                    $('#parentDiv').parent().show();
                }

                $("#editForm #isParentYes").iCheck(parentId == 0 ? 'check' : 'uncheck');
                $("#editForm #isParentNo").iCheck(parentId != 0 ? 'check' : 'uncheck');
                var state = resource.state;
                $("#editForm #stateYes").iCheck(state == 0 ? 'check' : 'uncheck');
                $("#editForm #stateNo").iCheck(state == 1 ? 'check' : 'uncheck');

                var isMenu = resource.isMenu;
                $("#editForm #isMenuYes").iCheck(isMenu == 0 ? 'check' : 'uncheck');
                $("#editForm #isMenuNo").iCheck(isMenu == 1 ? 'check' : 'uncheck');
                $("#parentDiv").empty();
                //如果为查看则设置为disabled
                if (isShow == 'show') {
                    $("#editModal .view").show();
                    $("#editForm input[type='radio']").attr("disabled", "disabled");
                } else {
                    //修改显示修改保存按钮
                    $("#editModal .update").show();
                    $("#editForm input[type='radio']").removeAttr("disabled");
                }
                $(data.menus).each(function (i, item) {
                    if (resource != null && resource.parentId != null && item.id == resource.parentId) {
                        var str = '<div class="col-sm-3"><label><input class="i-checks" type="checkbox" value="' + item.id + '" id="parentId" name="parentId" checked="checked" ' + dis + '><span>' + item.name + '</span></label> </div>';
                    } else {
                        var str = '<div class="col-sm-3"><label><input class="i-checks" type="checkbox" value="' + item.id + '" id="parentId" name="parentId" ' + dis + '><span>' + item.name + '</span></label> </div>';
                    }
                    $("#parentDiv").append(str);
                });
            } else {
                layer.msg(resData.msg);
            }
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            $('#parentDiv .i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
                chooseOne(this);
            });
            $("#editForm input[name='isMenu']").on("ifChecked", function (i) {
                var isMenu = $(this).val();
                if (isMenu == 0) {
                    $('#iconDiv').show();
                } else {
                    $('#iconDiv').hide();
                }
            });
            $("#editForm input[name='isParent']").on("ifChecked", function (i) {
                // var isMenu = $("input[name='isParent']:checked").val();
                var isParent = $(this).val();
                if (isParent == 0) {
                    $('#parentDiv').parent().hide();
                    $("#parentDiv .i-checks").iCheck('uncheck');
                    //如果修改了第二次所有的菜单id都为0；
                    // $('#editForm input[name="parentId"]').val(0);
                    $('#url').removeAttr("required");
                    $('#url').removeAttr("aria-required");
                } else {
                    $('#parentDiv').parent().show();
                }
            });
        }
    });

}

// function view(id) {
//     $.ajax({
//         type: "post",
//         url: "/resource/view",
//         data: {id: id},
//         dataType: "json",
//         success: function (resData) {
//             if (resData.code == 200) {
//                 var data = resData.data;
//                 var resource = data.resource;
//                 for (var attr in resource) {
//                     $("#editForm input[name=" + attr + "]").val(resource[attr]);
//                 }
//                 $("#parentDiv").empty();
//                 $(data.menus).each(function (i, item) {
//                     if (resource != null && resource.parentId != null && item.id == resource.parentId) {
//                         var str = '<div class="col-sm-3"><label><input type="checkbox" value="' + item.id + '" id="parentId" name="parentId" onclick="chooseOne(this)" checked="checked" disabled="disabled"><span>' + item.name + '</span></label> </div>';
//                     } else {
//                         var str = '<div class="col-sm-3"><label><input type="checkbox" value="' + item.id + '" id="parentId" name="parentId" onclick="chooseOne(this)" disabled="disabled" ><span>' + item.name + '</span></label> </div>';
//                     }
//                     $("#parentDiv").append(str);
//                 });
//             } else {
//                 layer.msg(resData.msg);
//             }
//             $('.i-checks').iCheck({
//                 checkboxClass: 'icheckbox_square-green',
//                 radioClass: 'iradio_square-green',
//             });
//             $('.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
//                 chooseOne(this)
//             });
//         }
//     });
// };


/**
 * 判断所属菜单组不为空
 * @returns {boolean}
 */
function checkEmpty() {
    // var obj = document.getElementsByName("parentId");
    if ($("input[name='isParent']:checked").val() == 1) {
        var j = 0;
        $("#parentDiv .i-checks").each(function (i) {
            if (this.checked) {
                j++;
            }
        });
        if (j == 0) {
            swal("所属菜单不能为空！！！");
            return false;
        } else {
            return true;
        }
    }
    return true;
}


submitHander = function (t, url) {
    if ($("#editForm").valid() && checkEmpty()) {
        layer.confirm("请确资源信息", {
            btn: ["确定", "取消"],
            shade: false
        }, function (index) {
            layer.close(index);
            startModal("#" + t.id);//锁定按钮，防止重复提交
            var formData = $("#editForm").serializeJson();
            formData.state = $("#editForm input[name='state']:checked").val();
            formData.isMenu = $("#editForm input[name='isMenu']:checked").val();
            if (formData.isParent == 0) {
                formData.parentId = 0;
            }
            console.log(formData);
            $.ajax({
                type: "post",
                url: url,
                data: formData,
                dataType: "json",
                success: function (data) {
                    Ladda.stopAll();
                    if (getResCode(data)) {
                        return;
                    }
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        $("#table_logs").jqGrid("setGridParam", {
                            // postData: $("#queryForm").serializeJson()
                        }).trigger("reloadGrid");
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
var resData = null;

function add() {
    $("#editForm input").removeAttr("disabled");
    //清除验证标签
    $("#editForm").find("input").removeClass('error');
    $("#editForm").validate().resetForm();
    document.getElementById("editForm").reset();
    $("#editModal").modal('toggle');
    $("#editModal .add").show();
    $("#editModal .update").hide();
    $("#editModal .view").hide();
    if (resData != null) {
        showCheck(resData);
    } else {
        $.ajax({
            type: "post",
            url: "/resource/listAllMenus",
            dataType: "json",
            success: function (resData) {
                showCheck(resData);
            }
        });
    }
    $("#parentDiv").empty();
    $('#parentDiv .i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
        chooseOne(this);
    });
    $("#editForm input[name='isMenu']").on("ifChecked", function (i) {
        var isMenu = $(this).val();
        if (isMenu == 0) {
            $('#iconDiv').show();
        } else {
            $('#iconDiv').hide();
        }
    });
    $("#editForm input[name='isParent']").on("ifChecked", function (i) {
        // var isMenu = $("input[name='isParent']:checked").val();
        var isParent = $(this).val();
        if (isParent == 0) {
            $('#parentDiv').parent().hide();
            $("#parentDiv .i-checks").iCheck('uncheck');
            //如果修改了第二次所有的菜单id都为0；
            // $('#editForm input[name="parentId"]').val(0);
            $('#url').removeAttr("required");
            $('#url').removeAttr("aria-required");
        } else {
            $('#parentDiv').parent().show();
        }
    });
}

function showCheck(resData) {
    var data = resData.data;
    $("#parentDiv").empty();
    $(data.resources).each(function (i, item) {
        var str = '<div  class="col-sm-3"><label><input class="i-checks" type="checkbox" value="' + item.id + '" name="parentId" id="parentId"><span>' + item.name + '</span></label> </div>';
        $("#parentDiv").append(str);
    });
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
    $('.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
        chooseOne(this)
    });
}