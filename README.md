# Fuse 7.x CXF Soap Service with Spring Boot example

A simple example of how to implement a JAX-WS (Soap) CXF service with Camel and Spring Boot.

## How to use

### Standalone

1. Clone this repo: `git clone https://github.com/ricardozanini/fuse-soap-spring-boot-example.git`
2. `cd fuse-soap-spring-boot-example`
3. Run the Spring Boot application with `mvn spring-boot:run`

### OpenShift

1. Clone this repo: `git clone https://github.com/ricardozanini/fuse-soap-spring-boot-example.git`
2. `cd fuse-soap-spring-boot-example`
3. Login to your cluster and select a project: `oc login -u <user> -p <password> && oc project <myproject>`
4. run `oc process -f openshift/template.json | oc create -f -`

Your **temperature converter** SOAP service will be ready to use.

### Endpoints

- Catalog of deployed services: [http://localhost:8080/services/](http://localhost:8080/services/)
- WSDL: [http://localhost:8080/services/TemperatureEndpoint?wsdl](http://localhost:8080/services/TemperatureEndpoint?wsdl)
- SOAP Endpoint: [http://localhost:8080/services/TemperatureEndpoint](http://localhost:8080/services/TemperatureEndpoint)

**Note:** If on OpenShift, change `localhost:8080` to your route hostname.