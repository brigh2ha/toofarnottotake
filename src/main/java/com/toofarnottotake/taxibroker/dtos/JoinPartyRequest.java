package com.toofarnottotake.taxibroker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinPartyRequest {
    private Long userId;
    private Long categoryId;
    private String time;
}
