# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 엔티티 선정

사용자, 상품, 주문, 장바구니로 선정 

 **USER 사용자**
- user_id(pk) 유저 아이디
- user_name   유저 이름
- password    비밀번호
- sign_date   가입일자
  
**PRODUCT 상품**
- product_id(pk) 상품 아이디
- product_name 상품 이름 
- price            가격
- quantity         수량
- description      상품 설명
- option           옵션
- discount_price   할인가

  
 **ORDER 주문**
- order_id(pk)     주문 번호
- user_id(fk)       유저 아이디
- order_date        주문 일시
- delivery         배송지
  
 **CART 장바구니**
- cart_id(pk)    장바구니 번호
- user_id(fk)     유저 아이디
- cart_date       장바구니에 담은 일시
- order_list      주문 목록 (목록 번호가 같은 것끼리 주문 된다)
- total_price     총 금액
- pay_date        결제 일시

**ODDER_PRODUCT 주문-상품 중간테이블**
- order_product_id(pk)
- order_id(fk) 주문 번호
- product_id(fk) 상품 아이디
- order_quantity 주문 수량

**CART_PRODUCT 장바구니- 주문 중간테이블**
- cart_product_id(pk)
- card_id(fk) 장바구니 번호
- product_id(fk) - 상품 아이디
- quantity- 장바구니에 담은 상품 수
- order_id(fk) 주문 번호


**장바구니와 주문 간의 차이점? 주문도 주문에서는 어떤 유저가 어떤 상품을 주문했는지를 저장하는 엔티티이고 장바구니는 이 주문들이 합쳐진 것**

**관계 정의** 

1. 유저 : 상품     일대다의 관계 
2. 유저 : 주문     일대다의 관계
3. 주문 : 상품     다대다의 관계 - order_product 중간 테이블이 필요
4. 상품 : 장바구니 다대다의 관계 - cart_product 중간 테이블이 필요
5. 주문 : 장바구니 다대일의 관계 
6. 유저 : 장바구니 일대일의 관계

중간 테이블은 erd 에서는 어떻게 나타내는지...?

테이블 간 정규화 필요 일단은 작성만 해보기 



**유저 테이블**
|user_id(pk)|user_name|password|sign_date|
|:--:|:--:|:--:|:--:|
|1|김명성|12345678|2024-07-22|

**상품 테이블**
|product_id(pk)|product_name|price|quantity|description|option|discount_price|
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|1|에어팟|280000|1|무선 이어폰|각인 여부 O X|270000|

**주문 테이블**
|order_id(pk)|user_id(fk)|order_date|delivery|
|:--:|:--:|:--:|:--:|
|123|1|2024-07-23|창원|

- 중간테이블 설정하면서 상품 아이디 잘 설정하기

**장바구니 테이블**
|cart_id(pk)|user_id(fk)|cart_date|order_list|total_price|pay_date|
|:--:|:--:|:--:|:--:|:--:|:--:|
|1|김명성|2024-07-23|여러 개 상품|500000|2024-07-23|



  
  
