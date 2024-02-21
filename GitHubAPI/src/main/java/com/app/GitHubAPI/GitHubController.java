package com.app.GitHubAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {
    private final GitHubApiClient gitHubApiClient;

    public GitHubController(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    @GetMapping("/api/github/repositories")
    public List<GitHubRepository> getUserRepositories(@RequestParam(value = "username") String username) {
        return gitHubApiClient.getUserRepositories(username);
    }

    @GetMapping("/api/github/repositories/raw")
    public String getUserRepositoriesRaw(@RequestParam(value = "username") String username) {
        return gitHubApiClient.getUserRepositoriesRaw(username);
    }
}

