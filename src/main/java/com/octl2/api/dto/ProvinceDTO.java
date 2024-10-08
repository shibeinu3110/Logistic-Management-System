package com.octl2.api.dto;

import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.commons.exception.OctException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProvinceDTO extends BaseLogisticDTO {
    private Integer provinceId;
    private String provinceName;
    private String provinceCode;
    public ProvinceDTO(ResultQuery resultQuery) {
        if(resultQuery != null) {
            this.provinceId = resultQuery.getProvinceId();
            this.provinceCode = resultQuery.getProvinceCode();
            this.provinceName = resultQuery.getProvinceName();

            this.setFfmPartnerList(new HashSet<>());
            this.setLmPartnerList(new HashSet<>());
            this.setWhList(new HashSet<>());
        } else {
            throw new OctException(ErrorMessages.NULL_EXCEPTION);
        }
    }
}
