package com.example.project_agriculture.response.user;

import com.example.project_agriculture.constant.ParamKey;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse extends AbstractResponse {
    private static final String USERS = "users";

    @JsonProperty(ParamKey.TOKEN)
    private String token;

    @JsonProperty(ParamKey.REFRESH_TOKEN)
    private String refreshToken;

    @JsonProperty(USERS)
    private Users users;
}

