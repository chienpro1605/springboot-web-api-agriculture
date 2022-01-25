package com.example.project_agriculture.request.pesticide;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePesticideRequest extends AbstractRequest {

    @JsonProperty("pesticideid")
    private String pesticideId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("usage_information")
    private String usage_information;

    @JsonProperty("quarantee_time")
    private Integer quarantee_time;

    @JsonProperty("activity")
    private Activity activity;

    public boolean validateRequest() {
        return  this.name != null
                && this.description != null && this.usage_information != null
                && this.quarantee_time != 0 && this.activity != null;
    }
}
