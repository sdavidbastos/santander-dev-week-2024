package com.david.sdw24.application;

import com.david.sdw24.domain.model.Champions;
import com.david.sdw24.domain.model.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champions> findAll(){
        return repository.findAll();
    }
}
