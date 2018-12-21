var fh = '<div class="form-group col-md-3"><label class="col-sm-4 control-label">${labelName}:</label><div class="col-sm-8"><input type="${type}" name="${name}" placeholder="${labelName}" class="form-control"/></div></div>';
var url = "media";
$(function () {
    // $.get("/mediaType/parentId/0?isFlag=true", function (data) {
    $.get("/mediaType/userId", function (data) {
        if (data == null || data == '') {
            swal("没有板块可操作！", "没有查询到板块信息，请联系管理员赋权！", "warning");
            return;
        }
        var html = "";
        $(data).each(function (i, item) {
            html += "<div class='col-md-1'><span class='btn btn-outline btn-success' title='" + item.name + "' onclick='setType(" + item.id + ",this)'>" + item.name + "</span></div>";
        });
        $("#mediaType").html(html);
        $("#mediaType>div:first-child>span:first-child").click();

    }, "json");
});

function setType(id, t) {
    $(t).parent().parent().find("div>span").each(function (i, item) {
        // console.log(t == item)
        $(item).removeClass("btn-success");
        if (t == item) {
            $(t).addClass("btn-success");
        }
    });
    $("#mType").val(id);
    $.get("/mediaForm/list/" + id, function (datas) {
        var html = '';
        $(datas).each(function (i, data) {
            if (i % 4 == 0)
                html += '<div class="col-md-12">';
            // var colsm=data.type=="textarea"?"col-sm-4":"col-sm-3";
            html += '<div class="form-group col-sm-3"><label class="col-sm-4 control-label">';
            var required = "";
            var maxLength = data.maxlength ? "minLength=" + data.maxlength : "";
            var minLength = data.minlength ? "minLength=" + data.minlength : "";
            var size = data.size ? "size=" + data.size : "";
            var min = data.min ? "min=" + data.min : "";
            var max = data.max ? "max=" + data.max : "";
            if (data.required == 1) {
                html += '<span class="text-red"> * </span>';
                required = "required";
            }
            html += data.name + ':</label><div class="col-sm-8">';
            switch (data.type) {
                case 'radio':
                    html += (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required);
                    // html += html.th("required", required);
                    break;
                case 'checkbox':
                    html += (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required);
                    // html += html.th("required", required);
                    break;
                case 'select':
                    var sel = (data.html == undefined ? "" : data.html).th('name', data.code);
                    html += sel.th("required", required);
                    if (data.code == "supplierId") {
                        html += '<button type="button" class="btn btn-primary btn-circle glyphicon glyphicon-plus " id="addSupplier" onclick="addSupplier0()"></button>';
                        //console.log('#required'.);
                    }
                    break;
                case 'textarea':
                    html += '<textarea name="${name}" placeholder="${labelName}" ' +required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max +
                        ' class="form-control"></textarea>';
                    break;
                case 'datetime':
                    // html += '<input name="${name}" placeholder="${labelName}" required="${required}" size="${size}" maxlength="${maxlength}" minlength="${minlength}" class="form-control layer-date laydate-icon" onclick="laydate({istime: true, format: \'YYYY-MM-DD hh:mm:ss\'})"/>'.th('name', data.code).th('labelName', data.name);
                    html += '<input name="${name}" placeholder="${labelName}" ' + required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max +
                        ' class="form-control layer-date laydate-icon" onclick="laydate({istime: true, format: \'YYYY-MM-DD hh:mm:ss\'})"/>';
                    break;
                case 'price':
                    // html += '<div class="input-group m-b"><span class="input-group-addon">¥</span><input required="${required}" size="${size}" maxlength="${maxlength}" minlength="${minlength}" type="text" class="form-control" name="${name}" placeholder="${labelName}"> <span class="input-group-addon">.00</span></div>'.th('name', data.code).th('labelName', data.name);
                    html += '<div class="input-group m-b"><span class="input-group-addon">¥</span><input onkeypress="return inPrice(event)" ' + required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max +
                        '  type="number" class="form-control" name="${name}" placeholder="${labelName}"> <span class="input-group-addon">.00</span></div>';
                    break;
                case 'file':
                    // html += '<input type="${type}" name="${name}" placeholder="${labelName}" required="${required}"  size="${size}" maxlength="${maxlength}" minlength="${minlength}" class="form-control"/>'.th('name', data.code).th('labelName', data.name).th('type', data.type);
                    html += '<input type="file" name="file" ' + required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max + ' class="form-control"/>';
                    break;
                case 'number':
                    // html += '<input type="${type}" name="${name}" placeholder="${labelName}" required="${required}"  size="${size}" maxlength="${maxlength}" minlength="${minlength}" class="form-control"/>'.th('name', data.code).th('labelName', data.name).th('type', data.type);
                    html += '<input onkeypress="return inNum(event)" type="number" name="${name}" id="${name}" placeholder="${labelName}" ' + required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max +
                        ' class="form-control"/>';
                    break;
                default:
                    // html += '<input type="${type}" name="${name}" id="${name}" placeholder="${labelName}" ' + required + maxLength + minLength + size + min + max +
                    //     ' class="form-control"/>';
                    html += '<input type="${type}" name="${name}" id="${name}" placeholder="${labelName}" ' + required +" "+ maxLength +" "+ minLength +" "+ size +" "+ min +" "+ max +
                        ' class="form-control"/>';
                    break;
            }
            html = html.th('id', data.code).th('name', data.code).th('labelName', data.name).th('type', data.type);//.th('required', required).th('size', data.size).th('maxlength', data.maxlength).th('minlength', data.minlength);
            // console.log(html);
            if ((i + 1) % 4 == 0) html += '</div></div></div>';
            else html += '</div></div>';
        });
        $("#mediaForm").html(html);
        $("#mediaForm select").each(function () {
            if ($(this).attr("onload"))
                this.onload();
        });
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
}

/**
 * 新增供应商
 */
function addSupplier0() {
    alertEdit('/media/supplier_edit?op=create&mediaTypeId=' + $("#mType").val(), '新增媒体供应商');
}

/**
 * 媒体保存
 */
function saveMedia() {
    $.get("/media/isDuplicateForName", {mType: $("#mType").val(), mediaName: $("#name").val()}, function (data) {
        if (data.code == 200) {
            // var mf = $("#mf").serializeJson();
            if ($("#mf").valid()) {
                // $.post("/media", mf, function (d) {
                //     // if (d.code == 200) {
                //     swal({
                //         title: "提示!",
                //         text: d.code == 200 ? "媒体保存成功！" : d.msg,
                //         type: d.code == 200 ? "success" : "error",
                //     });
                //     // }
                // });
                var formData = new FormData($('#mf')[0]);
                // formData.append('file', $('#file')[0].files[0]);
                $.ajax({
                    url: "/media",
                    type: 'POST',
                    cache: false,
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function (d) {
                        swal({
                            title: "提示!",
                            text: d.code == 200 ? "媒体保存成功！" : d.msg,
                            type: d.code == 200 ? "success" : "error",
                        });
                    }
                }).done(function (res) {
                }).fail(function (res) {
                });
            }
        } else {
            swal({
                title: "提示!",
                text: data.code == 200 ? "媒体不存在，可以新增！" : "媒体已存在，请更换媒体名称？",
                type: data.code == 200 ? "success" : "error",
            });
        }
    });
}

$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});

$().ready(function () {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#mf").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                remote: {
                    url: "/media/isDuplicateForName", // 后台处理程序
                    type: "get", // 数据发送方式
                    dataType: "json", // 接受数据格式
                    data: { // 要传递的数据
                        "mType": function () {
                            return $("#mType").val();
                        },
                        "mediaName": function () {
                            return $("#name").val();
                        }
                    },
                    dataFilter: function (data) {
                        data = JSON.parse(data);
                        if (data.code != 200) {
                            $("#name").focus();
                            return false;
                        } else {
                            return true;
                        }

                    }
                }
            },

        },
        messages: {
            name: {minlength: icon + "用户名必须两个字符以上", remote: icon + "该媒体名称已存在，请更换！"},
        }
    });
});


