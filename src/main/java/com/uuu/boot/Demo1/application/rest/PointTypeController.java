package com.uuu.boot.Demo1.application.rest;

import com.uuu.boot.Demo1.application.rest.request.CreatePointTypeRequest;
import com.uuu.boot.Demo1.application.rest.response.CreatePointTypeResponse;
import com.uuu.boot.Demo1.application.rest.response.ListPointTypeResponse;
import com.uuu.boot.Demo1.domain.PointType;
import com.uuu.boot.Demo1.domain.common.service.PointTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/points")
public class PointTypeController {
    @Autowired
    private PointTypeService pointTypeService;

    @PostMapping
    CreatePointTypeResponse createPointType(@RequestBody CreatePointTypeRequest createPointTypeRequest) {
        PointType type = new PointType(createPointTypeRequest.getType(),
                createPointTypeRequest.getDescription());
        UUID id = pointTypeService.createPointType(type);
        return new CreatePointTypeResponse(id);
    }
    @GetMapping("/list")
    ListPointTypeResponse listPointType() {
        ListPointTypeResponse response = new ListPointTypeResponse();
        response.setPointTypes(pointTypeService.allTypes());
        return response;
    }
}
