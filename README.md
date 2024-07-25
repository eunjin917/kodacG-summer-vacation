# kodacG-summer-vacation

### 1주차 - ERD, API 설계

#### ERD
![다이어그램 drawio](https://github.com/user-attachments/assets/85a688f0-79a0-4176-93af-47a95debaefc)


- Member에서 장바구니 엔티티를 one-to-many.
- Items에서 item을 one-to-many.
- 주문 엔티티는 Member의 정보를 가져오고 Member의 장바구니들 일부 혹은 전체.

#### RestFul API
<REST>
- 소프트웨어 프로그램 아키텍쳐의 한 형식
- http  url를 통해 자원을 명시, http method를 통해 해당 자원에 대한 crud오퍼레이션 적용
- rest는 자원 기반의 구조설계 중심에 resource가 있고 http method를 통해 resource를 처리하도록 설계된 아키텍쳐를 의미.
- 웹의 모든 자원에 고유한 id인 http uri를 부여.

<REST API>
- 서버 프로그램은 웹 브라우저, 아이폰, 안드로이드 애플리케이션과 통신에도 대응할 수 있어야 한다.
- 범용적으로 사용성을 보장하는 서버 디자인 필요

<REST 구성>
- 자원:url / 모든 자원에 고유한 id가 존재, 이 자원은 server에 존재
->자원을 구별하는 id는 HTTP URI
- 행위:Http Method / get,post,put,delete와 같은 메서드 제공
- 표현: Representations / client가 자원의 상태에 대한 조작을 요청하면 server는 이에 적절한 응답을 보낸다, REST에서 하나의 자원은 json,xml 등 여러 형태의 Representation으로 나타냄.
>post: post를 통해 해당 uri를 요청하면 리소스 생성
>get: get을 통해 해당 리소스 조회
>put: put을 통해 리소스 수정
>delete: delete를 통해 리소스 삭제

<rest 특징>
- 클라이언트/서버 구조
>클라이언트는 유저와 관련된 처리, 서버는 rest api 제공
>REST server: api를 제공하고 비즈니스 로직 처리 및 저장
>client: 사용자 인증,컨텍스트(세션,로그인 정보)등을 직접 관리하고 책임
>서로 간 의존성 줄어든다

- 무상태성: 서버에서 어떤 작업을 하기 위해 상태정보를 기억할 필요 없음, 요청에 대해 처리만 해주면 된다
- 캐시처리 기능: 대량의 요청을 효율적으로 처리하기 위해 캐시 요구
+캐시 사용을 통해 응답시간 빨라지고 REST server트랜잭션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용율 향상 시킬수 있다
- 자체표현 구조: json을 이요한 메시지 포멧을 이용해 직관적 이해가능, restapi메시지만으로 그 요청이 어떤 행위를 하는지 알 수 있다
-계층화: 클라이언트와 서버가 분리되어 있기 때문에 중간에 프록시 서버, 암호화 계층 등 중간 메체를 사용할 수 있어 자유도가 높다

<RESTful API>
-http와 uri 기반으로 자원에 접근할 수 있도록 제공하는 애플리케이션 개발 인터페이스, http메서드와 uri마느오 인터넷 자료를 crud가능
-restapi를 제공하는 웹 서비스를 RESTful하다고 함

<RESTful API개발 원칙>
-자원 식별 가능(url 만으로 어떤 자원을 제어하려고하는지 알 수 있어야 한다. 자원위치+자원종류까지, 서버가 제공하는 정보는 json이나 xml형태로 HttpBody에 포함되어 정송시킨다
-행위 명시적: 강제적이지 않음. get으로 update와 delete를 해도 됨.
다만 rest아키텍쳐에는 부합하지 않음. rest를 따른다고 할 수 없다.
-자기 서술적: 데이터에 대한 메타 정보만 가지고도 어떤 종류의 데이터인지, 데이터를 위해서 어떤 어플리케이션을 실행해야하는지 알 수 있어야 한다. 



#### API
| 기능       | 메소드 | 경로                | 파라미터       | 추가 정보 |
|------------|--------|---------------------|----------------|-----------|
| 웰컴페이지 | GET    | /                   |                |           |
| 회원가입   | GET    | /signup             |                |           |
| 회원가입   | POST   | /signup             |                |           |
| 로그인     | POST   | /login              |                |           |
| 장바구니   | GET    | /cart               |                |           |
| 상품정보   | GET    | /product/productsid | {productsid}   |           |
| 주문       | GET    | /order              |                |           |
| 주문       | POST   | /order              |                |           |
| 주문조회   | GET    | /result/orderid     | {orderid}      |           |



