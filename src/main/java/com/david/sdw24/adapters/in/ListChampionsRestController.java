package com.david.sdw24.adapters.in;

import com.david.sdw24.application.ListChampionsUseCase;
import com.david.sdw24.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name="Campeões", description="Endpoints do domínio de Campeões do LOL")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {
    @GetMapping
    public List<Champion> findAll(){
        return useCase.findAll();
    }
}
