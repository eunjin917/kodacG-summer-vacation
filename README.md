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
- option_description    옵션 설명

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
- payment_date       결제 일시
- amount             결제 금액
- payment_method     결제 방식
- payment_status     결제 상태

### ORDER_PAYMENT 테이블 속성
- order_payment_id(pk) 주문-결제 아이디
- order_id(fk)         주문 아이디
- payment_id(fk)       결제 아이디


**관계 정의**

| 번호 | 관계             | 관계가 설정된 이유                                 |
|------|------------------|---------------------------------------------------|
| 1    | 사용자:주문      | 1:0~n (주문을 하지 않거나 여러 개를 하는 경우)      |
| 2    | 사용자:장바구니  | 1:1 (사용자마다 장바구니는 하나만)                 |
| 3    | 상품:주문        | N:M (하나의 주문에 여러 상품이 포함 가능, 한 상품이 여러 주문에 들어갈 수 있음) |
| 4    | 상품:옵션        | 1:0~1 (하나의 상품을 주문 시에는 단일 옵션만 주문이 가능하고 옵션 없이 1사는 경우가 존재) |
| 5    | 주문:장바구니    | 0~n:1 (장바구니는 유저당 하나씩 가지고 이 장바구니에는 여러 주문이 포함 될 수 있다) |
| 6    | 결제:주문        | 1:1~n (결제를 하려면 하나의 주문이 필요하고 여러 주문을 결제 가능) |


## 중간 테이블 사용

**상품과 주문 n:m 관계**

먼저 상품과 주문에서 중간테이블을 사용하면 어떤 상품이 어떤 주문에 속해있고 
같은 주문에 어떤 상품들이 포함되어 있는지 이 상품의 옵션이 무엇인지를 쉽게 확인할 수 있어 중간테이블을 사용한다

**장바구니와 주문1: 0~n 관계**

장바구니와 주문간의 관계에서는 많은 유저들이 들어온다면 각 유저는 하나의 장바구니를 가지도록 설정했지만, 어떤 장바구니에 어떤 주문이 들어갔는지를 
한 장바구니의 한 속성에 모두 집어넣기는 힘들다 그래서 어떤 유저의 장바구니에 어떤 주문이 포함되어 있는지를 알기 쉽게 하도록 중간 테이블을 설정했다 

**결제와 주문 1:1~n 관계**
결제와 주문은 장바구니에 들어간 주문이 여러가지일 때와 한가지 일때 또는 장바구니에서 
선택한 주문만을 결제처리하는 내역을 남기기 위해서 중간 테이블을 사용한다


## 테이블 설계 후 GPT를 통해 각 데이터를 입력한 결과

<details>
<summary>USER 및 관련 테이블</summary>

### USER 테이블
| user_id (pk) | user_name | password | email  | sign_date |
|--------------|-----------|----------|--------|-----------|
| 1001 (김명성) | 김명성    | password | audtjd | 2024-07-12|
| 1011 (김태욱) | 김태욱    | pass     | xodnr  | 2024-07-13|

### CART 테이블
| cart_id (pk) | user_id (fk) | cart_date  | total_price |
|--------------|--------------|------------|-------------|
| 6001 (명성 장바구니) | 1001         | 2024-07-12 | 70000       |
| 6002 (태욱 장바구니) | 1011         | 2024-07-13 | 70000       |

### CART_ORDER 테이블
| cart_order_id (pk) | cart_id (fk) | order_id (fk) |
|--------------------|--------------|---------------|
| 7001 (명성 장바구니-주문) | 6001         | 4001          |
| 7002 (태욱 장바구니-주문) | 6002         | 4002          |

</details>

<details>
<summary>PRODUCT 및 관련 테이블</summary>

### PRODUCT 테이블
| product_id (pk) | product_name   | price  | stock | description | discount_price |
|-----------------|----------------|--------|-------|-------------|----------------|
| 2002 (아이패드 에어)  | 아이패드 에어  | 50000  | 10    | 에어        | 45000          |
| 2022 (아이패드 프로)  | 아이패드 프로  | 60000  | 45    | 프로        | 54000          |

### OPTION 테이블
| option_id (pk) | product_id (fk) | option_name | additional_price |
|----------------|------------------|-------------|------------------|
| 3002 (셀룰러 추가) | 2002 (아이패드 에어) | 셀룰러 추가 | 20000            |
| 3022 (용량 추가)   | 2002 (아이패드 에어) | 용량 추가   | 10000            |
| 3003 (셀룰러 추가) | 2022 (아이패드 프로) | 셀룰러 추가 | 20000            |
| 3023 (용량 추가)   | 2022 (아이패드 프로) | 용량 추가   | 10000            |

### ORDER_PRODUCT 테이블
| order_product_id (pk) | order_id (fk) | product_id (fk) | quantity | option_id (fk) | option_description |
|-----------------------|---------------|-----------------|----------|----------------|--------------------|
| 5001 (명성 에어 - 셀룰러 추가)      | 4001          | 2002            | 1        | 3002           | 셀룰러 추가        |
| 5002 (태욱 프로 - 용량 추가)      | 4002          | 2022            | 1        | 3023           | 용량 추가          |

</details>

<details>
<summary>ORDER 및 관련 테이블</summary>

### ORDER 테이블
| order_id (pk) | user_id (fk) | order_date | delivery | delivery_status | total_amount |
|---------------|--------------|------------|----------|-----------------|--------------|
| 4001 (명성 주문)  | 1001         | 2024-07-12 | 창원     | 배송중          | 70000        |
| 4002 (태욱 주문)  | 1011         | 2024-07-13 | 부산     | 배송완료        | 70000        |

### ORDER_PAYMENT 테이블
| order_payment_id (pk) | order_id (fk) | payment_id (fk) |
|-----------------------|---------------|------------------|
| 9001 (명성 주문 결제) | 4001          | 8001             |
| 9011 (태욱 주문 결제) | 4002          | 8011             |

</details>

<details>
<summary>PAYMENT 테이블</summary>

### PAYMENT 테이블
| payment_id (pk) | payment_date | amount | payment_method | payment_status |
|-----------------|--------------|--------|----------------|----------------|
| 8001 (명성 결제) | 2024-07-12   | 70000  | 신용카드       | 완료           |
| 8011 (태욱 결제) | 2024-07-13   | 70000  | 계좌이체       | 완료           |

</details>

![image](https://github.com/user-attachments/assets/5407cfbf-ca43-43b1-a3d0-1cd7a4fc0fb5)

![image](https://github.com/user-attachments/assets/b8d015b2-8015-40a5-baf7-5fab7b19848d)


**API 설계를 위한 기능 정리**






  
  
