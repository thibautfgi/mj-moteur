package com.mountain_journey.mj_moteur.entity;

import com.mountain_journey.mj_moteur.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "map")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Map_Id")
    private Integer mapId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Image_Id")
    private Image image;

    @Column(name = "Map_Name", nullable = false)
    @NotBlank
    private String mapName;

    @Column(name = "Map_Description")
    private String mapDescription;

    @Column(name = "Map_Rating")
    private Integer mapRating;

    @Column(name = "Map_TotalDistance")
    private Integer mapTotalDistance;

    @Column(name = "Map_DateCreation", nullable = false, columnDefinition = "timestamp")
    @NotNull
    private OffsetDateTime mapDateCreation;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Gpx> gpxFiles = new HashSet<>();

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Mark> marks = new HashSet<>();

}