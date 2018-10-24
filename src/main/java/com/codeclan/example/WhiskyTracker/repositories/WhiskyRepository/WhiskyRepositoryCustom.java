package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    //TODO: put all the custom querys in here!

    List<Whisky>getAllWhiskyFromParticularYear(int year);

    List<Whisky>getAllWhiskyFromRegion(String region);

    List<Whisky> getAllWhiskyByDistileryByAge(Long distilleryId, int age);
}
