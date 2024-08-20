
### 1주차 - ERD, API 설계
| 여기에 작성해주세요

### 2주차 - 상품 관련 DTO 및 ENTITY 구현

### 3주차 - 특정 상품 조회 및 페이지별 상품 조회    

저번 과제에서 부터 작성한 DTO를 전반적으로 조회 시 필요한 정보만을 담도록 수정하였고    
등록 삭제 수정등의 로직은 전부 서비스에서 구현할 예정이다    

각 단의 역할을 명확하게 인지 못하고 있는 것 같아 먼저 역할부터 정리해 보았다    

**컨트롤러**
- URL을 통한 요청에 대한 응답을 반환하는 부분이다   
- 반드시 리턴값이 존재해야 하고 이번 컨트롤러 설계에서는 @RestController 어노테이션을 사용했다   


**서비스**   
- 리포지터리 인터페이스가 지원하는 메소드 및 인터페이스 내부에서 선언한 메소드를 통해 로직을 설계하는 부분   
- 엔티티를 DTO로 변환하는 과정도 포함한다   

**리포지터리**
- 기본적으로 데이터를 처리하는 기능을 가진 JPA 리포지터리를 상속받는 인터페이스   
- 어떤 엔티티의 기본키를 받아올 것인지 상속과 함께 정의한다   
- DB에서 데이터를 가져오고 저장하는 기능이 대다수이다


**구현할 기능** 

- 특정 상품을 조회하는 URL http://localhost:8080/products/{product_id} @Pathvariable을 통해서 값을 전달해야 URL의 경로로 인식된다     
- 전체 상품(페이지별)  URL http://localhost:8080/products?page = (param) JPA의 페이지네이션 기능을 통해 구현했다   



**컨트롤러, 서비스, 리포지터리 작성**   

데이터 조회간에 실제 DB가 연결되어 있지 않았기 때문에 h2 DB를 통해서 임의로 값을 저장했고 postman을 통한 조회 API에
어떤 데이터가 반환되고 어떤 상태코드가 반환되는 지를 주로 확인했다. 
![image](https://github.com/user-attachments/assets/98f0b7be-83b0-4b75-ba68-fa9e1629dd7b)
H2 DB에 값을 저장한 상태


**특정 상품 조회**

먼저 상품이 등록되어 있지 않을 경우   


위 사진처럼 h2데이터베이스에 상품을 등록한 경우 - postman   
![image](https://github.com/user-attachments/assets/a9a33843-c2d9-41f9-9725-95885629467f)
![image](https://github.com/user-attachments/assets/817a0542-c2ed-493a-a364-10bf51467fec)


**전체 상품 조회**   
param으로 들어가는 page 값은 0을 디폴트값으로 가지게 하고 jpa에서 지원하는 페이지네이션을 통해서 코드를 작성했다    
한 페이지에 10개의 상품이 들어가도록 했고 h2데이터베이스에 확인을 위해 총 11개의 상품을 등록했다    

page=0 첫번째 페이지 조회   
![image](https://github.com/user-attachments/assets/77fa981d-8f90-40a6-937c-96e51ced4540)
```
{    // 사진에는 데이터가 끝까지 나오지 않아 첨부했다 
    "content": [
        {
            "productId": 1,
            "productName": "상품 1",
            "productDesc": "설명",
            "image": "image1.jpg",
            "options": []
        },
        {
            "productId": 2,
            "productName": "상품 2",
            "productDesc": "설명",
            "image": "image2.jpg",
            "options": []
        },
        {
            "productId": 3,
            "productName": "상품 3",
            "productDesc": "설명",
            "image": "image3.jpg",
            "options": []
        },
        {
            "productId": 4,
            "productName": "상품 4",
            "productDesc": "설명",
            "image": "image4.png",
            "options": []
        },
        {
            "productId": 5,
            "productName": "상품 5",
            "productDesc": "설명",
            "image": "image5.png",
            "options": []
        },
        {
            "productId": 6,
            "productName": "상품 6",
            "productDesc": "설명",
            "image": "image6.png",
            "options": []
        },
        {
            "productId": 7,
            "productName": "상품 7",
            "productDesc": "설명",
            "image": "image7.png",
            "options": []
        },
        {
            "productId": 8,
            "productName": "상품 8",
            "productDesc": "설명",
            "image": "image8.png",
            "options": []
        },
        {
            "productId": 9,
            "productName": "상품 9",
            "productDesc": "설명",
            "image": "image9.png",
            "options": []
        },
        {
            "productId": 10,
            "productName": "상품 10",
            "productDesc": "설명",
            "image": "image10.png",
            "options": []
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 11,
    "totalPages": 2,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 10,
    "empty": false
}
```
page=1 두번째 페이지 조회   
![image](https://github.com/user-attachments/assets/2fd22173-395c-45ae-b811-e64bf2dd67af)



-> 초기설정에 스프링 시큐리티가 적용되어 있어 로그인 페이지로 계속 리다이렉트 되는 현상이 발생해서 제거했다 






