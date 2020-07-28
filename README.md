# blueprintcode

---

`Inspired from things I have worked on or seen.`

---

## Service description


## Development notes

This application is compatible with [Maven](4).

[Swagger](9) is used to provide Api documentation, but it is up to the developer to annotate correctly the controllers in order to provide a good description of the endpoints.

To run the application from the sources __WITH PROXY__ use:
```bash
mvn clean
mvn spring-boot:run \
-Djavax.net.ssl.trustStore=${TRUSTSTORE-FILE-PATH} \
-Djavax.net.ssl.trustStorePassword=${TRUSTSTORE-PASSWORD} \
-Djavax.net.ssl.keyStore=${KEYSTORE-FILE-PATH} \
-Djavax.net.ssl.keyStorePassword=${KEYSTORE-PASSWORD} \
-Djavax.net.ssl.keyStoreType=PKCS12 \
-Dhttp.proxyPort=${PROXY-PORT} \
-Dhttp.proxyHost=${PROXY-URL} \
-Dhttps.proxyPort=${PROXY-PORT} \
-Dhttps.proxyHost=${PROXY-URL}
```

To run the application from the sources __WITHOUT PROXY__ use:
```bash
mvn clean
mvn spring-boot:run \
-Djavax.net.ssl.trustStore=${TRUSTSTORE-FILE-PATH} \
-Djavax.net.ssl.trustStorePassword=${TRUSTSTORE-PASSWORD} \
-Djavax.net.ssl.keyStore=${KEYSTORE-FILE-PATH} \
-Djavax.net.ssl.keyStorePassword=${KEYSTORE-PASSWORD} \
-Djavax.net.ssl.keyStoreType=PKCS12
```

### Frameworks 
This application is using [Spring Boot](3) as its main framework.
Api Documentation is available on the on the [Index URL](10) of the application.

## Production Notes
To run the application use:
```bash
blueprintcode-${VERSION}.jar \
--javax.net.ssl.trustStore=${TRUSTSTORE-FILE-PATH} \
--javax.net.ssl.trustStorePassword=${TRUSTSTORE-PASSWORD} \
--javax.net.ssl.keyStore=${KEYSTORE-FILE-PATH} \
--javax.net.ssl.keyStorePassword=${KEYSTORE-PASSWORD} \
--javax.net.ssl.keyStoreType=PKCS12
```

### External Services Dependencies

--- 

[3]: http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
[4]: https://maven.apache.org
[9]: http://swagger.io/specification/
[10]: http://localhost:8080
