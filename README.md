# Sample for Nginx + Spring Boot on Docker container


## Install the Docker

* https://docs.docker.com/docker-for-mac/
* https://docs.docker.com/docker-for-windows/

## Build images & containers up

```text
$ ./mvnw clean package
$ docker-compose up --build
```


## Containers up

```text
$ docker-compose up
```

## Containers down

```text
$ docker-compose down
```


## Access to Spring Boot via Nginx

```text
$ curl -D - http://localhost:10080/hello
HTTP/1.1 200 OK
Server: nginx/1.9.3
Date: Sat, 20 Aug 2016 04:54:27 GMT
Content-Type: text/plain;charset=UTF-8
Content-Length: 5
Connection: keep-alive

Hello
```

## Access to Spring Boot by directly

```text
$ curl -D - http://localhost:8080/hello
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/plain;charset=UTF-8
Content-Length: 5
Date: Sat, 20 Aug 2016 05:06:27 GMT

Hello
```