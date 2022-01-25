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
public class UpdateCooperativeRequest extends AbstractRequest {

    @JsonProperty("cooperativeid")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_time")
    private Timestamp created_time;

    @JsonProperty("address")
    private String address;

    public boolean validateRequest() {
        return this.name != null && this.address != null;
    }
}
