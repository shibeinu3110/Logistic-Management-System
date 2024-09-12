package com.octl2.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LmDTO {
    private Integer lmId;
    private String lmName;
    private String lmShortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LmDTO lmDTO = (LmDTO) o;
        return Objects.equals(lmId, lmDTO.lmId) && Objects.equals(lmName, lmDTO.lmName) && Objects.equals(lmShortName, lmDTO.lmShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lmId, lmName, lmShortName);
    }
}
