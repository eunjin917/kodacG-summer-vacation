    package com.example.week02.Dtos;
    import com.example.week02.Entity.User;

    //- 회원가입(사례 적기)
    //- 로그인(사례 적기)
    //- 유저 정보 조회
    //- 회원 정보 수정
    //- 회원 탈퇴

    import com.example.week02.Entity.User;
    import lombok.Getter;

    import java.time.LocalDateTime;

    public class UserDto {


        // 회원가입 얘도 그러면 그냥 레코드로 쓸까..?
        @Getter
        public static class userSign{

            private final String userName;
            private final String password;
            private final String email;
            private final LocalDateTime signDate;

            public userSign(User user){
                this.userName = user.getName();
                this.password = user.getPassword();
                this.email = user.getEmail();
                this.signDate = user.getSignDate();

            }

        }

        // 로그인
        @Getter
        public static class userLogin{

            public final String email;
            public final String password;

            public userLogin(String email, String password){
                this.email = email;
                this.password = password;
            }

        }

        // 유저 정보 조회
        @Getter
        public static class userDto{
            private final String userName;
            private final String email;
            private final LocalDateTime signDate;

            public userDto(User user){
                userName = user.getName();
                email = user.getEmail();
                signDate = LocalDateTime.now();
            }

        }

        // 유저 수정
        @Getter
        public static class userUpdate{

            private final String userName;
            private final String email;

            public userUpdate(String userName, String email){
                this.userName = userName;
                this.email = email;
            }

        }
        // 회원 탈퇴
        @Getter
        public static class userOut{
            private final String userName;
            private final String email;

            public userOut(String userName, String email){
                this.userName = userName;
                this.email = email;
            }
        }

    }