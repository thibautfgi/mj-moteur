package com.mountain_journey.mj_moteur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "mark")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Mark_Id")
    private Integer markId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Map_Id", nullable = false)
    @NotNull
    private Map map;

    @Column(name = "Mark_Name", nullable = false)
    @NotBlank
    private String markName;

    @Column(name = "Mark_Lat", nullable = false)
    @NotBlank
    private String markLat;

    @Column(name = "Mark_Lon", nullable = false)
    @NotBlank
    private String markLon;

    @Column(name = "Mark_ele")
    private String markEle;

}