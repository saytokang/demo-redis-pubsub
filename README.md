# Redis pub / sub sample
redis pub/sub 기능을 테스트 한다. 
사전 조건으로 redis가 구동되고 있어야 한다. 

주요 내용은  RedisConfig 설정에 있다. 
특징으로는 Listener를 지정할 때, 
MessageListenerContainer에 여러개의 Listener를 Add 할 수 있다는 것과, 
Add 할 때, 지정한 Topic 이름으로 리스닝하게 된다. 
Message Handler 함수는  @Component 대상 아무거나 가능하다. 

##  실행
mvn spring-boot:run

## 검증
아래 요청으로 publish 기능이 수행된다. 
```
POST http://localhost:8080/api/send
-data
{
	"payload" : "무궁화 꽃이 피었습니다.",
	"sender" : "ohong"
}
```
publish 된 메시지는 message listener 에 의해서 log로 출력된다. 

