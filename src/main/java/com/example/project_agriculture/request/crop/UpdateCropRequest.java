package com.example.project_agriculture.request.crop;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.TreeType;
import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCropRequest extends AbstractRequest {

    @JsonProperty("cropid")
    private String id;

    @JsonProperty("cooperative")
    private Cooperative cooperative;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("field")
    private String field;

    @JsonProperty("area")
    private Integer area;

    @JsonProperty("treeType")
    private TreeType treeType;

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

    public boolean validateRequest() {
        return this.cooperative != null && this.name != null
                && this.location != null && this.field != null
                && this.area != 0 && this.treeType != null
                && this.treeType != null && this.cultivarName != null
                && this.outputQuantity != null && this.startDate != null
                && this.endDate != null;
    }
}
