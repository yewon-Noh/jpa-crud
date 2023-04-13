# Spring-Data-JPA로 구현하는 간단한 CRUD

## Dependency 설정

- Maven
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
  </dependency>
<dependencies>
```

- Gradle
```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
}
```

## DB 및 Logging 설정

- application.properties

```properties
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://{IP:PORT}/{DB_NAME}
spring.datasource.username={USER_NAME}
spring.datasource.password={PASSWORD}

#update the schema with the given values.
spring.jpa.hibernate.ddl-auto=update
#To beautify or pretty print the SQL
spring.jpa.properties.hibernate.format_sql=true
#show sql
spring.jpa.properties.hibernate.show-sql=true
#show parameter binding
logging.level.org.hibernate.type.descriptor.sql=DEBUG

logging.level.org.hibernate.SQL=DEBUG
```
