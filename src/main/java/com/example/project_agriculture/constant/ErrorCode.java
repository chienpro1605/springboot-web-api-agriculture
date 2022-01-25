package com.example.project_agriculture.constant;

public enum ErrorCode {
    SUCCESS(0),
    UNKNOWN_ERROR(1),
    INVALID_EMAIL(2),
    INVALID_PASSWORD(3),
    PRODUCT_EXISTS(4),
    CATEGORY_EXISTS(5),
    OVER_PRODUCT(6),
    NOT_ENOUGH_MONEY(7),
    ACCOUNT_DISABLED(8),
    EXPIRE_TOKEN(9),
    ACCOUNT_NOT_EXISTS(10),
    REFRESH_TOKEN_EXPIRED(11),
    WRONG_FORMAT_INPUT(12),
    INVALID_TOKEN(13),
    ID_NOT_EXISTS(14),
    FILE_ERROR(15),
    CONVERT_MAP(16),
    ERROR_REDIS(17),
    ;

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}
