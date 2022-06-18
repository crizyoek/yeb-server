package com.example.server.demo;

public enum JobLevelEnum {
    SENIOR("senior","正高级"),
    SUB_SENIOR("sub_senior","副高级"),
    INTERMEDIATE("intermediate","中级"),
    PRIMARY("primary","初级")
    ;
    private String code;
    private String msg;

    JobLevelEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
