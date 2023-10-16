package com.example.Assistcontrolapi.service;

import com.example.Assistcontrolapi.model.Positions;

import java.util.List;

public interface PositionsService {
    List<Positions> getAllPositions();

    Positions createPosition(Positions position);

    void deletePositionById(Long positionId);
}
