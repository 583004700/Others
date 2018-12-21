function getDateStr(dateSelect){
    var dStr = "";
    switch (dateSelect){
        case '4':
            dStr = '日';
            break;
        case '3':
            dStr = '月';
            break;
        case '1':
            dStr = '年';
            break;
    }
    return dStr;
}

//得到查询参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  decodeURIComponent(r[2]); return null;
}

//统一加上权限，是否登录验证，baseURL
var ajax = $.ajax;
$.ajax = function(obj){
    if(obj.data){
        for(var k in obj.data){
            if(typeof(obj.data[k]) == "string"){
                //提交参数时去除前后空格
                obj.data[k] = obj.data[k].replace(/(^\s*)|(\s*$)/g , "");
            }
        }
    }
    var succ = obj.success;
    var realUrl = baseUrl+obj.url;
    obj.url = realUrl;
    obj.success = function(resData){
        if(getResCode(resData)){
            return;
        }
        succ(resData);
    };
    ajax(obj);
};

//给所有创建的echarts对象设置窗口自适应
if(typeof(echarts) != "undefined"){
    var echartsInit = echarts.init;
    var events = {};
    echarts.init = function(ele){
        var chartObj = echartsInit(ele);
        if(events[ele]){
            window.removeEventListener("resize",events[ele]);
        }
        events[ele] = chartObj.resize;
        window.addEventListener("resize",chartObj.resize);
        return chartObj;
    };
}