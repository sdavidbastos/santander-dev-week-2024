package com.david.sdw24.application;

import com.david.sdw24.domain.model.Champion;
import com.david.sdw24.domain.model.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champion> findAll(){
        return repository.findAll();
    }
}
