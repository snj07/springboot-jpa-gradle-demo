# springboot-jpa-gradle-demo

It is a demo project to configure Swagger with OAuth2 authorization using Spring Boot 2, JPA, MySQL database and Gradle

### Configuration
Add **public.key** in resource folder of this project. You can check [this](https://github.com/snj07/spring-oauth-jpa-demo) to generate public key for OAuth

    
### Import project in IntelliJ IDEA

Import the project in IntelliJ IDEA by using following steps
1.  Start IntelliJ IDEA 
2.  Click on Open(if no project is opened) or go to file -> open
3.  Select build.gradle file in the cloned repository and click on Open as Project
4.  You need to start OAuth server and update following OAuth URL in application.properties of this project based on your OAuth configuration
```
config.oauth2.accessTokenUri=http://localhost:8090/oauth/token
config.oauth2.userAuthorizationUri=http://localhost:8090/oauth/authorize
config.oauth2.resourceURI= http://localhost:8090/oauth/authorize
```
5.  After build completion, Run **Main.java**

    
### Test Project
1. Open swagger URL **http://localhost:8888/swagger-ui.html** <br/><br/>
![picture alt](https://github.com/snj07/springboot-jpa-gradle-demo/blob/master/images/swagger1.png "Swagger URL")

2. Enter required login details: client id, client secrent, username and password. Enter username = **admin** and password = **password** if you configured OAuth using [this](https://github.com/snj07/spring-oauth-jpa-demo) project.<br/><br/>
![picture alt](https://github.com/snj07/springboot-jpa-gradle-demo/blob/master/images/swagger2.png "Swagger")

3. Now click on Authorize and you will get access to hit URLs <br/><br/>
![picture alt](https://github.com/snj07/springboot-jpa-gradle-demo/blob/master/images/swagger3.png "Swagger")

4. Select Add Employee data URL <br/><br/>
![picture alt](https://github.com/snj07/springboot-jpa-gradle-demo/blob/master/images/swagger4.png "Swagger")

5. Click on try out, add employee details and click on execute to add employee data in database<br/><br/>
![picture alt](https://github.com/snj07/springboot-jpa-gradle-demo/blob/master/images/swagger5.png "Swagger")

## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
