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
- order_list  주문내역 *
  
**PRODUCT 상품**
- product_name(pk) 상품 이름 
- price            가격
- quantity         수량
- description      상품 설명
- option           옵션
- discount_price   할인가
  
 **ORDER 주문**
- order_num(pk)      주문 번호
- product_name(fk)  상품 이름
- user_id(fk)       유저 아이디
- order_date        주문 일시
- destination       배송지
  
 **COUPON 쿠폰**
- coupon_num(pk)    쿠폰 번호
- product_name(fk)  상품 이름(쿠폰이 적용되는)
- discount_rate     할인율
- use_date          사용 기간

 **CART 장바구니**
- cart_num(pk)    장바구니 번호
- order_num(fk)   주문 번호
- cart_date       장바구니에 담은 일시
- order_list      주문 목록 (목록 번호가 같은 것끼리 주문 된다)
- total_price     총 금액
- pay_date        결제 일시


  -> 장바구니와 주문 간의 차이점? 주문도 주문에서는 어떤 유저가 어떤 상품을 주문했는지를 저장하는 엔티티이고 장바구니는 이 주문들이 합쳐진 것
  
  관계 정의
  사용자 : 주문 = 1 : 0 ~ n
  주문 : 상품 = 1: 1 ~ n
  상품 : 쿠폰 = 1 : 1
  장바구니 : 주문 = 1 : 1 ~ n



  

  
  
