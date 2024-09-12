package com.octl2.api.service.impl;
import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.commons.exception.OctException;
import com.octl2.api.consts.Const;

import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.dto.SubDistrictDTO;
import com.octl2.api.mapper.SubDistrictMapper;
import com.octl2.api.repository.SubDistrictRepository;
import com.octl2.api.service.SubDistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubDistrictServiceImpl implements SubDistrictService {
    @Value("${levelMapping}")
    private int levelMapping;
    private final SubDistrictRepository subDistrictRepository;
    private final SubDistrictMapper subDistrictMapper;

    public List<ResultQuery> getLevelMapping(Long districtId) {
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                return subDistrictRepository.getSubDistrictLogisticDataLevelOne(districtId);
            case Const.LEVEL_TWO:
                return subDistrictRepository.getSubDistrictLogisticDataLevelTwo(districtId);
            case Const.LEVEL_THREE:
                return subDistrictRepository.getSubDistrictLogisticDataLevelThree(districtId);
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }

    @Override
    public List<SubDistrictDTO> getSubDistrictLogistic(Long districtId) {
        List<ResultQuery> resultQueries = getLevelMapping(districtId);
        return subDistrictMapper.mapResultQueryToSubDistrict(resultQueries);
    }

    @Override
    public void updateSubDistrictLogistic(Long locationId, DeliveryDTO deliveryDTO) {
        if(subDistrictRepository.checkValidSubDistrict(locationId) == 0) {
            throw new OctException(ErrorMessages.PROVINCE_NOT_FOUND);
        }
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                throw new OctException(ErrorMessages.LOCATION_SMALLER_THAN_LEVEL_MAPPING);
            case Const.LEVEL_TWO:
                throw new OctException(ErrorMessages.LOCATION_SMALLER_THAN_LEVEL_MAPPING);
            case Const.LEVEL_THREE:
                subDistrictRepository.updateLevelThree(locationId, deliveryDTO);
                break;
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }
}
