package com.octl2.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {
    @NotNull(message = "Fulfillment ID can't be null")
    private Integer fulfillmentId;
    @NotNull(message = "Last mile ID can't be null")
    private Integer lastMileId;
    @NotNull(message = "Warehouse ID can't be null")
    private Integer warehouseId;
}
