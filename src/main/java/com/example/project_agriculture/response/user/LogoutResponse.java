package com.example.project_agriculture.response.user;

import com.example.project_agriculture.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogoutResponse extends AbstractResponse {
}