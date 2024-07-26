# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 도메인 모델 선정 - > 사용자, 상품, 옵션, 주문, 장바구니, 결제 등...

### 도메인 모델들의 속성 정리   
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

**ORDER_PAYMENT 테이블 속성**
- order_payment_id(pk) 주문-결제 아이디
- order_id(fk)         주문 아이디
- payment_id(fk)       결제 아이디


### 도메인 모델들 간의 관계 

**관계 정의**

| 번호 | 관계             | 관계가 설정된 이유                                 |
|------|------------------|---------------------------------------------------|
| 1    | 사용자:주문      | 1:0~n (주문을 하지 않거나 여러 개를 하는 경우)      |
| 2    | 사용자:장바구니  | 1:1 (사용자마다 장바구니는 하나만)                 |
| 3    | 상품:주문        | N:M (하나의 주문에 여러 상품이 포함 가능, 한 상품이 여러 주문에 들어갈 수 있음) |
| 4    | 상품:옵션        | 1:0~1 (하나의 상품을 주문 시에는 단일 옵션만 주문이 가능하고 옵션 없이 1사는 경우가 존재) |
| 5    | 주문:장바구니    | 0~n:1 (장바구니는 유저당 하나씩 가지고 이 장바구니에는 여러 주문이 포함 될 수 있다) |
| 6    | 결제:주문        | 1:1~n (결제를 하려면 하나의 주문이 필요하고 여러 주문을 결제 가능) |


**중간 테이블 사용**

- 일반적으로 다대다 관계에서 사용, 편의상 추가한 것도 있다

**상품과 주문 n:m 관계**

먼저 상품과 주문에서 중간테이블을 사용하면 어떤 상품이 어떤 주문에 속해있고 
같은 주문에 어떤 상품들이 포함되어 있는지 이 상품의 옵션이 무엇인지를 쉽게 확인할 수 있어 중간테이블을 사용한다

**장바구니와 주문1: 0~n 관계**

장바구니와 주문간의 관계에서는 많은 유저들이 들어온다면 각 유저는 하나의 장바구니를 가지도록 설정했지만, 어떤 장바구니에 어떤 주문이 들어갔는지를 
한 장바구니의 한 속성에 모두 집어넣기는 힘들다 그래서 어떤 유저의 장바구니에 어떤 주문이 포함되어 있는지를 알기 쉽게 하도록 중간 테이블을 설정했다 

**결제와 주문 1:1~n 관계**
결제와 주문은 장바구니에 들어간 주문이 여러가지일 때와 한가지 일때 또는 장바구니에서 
선택한 주문만을 결제처리하는 내역을 남기기 위해서 중간 테이블을 사용한다   

**설정한 관계를 바탕으로 그린 ERD(draw.io)**

