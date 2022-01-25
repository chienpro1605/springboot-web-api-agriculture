package com.example.project_agriculture.dto.crop;

import com.example.project_agriculture.dto.AbstractDTO;
import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.TreeType;
import com.example.project_agriculture.entity.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDTO extends AbstractDTO {

    public static final String CROP_ID = "cropid";

    @JsonProperty(CROP_ID)
    private String cropId;

    @JsonProperty("cooperativeid")
    private String cooperativeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("field")
    private String field;

    @JsonProperty("area")
    private Integer area;

    @JsonProperty("tree_typeid")
    private String treeTypeId;

    @JsonProperty("cultivar_name")
    private String cultivarName;

    @JsonProperty("output_quantity")
    private Integer outputQuantity;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("created_time")
    private Timestamp created_time;

    private List<Users> users;
}
