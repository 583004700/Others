package com.demo.ssh.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SSHUtil {
    public static Session getSession(String username,String password, String host, int port) throws Exception{
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setUserInfo(new UserInfo() {
            public String getPassphrase() {
                return null;
            }

            public String getPassword() {
                return null;
            }

            public boolean promptPassword(String arg0) {
                return false;
            }

            public boolean promptPassphrase(String arg0) {
                return false;
            }

            public boolean promptYesNo(String arg0) {
                return true;
            }

            public void showMessage(String arg0) {
            }

        });
        session.setPassword(password);
        session.connect();
        return session;
    }
}
