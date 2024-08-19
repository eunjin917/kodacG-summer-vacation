
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












-> 초기설정에 스프링 시큐리티가 적용되어 있어 로그인 페이지로 계속 리다이렉트 되는 현상이 발생해서 제거했다 






