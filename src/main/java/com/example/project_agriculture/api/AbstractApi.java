package com.example.project_agriculture.api;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.AbstractRequest;
import com.example.project_agriculture.response.AbstractResponse;
import com.example.project_agriculture.response.ResponseData;

import java.text.ParseException;

public abstract class AbstractApi<T extends AbstractRequest, R extends AbstractResponse> {

    protected ResponseData handle(T request) {
        try {
            validateRequest(request);
            R response = execute(request);
            return new ResponseData(response);
        } catch (ApplicationException ex) {
            return new ResponseData(ex.getCode());
        } catch (Exception ex) {
            return new ResponseData(ErrorCode.UNKNOWN_ERROR.getValue());
        }
    }

    protected abstract void validateRequest(T request);

    protected abstract R execute(T request) throws ParseException;
}
