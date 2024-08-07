
### 1주차 - ERD, API 설계
| 여기에 작성해주세요

### 2주차 - 상품 관련 DTO 및 ENTITY 구현
| https://scratch-library-74f.notion.site/1-aeba30e7970145119f5231c27c8b2d1d?pvs=4 (맨 아래에 DTO, Entity 예시를 작성했습니다.)

**ERD 재설계**
![image](https://github.com/user-attachments/assets/dfa490ef-3067-4faf-a443-ae44e1040bef)

-> 확실히 엔티티와 DTO를 작성하면서 조금 보완이 되는 느낌이다. 계산된 필드는 제거했고 옵션은 등록을 위해서 남겨두었다   

반정규화 

**API 재설계**

1. 각각의 요청에 대한 상태코드를 반환   
2. 실패하는 경우에 상황을 나타내자   
3. 요청으로 필요한 값을 모두 전달하자   
4. 페이지 조회 기능... 추가해보자   


**DTO(Data Transfer Object)**
- 데이터 전송 객체(필요한 데이터만 전달하기 위해 사용)   
- 엔티티가 가지는 민감한 정보는 노출하지 않기 위해 사용   
- 각 DTO 에는 필요한 정보만을 등록,조회,삭제,수정할 수 있도록 설계   
- 비즈니스 로직은 들어가면 안된다(서비스에서 처리)      
  
**Entity**
- 데이터 베이스에 직접 연결된 테이블
- 민감한 정보를 가지고 있어 사용에 주의(비밀번호, 주민등록번호)
- 엔티티는 데이터베이스 접근이 가능, 이것을 직접 조회하면 보안에 취약


-> 엔티티 대신 DTO를 사용하는 이유는 엔티티가 가지는 민감한 정보를 노출하지 않음과 동시에 필요한 정보만을 전달하기 위함이다   
    (엔티티의 크기가 클 경우 트래픽을 줄이는 용도로도 사용한다)   


**Entity 설계 과정**

1. 엔티티가 가질 속성을 정의   
2. 데이터의 무결성 조건을 정의 (ex nullable = false, uniqueConstraints = @UniqueConstraint(name = " uk_variable_name", ColumnNames = "variable_name")
3. 기본키 생성(IDENTITY 전략 선택)
4. 각 엔티티의 관계에 따라 @ManyToOne, @OneToMany 등의 관계를 정의, 각 엔티티에서 양방향으로 정의
5. 객체 생성 패턴으로 @Builder 선택


