package com.example.project_agriculture.request.cooperative;

import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCooperativeIdRequest extends AbstractRequest {

    @JsonProperty("cooperativeid")
    private String id;
}
