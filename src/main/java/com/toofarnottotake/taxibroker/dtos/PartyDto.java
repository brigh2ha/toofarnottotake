package com.toofarnottotake.taxibroker.dtos;

import com.toofarnottotake.taxibroker.entities.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PartyDto {
    private Long id;
    private Long categoryId;
    private Double price;
    private String time;
    private Long captainId;
    private Long lieutenantId;
    private Long sergeantId;
    private Long airmanId;
}
