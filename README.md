# 팀업 oauth2 샘플 코드   

## oauth2-sample-code
code 인증 방식   
로그인은 팀업 홈페이지에서 하고 code를 이용해 token을 받아 오는 방식

### 사용법
oauth2-sample-code 폴더에서    
> gradlew build  

빌드 성공 하면 build\libs 폴더에  war 파일 생성됨   

> java -jar war file name      

ex) java -jar oauth2-sample-code-0.0.1-20160426-142801.war   
http://localhost:8080 접속    

## oauth2-sample-password
password 인증 방식    
id, password 를 직접 입력 받아 팀업 서버로 전송 후 token을 받아 오는 방식
* 권한있는 clientid로만 가능 함

### 사용법
oauth2-sample-password 폴더에서    

> gradlew build  


빌드 성공 하면 build\libs 폴더에  war 파일 생성됨   

> java -jar war file name      

ex) java -jar oauth2-sample-password-0.0.1-20160426-143100.war      
http://localhost:8080 접속    

### 환경
java 8 설치 필요
