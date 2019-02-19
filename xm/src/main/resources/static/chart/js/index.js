var LocalStorageOpt = {
    setObjectItem: function(key,value){
        window.localStorage.setItem(key,JSON.stringify(value));
    },
    getObjectItem: function(key){
        var itemStr = window.localStorage.getItem(key);
        if(key){
            return JSON.parse(itemStr);
        }
    }
};

var ChartRecord = {
    /**
     * 获取所有聊天记录
     * @returns {any}
     */
    getAllChartRecords: function(){
        //所有的聊天记录保存在localStorage中
        LocalStorageOpt.setObjectItem("allChartRecords",[{"chartFrom":"1","chartTo":"2","chartText":"你好，钟老师","chartDate":"1"},
            {"chartFrom":"2","chartTo":"1","chartText":"你好，朱老师","chartDate":"2"},
            {"chartFrom":"1","chartTo":"2","chartText":"发下邮件","chartDate":"3"}
        ]);
        var allChartRecords = LocalStorageOpt.getObjectItem("allChartRecords");
        return allChartRecords;
    },
    /**
     * 获取两个用户之间的聊天记录
     * @param user1
     * @param user2
     */
    getTwoUserChartRecords: function(user1,user2){
        var allChartRecords = this.getAllChartRecords();
        var twoUserChartRecords = [];
        for(var i=0;i<allChartRecords.length;i++){
            if((allChartRecords[i].chartFrom == user1.id && allChartRecords[i].chartTo == user2.id) || (allChartRecords[i].chartFrom == user2.id && allChartRecords[i].chartTo == user1.id)){
                twoUserChartRecords.push(allChartRecords[i]);
            }
        }
        return twoUserChartRecords;
    },
    //添加一条聊天记录
    addChartRecord: function(chartFrom,chartTo,chartText,chartDate){
        this.getAllChartRecords().push({"chartFrom":chartFrom,"chartTo":chartTo,"chartText":chartText,"chartDate":chartDate});

    }
};

/**
 * 用户对象
 * @param id
 * @param realName
 * @constructor
 */
var User = function(id,realName){
    this.id = id;
    this.realName = realName;
    this.pic = "/chart/images/own_head.jpg"
};

User.prototype = {
    //设置用户头像
    setPic: function(pic){
        this.pic = pic;
        return this;
    },

    /**
     * 加载与其它用户的聊天记录
     * @param otherUser
     */
    loadChartRecords:function(otherUser){
        //用户相互聊天记录，一般是从从数据库查出来的
        var chartRecords = ChartRecord.getTwoUserChartRecords(this,otherUser);
        return chartRecords;
    },
    /**
     * 打开与另一个用户的会话,并将聊天内容展示在对话框内
     */
    openUserSession(otherUser){
        var chartRecords = this.loadChartRecords(otherUser);
        $("#realName").html(otherUser.realName);
        //聊天记录box
        var chartBox = $("#chatbox");
        //清空页面上的聊天记录
        $(chartBox.html(""));
        for(var i = 0;i < chartRecords.length; i++){
            var success = false;
            var chartRecord = chartRecords[i];
            var chartRecordElement = $("<li class=\"\"><img src=\"\" title=\"\"><span></span></li>");
            if(chartRecord.chartFrom == this.id && chartRecord.chartTo == otherUser.id){
                chartRecordElement.attr("class","me");
                chartRecordElement.find("img").attr("src",this.pic);
                chartRecordElement.find("img").attr("title",this.realName);
                success = true;
            }
            if(chartRecord.chartFrom == otherUser.id && chartRecord.chartTo == this.id){
                chartRecordElement.attr("class","other");
                chartRecordElement.find("img").attr("src",otherUser.pic);
                chartRecordElement.find("img").attr("title",otherUser.realName);
                success = true;
            }
            if(success){
                chartRecordElement.find("span").html(chartRecord.chartText ? chartRecord.chartText : "");
                chartBox.append(chartRecordElement);
            }
        }

    }
};

/**
 * 聊天窗口
 * @param currentUser 当前操作的用户
 * @constructor
 */
var ChartWindow = function(currentUser){
    this.currentUser = currentUser;
    //用户列表
    this.userList = [];
    this.userMap = {};
    //用户列表在页面上的位置
    this.userListElement = $("#userList");
};

ChartWindow.prototype = {
    /**
     * 设置用户列表
     * @param userList
     * @returns {ChartWindow}
     */
    setUserList:function(userList){
        this.userList = [];
        this.userMap = {};
        //清空页面上的用户列表
        this.userListElement.html("");
        for(var i=0;i<userList.length;i++){
            this.onLine(userList[i]);
        }
        return this;
    },
    //用户上线
    onLine: function(user){
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
        userObj.attr("onclick","chartWindow.openUserSession('"+user.id+"',this)");
        userObj.find("img").attr("src",user.pic);
        userObj.find(".user_name").html(user.realName);
        //加载最近的聊天记录
        var chartRecords = this.currentUser.loadChartRecords(user);
        if(chartRecords && chartRecords.length > 0) {
            var lastChartRecord = chartRecords[chartRecords.length - 1];
            userObj.find(".user_message").html(lastChartRecord.chartText);
        }
        this.userListElement.append(userObj);
        return this;
    },
    //打开与其它用户的聊天窗口,因为页面调用时只传id过来
    openUserSession: function(otherUserId,element){
        //清空其它用户列表的激活状态
        this.userListElement.find("li").attr("class","");
        $(element).attr("class","user_active");
        var otherUser = this.userMap[otherUserId];
        this.currentUser.openUserSession(otherUser);
    }
};


var user1 = new User("1","朱未斌");

var user2 = new User("2","钟子祥").setPic("/chart/images/head/15.jpg");

var user3 = new User("3","郝忠斌").setPic("/chart/images/head/4.jpg");

var userList = [user2,user3];

var chartWindow = new ChartWindow(user1).setUserList(userList);





