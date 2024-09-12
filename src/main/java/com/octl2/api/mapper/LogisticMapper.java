package com.octl2.api.mapper;

import com.octl2.api.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class LogisticMapper {
    public  <T extends BaseLogisticDTO> void transfer(ResultQuery resultQuery, T data) {
        if (data.getFfmPartnerList() == null) {
            data.setFfmPartnerList(new HashSet<>());
        }
        if (data.getLmPartnerList() == null) {
            data.setLmPartnerList(new HashSet<>());
        }
        if (data.getWhList() == null) {
            data.setWhList(new HashSet<>());
        }

        transferFfm(resultQuery, data.getFfmPartnerList());
        transferLm(resultQuery, data.getLmPartnerList());
        transferWh(resultQuery, data.getWhList());
    }

    public void transferFfm(ResultQuery resultQuery, Set<FfmDTO> ffmDTOSet) {
        FfmDTO ffmDTO = new FfmDTO(resultQuery.getFfmId(), resultQuery.getFfmName(), resultQuery.getFfmShortName());
        if(ffmDTO.getFfmId() != null || ffmDTO.getFfmName() != null || ffmDTO.getFfmShortName() != null) {
            ffmDTOSet.add(ffmDTO);
        }
    }
    public void transferLm(ResultQuery resultQuery, Set<LmDTO> lmDTOSet) {
        LmDTO lmDTO = new LmDTO(resultQuery.getLmId(), resultQuery.getLmName(), resultQuery.getLmShortName());
        if(lmDTO.getLmId() != null || lmDTO.getLmName() != null || lmDTO.getLmShortName() != null) {
            lmDTOSet.add(lmDTO);
        }

    }
    public void transferWh(ResultQuery resultQuery, Set<WarehouseDTO> warehouseDTOSet) {
        WarehouseDTO warehouseDTO = new WarehouseDTO(resultQuery.getWhId(), resultQuery.getWhName(), resultQuery.getWhShortName());
        if(warehouseDTO.getWhId() != null || warehouseDTO.getWhName() != null || warehouseDTO.getWhShortName() != null) {
            warehouseDTOSet.add(warehouseDTO);
        }

    }
}
