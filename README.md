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

4)	Local => declared inside Pre-request Script i.e. Request -> Scripts -> Pre-request.

5)	Data => external files csv/text.

Referring variable: {{variable}}
