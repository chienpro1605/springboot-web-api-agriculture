package com.example.project_agriculture.request.crop;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCropRequest extends AbstractRequest {

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

    public boolean validateRequest() {
        return this.cooperativeId != null && this.name != null
                && this.location != null && this.field != null
                && this.area != 0 && this.treeTypeId != null
                && this.treeTypeId != null && this.cultivarName != null
                && this.outputQuantity != null && this.startDate != null
                && this.endDate != null;
    }
}
