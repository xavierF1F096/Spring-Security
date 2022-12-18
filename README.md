### Spring Security

- crear el proyecto desde start.spring.io [here](http://start.spring.io "here")
- Dependecias principales que debes agregar para poder trabajar bajo spring security
  **- Se desarrollo en la version de spring 3.0.0 con java 17(Maven)**

1. Spring Web
2. Spring Security
3. Lombok
4. Spring Data JPA
5. MySQL Driver(Este es opcional puedes ocuapar PostgreSql o algun otro)

# Conceptos principales que se debe leer primero

# JWT

![](https://supertokens.com/static/b0172cabbcd583dd4ed222bdb83fc51a/9af93/jwt-structure.png)

#Bearer

> WT is a particular type of token. JWT can be used as an OAuth Bearer token. A useful resource for reference can be found at https://auth0.com/docs/tokens.

**Librerias adicionales usadas para generar JsonWebToken**

```java
<!-- https://mvnrepository.com/artifact/com.auth0/java-jwt -->
          <dependency>
                <groupId>com.auth0</groupId>
               <artifactId>java-jwt</artifactId>
                <version>4.2.1</version>
           </dependency>
```

```java
 <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
           <dependency>
               <groupId>io.jsonwebtoken</groupId>
               <artifactId>jjwt-api</artifactId>
              <version>0.11.5</version>
            </dependency>

```

```java
           <dependency>
               <groupId>io.jsonwebtoken</groupId>
               <artifactId>jjwt-impl</artifactId>
              <version>0.11.5</version>
			  <scope>runtime</scope>
            </dependency>

```

```java
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
	<!-- or jjwt-gson if Gson is preferred -->
    <version>0.11.1</version>
    <scope>runtime</scope>
</dependency>
```
