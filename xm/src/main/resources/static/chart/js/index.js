//聊天的webSocket路径
var chartWebsocketHref = "ws://"+window.location.host+"/chartWebsocket/";

var LocalStorageOpt = {
    setObjectItem: function (key, value) {
        window.localStorage.setItem(key, JSON.stringify(value));
    },
    getObjectItem: function (key) {
        var itemStr = window.localStorage.getItem(key);
        if (key) {
            return JSON.parse(itemStr);
        }
    }
};

// LocalStorageOpt.setObjectItem("allChartRecords",[{"chartFrom":"1","chartTo":"2","chartText":"你好，钟老师","chartDate":"1"},
//     {"chartFrom":"2","chartTo":"1","chartText":"你好，朱老师","chartDate":"2"},
//     {"chartFrom":"1","chartTo":"2","chartText":"发下邮件","chartDate":"3"}
// ]);

var ChartRecord = {
    /**
     * 获取所有聊天记录
     * @returns {any}
     */
    getAllChartRecords: function () {
        //所有的聊天记录保存在localStorage中
        var allChartRecords = LocalStorageOpt.getObjectItem("allChartRecords");
        if(!allChartRecords){
            return [];
        }
        return allChartRecords;
    },
    /**
     * 获取两个用户之间的聊天记录
     * @param user1
     * @param user2
     */
    getTwoUserChartRecords: function (user1, user2) {
        var allChartRecords = this.getAllChartRecords();
        var twoUserChartRecords = [];
        for (var i = 0; i < allChartRecords.length; i++) {
            if ((allChartRecords[i].chartFrom == user1.id && allChartRecords[i].chartTo == user2.id) || (allChartRecords[i].chartFrom == user2.id && allChartRecords[i].chartTo == user1.id)) {
                twoUserChartRecords.push(allChartRecords[i]);
            }
        }
        return twoUserChartRecords;
    },
    //添加一条聊天记录在持久化对象中
    addChartRecord: function (chartObject) {
        var allChartRecords = this.getAllChartRecords();
        allChartRecords.push(chartObject);
        LocalStorageOpt.setObjectItem("allChartRecords", allChartRecords);
    }
};

/**
 * 用户对象
 * @param id
 * @param realName
 * @constructor
 */
var User = function (id, realName) {
    this.id = id;
    this.realName = realName;
    this.pic = "/chart/images/own_head.jpg";
    //用户对应界面左侧菜单元素，每个用户都有自己的，方便找到对应的左侧列表进行操作
    this.leftElements = "";
    //最后一次在输入框中未保存的内容
    this.lastChartText = "";
    //最后条发送成功或者接收成功的聊天记录
    this.lastChartRecord = "";
};

User.prototype = {
    chatbox: $("#chatbox"),
    //设置用户头像
    setPic: function (pic) {
        if(pic){
            this.pic = pic;
        }
        return this;
    },
    /**
     * 加载与其它用户的聊天记录数据
     * @param otherUser
     */
    loadChartRecords: function (otherUser) {
        //用户相互聊天记录，一般是从从数据库查出来的
        var chartRecords = ChartRecord.getTwoUserChartRecords(this, otherUser);
        return chartRecords;
    },
    /**
     * 添加一条消息在聊天界面
     * @param chartRecord
     * @param otherUser
     */
    addOneChartRecord: function (chartRecord, otherUser) {
        var success = false;
        var chartBox = this.chatbox;
        var chartRecordElement = $("<li class=\"\"><img src=\"\" title=\"\"><span></span></li>");
        if (chartRecord.chartFrom == this.id && chartRecord.chartTo == otherUser.id) {
            chartRecordElement.attr("class", "me");
            chartRecordElement.find("img").attr("src", this.pic);
            chartRecordElement.find("img").attr("title", this.realName);
            success = true;
        }
        if (chartRecord.chartFrom == otherUser.id && chartRecord.chartTo == this.id) {
            chartRecordElement.attr("class", "other");
            chartRecordElement.find("img").attr("src", otherUser.pic);
            chartRecordElement.find("img").attr("title", otherUser.realName);
            success = true;
        }
        if (success) {
            chartRecordElement.find("span").html(chartRecord.chartText ? chartRecord.chartText : "");
            chartBox.append(chartRecordElement);
        }
    },
    /**
     * 打开与另一个用户的会话,并将聊天内容展示在对话框内
     */
    openUserSession: function (otherUser) {
        //加载聊天记录的数据
        var chartRecords = this.loadChartRecords(otherUser);
        $("#realName").html(otherUser.realName);
        //聊天记录box
        var chartBox = this.chatbox;
        //清空页面上的聊天记录
        $(chartBox.html(""));
        for (var i = 0; i < chartRecords.length; i++) {
            var chartRecord = chartRecords[i];
            //将聊天记录数据添加在页面
            this.addOneChartRecord(chartRecord, otherUser);
        }
    }
};

