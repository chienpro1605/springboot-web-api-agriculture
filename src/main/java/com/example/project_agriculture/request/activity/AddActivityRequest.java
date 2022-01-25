package com.example.project_agriculture.request.activity;

import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddActivityRequest extends AbstractRequest {

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

    public boolean validateRequest() {
        return this.cropId != null && this.userId != null
                && this.name != null && this.location != null
                && this.activityDate != null && this.description != null
                && this.pesticideId != null && this.cost != null
                && this.pesticideId != null && this.working_day != null;
    }
}
