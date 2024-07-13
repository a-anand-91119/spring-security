### OAuth Setup

#### Github

- Go to your settings in GitHub
- Open developer settings
- Choose OAuth Apps
- Create a new app and set the client id and secret to the following environment variables

```
OAUTH_GITHUB_CLIENT_ID=<github_client_id>
OAUTH_GITHUB_CLIENT_SECRET=<github_client_secret>
```

#### Google

- Navigate to [cloud.google.com](https://cloud.google.com)
- Choose APIs & Services
- Set up your OAuth consent screen properly
- Navigate to Credentials
- Create a new `OAuth client ID` credentials
- Set the client id and secret to the following environment variables

```
OAUTH_GOOGLE_CLIENT_ID=<google_client_id>
OAUTH_GOOGLE_CLIENT_SECRET=<google_client_secret>
```
