package com.app.GitHubAPI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GitHubApiClient {
    private final String GITHUB_API_URL = "https://api.github.com";

    private final WebClient webClient;

    public GitHubApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(GITHUB_API_URL).build();
    }

    public String getUserRepositories(String username) {
        return webClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
