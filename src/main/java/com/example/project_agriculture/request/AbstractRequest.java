package com.example.project_agriculture.request;

import com.example.project_agriculture.constant.ParamKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractRequest {

    // Only use for api logout. If use for other api need pass additional key token side client
    @JsonProperty(ParamKey.TOKEN)
    private String token;

}
