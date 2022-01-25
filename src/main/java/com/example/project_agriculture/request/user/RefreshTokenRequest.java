package com.example.project_agriculture.request.user;

import com.example.project_agriculture.constant.ParamKey;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RefreshTokenRequest extends AbstractRequest {
    @JsonProperty(ParamKey.REFRESH_TOKEN)
    private String refreshToken;

    public boolean validateRequest() {
        return this.refreshToken!=null;
    }
}
