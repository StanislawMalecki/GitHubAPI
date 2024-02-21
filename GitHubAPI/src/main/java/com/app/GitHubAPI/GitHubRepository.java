package com.app.GitHubAPI;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GitHubRepository {
    private String artifactName;
    private String ownerLogin;
    private List<GitHubBranch> branches;
}