/**
 * 聊天窗口
 * @param currentUser 当前操作的用户
 * @constructor
 */
var ChartWindow = function (currentUser) {
    this.currentUser = currentUser;
    $("#myPic").css("background","url("+this.currentUser.pic+")");
    //用户列表
    this.userList = [];
    this.userMap = {};
    //用户列表在页面上的位置
    this.userListElement = $("#userList");
    //另一个用户对象
    this.otherUser = {};
    //聊天记录box
    this.chatbox = $("#chatbox");
    this.inputBox = $("#input_box");
};

ChartWindow.prototype = {
    /**
     * 设置用户列表，因为会重置状态，并加载列表，适用于连接被关闭时重置，或首次加载列表
     * @param userList
     * @returns {ChartWindow}
     */
    setUserList: function (userList) {
        this.userList = [];
        this.userMap = {};
        this.otherUser = "";
        //清空页面上的用户列表
        this.userListElement.html("");
        for (var i = 0; i < userList.length; i++) {
            this.onLine(userList[i]);
        }
        return this;
    },
    /**
     * 刷新用户列表,如果直接用setUserList，则会清空列表和重新加载，会影响当前正在聊天的窗口
     * @param newUserList
     */
    flushUserList: function(newUserList){
        if(!newUserList){
            return;
        }
        for (var i = 0; i < newUserList.length; i++) {
            var newUser = newUserList[i];
            if(this.userMap[newUser.id] && this.userMap[newUser.id].id){
                //如果新的列表中的用户在当前列表，则不操作
            }else{
                this.onLine(newUser);
            }
        }

        for (var i = 0; i < this.userList.length; i++) {
            var outLineBoolean = true;
            var user = this.userList[i];
            for (var i = 0; i < newUserList.length; i++) {
                if(newUserList[i].id == user.id){
                    outLineBoolean = false;
                }
            }
            if(outLineBoolean){
                this.outLine(this.userList[i].id);
            }
        }

    },
    //用户上线
    onLine: function (user) {
        this.userList.push(user);
        this.userMap[user.id] = user;
        //操作页面元素
        var userObj = $("<li onclick=\"\">\n" +
            "<div class=\"user_head\"><img src=\"\"/></div>\n" +
            "<div class=\"user_text\">\n" +
            "<p class=\"user_name\"></p>\n" +
            "<p class=\"user_message\"></p>\n" +
            "</div>\n" +
            "<div class=\"user_time\"></div>\n" +
            "</li>");
        userObj.attr("onclick", "chartWindow.openUserSession('" + user.id + "',this)");
        userObj.find("img").attr("src", user.pic);
        userObj.find(".user_name").html(user.realName);
        //加载最近的聊天记录
        var chartRecords = this.currentUser.loadChartRecords(user);
        if (chartRecords && chartRecords.length > 0) {
            user.lastChartRecord = chartRecords[chartRecords.length - 1];
            userObj.find(".user_message").html(user.lastChartRecord.chartText);
        }
        this.userListElement.append(userObj);
        user.leftElements = userObj;
        return this;
    },
    /**
     * 用户下线
     * @param user
     */
    outLine: function(userId){
        this.userMap[userId].leftElements.remove();
        for(var i = 0;i<this.userList.length;i++){
            if(this.userList[i].id == userId){
                this.userList.splice(i,1);
            }
        }
        this.userMap[userId] = "";
        if(this.otherUser){
            if(userId == this.otherUser.id){
                this.cleanChart();
                this.otherUser = {};
            }
        }
    },
    /**
     * 清除右边元素内容
     */
    cleanChart: function(){
        //清空页面上的聊天记录
        $(this.chatbox.html(""));
        $("#realName").html("");
    },
    inputBoxValueChange: function(element){
        if(this.otherUser){
            this.otherUser.lastChartText = element.value;
        }
    },
    /**
     * 将聊天记录定位到最新位置
     */
    lastPosition: function(){
        var chartBox = this.chatbox;
        var chartParent = chartBox.parent();
        var topValue = -(chartBox.height() - chartParent.height()+20);
        if(topValue<0){
            chartBox.css("top",topValue);
        }else{
            chartBox.css("top",0);
        }
    },
    //打开与其它用户的聊天窗口,因为页面调用时只传id过来
    openUserSession: function (otherUserId, element) {
        if(this.otherUser.lastChartText){
            var messageText ="<span style='color: red'>[草稿]</span>" + this.otherUser.lastChartText;
            this.otherUser.leftElements.find(".user_message").html(messageText);
        }

        this.otherUser = this.userMap[otherUserId];

        this.otherUser.leftElements.find(".user_message").html(this.otherUser.lastChartRecord ? this.otherUser.lastChartRecord.chartText : '');

        //清空其它用户列表的激活状态
        this.userListElement.find("li").attr("class", "");
        $(element).attr("class", "user_active");
        this.currentUser.openUserSession(this.otherUser);
        this.inputBox.val(this.otherUser.lastChartText);
        this.lastPosition();
    },
    //因为打开聊天窗口时就已经知道另一个用户是谁，所以不用传给哪个用户发送消息
    sendMessage: function (messageText) {
        if(!this.otherUser.id){
            alert("请在左侧选择要发送的对象");
            return;
        }
        if(!messageText || messageText.replace(/\s+/g,"") == ""){
            alert("不能发送空消息");
            return;
        }
        var chartRecord = {
            "chartFrom": this.currentUser.id,
            "chartTo": this.otherUser.id,
            "chartText": messageText,
            "chartDate": chartDate
        };
        var chartDate = new Date().getTime();
        this.currentUser.addOneChartRecord(chartRecord, this.otherUser);
        ChartRecord.addChartRecord(chartRecord);
        this.otherUser.leftElements.find(".user_message").html(messageText);
        //将聊天窗口定位到最新位置
        this.lastPosition();

        this.inputBox.val('').focus();
        this.otherUser.lastChartText = "";

        var sendMessageObj = {"sendMessage":chartRecord};
        socket.send(JSON.stringify(sendMessageObj));
    },
    receiveMessage: function(fromUserId,messageText){
        var chartRecord = {
            "chartFrom": fromUserId,
            "chartTo": this.currentUser.id,
            "chartText": messageText,
            "chartDate": chartDate
        };
        var chartDate = new Date().getTime();
        this.currentUser.addOneChartRecord(chartRecord, this.otherUser);
        ChartRecord.addChartRecord(chartRecord);
        $(this.userMap[fromUserId].leftElements).find(".user_message").html(messageText);
        //将聊天窗口定位到最新位置
        this.lastPosition();
    }
};

