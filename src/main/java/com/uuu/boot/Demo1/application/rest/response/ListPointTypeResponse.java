package com.uuu.boot.Demo1.application.rest.response;

import com.uuu.boot.Demo1.domain.PointType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPointTypeResponse {
    private List<PointType> pointTypes;
}