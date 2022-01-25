package com.example.project_agriculture.request.cooperative;

import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllCooperativeRequest extends AbstractRequest {
}
