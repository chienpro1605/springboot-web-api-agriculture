package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.Activity;
import com.example.project_agriculture.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

    @Query(value = "SELECT * FROM Activity a WHERE a.cropId = ?1", nativeQuery = true)
    Iterable<Activity> viewActivitiesOfCrop(String cropId);
}
