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
-  delivery_status 배송 상태

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


테이블 설계 후 GPT를 통해 각 데이터를 입력한 결과
#### 1. USER 테이블
| user_id (pk) | user_name | password | email  | sign_date |
|--------------|-----------|----------|--------|-----------|
| 1001 (김명성) | 김명성    | password | audtjd | 2024-07-12|
| 1011 (김태욱) | 김태욱    | pass     | xodnr  | 2024-07-13|

#### 2. PRODUCT 테이블
| product_id (pk) | product_name   | price  | stock | description | discount_price |
|-----------------|----------------|--------|-------|-------------|----------------|
| 2002 (아이패드 에어)  | 아이패드 에어  | 50000  | 10    | 에어        | 45000          |
| 2022 (아이패드 프로)  | 아이패드 프로  | 60000  | 45    | 프로        | 54000          |

#### 3. OPTION 테이블
| option_id (pk) | product_id (fk) | option_name | additional_price |
|----------------|------------------|-------------|------------------|
| 3002 (셀룰러 추가) | 2002 (아이패드 에어) | 셀룰러 추가 | 20000            |
| 3022 (용량 추가)   | 2002 (아이패드 에어) | 용량 추가   | 10000            |
| 3003 (셀룰러 추가) | 2022 (아이패드 프로) | 셀룰러 추가 | 20000            |
| 3023 (용량 추가)   | 2022 (아이패드 프로) | 용량 추가   | 10000            |

#### 4. ORDER 테이블
| order_id (pk) | user_id (fk) | order_date | delivery | delivery_status | total_amount |
|---------------|--------------|------------|----------|-----------------|--------------|
| 4001 (명성 주문)  | 1001         | 2024-07-12 | 창원     | 배송중          | 70000        |
| 4002 (태욱 주문)  | 1011         | 2024-07-13 | 부산     | 배송완료        | 70000        |

#### 5. ORDER_PRODUCT 테이블
| order_product_id (pk) | order_id (fk) | product_id (fk) | quantity | option_id (fk) | option_description |
|-----------------------|---------------|-----------------|----------|----------------|--------------------|
| 5001 (명성 에어 - 셀룰러 추가)      | 4001          | 2002            | 1        | 3002           | 셀룰러 추가        |
| 5002 (태욱 프로 - 용량 추가)      | 4002          | 2022            | 1        | 3023           | 용량 추가          |

#### 6. CART 테이블
| cart_id (pk) | user_id (fk) | cart_date  | total_price |
|--------------|--------------|------------|-------------|
| 6001 (명성 장바구니) | 1001         | 2024-07-12 | 70000       |
| 6002 (태욱 장바구니) | 1011         | 2024-07-13 | 70000       |

#### 7. CART_ORDER 테이블
| cart_order_id (pk) | cart_id (fk) | order_id (fk) |
|--------------------|--------------|---------------|
| 7001 (명성 장바구니-주문) | 6001         | 4001          |
| 7002 (태욱 장바구니-주문) | 6002         | 4002          |

#### 8. PAYMENT 테이블
| payment_id (pk) | payment_date | amount | payment_method | payment_status |
|-----------------|--------------|--------|----------------|----------------|
| 8001 (명성 결제) | 2024-07-12   | 70000  | 신용카드       | 완료           |
| 8011 (태욱 결제) | 2024-07-13   | 70000  | 계좌이체       | 완료           |

#### 9. ORDER_PAYMENT 테이블
| order_payment_id (pk) | order_id (fk) | payment_id (fk) |
|-----------------------|---------------|------------------|
| 9001 (명성 주문 결제) | 4001          | 8001             |
| 9011 (태욱 주문 결제) | 4002          | 8011             |









  
  
