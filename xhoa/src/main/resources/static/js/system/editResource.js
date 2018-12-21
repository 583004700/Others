//只允许选一个
function chooseOne(chk){
    //先取得同name的chekcBox的集合物件
    var obj = document.getElementsByName("groupId");
    for (i=0; i<obj.length; i++){
        if (obj[i]!=chk) obj[i].checked = false;
        else obj[i].checked = true;
    }
}
$.ajax({
    type: "post",
    url: "/resource/edit",
    data:{id:getQueryString("id")},
    dataType: "json",
    success: function (recData) {
        // console.log(recData)
        for(var attr in recData.data.resource){
            $("[name="+attr+"]").val(recData.data.resource[attr]);
        }
        $("#groupDiv").empty() ;
        for(var x=0;x<recData.data.groups.length;x++){
            // console.log(data.data.list[x].id)
            // console.log(data.data.user.user.id)
            if(recData.data.resource!=null && recData.data.resource.groupId!=null && recData.data.groups[x].id==recData.data.resource.groupId){
                var str = '<div  class="col-sm-3"><label><input type="checkbox" value="'+recData.data.groups[x].id+'" id="groupId" name="groupId" onclick="chooseOne(this)" checked="checked" required=""><span>'+recData.data.groups[x].name+'</span></label> </div>' ;
            }else{
                var str = '<div  class="col-sm-3"><label><input type="checkbox" value="'+recData.data.groups[x].id+'" id="groupId" name="groupId" onclick="chooseOne(this)" required=""><span>'+recData.data.groups[x].name+'</span></label> </div>' ;
            }
            $("#groupDiv").append(str) ;
        }
    }
});
$(document).ready(function () {

    $("#submit").click(function () {
        if($("#form").valid()){
            // alert($("#form").serialize());
            // alert(JSON.stringify($("#form").serializeJson()));
            $.ajax({
                type: "post",
                url: "/resource/submit",
                data: $("#form").serializeJson(),
                dataType: "json",
                success: function(data) {
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        setTimeout(function(){
                            window.location.href = "/system/editResource?id=" + data.data.resource.id;
                        },1000);
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
        }
    });
    $("#cancel").click(function () {
        window.location.href = "/system/queryResource";
    });
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
    $().ready(function () {
        var e = "<i class='fa fa-times-circle'></i> ";
        $("#form").validate({
            rules: {
                name: {required: !0, minlength: 2, maxlength: 50,
                    remote : {
                        url : "/resource/checkName", // 后台处理程序
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
                link: {required: !0, minlength: 3, maxlength: 50},
            },
            messages: {
                name: {required: e + "请输入权限组名称", minlength: e + "权限组名称长度必须大于{0}个字符", maxlength: e + "权限组名称长度必须小于{0}个字符",remote: e+"该名称已存在，请更换！"},
                link: {required: e + "请输入链接", minlength: e + "链接长度必须大于{0}个字符", maxlength: e + "链接长度必须小于{0}个字符"},
            }
        });
    });