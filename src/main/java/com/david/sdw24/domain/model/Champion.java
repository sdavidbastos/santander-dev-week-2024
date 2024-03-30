package com.david.sdw24.domain.model;

public record Champion(
         Long id,
         String name,
         String role,
         String lore,
         String imageUrl
) {
    public String generateContextByQuestions(String question){
        return """
                pergunta: %s
                Nome do Campeão: %s
                Função: %s
                Lore (História): %s
                """.formatted(question, this.name, this.role, this.lore);
    }
}
