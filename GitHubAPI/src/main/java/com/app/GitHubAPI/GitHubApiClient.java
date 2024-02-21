package com.app.GitHubAPI;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class GitHubApiClient {
    private final WebClient webClient;

    public GitHubApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
    }

    public List<GitHubRepository> getRepositories(String username) {
        return webClient.get()
                .uri("/users/{username}/repos", username)
                .header("Accept", "application/json")
                .retrieve()
                .bodyToFlux(GitHubRepository.class)
                .collectList()
                .block();
    }
}

