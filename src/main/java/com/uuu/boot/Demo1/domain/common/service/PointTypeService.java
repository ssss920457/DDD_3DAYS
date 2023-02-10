package com.uuu.boot.Demo1.domain.common.service;

import com.uuu.boot.Demo1.domain.PointType;

import java.util.List;
import java.util.UUID;

public interface PointTypeService {
    UUID createPointType(PointType type);
    List<PointType> allTypes();
}
