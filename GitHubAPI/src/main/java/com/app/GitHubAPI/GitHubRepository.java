package com.app.GitHubAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepository {
    private Long id;
    private String node_id;

    @Getter
    @JsonProperty("name")
    private String name;
    private String full_name;

    @Getter
    @JsonProperty("owner")
    private Owner owner;
    private Boolean privateRepo;
    private String html_url;
    private String description;

    @Getter
    private Boolean fork;
    private String url;
    private String archive_url;
    private String assignees_url;
    private String blobs_url;
    private String branches_url;
    private String tags_url;
    private String languages_url;
    private String merges_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String releases_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private String mirror_url;
    private String hooks_url;
    private String homepage;
    private String language;
    private Integer forks_count;
    private Integer stargazers_count;
    private Integer watchers_count;
    private Integer size;
    private String default_branch;
    private Integer open_issues_count;
    private Boolean is_template;
    private List<String> topics;
    private Boolean has_issues;
    private Boolean has_projects;
    private Boolean has_wiki;
    private Boolean has_pages;
    private Boolean has_downloads;
    private Boolean has_discussions;
    private Boolean archived;
    private Boolean disabled;
    private String visibility;
    private String pushed_at;
    private String created_at;
    private String updated_at;
    private Permissions permissions;
    private String role_name;
    private String temp_clone_token;
    private Boolean delete_branch_on_merge;
    private Integer subscribers_count;
    private Integer network_count;
    private CodeOfConduct code_of_conduct;
    private License license;
    private Integer forks;
    private Integer open_issues;
    private Integer watchers;
    private Boolean allow_forking;
    private Boolean web_commit_signoff_required;
    private SecurityAndAnalysis security_and_analysis;

    public static class Owner {
        private String name;
        private String email;
        @Getter
        @JsonProperty("login")
        private String login;
        private Integer id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private Boolean site_admin;
        private String starred_at;
    }

//    @Getter
    public static class Permissions {
        private Boolean admin;
        private Boolean maintain;
        private Boolean push;
        private Boolean triage;
        private Boolean pull;
    }

//    @Getter
    public static class CodeOfConduct {
        private String key;
        private String name;
        private String url;
        private String body;
        private String html_url;
    }

//    @Getter
    public static class License {
        private String key;
        private String name;
        private String spdx_id;
        private String url;
        private String node_id;
    }

//    @Getter
    public static class SecurityAndAnalysis {
        private AdvancedSecurity advanced_security;
        private DependabotSecurityUpdates dependabot_security_updates;
        private SecretScanning secret_scanning;
        private SecretScanningPushProtection secret_scanning_push_protection;
    }

//    @Getter
    public static class AdvancedSecurity {
        private String status;
    }

//    @Getter
    public static class DependabotSecurityUpdates {
        private String status;
    }
//    @Getter
    public static class SecretScanning {
        private String status;
    }
//    @Getter
    public static class SecretScanningPushProtection {
        private String status;
    }
}

