package com.david.sdw24.adapters.out;

import com.david.sdw24.domain.model.ports.GenerativeAiApiService;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "OPENAI", matchIfMissing = true)
@FeignClient(name="openAiApiService", url="${openai.base-url}", configuration=OpenAiChatApiService.Config.class)
public interface OpenAiChatApiService extends GenerativeAiApiService {
    @Override
    default String generateContent(String objective, String context) {
        String model="gpt-3.5-turbo";
        List<Message> messages=List.of(
                new Message("system", objective),
                new Message("user", context)
        );

        OpenAiChatCompletionReq req=new OpenAiChatCompletionReq(model, messages);
        OpenAiChatCompletionRes res=chatCompletion(req);
        return res.choices().getFirst().message().content();
    }
    @PostMapping("/v1/chat/completions")
    OpenAiChatCompletionRes chatCompletion(OpenAiChatCompletionReq req);
    record OpenAiChatCompletionReq(String model, List<Message> messages) {}

    record Message(String role, String content) {}

    record OpenAiChatCompletionRes(List<Choice> choices) {}

    record Choice(Message message){}

    class Config{
        @Bean
        public RequestInterceptor apiKeyRequestInterceptor(@Value("${openai.api-key}") String apiKey){
            return requestTemplate -> requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(apiKey));
        }
    }

}