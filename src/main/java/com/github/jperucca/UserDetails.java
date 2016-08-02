package com.github.jperucca;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDetails {

    private String name;

    private List<String> roles;
}
