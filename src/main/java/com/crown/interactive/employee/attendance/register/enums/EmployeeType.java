package com.crown.interactive.employee.attendance.register.enums;

public enum EmployeeType {
    MEDICAL("medical"),
    NON_MEDICAL("non_medical");

    private final String code;
    EmployeeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
