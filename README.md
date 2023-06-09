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

## 도메인 객체 생성
```java
@Entity
@Table(name = "cafe")
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    ...
}
```

## Repository 생성
```java
@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {
    
}
```

## CRUD 작성
```java
// Create - 생성
Cafe savedCafe = cafeRepository.save(cafe);

// Read - 조회
Optional<Cafe> OptionalCafe = cafeRepository.findById(id);
Cafe findCafe OptionalCafe.get();

// Update - 수정
Cafe cafe = cafeRepository.findById(id).get();
cafe.setName(newName);

// Delete - 삭제
cafeRepository.delete(cafe);
```
**Setter를 사용하지 않는 것을 권장함**
```java
Cafe cafe = cafeRepository.findById(id).get();
cafe.updateCafeName(newName);
```

```java
public class Cafe {

    @NonNull
    private String name;

    public void updateCafeName(String name) {
        this.name = name;
    }
}
```
