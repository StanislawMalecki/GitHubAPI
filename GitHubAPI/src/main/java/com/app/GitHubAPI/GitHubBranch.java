package com.app.GitHubAPI;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GitHubBranch
{
    private String name;
    private String header;

    public GitHubBranch(String name, String header)
    {
        this.name = name;
        this.header = header;
    }


}
