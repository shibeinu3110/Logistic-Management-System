package com.octl2.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FfmInfoDTO {
    private Integer ffmID;
    private String ffmName;
    private Set<LmDTO> lmDTOSet;
    private Set<WarehouseDTO> warehouseDTOSet;
    public FfmInfoDTO (ResultQuery resultQuery) {
        this.ffmID = resultQuery.getFfmId();
        this.ffmName = resultQuery.getFfmName();

        this.setLmDTOSet(new HashSet<>());
        this.setWarehouseDTOSet(new HashSet<>());
    }
}
