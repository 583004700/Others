$(document).ready(function () {

    $("#submit").click(function () {
        if($("#form").valid()){
            // alert($("#form").serialize());
            // alert(JSON.stringify($("#form").serializeJson()));
            var userId = $("#userId").val() ;
            var checkId = "" ;
            $('input:checkbox[name="name"]:checked').each(function() {
                checkId += this.value + "|" ;
            }) ;

            $.ajax({
                type: "post",
                url: "/user/submitUserRole",
                data: {userId:userId,checkId:checkId},
                dataType: "json",
                success: function(data) {
                    // console.log(data)
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        setTimeout(function(){
                            return ;
                        },1000);
                        //window.location.href = "/system/roleList";
                        // parent.layer.confirm(data.data.message, {
                        //     btn: ['确认'], //按钮
                        //     shade: false //不显示遮罩
                        // },function(){
                        //     return ;
                        //     window.location.href = "/user/editUserRole?id="+data.data.userId;
                        // });
                    }else{
                        layer.msg(data.msg) ;
                    }
                }
            });
        }
    });
    $("#cancel").click(function () {
        window.location.href = "/system/queryUser";
    });
});