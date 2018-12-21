var BusinessEdit = {
    //回显稿件信息
    showDetail:function(){
        var artId = getQueryString("artId");
        $("#id").val(artId);
        var commissionStates = getQueryString("commissionStates");
        var invoiceStates = getQueryString("invoiceStates");
        if(invoiceStates == 1){
            $("input").attr("disabled","disabled");
        }else if(commissionStates != 1){

        }else if(commissionStates == 1){
            $("[name]").attr("readonly","readonly");
            $("[name='link']").removeAttrs("readonly");
        }
        $.ajax({
            url: "/article/editArticle",
            type: "post",
            data: {id:artId},
            success: function(resData){
                for(var o in resData){
                    if(o == "issuedDate"){
                        var d2 = new Date(resData[o]).format("yyyy/MM/dd");
                        $("#issuedDate").val(d2);
                        continue;
                    }
                    var v = resData[o] || "";
                    $("[name="+o+"]").val(v);
                    if(o=="payAmount"){
                        $("#outgoAmount").val(resData[o])
                    }
                }
            }
        });
    },
    update: function() {
        var param = $("#art").serializeJson();
        if ($("#art").valid()) {
            $.ajax({
                url: "/article/updateArticle",
                type: "post",
                data: param,
                success: function (resData) {
                    if (resData.code == 200) {
                        layer.alert("更新成功");
                        setTimeout("top.layer.closeAll()", 1000);
                    } else {
                        layer.alert("更新稿件失败");
                    }
                }
            });
        }
    }
};