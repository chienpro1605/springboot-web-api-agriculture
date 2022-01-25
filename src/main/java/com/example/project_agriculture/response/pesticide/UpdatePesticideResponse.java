package com.example.project_agriculture.response.pesticide;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePesticideResponse extends AbstractResponse {

    private String pesticideId;
    private String name;
    private String description;
    private String usage_information;
    private Integer quarantee_time;
    private Activity activity;
}
