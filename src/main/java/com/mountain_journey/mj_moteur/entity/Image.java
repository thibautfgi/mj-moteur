package com.mountain_journey.mj_moteur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "image")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_Id")
    private Integer imageId;

    @Column(name = "Image_Name", nullable = false)
    @NotBlank
    private String imageName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Image_Data", nullable = false)
    @NotNull
    private byte[] imageData;

}