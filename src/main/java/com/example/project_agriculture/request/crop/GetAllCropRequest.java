package com.example.project_agriculture.request.crop;

import com.example.project_agriculture.request.AbstractRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllCropRequest extends AbstractRequest {
}
