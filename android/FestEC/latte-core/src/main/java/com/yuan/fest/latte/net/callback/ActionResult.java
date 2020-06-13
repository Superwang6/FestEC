package com.yuan.fest.latte.net.callback;

public enum ActionResult {
    CODE("code"),
    MESSAGE("message"),
    DATA("data");

    private String eMark;

    ActionResult(String mark) {
        this.eMark = mark;
    }

    public String getMark() {
        return eMark;
    }
}
