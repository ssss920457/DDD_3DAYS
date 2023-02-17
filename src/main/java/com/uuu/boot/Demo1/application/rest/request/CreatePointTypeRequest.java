package com.uuu.boot.Demo1.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePointTypeRequest {
    private String type;
    private String description;
}
