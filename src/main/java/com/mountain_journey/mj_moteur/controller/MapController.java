package com.mountain_journey.mj_moteur.controller;

import com.mountain_journey.mj_moteur.dto.MapCreateRequest;
import com.mountain_journey.mj_moteur.dto.MapResponse;
import com.mountain_journey.mj_moteur.service.MapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maps")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @PostMapping
    public ResponseEntity<MapResponse> createMap(@Valid @RequestBody MapCreateRequest request,
                                                 Authentication authentication) {
        if (authentication == null || authentication.getPrincipal() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String email = authentication.getPrincipal().toString();
        MapResponse response = mapService.createMap(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

