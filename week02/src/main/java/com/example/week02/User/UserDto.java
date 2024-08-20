    package com.example.week02.User;


    // DTO에는 로직을 포함시키지 않는다 그저 전송할 데이터만을 담는다
    // 비밀번호와 같은 민감한 데이터는 포함시키지 않는다.

    import java.time.LocalDateTime;

    // 엔티티 객체를 통해서 Get 메소드로 값을 저장하는 방식


        public record UserDto(

                int userId,
                String userName,
                String email,
                LocalDateTime signDate){

            public UserDto(User user){

                this(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail(),
                        user.getSignDate());
            }
        }


