# GitHubAPI

This project is a simple application that consumes the GitHub API to retrieve user repositories.

## Getting Started 
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes. 
### Prerequisites 
Make sure you have the following software installed on your machine: 
- Java JDK 21 or later 
- Maven 
### Installing
1. Clone the repository: ```git clone https://github.com/StanislawMalecki/GitHubAPI.git ```
2. Navigate to the project directory: ```cd GitHubAPI ``` 
3. Build the project: ```mvn clean install ``` 
### Running the Application 
Run the application using the following command: ```java -jar target/GitHubAPI.jar```

The application will start on `http://localhost:8080`.

### OAuth
You can use environmental variable to add GITHUB_API_TOKEN to incresse limits of queries.
## API Usage

## 1. Get User Repositories

### Endpoint
- **URL:** `/api/github/repositories`
- **Method:** `GET`
### Description
Retrieve a list of GitHub repositories for a specified user.
### Request Parameters
- `username` (String): GitHub username for which repositories will be fetched.
curl http://localhost:8080/api/github/repositories?username=StanislawMalecki 
### Response
- Returns a list of GitHub repositories excluding forks.

---
## 2. Get User Repositories Raw

### Endpoint
- **URL:** `/api/github/repositories/raw`
- **Method:** `GET`
### Description
Retrieve raw data String of GitHub repositories for a specified user.
### Request Parameters
- `username` (String): GitHub username for which repositories will be fetched.
curl http://localhost:8080/api/github/repositories/raw?username=StanislawMalecki
### Response
- Returns raw String data of GitHub repositories.

---
## 3. Get Branches of a Repository

### Endpoint
- **URL:** `/api/github/repositories/branches`
- **Method:** `GET`
### Description
Retrieve the branches of a GitHub repository for a specified user.
### Request Parameters
- `username` (String): GitHub username for which repository branches will be fetched.
curl http://localhost:8080/api/github/repositories/branches?username=StanislawMalecki
or
curl -H "Accept: application/json" http://localhost:8080/api/github/repositories/branches?username=StanislawMalecki
### Response
- Returns a formatted JSON representation of repository branches.
- If the `Accept` header is not set to `application/json`, the response will be in a preformatted HTML `pre` tag to ensure nice formatting when using browser.
# Built With

- Spring Boot - The web framework used
- Maven - Dependency management

