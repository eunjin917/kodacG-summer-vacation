
### 1주차 - ERD, API 설계
| 여기에 작성해주세요

### 2주차 - 상품 관련 DTO 및 ENTITY 구현


**ERD 재설계**
![image](https://github.com/user-attachments/assets/edab4b0e-b0e0-428f-b087-73115e5e8fc0)


-> 확실히 엔티티와 DTO를 작성하면서 조금 보완이 되는 느낌이다. 계산된 필드는 제거했고 옵션은 등록을 위해서 남겨두었다

**반정규화**

- 시스템의 성능향상과 개발과 운영의 단순화를 위해 중복, 통합, 분리 등을 수행하는 데이터 모델링의 기법
- 저의 경우는 상품테이블에 할인율이라는 속성을 계산된 필드로 사용했습니다

-> 할인가가 자주 변동된다면 계산된 필드를 사용하는 것이 좋을 수도 있지만 그렇지 않다면 그저 가격만 저장해도 될 것 같아 제거함.

**API 재설계**

1. 각각의 요청에 대한 상태코드를 반환   
2. 실패하는 경우에 상황을 특정하자
3. 요청으로 필요한 값을 모두 전달하자   
4. 페이지 조회 기능... 추가해보자   


**API 수정**

[https://www.notion.so/pusan-dev/2-API-42133cdcdb894e11b8ec17ec32c0ebe4](https://www.notion.so/pusan-dev/2-API-42133cdcdb894e11b8ec17ec32c0ebe4)



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

 **record**    
- record는 get, toString, tohashcode, equals등의 메소드를 지원하고 모든 필드를 초기화하는 생성자를    자동으로 생성해 준다
- record가 가지는 필드는 불변으로 생성자를 통해 값을 저장하고 나면 바뀌지 않는다
- 실제 클래스를 작성하는 것보다 간단하고 편리하다(직접 작성해 보니 그렇다)



**Entity 설계 과정**

- 엔티티가 가질 속성을 정의   
- 데이터의 무결성 조건을 정의 (ex nullable = false, uniqueConstraints = @UniqueConstraint(name = " uk_variable_name", ColumnNames = "variable_name")
- 기본키 생성(IDENTITY 전략 선택)
- 각 엔티티의 관계에 따라 @ManyToOne, @OneToMany 등의 관계를 정의, 각 엔티티에서 양방향으로 정의
- 객체 생성 패턴으로 @Builder 선택(체이닝 형식으로 객체를 생성하여 가독성이 높고 편리하다)

**DTO 설계 과정**

처음에는 각각의 기능에 따른 클래스를 선언하여 필요한 것들을 필드로 가지고, 생성자를 통해서만 값을 지정하는 방식으로 설계했다    
-> 추후에 레코드를 사용하여 코드를 수정했다.  

- 엔티티 객체를 매개변수로 받아 getter를 통해 생성자에 값을 저장
- 한번씩 로그인과 같이 필요한 매개변수가 정해져 있는 경우에는 이메일, 비밀번호만 매개변수로 한 생성자를 만듬  
- 각각의 엔티티 간의 관계에 유념해서 외래키로 값을 가지고 오는 경로를 확인
- 클래스의 필드는 불변 객체로, 값을 변경하는 것은 생성자를 통해서만   

**과제 진행하면서 잘 모르겠는 것** 

사용자 Dto를 예시로 들겠습니다.
```

public record loginUser(String email, String password){
            public loginUser(User user){
                this(user.getEmail(),user.getPassword());
            }

// 위 레코드에서는 엔티티 객체를 생성자의 매개변수로 받아 get 메소드를 통해서 값을 저장하고 있고 

@Getter
        public static class userLogin{

            public final String email;
            public final String password;

            public userLogin(String email, String password){
                this.email = email;
                this.password = password;
            }

        }

/*
하단의 정적 클래스는 로그인에 필요한 값만 생성자의 매개변수로 받아서 값을 저장한다
이때 엔티티를 통해서 위와 같이 값을 가져오는 것이 맞는지 사용자의 입장에서 아래 코드와 같이 작성하는 것이
맞는지 둘중 어느 방식이 사용되어야 하는지 잘 모르겠다.... 그래서 일단은 전반적으로 DTO에 두가지 양식을 모두 작성했다.
*/

```
  



