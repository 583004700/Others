var BusinessEdit = {
    taxes:0,
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
                BusinessEdit.taxes = resData.taxes || 0;
                for(var o in resData){
                    if(o == "issuedDate" || o == "promiseDate"){
                        var d2 = new Date(resData[o]).format("yyyy/MM/dd");
                        $("#issuedDate").val(d2);
                        $("#promiseDate").val(d2);
                        continue;
                    }
                    var v = resData[o] || "";
                    $("[name="+o+"]").val(v);
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
    },
    loadTax: function(){
        $.ajax({
            url: "/article/tax",
            success:function(data){
                var mTypeEle = $("[name='taxSelect']");

                for (var i = 0; i < data.length; i++) {
                    var mType = data[i];
                    mTypeEle.append("<option value='${id}'>${name}</option>".replace("${id}", mType.code).replace("${name}", mType.name));

                }
            }
        });
    },
    taxChange: function(o){
        var v = o.value;
        $("#taxpoint").val(v);
        var newTaxes = parseFloat(v)*parseFloat($("#saleAmount").val() - BusinessEdit.taxes);
        $("#taxes").val(newTaxes.toFixed(2));
    }
};
