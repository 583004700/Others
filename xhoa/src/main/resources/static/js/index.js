function startTime() {
    var today = new Date();
    var y = today.getFullYear();
    var M = today.getMonth() + 1;
    var d = today.getDate();
    var w = today.getDay();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var week = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    // add a zero in front of numbers<10
    m = checkTime(m);
    s = checkTime(s);
    $('#DateTime').html(y + '年' + M + '月' + d + "日 " + h + ':' + m + ':' + s + ' <span class="text-warning">' + week[w] + '</span>');//可改变格式
    t = setTimeout(startTime, 1000);

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }
}

$(function () {
    startTime();
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {

            $("#sendMsg").trigger("click");
        }
    });
    $.get("/user/list", {}, function (d) {
        $(d).each(function (i, user) {
            var div = '<div onclick="setUser(this,' + user.id + ',\'' + user.name + '\',\'' + user.image + '\')"><span><img class="img-circle" src="' + user.image + '"/></span><span>' + user.name + '</span></div>';
            $("#userList").append(div);
        });
    });

});

function setUser(t, id, name, headImg) {
    $("#im-body>div:first-child>div").each(function (j, item) {
        if (item == t) $(this).css("background-color", "#eeeeee");
        else $(this).css("background-color", "white");
    });
    // $("#receiveUserName").text(name);
    $("#receiveName").text(name);
    $("#receiveUserId").val(id);
    $("#headImg").val(headImg);
}

//=================================================修改密码开始===================================================
// $.validator.setDefaults({
//     highlight: function (e) {
//         $(e).closest(".form-group").removeClass("has-success").addClass("has-error")
//     }, success: function (e) {
//         e.closest(".form-group").removeClass("has-error").addClass("has-success")
//     }, errorElement: "span", errorPlacement: function (e, r) {
//         e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent())
//     }, errorClass: "help-block m-b-none", validClass: "help-block m-b-none"
// }),
    $().ready(function () {
        var e = "<i class='fa fa-times-circle'></i> ";
        $("#form").validate({
            rules: {
                oldpassword: {required: !0},
                password1: {required: !0, minlength: 6, maxlength: 16},
                password2: {required: !0, minlength: 6, maxlength: 16, equalTo: "#password1"},
            },
            messages: {
                oldpassword: {required: e + "必填"},
                password1: {
                    required: e + "请输入新密码",
                    minlength: e + "密码长度必须大于{0}个字符",
                    maxlength: e + "密码长度必须小于{0}个字符"
                },
                password2: {
                    required: e + "请再次输入密码",
                    minlength: e + "密码长度必须大于{0}个字符",
                    maxlength: e + "密码长度必须小于{0}个字符",
                    equalTo: "两次密码输入不一致"
                },
            }
        });
        $("#submit").click(function () {
            var oldpassword = $("#oldpassword").val();
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();
            if (password1 == password2) {
                if ($("#form").valid()) {
                    $.ajax({
                        type: "post",
                        url: "/user/updatePassword",
                        data: {
                            oldpassword: oldpassword,
                            password1: password1,
                            password2: password2
                        },
                        dataType: "json",
                        success: function (data) {
                            if (data.code == 200) {
                                // layer.msg(data.data.message, {time: 1000, icon:6});
                                // setTimeout(function(){
                                //     window.parent.location.href = "/";
                                // },1000);
                                parent.layer.alert(data.data.message);
                                parent.layer.confirm('密码修改成功，请重新登录！', {
                                    btn: ['确定'], //按钮
                                    shade: false //不显示遮罩
                                }, function () {
                                    window.location.href = "index";
                                });
                            } else {
                                if ($("#form").valid()) {
                                    parent.layer.alert(data.msg);
                                    initInfo();
                                    // $("#myModal").modal('hide');
                                }
                            }

                            // return ;
                            //window.location.href = "/user/edit?id=" + data.data.sysUser.id;
                        }
                    });
                }
            } else {
                parent.layer.alert("两次密码不一致");
            }

        });
        $("#cancel").click(function () {
            initInfo();
        });

        function initInfo() {
            document.getElementById("form").reset() ;
            $("#form").find("input").removeClass('error');;//清除验证标签
            $("#form").validate().resetForm();
        }

    });
