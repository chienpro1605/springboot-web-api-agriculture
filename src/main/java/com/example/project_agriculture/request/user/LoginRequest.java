package com.example.project_agriculture.request.user;

import com.example.project_agriculture.constant.ParamKey;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest extends AbstractRequest {

    @JsonProperty(ParamKey.USERNAMES)
    private String username;

    @JsonProperty(ParamKey.PASSWORD)
    private String password;

}