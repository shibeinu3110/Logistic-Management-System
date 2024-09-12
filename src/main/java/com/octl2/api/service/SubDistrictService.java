package com.octl2.api.service;

import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.dto.SubDistrictDTO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface SubDistrictService {
    List<SubDistrictDTO> getSubDistrictLogistic(Long districtId);
    void updateSubDistrictLogistic(Long locationId, DeliveryDTO deliveryDTO);
}
