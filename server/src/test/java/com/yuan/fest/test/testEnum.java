package com.yuan.fest.test;

public class testEnum {

    public static void main(String[] args) {
        String name = test.CODE.name();
        System.out.println(name);
        System.out.println(test.CODE.geteResult());
    }

}

enum test{
    CODE("code"),
    MESSAGE("message"),
    DATA("data");


    private String eResult;

    test(String result) {
        this.eResult = result;
    }

    public String geteResult() {
        return eResult;
    }
}