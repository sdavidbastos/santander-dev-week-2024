package com.david.sdw24.adapters.in;

import com.david.sdw24.application.AskChampionUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name="Campeões", description="Endpoints do domínio de Campeões do LOL")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {

    @CrossOrigin
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampionResponse(@PathVariable Long championId, @RequestBody AskChampionRequest request){
        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }
    public record AskChampionRequest(String question){}
    public record AskChampionResponse(String answer){}
}
