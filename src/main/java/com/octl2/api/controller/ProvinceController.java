package com.octl2.api.controller;

import com.octl2.api.commons.OctResponse;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.service.ExcelService;
import com.octl2.api.service.PartnerService;
import com.octl2.api.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/v1/provinces")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ProvinceController {

    private final ProvinceService provinceService;
    private final ExcelService excelService;

    @GetMapping()
    public OctResponse<List<ProvinceDTO>> getProvinceLogisticInfo() {
        log.info("get province logistic info base on level mapping");
        List<ProvinceDTO> list = provinceService.getProvinceLogistic();
        return OctResponse.build(list, "Get logistic information ");
    }
    @GetMapping("/excel")
    public OctResponse<Object> exportProvinceExcel(HttpServletResponse response) throws IOException {
        log.info("get province logistic info base on level mapping");
        Object object = excelService.exportExcelFile(response);
        return OctResponse.build(object, "Get logistic information ");
    }
    @PutMapping("/{locationId}")
    public OctResponse<String> updateProvinceLogistic(@PathVariable("locationId") Long locationId,@Valid @RequestBody DeliveryDTO deliveryDTO) {
        log.info("update province logistic");
        provinceService.updateProvinceLogistic(locationId, deliveryDTO);
        return OctResponse.build("update province logistic successfully");
    }

}
