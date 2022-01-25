package com.example.project_agriculture.response.activity;

import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.entity.Pesticide;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.response.AbstractResponse;
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
public class AddActivityResponse extends AbstractResponse {

    private Crop crop;
    private Users users;
    private String name;
    private String location;
    private Date activityDate;
    private String description;
    private BigInteger cost;
    private BigInteger revenue;
    private Timestamp created_time;
    private Pesticide pesticide;
    private Date working_day;
}
