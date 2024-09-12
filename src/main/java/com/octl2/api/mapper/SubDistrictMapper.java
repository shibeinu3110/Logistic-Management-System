package com.octl2.api.mapper;

import com.octl2.api.dto.ResultQuery;
import com.octl2.api.dto.SubDistrictDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SubDistrictMapper {
    private final LogisticMapper logisticMapper;

    public List<SubDistrictDTO> mapResultQueryToSubDistrict (List<ResultQuery> resultQueries) {
        Map<Integer, SubDistrictDTO> subDistrictDTOMap = new LinkedHashMap<>();

        for(ResultQuery resultQuery : resultQueries) {
            SubDistrictDTO subDistrictDTO = subDistrictDTOMap.get(resultQuery.getSubDistrictId());

            if(subDistrictDTO == null) {
                subDistrictDTO = new SubDistrictDTO(resultQuery.getSubDistrictId(), resultQuery.getSubDistrictCode(), resultQuery.getSubDistrictName());
                subDistrictDTOMap.put(resultQuery.getSubDistrictId(), subDistrictDTO);
            }
            logisticMapper.transfer(resultQuery, subDistrictDTO);
        }
        return new ArrayList<>(subDistrictDTOMap.values());
    }
}
