# Netty server,client tutorial

## Netty 설정

netty-all 4.1.54.Final

```groovy
    dependencies {
        compile group: 'io.netty', name: 'netty-all', version: '4.1.53.Final'
    }
```

## Run Echo Server

```shell script
$ ./gradlew :echo-server:run --args='9999'
```
> 실행 파라미터로 서버 리스닝 포트(9999) 지정


## Run Echo Client

```shell script
$ ./gradlew :echo-client:run --args='localhost 9999 echo-message'
```
> 실행 파라미터로 에코 서버 호스트,포트,메시지 를 기술