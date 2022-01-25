package com.example.project_agriculture.response;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.constant.ParamKey;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseData<T extends AbstractResponse> {
    @JsonProperty(ParamKey.CODE)
    private int code;
    @JsonProperty(ParamKey.DATA)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseData(T data) {
        this.data = data;
        this.code = ErrorCode.SUCCESS.getValue();
    }

    public ResponseData(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.toString();
    }
}
