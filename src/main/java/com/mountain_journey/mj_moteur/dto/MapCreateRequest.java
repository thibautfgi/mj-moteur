package com.mountain_journey.mj_moteur.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapCreateRequest {

    @NotBlank
    private String mapName;

    private String mapDescription;

    @PositiveOrZero
    private Integer mapRating;

    @PositiveOrZero
    private Integer mapTotalDistance;
}

