# kodacG-summer-vacation

### 1주차 - ERD, API 설계
![다이어그램 drawio](https://github.com/user-attachments/assets/7d79589c-15d6-462d-83ae-9f38767b8b10)

-Member에서 장바구니 엔티티를 onetomany.
-Items에서 item을 onetomany
-주문엔티티는 Member의 정보를 가져오고 Member의 장바구니들 일부 혹은 전체



| 기능       | 메소드 | 경로                | 파라미터       | 추가 정보 |
|------------|--------|---------------------|----------------|-----------|
| 웰컴페이지 | GET    | /                   |                |           |
| 회원가입   | GET    | /signup             |                |           |
| 회원가입   | POST   | /signup             |                |           |
| 로그인     | POST   | /login              |                |           |
| 장바구니   | GET    | /cart               |                |           |
| 상품정보   | GET    | /product/productsid | {productsid}  |           |
| 주문       | GET    | /order              |                |           |
| 주문       | POST   | /order              |                |           |
| 주문조회   | GET    | /result/orderid   | {orderid}      |           |



