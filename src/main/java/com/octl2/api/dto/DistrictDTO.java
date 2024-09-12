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
public class DistrictDTO extends BaseLogisticDTO{
    private Integer districtId;
    private String districtName;
    private String districtCode;

    public DistrictDTO(ResultQuery resultQuery) {
        if(resultQuery != null) {
            this.districtId = resultQuery.getDistrictId();
            this.districtName = resultQuery.getDistrictName();
            this.districtCode = resultQuery.getDistrictCode();

            this.setFfmPartnerList(new HashSet<>());
            this.setLmPartnerList(new HashSet<>());
            this.setWhList(new HashSet<>());
        } else {
            throw new OctException(ErrorMessages.NULL_EXCEPTION);
        }
    }
}
