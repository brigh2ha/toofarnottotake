package com.toofarnottotake.taxibroker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PartyDto {
    private Long id;
    private Short departureId;
    private Short destinationId;
    private Double price;
    private String time;
    private Long captainId;
    private Long lieutenantId;
    private Long sergeantId;
    private Long airmanId;
}
