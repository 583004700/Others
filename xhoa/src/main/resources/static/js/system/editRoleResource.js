$(document).ready(function () {
    $("#changeRole").change(function(){
       // window.location.href="/role/editRoleResource?id="+ $(this).val() ;
    }) ;

    $("#submit").click(function () {
        if($("#form").valid()){
            // alert($("#form").serialize());
            // alert(JSON.stringify($("#form").serializeJson()));
            var roleId = $("#roleId").val() ;
            var checkId = "" ;
            $('input:checkbox[name="resourceName"]:checked').each(function() {
                checkId += this.value + "|" ;
            }) ;
            $.ajax({
                type: "post",
                url: "/role/submitRoleresource",
                data: {roleId:roleId,checkId:checkId},
                dataType: "json",
                success: function(data) {
                    if(data.code==200){
                        layer.msg(data.data.message, {time: 1000, icon:6});
                        setTimeout(function(){
                            return ;
                            // window.location.href = "/role/editRoleResource?id="+data.data.roleId;
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

    //全不选
    //
    // $("#btnAllNotChk").click(function () {
    //
    //     $("#chk input:checkbox").removeAttr("checked");
    //
    // });
    //全选

    $(".level1").click(function () {
        if(this.checked){
            // $(".level2Div :checkbox:first-child").prop('checked',true);
            $(".level2Div :checkbox").prop('checked',true);
        }else{
            // $(".level2Div :checkbox:first-child").prop('checked',false);
            $(".level2Div :checkbox").prop('checked',false);
        }
    });

    $(".level2").click(function () {
        if(this.checked){
            $(this).parent().parent().find(".level3").prop('checked',true);
            // $(".level3Div :checkbox").prop('checked',true);
        }else{
            // $(".level2Div :checkbox:first-child").prop('checked',false);
            // $(".level3Div :checkbox").prop('checked',false);
            $(this).parent().parent().find(".level3").prop('checked',false);
        }
        level1chk()
    });

    $(".level3").click(function(){
        //处理全选和单选的问题
        level1chk();
        //处理子节点全选和单选的问题
        var chknum2 = $(this).parent().parent().parent().parent().find(".level3").size() ;
        // console.log("chknum2="+chknum2) ;
        var chk2 = 0 ;
        $($(this).parent().parent().parent().parent().find(".level3")).each(function () {
            if($(this).prop("checked")==true){
                chk2++;
            }
        });
        // console.log("chk2="+chk2) ;
        if(chknum2==chk2){//全选
            $(this).parent().parent().parent().parent().find(".level2").prop("checked",true);
        }else{//不全选
            $(this).parent().parent().parent().parent().find(".level2").prop("checked",false);
        }
    });

    function level1chk(){
        var chknum = $(".level3").size();//选项总个数
        var chk = 0;
        $(".level3Div :checkbox").each(function () {
            if($(this).prop("checked")==true){
                chk++;
            }
        });
        if(chknum==chk){//全选
            $(".level1").prop("checked",true);
        }else{//不全选
            $(".level1").prop("checked",false);
        }
    }
});