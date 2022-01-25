package com.example.project_agriculture.request.activity;

import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWorkingDayRequest extends AbstractRequest {

    @JsonProperty("activityid")
    private String activityId;

    @JsonProperty("working_day")
    private Date working_day;

    public boolean validateRequest() {
        return this.activityId != null && this.working_day != null;
    }
}
