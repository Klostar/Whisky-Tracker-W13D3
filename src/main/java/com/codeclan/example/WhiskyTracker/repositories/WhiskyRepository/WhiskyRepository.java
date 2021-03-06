package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    List<Whisky> getAllWhiskyFromParticularYear(int year);

    List<Whisky>getAllWhiskyFromRegion(String region);

    List<Whisky> getAllWhiskyByDistileryByAge(Long distilleryId, int age);
}
