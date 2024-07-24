# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 도메인 모델 선정 

사용자, 상풍, 옵션, 주문, 장바구니, 결제


 **USER 사용자**
- user_id(pk) 유저 아이디
- user_name   유저 이름
- password    비밀번호
- email       이메일 
- sign_date   가입일자
  
**PRODUCT 상품**
- product_id(pk)   상품 아이디
- product_name     상품 이름 
- price            가격
- stock            재고 수량
- description      상품 설명
- option           옵션
- discount_price   할인가

**OPTION 옵션**
- option_id        옵션의 아이디
- product_id(fk)   상품의 아이디
- option_name      옵션 이름(예 빨간색, OO추가)
- additional_price 옵션 추가금 

 **ORDER 주문**
- order_id(pk)     주문 번호
- user_id(fk)      유저 아이디
- order_date       주문 일시
- delivery         배송지
- total_amount     총 주문금액

**ORDER_PRODUCT 주문-상품 중간 테이블**
- order_product_id(pk)  주문 -상품 아이디
- order_id(fk)          주문 번호
- product_id(fk)        상품 아이디
- quantity              주문 수량
- option_id(fk)         옵션아이디(필수 x)
- order_price           주문 시 상품 가격

 **CART 장바구니**
- cart_id(pk)    장바구니 번호
- user_id(fk)     유저 아이디
- cart_date       장바구니에 담은 일시
- total_price     총 금액


**CART_ORDER 장바구니-주문 중간테이블**
- cart_order_id(pk)  장바구니-주문 아이디
- cart_id(fk)        장바구니 아이디
- order_id(fk)       주문 아이디

**PAYMENT 결제**
- payment_id(pk)     결제 아이디
- order_id(fk)       주문 아이디
- payment_date       결제 일시
- amount             결제 금액
- payment_method     결제 방식
- payment_status     결제 상태




**관계 정의** 


테이블 간 정규화 필요 일단은 작성만 해보기 






  
  
