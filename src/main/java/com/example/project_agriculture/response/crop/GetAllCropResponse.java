package com.example.project_agriculture.response.crop;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.entity.Crop;
import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCropResponse extends AbstractResponse {
    @JsonProperty("crops")
    private List<Crop> crops;
}
