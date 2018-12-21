$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/role/edit",
        data:{id:getQueryString("id")},
        dataType: "json",
        success: function (data) {
            for(var attr in data.data.role){
                $("[name="+attr+"]").val(data.data.role[attr]);
            }
            $("#deptId").empty() ;
            var str = "<option value=''>请选择所属部门</option>" ;
            $("#deptId").append(str) ;
            for(var x=0;x<data.data.list.length;x++){
                // console.log("****="+recData.data.role.dept.id) ;
                // console.log(data.data.list[x].id) ;
                // console.log("------------------") ;
                if(data.data.role!=null && data.data.role.dept!=null && data.data.list[x].id==data.data.role.dept.id){
                    var str = "<option value='" + data.data.list[x].id+"' selected='selected' name='dept.id'>"+data.data.list[x].name+"</option>" ;
                }else{
                    var str = "<option value='" + data.data.list[x].id+"'  name='dept.id'>"+data.data.list[x].name+"</option>" ;
                }
                $("#deptId").append(str) ;
            }
        }
    });
    $("#submit").click(function () {
        if($("#form").valid()){
            // alert($("#form").serialize());
            // alert(JSON.stringify($("#form").serializeJson()));
            $.ajax({
                type: "post",
                url: "/role/submit",
                data: $("#form").serializeJson(),
                dataType: "json",
                success: function(data) {
                    // console.log(data)
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        setTimeout(function(){
                            window.location.href = "/system/editRole?id="+data.data.role.id
                        },1000);
                    }else{
                        layer.msg(data.msg) ;
                    }
                }
            });
        }
    });
    $("#cancel").click(function () {
        window.location.href = "/system/queryRole";
    });



    // 验证
    // $.validator.setDefaults({
    //     highlight: function (e) {
    //         $(e).closest(".form-group").removeClass("has-success").addClass("has-error")
    //     }, success: function (e) {
    //         e.closest(".form-group").removeClass("has-error").addClass("has-success")
    //     }, errorElement: "span", errorPlacement: function (e, r) {
    //         e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent())
    //     }, errorClass: "help-block m-b-none", validClass: "help-block m-b-none"
    // }),
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#form").validate({
        rules: {
            name: {required: !0, minlength: 2, maxlength: 50,
                    remote : {
                        url : "/role/checkName", // 后台处理程序
                        type : "post", // 数据发送方式
                        dataType : "json", // 接受数据格式
                        data : { // 要传递的数据
                            "id" : function() {
                                return $("#id").val();
                            },
                            "name" : function() {
                                return $("#name").val();
                            }
                        },
                        message: "用户名重复！",
                        dataFilter : function(data) {
                            //返回值是string，需要转换成json
                            var obj = JSON.parse(data)
                            if(obj.data.flag){
                                return true ;
                            }else{
                                return false ;
                            }

                        }
                    }
                },
            // password: {required: !0, minlength: 3, maxlength: 50},
        },
        messages: {
            name: {required: e + "请输入角色名称", minlength: e + "角色名称长度必须大于{0}个字符", maxlength: e + "角色名称长度必须小于{0}个字符",remote: e + "名称重复，请更改！"},
            // password: {required: e + "请输入密码", minlength: e + "密码长度必须大于{0}个字符", maxlength: e + "密码长度必须小于{0}个字符"},
        }
    });
});