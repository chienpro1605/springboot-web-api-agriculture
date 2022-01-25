package com.example.project_agriculture.response.cooperative;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCooperativeIdResponse extends AbstractResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_time")
    private Timestamp created_time;

    @JsonProperty("address")
    private String address;
}
