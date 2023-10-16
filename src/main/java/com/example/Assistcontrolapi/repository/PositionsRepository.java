package com.example.Assistcontrolapi.repository;

import com.example.Assistcontrolapi.model.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Long> {
}