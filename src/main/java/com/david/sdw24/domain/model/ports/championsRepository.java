package com.david.sdw24.domain.model.ports;

import com.david.sdw24.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface championsRepository {
    public interface ChampionsRepository{
        List<Champions> findAll();
        Optional<Champions> findOne(Long id);
    }
}
