# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 도메인 모델 선정 - > 사용자, 상품, 옵션, 주문, 장바구니, 결제 등...

#### 도메인 모델들의 속성 정리   

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
- description      상품 설명
- discount_price   할인가
- 이 부분이 계산된 필드 조금 더 생각해보기

**OPTION 옵션**
- option_id        옵션의 아이디
- product_id(fk)   상품의 아이디
- option_name      옵션 이름(예 빨간색, OO추가)
- stock            재고 수량
- additional_price 옵션 추가금 

 **ORDER 주문**
- order_id(pk)     주문 번호
- user_id(fk)      유저 아이디
- order_date       주문 일시
- delivery         배송지
- total_amount     총 주문금액
- delivery_status 배송 상태

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
- 무엇을 담았는지에 대한 내용이 부족. order_product_ID를 가져올까? 조금 더 생각해보기 
- cart_date       장바구니에 담은 일시
- total_price     총 금액

**PAYMENT 결제**
- payment_id(pk)     결제 아이디
- order_id(fk)       주문 번호
- payment_date       결제 일시
- amount             결제 금액
- payment_method     결제 방식
- payment_status     결제 상태



#### 도메인 모델들 간의 관계 

**관계 정의**

| 번호 | 관계             | 관계가 설정된 이유                                 |
|------|------------------|---------------------------------------------------|
| 1    | 사용자:주문      | 1:0 ~ n (주문을 하지 않거나 여러 개를 하는 경우)      |
| 2    | 사용자:장바구니  | 1:1 (사용자마다 장바구니는 하나만)                 |
| 3    | 상품:주문        | N:M (하나의 주문에 여러 상품이 포함 가능, 한 상품이 여러 주문에 들어갈 수 있음) |
| 4    | 상품:옵션        | 1:1 (하나의 상품에 무조건 하나의 옵션이 포함) |
| 5    | 주문:장바구니    | 0~n:1 (장바구니는 유저당 하나씩 가지고 이 장바구니에는 여러 주문이 포함 될 수 있다) |
| 6    | 결제:주문        | 1:1~n (결제를 하려면 하나의 주문이 필요하고 여러 주문을 결제 가능) |


**중간 테이블 사용**

- 일반적으로 다대다 관계에서 사용하면 

**상품과 주문 n:m 관계**

먼저 상품과 주문에서 중간테이블을 사용하면 어떤 상품이 어떤 주문에 속해있고 
같은 주문에 어떤 상품들이 포함되어 있는지 이 상품의 옵션이 무엇인지를 쉽게 확인할 수 있어 중간테이블을 사용한다


**설정한 관계를 바탕으로 그린 ERD(draw.io)**
![image](https://github.com/user-attachments/assets/7ab9c9ab-8cbc-4872-a5a6-257640446134)


![image](https://github.com/user-attachments/assets/f2db2062-dac4-4171-adc7-e8d6c2af9505)


**테이블 설계 후 GPT를 통해 각 데이터를 입력한 결과**

편의상 테이블이 나열되는 순서대로 유저는 1000번대, 상품은 2000번대, 옵션은 3000번대를   
기본키로 설정하여 어떤 테이블에 어떤 내용이 들어갈지 임의로 가시화했다   


**API 설계를 위한 기능 정리**

기본적으로 등록(생성), 조회, 수정, 삭제를 기반으로 동작한다.   
그리고 필요한 기능들을 속속들이 추가해본다.   

-- 성공 및 실패 간의 http status를 반환하도록 설계 

**사용자 관련기능** 
- 회원가입(사례 적기)
- 로그인(사례 적기)
- 유저 정보 조회
- 회원 정보 수정
- 회원 탈퇴

-> ( 로그인에는 서버가 사용자를 인증한 후 보내주는 JWT 형식의 토큰이 응답에 포함되어야 한다)   

**상품 관련 기능**
- 상품 등록
- 상품 검색
- 상품 전체 조회(1페이지에 10개 정도)
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


전달해야하는 값을 JSON 데이터의 형식은 잘 몰라서 위와 같은 형식으로 대부분 작성한 후 gpt를 통해   
json의 형식으로 변경했다 위 데이터는 상품 등록 시 들어가야하는 데이터이다

```

중요한 상태 코드 정리

1. **200 (OK)**: 클라이언트의 요청이 성공적으로 처리되었음을 나타냅니다. 이는 주로 GET 요청에 대한 성공적인 응답을 나타냅니다.
2. **201 (Created)**: 서버가 요청을 성공적으로 처리하여 새로운 리소스를 생성했음을 나타냅니다. 주로 POST 요청에 대한 응답으로 사용됩니다.
3. **204 (No Content)**: 서버가 요청을 성공적으로 처리했지만, 클라이언트에게 컨텐츠를 반환하지 않는다는 것을 나타냅니다. 주로 DELETE 요청에 대한 응답으로 사용됩니다.
4. **400 (Bad Request)**: 클라이언트의 요청이 서버에서 처리할 수 없는 잘못된 요청 형식이거나 구문 오류가 있음을 나타냅니다.
5. **401 (Unauthorized)**: 클라이언트가 인증되지 않았거나 인증 정보가 유효하지 않음을 나타냅니다.
6. **403 (Forbidden)**: 클라이언트가 요청한 리소스에 대한 액세스 권한이 없음을 나타냅니다.
7. **404 (Not Found)**: 클라이언트가 요청한 리소스가 서버에서 찾을 수 없음을 나타냅니다.
8. **500 (Internal Server Error)**: 서버에서 처리 중에 오류가 발생하여 요청을 완료할 수 없음을 나타냅니다. 일반적으로 이 오류는 서버 측에서 발생한 예기치 않은 오류로 인해 발생합니다.





