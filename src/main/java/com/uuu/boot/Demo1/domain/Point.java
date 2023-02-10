package com.uuu.boot.Demo1.domain;

public class Point {
    PointType type;
    PointStatus status;
    float value;

    public Point(PointType type, PointStatus status, float value) {
        this.type = type;
        this.status = status;
        this.value = value;
    }
}
