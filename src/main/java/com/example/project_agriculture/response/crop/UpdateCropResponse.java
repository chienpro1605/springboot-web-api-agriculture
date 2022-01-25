package com.example.project_agriculture.response.crop;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.TreeType;
import com.example.project_agriculture.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCropResponse extends AbstractResponse {

    private String cropId;
    private Cooperative cooperative;
    private String name;
    private String location;
    private String field;
    private Integer area;
    private TreeType treeType;
    private String cultivarName;
    private Integer outputQuantity;
    private Date startDate;
    private Date endDate;
    private Timestamp created_time;
}
