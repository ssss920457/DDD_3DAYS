package com.uuu.boot.Demo1.application.rest.response;

import lombok.Getter;

import java.util.UUID;

public class CreatePointTypeResponse {

    @Getter
    private final UUID id;

    public CreatePointTypeResponse(UUID id) {
        this.id = id;
    }
}
