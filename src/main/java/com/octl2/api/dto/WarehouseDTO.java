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
public class WarehouseDTO {
    private Integer whId;
    private String whName;
    private String whShortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseDTO that = (WarehouseDTO) o;
        return Objects.equals(whId, that.whId) && Objects.equals(whName, that.whName) && Objects.equals(whShortName, that.whShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whId, whName, whShortName);
    }
}
