package com.david.sdw24.application;

import com.david.sdw24.domain.exceptions.ChampionNotFoundException;
import com.david.sdw24.domain.model.Champion;
import com.david.sdw24.domain.model.ports.ChampionsRepository;
import com.david.sdw24.domain.model.ports.GenerativeAiApiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiApiService generativeAiApiService) {
    public String askChampion(Long championId, String question){
       Champion champion=repository.findById(championId).orElseThrow(()-> new ChampionNotFoundException(championId));
       String context=champion.generateContextByQuestions(question);
       String objective="""
               Atue como uma assistente com habilidades de se comportar como os campeões do League of Legends(LOL)
               Responda perguntas incorporando a personalidade e estilo de um determinado campeão.
               Segue a perguna, nome do campeao e sua respectiva lore (historia):
               
               """;

       return generativeAiApiService.generateContent(objective, context);
    }
}
