package com.app.GitHubAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {
    private final GitHubApiClient gitHubApiClient;

    public GitHubController(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    @GetMapping("/api/github/repositories")
    public String getUserRepositories(@RequestParam(value = "username") String username) {
        return gitHubApiClient.getUserRepositories(username);
    }
}

