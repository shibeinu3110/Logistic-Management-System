package com.octl2.api.service.impl;

import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.commons.exception.OctException;
import com.octl2.api.consts.Const;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.mapper.ProvinceMapper;
import com.octl2.api.repository.ProvinceRepository;
import com.octl2.api.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    @Value("${levelMapping}")
    private int levelMapping;

    private final ProvinceRepository provinceRepo;
    private final ProvinceMapper provinceMapper;
    public List<ResultQuery> getLevelMapping() {
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                return provinceRepo.getProvinceLogisticDataLevelOne();
            case Const.LEVEL_TWO:
                return provinceRepo.getProvinceLogisticDataLevelTwo();
            case Const.LEVEL_THREE:
                return provinceRepo.getProvinceLogisticDataLevelThree();
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }

    public List<ProvinceDTO> getProvinceLogistic() {
        List<ResultQuery> resultQueries = getLevelMapping();
        return provinceMapper.mapResultQueryToProvince(resultQueries);
    }

    @Override
    public void updateProvinceLogistic(Long locationId, DeliveryDTO deliveryDTO) {
        if(provinceRepo.checkValidProvince(locationId) == 0) {
            throw new OctException(ErrorMessages.PROVINCE_NOT_FOUND);
        }
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                provinceRepo.updateLevelOne(locationId, deliveryDTO);
                break;
            case Const.LEVEL_TWO:
                provinceRepo.updateLevelTwo(locationId, deliveryDTO);
                break;
            case Const.LEVEL_THREE:
                provinceRepo.updateLevelThree(locationId, deliveryDTO);
                break;
            default:
                throw new OctException(ErrorMessages.INVALID_VALUE);
        }
    }
}
