package com.uuu.boot.Demo1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointType {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID typeId;
    private String type;
    private String description;
    public PointType(String type, String description){
        this.type = type;
        this.description = description;
    }
}
