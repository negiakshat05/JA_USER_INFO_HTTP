# JA_USER_INFO_HTTP
Author: Akshat Negi
<br>
Task 1 for SITA
<br>
This service checks if a user is valid or not. If the user is valid, it'll call another service and add the user info.
<br>
I'm using WebClient to make the api call from one service to another.
<br>
URL to test the api: http://localhost:8080/appName/userDetail?user=admin
<br>
user is added as a RequestParam here and replace admin with other user types to check the authentication.
<br>
I'm fetching the user types, like admin or staff and baseURL and baseURI of the other service from application.properties file.
