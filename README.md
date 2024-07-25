# kodacG-summer-vacation

### 1주차 - ERD, API 설계
#### ERD
![다이어그램 drawio](https://github.com/user-attachments/assets/95010866-3f99-4959-9751-01605571c7be)

- Member에서 장바구니 엔티티를 one-to-many.
- Items에서 item을 one-to-many.
- 주문 엔티티는 Member의 정보를 가져오고 Member의 장바구니들 일부 혹은 전체가져옴.

#### RESTful API

**REST**  
- 소프트웨어 프로그램 아키텍처의 한 형식
- HTTP URL를 통해 자원을 명시, HTTP 메서드를 통해 해당 자원에 대한 CRUD 오퍼레이션 적용
- REST는 자원 기반의 구조 설계, 중심에 Resource가 있고 HTTP 메서드를 통해 Resource를 처리하도록 설계된 아키텍처를 의미
- 웹의 모든 자원에 고유한 ID인 HTTP URI를 부여

**REST API**  
- 서버 프로그램은 웹 브라우저, 아이폰, 안드로이드 애플리케이션과 통신에도 대응할 수 있어야 함
- 범용적으로 사용성을 보장하는 서버 디자인 필요

**REST 구성**
- **자원**: URL / 모든 자원에 고유한 ID가 존재, 이 자원은 서버에 존재
  - 자원을 구별하는 ID는 HTTP URI
- **행위**: HTTP Method / GET, POST, PUT, DELETE와 같은 메서드 제공
- **표현**: Representations / 클라이언트가 자원의 상태에 대한 조작을 요청하면 서버는 이에 적절한 응답을 보냄. REST에서 하나의 자원은 JSON, XML 등 여러 형태의 Representation으로 나타냄
  - POST: POST를 통해 해당 URI를 요청하면 리소스 생성
  - GET: GET을 통해 해당 리소스 조회
  - PUT: PUT을 통해 리소스 수정
  - DELETE: DELETE를 통해 리소스 삭제

**REST 특징**
- **클라이언트/서버 구조**
  - 클라이언트는 유저와 관련된 처리, 서버는 REST API 제공
  - REST 서버: API를 제공하고 비즈니스 로직 처리 및 저장
  - 클라이언트: 사용자 인증, 컨텍스트(세션, 로그인 정보) 등을 직접 관리하고 책임
  - 서로 간 의존성 줄어듦
- **무상태성**: 서버에서 어떤 작업을 하기 위해 상태 정보를 기억할 필요 없음, 요청에 대해 처리만 해주면 됨
- **캐시 처리 기능**: 대량의 요청을 효율적으로 처리하기 위해 캐시 요구
  - 캐시 사용을 통해 응답 시간 빨라지고, REST 서버 트랜잭션이 발생하지 않기 때문에 전체 응답 시간, 성능, 서버의 자원 이용률 향상 가능
- **자체 표현 구조**: JSON을 이용한 메시지 포맷을 통해 직관적 이해 가능, REST API 메시지만으로 그 요청이 어떤 행위를 하는지 알 수 있음
- **계층화**: 클라이언트와 서버가 분리되어 있기 때문에 중간에 프록시 서버, 암호화 계층 등 중간 매체를 사용할 수 있어 자유도가 높음

**RESTful API**
- HTTP와 URI 기반으로 자원에 접근할 수 있도록 제공하는 애플리케이션 개발 인터페이스, HTTP 메서드와 URI만으로 인터넷 자료를 CRUD 가능
- REST API를 제공하는 웹 서비스를 RESTful하다고 함

**RESTful API 개발 원칙**
- **자원 식별 가능**: URL만으로 어떤 자원을 제어하려고 하는지 알 수 있어야 함. 자원 위치+자원 종류까지, 서버가 제공하는 정보는 JSON이나 XML 형태로 HttpBody에 포함되어 전송
- **행위 명시적**: 강제적이지 않음. GET으로 UPDATE와 DELETE를 해도 됨. 다만 REST 아키텍처에는 부합하지 않음. REST를 따른다고 할 수 없음
- **자기 서술적**: 데이터에 대한 메타 정보만 가지고도 어떤 종류의 데이터인지, 데이터를 위해 어떤 애플리케이션을 실행해야 하는지 알 수 있어야 함


#### API

| 기능       | 메소드 | 경로                | 파라미터       | 추가 정보 |
|------------|--------|---------------------|----------------|-----------|
| 웰컴페이지 | GET    | /                   |                |           |
| 회원가입   | GET    | /signup             |                |           |
| 회원가입   | POST   | /signup             |                | [자세히보기](#회원가입-post) |
| 로그인     | GET   | /login              |                |   
| 로그인     | POST   | /login              |                | [자세히 보기](#로그인-post)  |
| 장바구니   | GET    | /cart               |                |           |
| 상품정보   | GET    | /product/productsid | {productsid}   |           |
| 주문       | GET    | /order              |                |           |
| 주문       | POST   | /order              |                |[자세히 보기](주문-post)  |
| 주문조회   | GET    | /result/orderid     | {orderid}      |           |

#### 로그인 POST
**로그인: RequestBody**
```json
{
  "user ID": "kimjiwon512@gmial.com",
  "user password": "1234"
}
```
#### 회원가입 POST
**회원가입: RequestBody**
```json
{
  "user_id": "kimjiwon512@gmail.com",
  "password": "1234",
  "name": "김지원"
}
```
#### 주문 POST
**주문: RequestBody**
```json
{
  "delivery_name": "기본 배송지 이름",
  "phone_number": "핸드폰 번호",
  "delivery_address": "기본 배송지 주소",
  "delivery_request": "배송 요청 사항",
  "cart_list": [
    {
      "itmes_name": "상품 묶음 이름 1",
      "item_name": "상품1",
      "order_quantity": "주문 상품 수 1",
      "order_price": "주문 상품 가격 1"
    },
    {
      itemse_name": "상품 묶음 이름 2",
      "item_name": "상품2",
      "order_quantity": "주문 상품 수 2",
      "order_price": "주문 상품 가격 2"
    }
  ],
  "total_order_amount": "총 주문 금액"
}
```



