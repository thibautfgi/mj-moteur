package com.mountain_journey.mj_moteur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "gpx")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Gpx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Gpx_Id")
    private Integer gpxId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Map_Id", nullable = false)
    @NotNull
    private Map map;

    @Column(name = "Gpx_Name", nullable = false)
    @NotBlank
    private String gpxName;

    @Lob
    @Column(name = "Gpx_Content", nullable = false, columnDefinition = "text")
    @NotBlank
    private String gpxContent;

}