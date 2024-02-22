package com.app.GitHubAPI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class GitHubApiClient {

    private final WebClient webClient;

    public GitHubApiClient(WebClient.Builder webClientBuilder) {
        String GITHUB_API_URL = "https://api.github.com";
        this.webClient = webClientBuilder.baseUrl(GITHUB_API_URL).build();
    }

    public List<GitHubRepository> getUserRepositories(String username) {
        return webClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GitHubRepository>>() {})
                .block();
    }

    public LinkedList<GitHubRepository> getUserRepositoriesWithoutForks(String username) {
        LinkedList<GitHubRepository> list = new LinkedList<>(getUserRepositories(username));
        list.removeIf(GitHubRepository::getFork);
        return list;
    }

    public ArrayList<String> getBranches(String username) {
        ArrayList<GitHubRepository> list = new ArrayList<>(getUserRepositoriesWithoutForks(username));

        ArrayList<String> listOfBranches = new ArrayList<>();
        list.forEach(gitHubRepository ->
        {
            listOfBranches.add(getBranchesFromRepo(gitHubRepository.getOwner().getLogin(), gitHubRepository.getName()));
        });

        return listOfBranches;
    }

    public String getBranchesFromRepo(String owner, String repo) {
        return webClient.get()
                .uri("/repos/{owner}/{repo}/branches", owner, repo)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getUserRepositoriesRaw(String username)
    {
        return webClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
