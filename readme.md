## CONFIG SERVER

Config server helps to provide configuration to all the service.

To use this config server,
1. Create a repository in your local/github
2. Add/commit application.properties file with some properties in the repository
3. Add a repository url in application.properties file
example: spring.cloud.config.server.git.uri=repository url
4. Run the configuration server
5. in Config client, add config server endpoint like below in application.properties file
example: spring.config.import=configserver:http://localhost:8888

# note: config server runs on 8888 port (global rule)