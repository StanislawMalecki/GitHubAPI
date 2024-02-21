package com.app.GitHubAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @GetMapping("/repositories")
    public GitHubRepository repositories(@RequestParam(value = "username", defaultValue = "World") String name, @RequestParam(value = "header", defaultValue = "World") String header) {
        GitHubBranch aaa = new GitHubBranch(name, header);

        GitHubRepository bbb = new GitHubRepository();
        bbb.setArtifactName(aaa.getName());
        return bbb;
    }
}
