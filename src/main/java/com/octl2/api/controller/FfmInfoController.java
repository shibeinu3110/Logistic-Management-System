package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.dto.FfmInfoDTO;
import com.octl2.api.service.FfmInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mapping_ffm")
@RequiredArgsConstructor
@Validated
@Slf4j
public class FfmInfoController {
    private final FfmInfoService ffmInfoService;
    @GetMapping("")
    public OctResponse<List<FfmInfoDTO>> getFfmInfo() {
        log.info("get fulfillment logistic info base on level mapping");
        List<FfmInfoDTO> list = ffmInfoService.getFfmInfo();
        return OctResponse.build(list, "Get fulfillment logistic information ");
    }
}
