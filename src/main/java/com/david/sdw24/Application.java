package com.david.sdw24;

import com.david.sdw24.application.AskChampionUseCase;
import com.david.sdw24.application.ListChampionsUseCase;
import com.david.sdw24.domain.model.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}

	@Bean
	public AskChampionUseCase askChampionUseCase(ChampionsRepository repository){
		return new AskChampionUseCase(repository);
	}

}
