package com.yuan.fest.latte.ec.net;

public class NetConfig {
    public static final boolean ISDEBUG = true;
    public static String serverDomain = "http://121.36.153.215:8080";

    public static String getServer(){
        if(ISDEBUG) {
            serverDomain = "http://192.168.0.114:8090/";
        }
        return serverDomain;
    }
}
