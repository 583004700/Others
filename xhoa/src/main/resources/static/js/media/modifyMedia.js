//var fh = '<div class="form-group col-md-3"><label class="col-sm-4 control-label">${labelName}:</label><div class="col-sm-8"><input type="${type}" name="${name}" placeholder="${labelName}" class="form-control"/></div></div>';
var url = "media";
$(function () {
    var id = $.getUrlParam('id');
    $.ajax({
        url: baseUrl + 'media/' + id,
        dataType: 'json',
        type: 'get',
        success: function (data) {
            var media = data.data.media;
            if (media == null || media == undefined) {
                swal("没有查到相关媒体信息！");
                return;
            }
            $("#mType").val(media.mType);
            $("#id").val(media.id);
            setType(media);
        }
    });
});

function setType(media) {
    // console.log(media);
    // for(var k in media){
    //     console.log(k+"=="+media[k]);
    // }
    $.get("/mediaForm/list/" + media.mType, function (datas) {
        var html = '';
        $(datas).each(function (i, data) {
            if (i % 4 == 0)
                html += '<div class="col-md-12">';
            html += '<div class="form-group col-sm-3"><label class="col-sm-4 control-label">';
            var required = "";
            var maxLength = data.maxlength ? "maxLength=" + data.maxlength + " " : " ";
            var minLength = data.minlength ? "minLength=" + data.minlength + " " : " ";
            var size = data.size ? "size=" + data.size + " " : " ";
            var min = data.min ? "min=" + data.min + " " : " ";
            var max = data.max ? "max=" + data.max + " " : " ";
            if (data.required == 1) {
                html += '<span class="text-red"> * </span>';
                required = "required";
            }
            html += data.name + ':</label><div class="col-sm-8">';
            var value = media[data.code];
            value = value == undefined ? "" : value;
            switch (data.type) {
                case 'checkbox':
                // var checkbox = (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required).th("data-value",value);
                // html += checkbox;
                // break;
                case 'radio':
                // var radio = (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required).th("data-value",value);
                // html += radio;
                // break;
                case 'select':
                    // var sel = (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required).th("data-value",value);
                    // html += sel;
                    // break;
                    var ctx = (data.html == undefined ? "" : data.html).th('name', data.code).th("required", required).th("data-value", value);
                    html += ctx;
                    if (data.code == "supplierId") {
                        html += '<button type="button" class="btn btn-primary btn-circle glyphicon glyphicon-plus " id="addSupplier" onclick="addSupplier0()"></button>';
                        //console.log('#required'.);
                    }
                    break;
                case 'textarea':
                    html += '<textarea name="${name}" placeholder="${labelName}" ' + required + maxLength + minLength + size + min + max +
                        ' class="form-control">' + value + '</textarea>';
                    break;
                case 'datetime':
                    html += '<input name="${name}" placeholder="${labelName}" ' + required + maxLength + minLength + size + min + max +
                        ' class="form-control layer-date laydate-icon" onclick="laydate({istime: true, format: \'YYYY-MM-DD hh:mm:ss\'})" value="' + value + '"/>';
                    break;
                case 'price':
                    html += '<div class="input-group m-b"><span class="input-group-addon">¥</span><input ' + required + maxLength + minLength + size + min + max +
                        '  type="${type}" class="form-control" name="${name}" placeholder="${labelName}" value="' + value + '"> <span class="input-group-addon">.00</span></div>';
                    break;
                case 'file':
                    html += '<img style="float: left;width: 60px;width: 60px;" src="' + value + '"/><input type="hidden" name="picPath"  value="' + value + '"/><input style="width: 90px;float: left" type="file" name="file" ' + required + maxLength + minLength + size + min + max + ' class="form-control"/>';
                    break;
                case 'number':
                    // html += '<input type="${type}" name="${name}" placeholder="${labelName}" required="${required}"  size="${size}" maxlength="${maxlength}" minlength="${minlength}" class="form-control"/>'.th('name', data.code).th('labelName', data.name).th('type', data.type);
                    html += '<input onkeypress="return inNum(event)" min="0" type="number" name="${name}" id="${name}" placeholder="${labelName}" ' + required + maxLength + minLength + size + min + max +
                        ' class="form-control" value="' + value + '"/>';
                    break;
                default:
                    html += '<input type="${type}" id="${id}" name="${name}" placeholder="${labelName}" ' + required + maxLength + minLength + size + min + max +
                        ' class="form-control" value="' + value + '"/>';
                    break;
            }
            html = html.th('id', data.code).th('name', data.code).th('labelName', data.name).th('type', data.type);
            if ((i + 1) % 4 == 0) html += '</div></div></div>';
            else html += '</div></div>';
        });
        $("#mediaForm").html(html);
        $("#mediaForm select").each(function () {
            // alert(media+"---");
            this.onload();
            // $(this).trigger("onload",this,media);
        });
        $("#mediaForm input[type='radio']").each(function () {
            // alert(media+"---");
            var value = $(this).attr("data-value");
            // console.log(value);
            $(this).iCheck(value == $(this).val() ? "check" : 'uncheck');
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
    var mf = $("#mf").serializeJson();
    // alert(JSON.stringify(mf));
    // $.get("/media/isDuplicateForName", {mType: mf.mType, mediaName: mf.name}, function (data) {
    //     alert(JSON.stringify(data));
    //     if (data == null || data == "" || data.code == 200) {
    if ($("#mf").valid()) {
        var formData = new FormData($('#mf')[0]);
        // formData.append('file', $('#file')[0].files[0]);
        $.ajax({
            url: "/media/update",
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
                }, function (isConfirm) {
                    location.reload();
                });
            }
        }).done(function (res) {
        }).fail(function (res) {
        });
    }
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
        onkeyup: false,
        rules: {
            name: {
                remote: {
                    onkeyup: false,
                    minlength: 2,
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
                        if (data != null || data.code == 1001) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            },
            discount: {range: [0, 100]},
        },
        messages: {
            name: {minlength: icon + "用户名必须两个字符以上", remote: icon + "该媒体名称已存在，请更换！"},
            discount: {range: $.validator.format("折扣率位于{0} 和 {1} 之间的值")},
        }
    });
});


