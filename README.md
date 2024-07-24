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

여기에 제공된 정보를 바탕으로 테이블 구조와 예시 데이터를 만들어보겠습니다.

### USER 사용자 테이블
| user_id (pk) | user_name | password | email  | sign_date |
|--------------|-----------|----------|--------|-----------|
| 1            | 김명성    | password | audtjd | 2024-07-12|
| 2            | 김태욱    | pass     | xodnr  | 2024-07-13|

### PRODUCT 상품 테이블
| product_id (pk) | product_name   | price  | stock | description | option | discount_price |
|-----------------|----------------|--------|-------|-------------|--------|----------------|
| 1546            | 아이패드 에어  | 50000  | 10    | 에어        | 128GB  | 10%            |
| 1547            | 아이패드 프로  | 60000  | 45    | 프로        | 256GB  | 15%            |

### OPTION 옵션 테이블
| option_id | product_id (fk) | option_name  | additional_price |
|-----------|------------------|--------------|------------------|
| 754       | 1546             | 셀룰러 추가  | 10000            |
| 787       | 1547             | 용량 추가    | 15000            |

### ORDER 주문 테이블
| order_id (pk) | user_id (fk) | order_date  | delivery | total_amount |
|---------------|--------------|-------------|----------|--------------|
| 474           | 1            | 2024-07-11  | 창원     | 60000        |
| 785           | 2            | 2024-07-24  | 부산     | 75000        |

### ORDER_PRODUCT 주문-상품 중간 테이블
| order_product_id (pk) | order_id (fk) | product_id (fk) | quantity | option_id (fk) | order_price |
|-----------------------|---------------|-----------------|----------|----------------|-------------|
| 1                     | 474           | 1546            | 1        | 754            | 60000       |
| 2                     | 785           | 1547            | 1        | 787            | 75000       |

### CART 장바구니 테이블
| cart_id (pk) | user_id (fk) | cart_date  | total_price |
|--------------|--------------|------------|-------------|
| 1            | 1            | 2024-07-11 | 60000       |
| 2            | 2            | 2024-07-24 | 75000       |

### CART_ORDER 장바구니-주문 중간 테이블
| cart_order_id (pk) | cart_id (fk) | order_id (fk) |
|--------------------|--------------|---------------|
| 1                  | 1            | 474           |
| 2                  | 2            | 785           |

### PAYMENT 결제 테이블
| payment_id (pk) | order_id (fk) | payment_date | amount | payment_method | payment_status |
|-----------------|---------------|--------------|--------|----------------|----------------|
| 1               | 474           | 2024-07-11   | 60000  | 신용카드       | 완료           |
| 2               | 785           | 2024-07-24   | 75000  | 계좌이체       | 완료           |







  
  