//=================================================修改密码结束===================================================

//修改头像

showImage = function() {
    var docObj = document.getElementById("doc");
    var imgObjPreview = document.getElementById("preview");
    if (docObj.files && docObj.files[0]) {
        //火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '300px';
        imgObjPreview.style.height = '300px';
        //imgObjPreview.src = docObj.files[0].getAsDataURL();
        //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    } else {
        //IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag");
        //必须设置初始大小
        localImagId.style.width = "300px";
        localImagId.style.height = "300px";
        //图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters
                .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        } catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'none';
        document.selection.empty();
    }
    return true;
}

edit = function(){
    $("#editModal").modal("toggle");
    $("input:radio").removeAttr("checked");
    $("input:radio").parent().removeClass("checked");
    $.ajax({
        type: "post",
        url: "/user/editUserSelf",
        dataType: "json",
        success:function (data) {
            for (var attr in data.data.user){
                $("input[name="+attr+"][type!='radio']").attr("value",data.data.user[attr]);
                if(attr="sex"){
                    $("input[name='sex']").attr("disabled","disabled");
                    $("input[name='sex'][value='"+data.data.user[attr]+"']").attr("checked","checked");
                    $("input[name='sex'][value='"+data.data.user[attr]+"']").parent().addClass("checked");
                }
                if(attr="isMgr"){
                    $("input[name='isMgr']").attr("disabled","disabled");
                    $("input[name='isMgr'][value='"+data.data.user[attr]+"']").attr("checked","checked");
                    $("input[name='isMgr'][value='"+data.data.user[attr]+"']").parent().addClass("checked");
                }
                if(attr="remark"){
                    $("#remark").val(data.data.user[attr]);
                }
            }
        }
    });
}

submitHander = function(t,url){
    if($("#editForm").valid()){
        layer.confirm("请确认用户信息",{
                btn:["确认","取消"],
                shade:false
            },function (index) {
                layer.close(index);
                startModal("#"+t.id);
                var formData = $("#editForm").serializeJson();
                $.ajax({
                    type: "post",
                    url: url,
                    data: formData,
                    dataType: "json",
                    success:function (data) {
                        Ladda.stopAll();
                        if(data.code==200){
                            layer.msg(data.data.message,{time:1000,icon:6})
                            $("#editModal").modal("hide");
                        }
                    },
                    error:function (data) {
                        layer.msg(data.msg);
                        $("#editModal").modal("hide");
                    }
                });
        },function () {
            return;
        });
    }
}

$(document).ready(function(){

    var e = "<i class='fa fa-times-circle'></i> ";
    $("#editForm").validate({
        rules: {
            userName:{required:true},
            name:{required:true},
            email:{email: true},
            qq: {checkQQ: true},
            phone: {checkPhone: true}
        },
        messages: {
            userName: {required: e + "请输入用户名"},
            name: {required: e + "请输入姓名"}
        }
    });
    //自定义正则表达式验证方法
    $.validator.addMethod("checkPhone",function(value,element,params){
        var checkPhone = /^(([0]\d{2,3}-\d{7,8})|([1]\d{10}))$/;
        return this.optional(element)||(checkPhone.test(value));
    },"请输入正确的手机号码！");
    $.validator.addMethod("checkQQ",function(value,element,params){
        var checkQQ = /^[1-9][0-9]{4,19}$/;
        return this.optional(element)||(checkQQ.test(value));
    },"请输入正确的QQ号码！");

    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });

    $("#submit2").click(function () {
        var formData = new FormData($("#changePhotoForm")[0]);
        $.ajax({
            type: "post",
            url: "/user/saveImage",
            data: formData,
            dataType: "json",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
                if(data.code==200){
                    layer.msg(data.data.message, {time: 1000, icon:6});
                    setTimeout(function(){
                        window.parent.location.href = "/";
                    },1000);
                }else{
                    layer.msg(data.msg) ;
                }
            }
        });
    });
    $("#cancel2").click(function () {
        window.parent.location.href = "/";
    });
})
