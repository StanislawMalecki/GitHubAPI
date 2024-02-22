package com.app.GitHubAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubBranch {

    @JsonProperty("name")
    private String name;

    @JsonProperty("commit")
    private Commit commit;

    @JsonProperty("protected")
    private boolean isProtected;

    @JsonProperty("protection")
    private Protection protection;

    @JsonProperty("protection_url")
    private String protectionUrl;

    @Data
    public static class Commit {

        @JsonProperty("sha")
        private String sha;

        @JsonProperty("url")
        private String url;
    }

    @Data
    public static class Protection {

        @JsonProperty("required_status_checks")
        private RequiredStatusChecks requiredStatusChecks;

        @Data
        public static class RequiredStatusChecks {

            @JsonProperty("enforcement_level")
            private String enforcementLevel;

            @JsonProperty("contexts")
            private String[] contexts;
        }
    }
}

