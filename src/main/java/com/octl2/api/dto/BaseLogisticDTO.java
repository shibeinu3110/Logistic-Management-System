package com.octl2.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseLogisticDTO {
    private Set<FfmDTO> ffmPartnerList;
    private Set<LmDTO> lmPartnerList;
    private Set<WarehouseDTO> whList;
}
