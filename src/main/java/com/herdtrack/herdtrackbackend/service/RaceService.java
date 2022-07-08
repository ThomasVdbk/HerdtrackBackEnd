package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.repository.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    @Autowired
    private RaceRepo raceRepo;
}
