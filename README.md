# cab-trip-data

### Instructions to run

##### Server that provides REST endpoints
in terminal
- checkout project 
>git co https://github.com/perrydevx/cab-trip-data.git 
- cd to project directory, build and run
> cd cab

>./gradlew build

>./gradlew bootRun
##### Simple command line client that will consume the APIs provided by the server 
- End point to query cab trips (cached)

one cab
>curl http://localhost:8080/cab/2013-12-31?id=5D4C105C32FB4E64D50BC8EC88AE4C41

or multiple cabs
>curl http://localhost:8080/cab/2013-12-31?id=5D4C105C32FB4E64D50BC8EC88AE4C41,6CAE8E055C6B5B0017C2669A9E7EF818

- End point to query cab trips (without cache)

one cab
>curl http://localhost:8080/cab/fresh/2013-12-31?id=5D4C105C32FB4E64D50BC8EC88AE4C41

or multiple cabs
>curl http://localhost:8080/cab/fresh/2013-12-31?id=5D4C105C32FB4E64D50BC8EC88AE4C41,6CAE8E055C6B5B0017C2669A9E7EF818

- End point to clear cache
>curl http://localhost:8080/clear-cache

(you can also hit the endpoints in the browser)
