
function initCompany(){
    //iframe中的window对象
    companyWindow = $('#companyFrame').prop('contentWindow');
}
/**
 * 弹出编辑窗口
 */
function alertEdit(url,title){
    var height = "60%";
    if(title.indexOf("产品")!=-1 || title.indexOf("用户")!=-1){
        height = "32%";
    }
    var width = "60%";
    if(title.indexOf("账户")!=-1){
        width = "80%";
    }
    parent.layer.open({
        type: 2,
        title: title,
        shadeClose: true,
        shade: 0.8,
        area: [width, height],
        content: url, //iframe的url
        end: function (){
            if(title.indexOf("对接人")!=-1){
                dockingGrid.reflush();
            }
            if(title.indexOf("产品")!=-1){
                productGrid.reflush();
            }
            if(title.indexOf("用户")!=-1){
                usersGrid.reflush();
            }
        }
    });
}

//对接人操作
var commonDockingPeople = {
    //解绑
    cancelBind: function(id,custGrid){
        layer.confirm('您确定要解除绑定吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/cust/cancelBind",
                type: "POST",
                data: {id: id},
                async: false,
                success: function(respData){
                    layer.close(layer.index);
                    layer.alert(respData.data.status);
                    //重新加载表格
                    custGrid.reflush();
                }
            });
        }, function(){

        });
    },
    //认领
    bind: function(id,custGrid){
        layer.confirm('您确定要认领吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/cust/bind",
                type: "POST",
                data: {id: id},
                async: false,
                success: function(respData){
                    layer.close(layer.index);
                    layer.alert(respData.data.status);
                    //重新加载表格
                    custGrid.reflush();
                }
            });
        }, function(){

        });
    },
    stopOrOpen: function(id,bz,custGrid){
        var stat = bz != 1 ? "启用" : "停用";
        layer.confirm('您确定要'+stat+'吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            $.ajax({
                url: "/cust/stopOrOpen",
                type: "POST",
                data: {id: id,deleteFlag:bz},
                async: false,
                success: function(respData){
                    layer.close(layer.index);
                    layer.alert(respData.data.status);
                    //重新加载表格
                    custGrid.reflush();
                }
            });
        }, function(){

        });
    }
};