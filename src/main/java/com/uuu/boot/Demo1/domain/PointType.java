package com.uuu.boot.Demo1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointType {
    private UUID typeId;
    private String type;
    private String description;
    public PointType(String type, String description){
        this.type = type;
        this.description = description;
    }
}
