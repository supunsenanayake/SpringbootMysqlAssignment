
# Take-home assignment

"InterfaceWithDataTeam" and "InterfaceWitheCommerceService" are simple Spring boot two services.each have embedded Tomcat servers. Since the External Interface (with eCommerce) is read-heavy according to the assignment, I decided to write a separate service for the External Interface (with eCommerce). This service's name is InterfaceWithECommerceService. In both services, I have added a DB connection pool to support throughput and, especially, added a caching layer for InterfaceWithECommerceService for high performance. If needed, we can add a read replica for the database.
Initaly need to Create the database using the shared DB script, which also contains test data.
## Services
### InterfaceWitheCommerceService
This is a simple Spring Boot service. "EcommerceServiceApplication.java" is the main class, and you can run it as a normal Spring Boot application.

#### How to run on CMD line Interface
1. Configure DB username and password in application.properties (Location: InterfaceWitheCommerceService\src\main\resources)

2. Go to project folder InterfaceWitheCommerceService
Open the CMD interface in the project folder and run "mvn clean install" 

3. After building successfully, run the command.  “mvn spring-boot:run”
#### Dependencies 

 1. Java 17
 2. Maven 3.9.6
 3. MySql Database

#### Test API request endpoint
Get Products by shopper (with filters)
* Shopper ID - String, required
* Category - String, optional
* Brand - String, optional
* Limit - Integer, optional, default = 10, max = 100
```
curl --location 'localhost:8082/external/products?shopperId=S-1000&category=Babies&brand=Babyom&limit=2'
```
### InterfaceWitheDataTeam
This is a simple spring boot service "DataTeamApplication.java" is the main class you can run it as a normal Spring boot Application.
How to run on cmd line interface

#### How to run on CMD line Interface
1. Configure DB username and password in application.properties (Location: InterfaceWitheDataTeam\src\main\resources)

2. Go to project folder InterfaceWitheDataTeam Open the CMD interface in the project folder and run "mvn clean install" 

3. After building successfully, run the command.  “mvn spring-boot:run”

#### Dependencies 

 1. Java 17
 2. Maven 3.9.6
 3. MySql Database

#### Test API request endpoint
##### For create productMetadata
```
curl --location 'localhost:8083/api/productMetadata' \
--header 'Content-Type: application/json' \
--data '
{
    "productId":"BB-21447468523",
    "category":"Babiesd",
    "brand":"Babyom"
}
'
```
##### For Create a shopperProductLists

```
curl --location 'localhost:8083/api/shopperProductLists' \
--header 'Content-Type: application/json' \
--data '{
    "shopperId": "S-1000",
    "shelf": [
        {
            "productId": "BB-21447468518",
            "relevancyScore": 31.089209569320897
        },
        {
            "productId": "BB-21447468519",
            "relevancyScore": 55.16626010671777
        },
        {
            "productId": "BB-21447468520",
            "relevancyScore": 73.01492966268303
        }
    ]
}'
```
