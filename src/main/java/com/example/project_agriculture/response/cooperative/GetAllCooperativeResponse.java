package com.example.project_agriculture.response.cooperative;

import com.example.project_agriculture.entity.Cooperative;
import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCooperativeResponse extends AbstractResponse {
    @JsonProperty("cooperatives")
    private List<Cooperative> cooperatives;

}
