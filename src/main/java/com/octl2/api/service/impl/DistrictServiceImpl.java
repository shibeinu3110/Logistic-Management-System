package com.octl2.api.service.impl;

import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.commons.exception.OctException;
import com.octl2.api.consts.Const;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.entity.District;
import com.octl2.api.mapper.DistrictMapper;
import com.octl2.api.repository.DistrictRepository;
import com.octl2.api.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    @Value("${levelMapping}")
    private int levelMapping;
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public List<ResultQuery> getLevelMapping(Long provinceId) {
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                return districtRepository.getDistrictLogisticDataLevelOne(provinceId);
            case Const.LEVEL_TWO:
                return districtRepository.getDistrictLogisticDataLevelTwo(provinceId);
            case Const.LEVEL_THREE:
                return districtRepository.getDistrictLogisticDataLevelThree(provinceId);
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }
    @Override
    public List<DistrictDTO> getDistrictLogistic(Long provinceId) {
        List<ResultQuery> resultQueries = getLevelMapping(provinceId);
        return districtMapper.mapResultQueryToDistrict(resultQueries);
    }

    @Override
    public void updateDistrictLogistic(Long locationId, DeliveryDTO deliveryDTO) {
        if(districtRepository.checkValidDistrict(locationId) == 0) {
            throw new OctException(ErrorMessages.DISTRICT_NOT_FOUND);
        }
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                throw new OctException(ErrorMessages.LOCATION_SMALLER_THAN_LEVEL_MAPPING);
            case Const.LEVEL_TWO:
                districtRepository.updateLevelTwo(locationId, deliveryDTO);
                break;
            case Const.LEVEL_THREE:
                districtRepository.updateLevelThree(locationId, deliveryDTO);
                break;
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }
}
