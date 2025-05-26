package com.toofarnottotake.taxibroker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinPartyRequest {
    private Long userId;
    private Long departureId;
    private Long destinationId;
    private String time;
}
