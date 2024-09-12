package com.octl2.api.service;

import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ProvinceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProvinceService {
    List<ProvinceDTO> getProvinceLogistic();
    void updateProvinceLogistic(Long locationId, DeliveryDTO deliveryDTO);
}
