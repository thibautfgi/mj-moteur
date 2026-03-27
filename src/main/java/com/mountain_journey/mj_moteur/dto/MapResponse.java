package com.mountain_journey.mj_moteur.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class MapResponse {
    private final Integer mapId;
    private final String mapName;
    private final String mapDescription;
    private final Integer mapRating;
    private final Integer mapTotalDistance;
    private final OffsetDateTime mapDateCreation;
}

