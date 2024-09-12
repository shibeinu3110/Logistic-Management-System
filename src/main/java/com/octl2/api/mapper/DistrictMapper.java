package com.octl2.api.mapper;

import com.octl2.api.dto.DistrictDTO;
import com.octl2.api.dto.ResultQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DistrictMapper {
    private final LogisticMapper logisticMapper;

    public List<DistrictDTO> mapResultQueryToDistrict(List<ResultQuery> resultQueries) {
        Map<Integer, DistrictDTO> districtDTOMap = new LinkedHashMap<>();

        for(ResultQuery resultQuery : resultQueries) {
            DistrictDTO districtDTO = districtDTOMap.get(resultQuery.getDistrictId());

            if(districtDTO == null) {
                districtDTO = new DistrictDTO(resultQuery.getDistrictId(), resultQuery.getDistrictName(), resultQuery.getDistrictCode());
                districtDTOMap.put(districtDTO.getDistrictId(), districtDTO);
            }
            logisticMapper.transfer(resultQuery,districtDTO);
        }
        return new ArrayList<>(districtDTOMap.values());
    }
}
