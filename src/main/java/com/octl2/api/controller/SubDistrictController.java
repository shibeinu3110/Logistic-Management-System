package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.SubDistrictDTO;
import com.octl2.api.service.SubDistrictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-districts")
@RequiredArgsConstructor
@Validated
@Slf4j
public class SubDistrictController {
    private final SubDistrictService subDistrictService;

    @GetMapping("/{districtId}")
    public OctResponse<List<SubDistrictDTO>> getSubDistrictLogisticInfo(@PathVariable("districtId") Long districtId) {
        log.info("get sub district logistic info base on level mapping");
        List<SubDistrictDTO> list = subDistrictService.getSubDistrictLogistic(districtId);
        return OctResponse.build(list, "Get district logistic information ");
    }
    @PutMapping("/{locationId}")
    public OctResponse<String> updateSubDistrictLogistic(@PathVariable("locationId") Long locationId, @Valid @RequestBody DeliveryDTO deliveryDTO) {
        log.info("update sub district logistic");
        subDistrictService.updateSubDistrictLogistic(locationId, deliveryDTO);
        return OctResponse.build("update sub district logistic successfully");
    }
}
