package com.crown.interactive.employee.attendance.register.enums;

public enum AttendanceStatus {
    SIGN_IN("Sign in"),
    SIGN_OUT("Sign out"),
    SICK_LEAVE("Sick leave"),
    ABSENCE("Absence");

    private final String code;

    AttendanceStatus(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }

}
