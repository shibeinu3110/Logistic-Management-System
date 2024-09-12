package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.service.DistrictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/districts")
@RequiredArgsConstructor
@Validated
@Slf4j
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/{provinceId}")
    public OctResponse<List<DistrictDTO>> getProvinceLogisticInfo(@PathVariable("provinceId") Long provinceId) {
        log.info("get province logistic info base on level mapping");
        List<DistrictDTO> list = districtService.getDistrictLogistic(provinceId);
        return OctResponse.build(list, "Get district logistic information ");
    }
    @PutMapping("/{locationId}")
    public OctResponse<String> updateDistrictLogistic(@PathVariable("locationId") Long locationId,@Valid @RequestBody DeliveryDTO deliveryDTO) {
        log.info("update district logistic");
        districtService.updateDistrictLogistic(locationId, deliveryDTO);
        return OctResponse.build("update district logistic successfully");
    }

}
