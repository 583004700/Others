package com.zhuwb;

import java.util.List;

public abstract class Config {
    private List<Friend> friendList;

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }
}
