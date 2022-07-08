package com.herdtrack.herdtrackbackend.service;

import com.herdtrack.herdtrackbackend.repository.VaccinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinService {

    @Autowired
    private VaccinRepo vaccinRepo;

}
