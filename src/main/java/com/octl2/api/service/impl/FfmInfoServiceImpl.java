package com.octl2.api.service.impl;

import com.octl2.api.dto.FfmInfoDTO;
import com.octl2.api.dto.LmDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.dto.WarehouseDTO;
import com.octl2.api.repository.MappingFfmLmRepository;
import com.octl2.api.service.FfmInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FfmInfoServiceImpl implements FfmInfoService {
    private final MappingFfmLmRepository ffmInfoRepository;
    @Override
    public List<FfmInfoDTO> getFfmInfo() {
        List<ResultQuery> ffmInfoQueries = ffmInfoRepository.getFfmInfo();
        Map<Integer, FfmInfoDTO> ffmInfoDTOMap = new LinkedHashMap<>();

        for(ResultQuery resultQuery : ffmInfoQueries) {
            FfmInfoDTO ffmInfoDTO = ffmInfoDTOMap.get(resultQuery.getFfmId());

            if(ffmInfoDTO == null) {
                ffmInfoDTO = new FfmInfoDTO(resultQuery);
                ffmInfoDTOMap.put(ffmInfoDTO.getFfmID(), ffmInfoDTO);
            }
            mapperToFfmInfo(ffmInfoDTO, resultQuery);
        }

        return new ArrayList<>(ffmInfoDTOMap.values());
    }


    public void mapperToFfmInfo(FfmInfoDTO ffmInfoDTO, ResultQuery resultQuery) {
        mapperLm(ffmInfoDTO.getLmDTOSet(), resultQuery);
        mapperWarehouse(ffmInfoDTO.getWarehouseDTOSet(), resultQuery);
    }

    public void mapperLm(Set<LmDTO> lmDTOSet, ResultQuery resultQuery) {
        LmDTO lmDTO = new LmDTO(resultQuery.getLmId(), resultQuery.getLmName(), resultQuery.getLmShortName());
        if(lmDTO.getLmId() != null || lmDTO.getLmName() != null || lmDTO.getLmShortName() != null) {
            lmDTOSet.add(lmDTO);
        }
    }
    public void mapperWarehouse(Set<WarehouseDTO> warehouseDTOSet, ResultQuery resultQuery) {
        WarehouseDTO warehouseDTO = new WarehouseDTO(resultQuery.getWhId(), resultQuery.getWhName(), resultQuery.getWhShortName());
        if(warehouseDTO.getWhId() != null || warehouseDTO.getWhName() != null || warehouseDTO.getWhShortName() != null) {
            warehouseDTOSet.add(warehouseDTO);
        }
    }
}
