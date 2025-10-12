
## Secure login gateway

Проект демонстрирует реализацию OAuth2 Resource Server с поддержкой [OpenID Connect](https://auth0.com/docs/authenticate/protocols/openid-connect-protocol). Цель проекта — показать, 
как подключить сервер ресурсов к внешнему серверу аутентификации и авторизации, работающему по стандарту OpenID Connect.

[См официальную документацию - OAuth 2.0 Resource Server JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)

Настройка Certificate endpoint (точка доступа сертификата) - ``spring.security.oauth2.resourceserver.jwt.jwk-set-uri`` - Этот endpoint возвращает публичные ключи, которые включены для конкретного домена (realm) в формате JSON Web Key (JWK). Эти ключи используются для проверки цифровых подписей токенов, выдаваемых сервером авторизации. 
В зависимости от настроек домена, может быть доступно одно или несколько ключей для проверки токенов.


```application.properties

spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8484/auth/realms/my-test-realm/protocol/openid-connect/certs

```


