package com.mountain_journey.mj_moteur.service;

import com.mountain_journey.mj_moteur.dto.MapCreateRequest;
import com.mountain_journey.mj_moteur.dto.MapResponse;
import com.mountain_journey.mj_moteur.entity.Map;
import com.mountain_journey.mj_moteur.entity.User;
import com.mountain_journey.mj_moteur.repository.MapRepository;
import com.mountain_journey.mj_moteur.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;
    private final UserRepository userRepository;

    @Transactional
    public MapResponse createMap(String userEmail, MapCreateRequest request) {
        User user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utilisateur inconnu"));

        Map map = Map.builder()
                .user(user)
                .mapName(request.getMapName())
                .mapDescription(request.getMapDescription())
                .mapRating(request.getMapRating())
                .mapTotalDistance(request.getMapTotalDistance())
                .mapDateCreation(OffsetDateTime.now())
                .build();

        Map saved = mapRepository.save(map);
        return MapResponse.builder()
                .mapId(saved.getMapId())
                .mapName(saved.getMapName())
                .mapDescription(saved.getMapDescription())
                .mapRating(saved.getMapRating())
                .mapTotalDistance(saved.getMapTotalDistance())
                .mapDateCreation(saved.getMapDateCreation())
                .build();
    }
}

