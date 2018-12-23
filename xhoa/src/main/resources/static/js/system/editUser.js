$(document).ready(function () {
    $("#submit").click(function () {
        // console.log($("#mgrId").val())
        if ($("#form").valid()) {
            $.ajax({
                type: "POST",
                url: "/user/update",
                data: $("#form").serializeJson(),
                dataType: "json",
                success: function (data) {
                    console.log(data)
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        // swal(data.data.message);
                        // setTimeout(function(){
                        //     window.location.href = "/system/editUser?id="+data.data.user.id
                        // },1000);
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
        }
    });
    $("#cancel").click(function () {
        window.location.href = "/system/queryUser";
    });
    // $.ajax({
    //     type: "post",
    //     url: "/user/edit",
    //     data:{id:getQueryString("id")},
    //     dataType: "json",
    //     success: function (data) {
    //         // console.log(data)
    //         for(var attr in data.data.user){
    //             $("[name="+attr+"]").val(data.data.user[attr]);
    //         }
    //         $("#mgrId").empty() ;
    //         var str = "<option value=''>请选择上级领导</option>" ;
    //         $("#mgrId").append(str) ;
    //         for(var x=0;x<data.data.list.length;x++){
    //             // console.log(data.data.list[x].id)
    //             // console.log(data.data.user.user.id)
    //             if(data.data.user!=null && data.data.list[x].id==data.data.user.mgrId){
    //                 var str = "<option value='" + data.data.list[x].id+"' selected='selected' disabled='disabled'>"+data.data.list[x].name+"</option>" ;
    //             }else{
    //                 var str = "<option value='" + data.data.list[x].id+"' disabled='disabled'>"+data.data.list[x].name+"</option>" ;
    //             }
    //             $("#mgrId").append(str) ;
    //         }
    //     }
    // });
    // $("#mgrId").change(function(){
    //     console.log($(this).val());
    // }) ;
});