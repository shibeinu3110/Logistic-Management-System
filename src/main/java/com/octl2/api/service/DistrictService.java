package com.octl2.api.service;

import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.DistrictDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DistrictService {
    List<DistrictDTO>  getDistrictLogistic(Long provinceId);
    void updateDistrictLogistic(Long locationId, DeliveryDTO deliveryDTO);
}
