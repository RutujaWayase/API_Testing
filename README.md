# API_Testing
Project: API Testing

# Types of API
There re 2 types of API’s.

1)	Simple Object Access Protocol (SOAP).

2)	REST (Representation State Transfer).

# All WebServices are API. But all API are not Web Service.

API vs WebService
1) Web Service is on API wrapped in HTTP.
2) All Web Services are API but API's are not Web Services.
3) A Web Service needs a network while on API doesn't need a network for its operation.

# Rest API methods: http request

Request message: HTTP request

Get: we get data from the server.

Post: we are sending data to server to store.

Put: we can create/edit/update data in the server.

Delete: we delete the data from server.

API

Response message: Validations performed
Response Status Code
Data

# http vs https
http: Hypertext Transfer Protocol

https: Hypertext Transfer Protocol Secure

# Terminologies
1) URI: Uniform Resource Identifier
2) URL: Uniform Resource Locator
3) URN: Uniform Resource Name

Feature: term used in manual testing to test functionality.

Resource: term used in API Automation testing to test functionality.

Palyload: Body in the HTTP request and response message.
1) Request Payload.
2) Response Payload.

# Postman:
Variables:
Scope:
Workspace -> Collections -> Requests
 Types of variables as per Scope of access of variables:
1)	Global => accessible in workspace.

2)	Collection => accessible within collection.

3)	Environment => accessible in all collections, but we need to switch to environment.

4)	Local => accessible only within request(specific to request). Declared inside Pre-request Script i.e. Request -> Scripts -> Pre-request.

Ex: //Local variables
pm.variables.set("url_local", "https://reqres.in");

5)	Data => external files csv/text.

Referring variable: {{variable}}

Methods:

Set, unset, get => global, env, collection, local.

# RestAssured 

RestAssured: https://rest-assured.io/

Dependencies: https://github.com/rest-assured/rest-assured/wiki/GettingStarted

Add dependencies: Maven, Gradle, XmlPath, etc.

Dependencies to add in pom.xml:
1)	rest-assured

2)	json-path

3)	json

4)	gson

5)	testng

6)	scribejava-apis

7)	json-schema-validator

8)	xml-schema-validator

TestNG Style

• given(): Content type, set cookies, add auth i.e. authentication, add param i.e. parameters, set headers info i.e. information, etc.

• when(): get, post, put, delete requests.

• then(): validate status code, extract response, extract headers cookies & response body


Ways to create request body:
1)	Hashmap -> We can directly pass data. Ex: .body(data)

2)	Using org.json -> We need to convert data to string format. Ex: .body(data.toString())

3)	Using POJO (Plain Old Java Object) -> Ex: .body(data)

4)	Using external json file -> convert data to String format. Ex: .body(data.toString()) here data is received from external JSON file.

toString() is only required for org.json class
