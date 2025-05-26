package com.toofarnottotake.taxibroker.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "parties")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "price")
    private Double price;

    @Column(name = "time")
    private String time;

    @Column(name = "captain_id")
    private Long captainId;

    @Column(name = "lieutenant_id")
    private Long lieutenantId;

    @Column(name = "sergeant_id")
    private Long sergeantId;

    @Column(name = "airman_id")
    private Long airmanId;
}
