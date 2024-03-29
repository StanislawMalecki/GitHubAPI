package com.app.GitHubAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class GitHubController
{
    private final GitHubApiClient gitHubApiClient;

    public GitHubController(GitHubApiClient gitHubApiClient)
    {
        this.gitHubApiClient = gitHubApiClient;
    }

    @GetMapping("/api/github/repositories/branches")
    public String getBranches(@RequestParam(value = "username") String username, @RequestHeader HttpHeaders header) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String branches = "["+String.join(",",gitHubApiClient.getBranches(username))+"]";

        Object json = objectMapper.readValue(branches, Object.class);
        String formattedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

        if(header == null || !Objects.equals(header.getFirst(HttpHeaders.ACCEPT), "application/json"))
        {
            return "<pre>" + formattedJson + "<pre>";
        }
        else
        {
            return formattedJson;
        }
    }


    @GetMapping("/api/github/repositories")
    public List<GitHubRepository> getUserRepositories(@RequestParam(value = "username") String username)
    {
        return gitHubApiClient.getUserRepositoriesWithoutForks(username);
    }

    @GetMapping("/api/github/repositories/raw")
    public String getUserRepositoriesRaw(@RequestParam(value = "username") String username)
    {
        return gitHubApiClient.getUserRepositoriesRaw(username);
    }
}

