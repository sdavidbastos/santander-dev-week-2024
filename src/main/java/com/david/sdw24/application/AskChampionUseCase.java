package com.david.sdw24.application;

import com.david.sdw24.domain.exceptions.ChampionNotFoundException;
import com.david.sdw24.domain.model.Champion;
import com.david.sdw24.domain.model.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId, String question){
       Champion champion=repository.findById(championId).orElseThrow(()-> new ChampionNotFoundException(championId));
        //TODO: Evoluir lógica de negocio para considerar a integração com IAs generativas.

        return champion.generateContextByQuestions(question);
    }
}
