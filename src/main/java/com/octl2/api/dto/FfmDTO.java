package com.octl2.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FfmDTO {
    private Integer ffmId;
    private String ffmName;
    private String ffmShortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FfmDTO ffmDTO = (FfmDTO) o;
        return Objects.equals(ffmId, ffmDTO.ffmId) && Objects.equals(ffmName, ffmDTO.ffmName) && Objects.equals(ffmShortName, ffmDTO.ffmShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ffmId, ffmName, ffmShortName);
    }
}
