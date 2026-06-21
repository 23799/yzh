package com.example.farm.repository;

import com.example.farm.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Integer> { }
