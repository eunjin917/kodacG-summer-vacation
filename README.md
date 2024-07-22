# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 엔티티 선정

 **USER 사용자**
- user_id(pk) 유저 아이디
- user_name   유저 이름
- password    비밀번호
- sign_date   가입일자
  
**PRODUCT 상품**
- product_name(pk) 상품 이름 
- price            가격
- quantity         수량
- description      상품 설명
- option           옵션
- discount_price   할인가

  
 **ORDER 주문**
- order_num(pk)     주문 번호
- product_name(fk)  상품 이름
- user_id(fk)       유저 아이디
- order_date        주문 일시
- delivery         배송지
  
 **CART 장바구니**
- cart_num(pk)    장바구니 번호
- user_id(fk)     유저 아이디
- cart_date       장바구니에 담은 일시
- order_list      주문 목록 (목록 번호가 같은 것끼리 주문 된다)
- total_price     총 금액
- pay_date        결제 일시

**장바구니와 주문 간의 차이점? 주문도 주문에서는 어떤 유저가 어떤 상품을 주문했는지를 저장하는 엔티티이고 장바구니는 이 주문들이 합쳐진 것**

**관계 정의** 

1. 유저 : 상품     일대다의 관계 
2. 유저 : 주문     일대다의 관계
3. 주문 : 상품     다대다의 관계 - order_product 중간 테이블이 필요
4. 상품 : 장바구니 다대다의 관계 - cart_product 중간 테이블이 필요
5. 주문 : 장바구니 다대일의 관계 
6. 유저 : 장바구니 일대일의 관계

중간 테이블은 erd 에서는 어떻게 나타내는지...?

**order_product (중간 테이블)**   

order_num (fk) 주문 번호   
product_name (fk) 상품 이름   
coupon_product (중간 테이블)   

**cart_product(중간 테이블)**   

cart_num (fk) 장바구니 번호   
product_name (fk) 상품 이름   

**유저 테이블**
|user_id(pk)|user_name|password|sign_date|
|:--:|:--:|:--:|:--:|
|1|김명성|12345678|2024-07-22|

**상품 테이블**
|product_name(pk)|price|quantity|description|option|discount_price|
|:--:|:--:|:--:|:--:|:--:|:--:|
|에어팟|280000|1|무선 이어폰|각인 여부 O X|270000|

**주문 테이블**
|order_num(pk)|product_name(fk)|user_id|order_date|delivery|
|:--:|:--:|:--:|:--:|:--:|
|123|에어팟|1|2024-07-23|창원|



  
  
