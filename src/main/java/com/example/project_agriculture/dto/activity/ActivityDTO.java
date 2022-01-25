package com.example.project_agriculture.dto.activity;

import com.example.project_agriculture.dto.AbstractDTO;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.entity.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO extends AbstractDTO {

    @JsonProperty("activityid")
    private String activityId;

    @JsonProperty("cropid")
    private String cropId;

    @JsonProperty("userid")
    private String userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("activityDate")
    private Date activityDate;

    @JsonProperty("description")
    private String description;

    @JsonProperty("cost")
    private BigInteger cost;

    @JsonProperty("revenue")
    private BigInteger revenue;

    @JsonProperty("created_time")
    private Timestamp created_time;

    @JsonProperty("pesticideid")
    private String pesticideId;

    @JsonProperty("working_day")
    private Date working_day;
}
