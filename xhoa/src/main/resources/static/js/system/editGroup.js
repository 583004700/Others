$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/group/edit",
        data:{id:getQueryString("id")},
        dataType: "json",
        success: function (recData) {
            for(var attr in recData.data.group){
                $("[name="+attr+"]").val(recData.data.group[attr]);
            }
        }
    });
    $("#submit").click(function () {
        if($("#form").valid()){
            // alert($("#form").serialize());
            // alert(JSON.stringify($("#form").serializeJson()));
            $.ajax({
                type: "post",
                url: "/group/submit",
                data: $("#form").serializeJson(),
                dataType: "json",
                success: function(data) {
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        setTimeout(function(){
                            window.location.href = "/system/editGroup?id=" + data.data.group.id;
                        },1000);
                    } else{
                        layer.msg(data.msg);
                    }
                }
            });
        }
    });

    $("#cancel").click(function () {
        window.location.href = "/system/queryGroup";
    });
});