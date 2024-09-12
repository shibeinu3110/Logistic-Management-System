package com.octl2.api.mapper;

import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.dto.ResultQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class ProvinceMapper {
    private final LogisticMapper logisticMapper;
    public List<ProvinceDTO> mapResultQueryToProvince(List<ResultQuery> resultQueries) {
        Map<Integer, ProvinceDTO> provinceDTOMap = new LinkedHashMap<>();
        for(ResultQuery resultQuery : resultQueries) {
            ProvinceDTO provinceDTO = provinceDTOMap.get(resultQuery.getProvinceId());
            if(provinceDTO == null) {
                provinceDTO = new ProvinceDTO(resultQuery);
                provinceDTOMap.put(provinceDTO.getProvinceId(), provinceDTO);
            }
            logisticMapper.transfer(resultQuery, provinceDTO);
        }
        return new ArrayList<>(provinceDTOMap.values());
    }
}
