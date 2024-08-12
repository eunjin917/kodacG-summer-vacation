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


        // 추후에 레코드로 작성하기
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
        public static class userInfo{
            private final int userId;
            private final String userName;
            private final String email;
            private final LocalDateTime signDate;

            public userInfo(User user){
                userId = user.getUserId();
                userName = user.getName();
                email = user.getEmail();
                signDate = LocalDateTime.now();
            }

        }

        // 유저 수정
        @Getter
        public static class userUpdate{

            private final int userId;
            private final String email;

            public userUpdate(int userId, String email){
                this.userId = userId;
                this.email = email;
            }

        }
        // 회원 탈퇴
        @Getter
        public static class userOut{

            private final int userId;

            public userOut(int userId){
                this.userId = userId;

            }
        }

        // 회원가입
        public record signUser(String userName, String password, String email){
            public signUser(User user){
                this(user.getName(),user.getPassword(),user.getEmail());
            }
        }
        // 로그인
        public record loginUser(String email, String password){
            public loginUser(User user){
                this(user.getEmail(),user.getPassword());
            }

        }
        // 유저 정보 조회
        public record infoUser(int userId, String userName, String email, LocalDateTime signDate){
            public infoUser(User user){
                this(user.getUserId(),user.getName(), user.getEmail(),user.getSignDate());
            }
        }

        // 유저 정보 수정
        public record updateUser(int userId, String email){
            public updateUser(User user){
                this(user.getUserId(), user.getEmail());
            }
        }
        // 회원 탈퇴

        public record deleteUser(int userId){
            public deleteUser(User user){
                this(user.getUserId());
            }
        }
    }