# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 엔티티 선정

- USER사용자( 유저 아이디 - 기본키, 유저 이름, 비밀번호, 가입일자, 주문내역)
- user_id(pk)
- user_name
- password
- sign_date
- order_list
  
- PRODUCT 상품( 상품 이름 - 기본키, 가격, 수량, 상품설명, 옵션, 할인가(톡등가))
- product_name(pk)
- price
- quantity
- 상품 설명
- option
- discount_price
  
- ORDER 주문 (유저 아이디 - 외래키, 상품 이름 - 외래키 주문번호 - 기본키, 주문 일시, 배송지)
- order_id(pk)
- product_name(fk)
- user_id(fk)
- order_date
- destination
  
- 쿠폰(상품 이름 - 외래키, 쿠폰 이름 - 기본키, 할인율, 사용기간)
- 장바구니(주문번호 - 외래키, 장바구니 ID, 장바구니에 담긴 일시, 장바구니의 주문 수, 배송상태 총 가격 ) - 주문번호만 알아와도 사용자 아이디의 참조가 가능해 보인다 

  -> 장바구니와 주문 간의 차이점? 주문도 주문에서는 어떤 유저가 어떤 상품을 주문했는지를 저장하는 엔티티이고 장바구니는 이 주문들이 합쳐진 것
  
  관계 정의
  사용자 : 주문 = 1 : 0 ~ n
  주문 : 상품 = 1: 1 ~ n
  상품 : 쿠폰 = 1 : 1
  장바구니 : 주문 = 1 : 1 ~ n



  

  
  
