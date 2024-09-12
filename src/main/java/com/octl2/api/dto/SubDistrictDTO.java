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
public class SubDistrictDTO extends BaseLogisticDTO{
    private Integer subDistrictId;
    private String subDistrictCode;
    private String subDistrictName;

    public SubDistrictDTO(ResultQuery resultQuery) {
        if(resultQuery != null) {
            this.subDistrictId = resultQuery.getSubDistrictId();
            this.subDistrictCode = resultQuery.getSubDistrictCode();
            this.subDistrictName = resultQuery.getSubDistrictName();

            this.setFfmPartnerList(new HashSet<>());
            this.setLmPartnerList(new HashSet<>());
            this.setWhList(new HashSet<>());
        } else {
            throw new OctException(ErrorMessages.NULL_EXCEPTION);
        }
    }
}