package com.example.project_agriculture.dto.pesticide;


import com.example.project_agriculture.dto.AbstractDTO;
import com.example.project_agriculture.entity.Activity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesticideDTO extends AbstractDTO {

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

    @JsonProperty("activityid")
    private String activityId;
}