![image](https://github.com/user-attachments/assets/5407cfbf-ca43-43b1-a3d0-1cd7a4fc0fb5)

![image](https://github.com/user-attachments/assets/b8d015b2-8015-40a5-baf7-5fab7b19848d)   



**테이블 설계 후 GPT를 통해 각 데이터를 입력한 결과**

편의상 테이블이 나열되는 순서대로 유저는 1000번대, 상품은 2000번대, 옵션은 3000번대를   
기본키로 설정하여 어떤 테이블에 어떤 내용이 들어갈지 임의로 가시화했다   

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


**API 설계를 위한 기능 정리**

기본적으로 등록(생성), 조회, 수정, 삭제를 기반으로 동작한다.   
그리고 필요한 기능들을 속속들이 추가해본다.


**사용자 관련기능** 
- 회원가입
- 로그인
- 유저 정보 조회
- 회원 정보 수정
- 회원 탈퇴

-> ( 로그인에는 서버가 사용자를 인증한 후 보내주는 JWT 형식의 토큰이 응답에 포함되어야 한다)   

**상품 관련 기능**
- 상품 등록
- 상품 검색
- 상품 수정
- 상품 삭제
  
**주문 관련 기능**
- 주문 하기
- 주문 조회
- 주문 수정
- 주문 취소
- 배송 상태 조회

**결제 관련 기능**
- 결제 처리
- 결제 내역 조회
- 결제 상태 조회(완료, 미완)
- 결제 취소(삭제)
- 결제 수정(환불 후 다른 카드로 재결제)

**장바구니**
- 장바구니 담기
- 장바구니 조회
- 장바구니 비우기(개별, 전부)

**옵션**
- 옵션 등록
- 옵션 수정
- 옵션 삭제

```

product_name: ipad air
price : 200000
stock : 15
description: air 4 generation
discount_price : 10 percentage


product_name: ipad pro
price : 300000
stock : 20
description: pro 6 generation
discount_price : 10 percentage


전달해야하는 값을 JSON 데이터의 형식은 잘 몰라서 위와 같은 형식으로 대부분 작성한 후 gpt를 통해 json의 형식으로 변경했다 
위 데이터는 상품 등록 시 들어가야하는 데이터이다



# 

[회원가입](https://www.notion.so/9c965b03bd0241369b74f6d5f5e4ca1d?pvs=21)

[로그인](https://www.notion.so/fe766b140e91484fb1020d11f7c73f1c?pvs=21)

[유저 정보 ](https://www.notion.so/4be0e299eeb3423ca41fc19957536686?pvs=21)

[유저 정보 수정](https://www.notion.so/3fa0f0ad1a6e4706a22dc514fa4a1752?pvs=21)

[회원 탈퇴](https://www.notion.so/bb34df286b7a4300aa700f642d7cd277?pvs=21)

[](https://www.notion.so/2b17465b32824587ada3db073f26b3e8?pvs=21)

[상품 등록](https://www.notion.so/ffe91e195710484388f544df1eb240e3?pvs=21)

[상품 검색](https://www.notion.so/8611b6d54fce4ad5a14a09ca0884e689?pvs=21)

[상품 수정](https://www.notion.so/dc11ab2393034c00b307fac6ccfb261a?pvs=21)

[상품 삭제](https://www.notion.so/4eeee727c9624a41a01b4e212ef18927?pvs=21)

[](https://www.notion.so/d18b31fa86b54fb784ee7efd376f69ab?pvs=21)

[주문 생성](https://www.notion.so/5efdbbb0c07f4bac930822da44a90166?pvs=21)

[주문 조회](https://www.notion.so/301fca9c625e40289d3f63dd57fdce13?pvs=21)

[주문 수정](https://www.notion.so/a1f5ef5213c443869d321659fa6f3335?pvs=21)

[주문 취소](https://www.notion.so/2f2499aadeb149a8a7e303fa8f810d1e?pvs=21)

[배송 상태 조회](https://www.notion.so/ad5a71427caa46ab9b72e0b0d68e48b2?pvs=21)

[](https://www.notion.so/b35ae2420f754bc8a5beb213780b3b3c?pvs=21)

[옵션 등록](https://www.notion.so/a27c931c9b8548d7a4d21ba31f09b283?pvs=21)

[옵션 수정](https://www.notion.so/35b0ebe92c4742a78d700a015678df95?pvs=21)

[옵션 삭제 ](https://www.notion.so/dfe040cdb90449e6bf3ba2a02738df5d?pvs=21)

[](https://www.notion.so/10b3f30357e44c558e3c7cc519cad530?pvs=21)

[장바구니 담기](https://www.notion.so/daf94dfce8534352b55568a2049d2073?pvs=21)

[장바구니 조회](https://www.notion.so/a798dd0e29db4893aa16e7ef8aa04b66?pvs=21)

[장바구니 비우기](https://www.notion.so/6db78b9e6fab4f09a0679e76c61913a2?pvs=21)

[](https://www.notion.so/1ed983687fd7469cad711f84ec6e0f50?pvs=21)

[결제 처리(등록) ](https://www.notion.so/f2af97bb32eb4cc0916da8d5245382df?pvs=21)

[결제 내역 조회](https://www.notion.so/2babffb786814deca1318beaa22d7bd7?pvs=21)

[결제 상태 조회](https://www.notion.so/14177ffefdd34d64a6a395a6e1c7b16d?pvs=21)

[결제 방식 변경](https://www.notion.so/a9748eb83ed647a69587ef6a4508dfc5?pvs=21)

[결제 취소](https://www.notion.so/706a386edfe548f190ae5e36e1f206b6?pvs=21)





