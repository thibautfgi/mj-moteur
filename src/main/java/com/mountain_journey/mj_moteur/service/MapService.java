package com.mountain_journey.mj_moteur.service;

import com.mountain_journey.mj_moteur.dto.MapCreateRequest;
import com.mountain_journey.mj_moteur.dto.MapResponse;
import com.mountain_journey.mj_moteur.entity.Map;
import com.mountain_journey.mj_moteur.repository.MapRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;

    @Transactional
    public MapResponse createMap(Integer userId, MapCreateRequest request) {
        Map map = Map.builder()
                .userId(userId)
                .mapName(request.getMapName())
                .mapDescription(request.getMapDescription())
                .mapRating(request.getMapRating())
                .mapTotalDistance(request.getMapTotalDistance())
                .mapDateCreation(OffsetDateTime.now())
                .build();

        Map saved = mapRepository.save(map);
        return MapResponse.builder()
                .mapId(saved.getMapId())
                .userId(saved.getUserId())
                .mapName(saved.getMapName())
                .mapDescription(saved.getMapDescription())
                .mapRating(saved.getMapRating())
                .mapTotalDistance(saved.getMapTotalDistance())
                .mapDateCreation(saved.getMapDateCreation())
                .build();
    }
}