function onKeyPress(event) {
    event = event || window.event;
    if (event.keyCode == 13) {
        event.returnValue = false;
        event.preventDefault();
        $("#send").click();
    }
}

var user1;
var chartWindow;
var socket;

$(document).ready(function(){
    user1 = new User(user.id, user.realName).setPic(user.pic);

    chartWindow = new ChartWindow(user1);

    var currentUserId = user.id;
    socket = new WebSocket(chartWebsocketHref+currentUserId);

    socket.onopen = function() {
        console.log("Socket 已打开");
        var flushUsers = {"flushUsers":currentUserId};
        socket.send(JSON.stringify(flushUsers));
    };

    socket.onmessage = function(msg) {
        var messageObj = JSON.parse(msg.data);
        if(messageObj.onLine){
            var user2 = new User(messageObj.onLine.id, messageObj.onLine.realName).setPic(messageObj.onLine.pic);
            chartWindow.onLine(user2);
            //chartWindow.flushUserList([user2]);
        }
        if(messageObj.outLine){
            chartWindow.outLine(messageObj.outLine.id);
            //chartWindow.flushUserList([]);
        }
        if(messageObj.flushUsers){
            var newUserList = [];
            for (var i = 0; i < messageObj.flushUsers.length; i++) {
                var newUser = new User(messageObj.flushUsers[i].id, messageObj.flushUsers[i].realName).setPic(messageObj.flushUsers[i].pic);
                newUserList.push(newUser);
            }
            chartWindow.flushUserList(newUserList);
        }
        if(messageObj.sendMessage){
            var chartObj = messageObj.sendMessage;
            chartWindow.receiveMessage(chartObj.chartFrom,chartObj.chartText);
        }
    };

    socket.onclose = function() {
        console.log("Socket 已关闭");
        //重置用户列表
        chartWindow.setUserList([]);
    };

    socket.onerror = function() {
        console.log("Socket error");
    };

    $(window).unload(function(){
        socket.close();
    });
});

