package com.example.project_agriculture.response.cooperative;

import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCooperativeResponse extends AbstractResponse {

    @JsonProperty("cooperativeid")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_time")
    private Timestamp created_time;

    @JsonProperty("address")
    private String address;
}
