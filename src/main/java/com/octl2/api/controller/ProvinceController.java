package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1/provinces")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping("/{id}")
    public OctResponse<ProvinceDTO> getById(@PathVariable @Min(1) long id) {
        ProvinceDTO result = provinceService.getBybId(id);
        return OctResponse.build(result);
    }
}
