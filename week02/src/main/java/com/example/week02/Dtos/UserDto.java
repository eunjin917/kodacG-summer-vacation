package com.example.week02.Dtos;


//- 회원가입(사례 적기)
//- 로그인(사례 적기)
//- 유저 정보 조회
//- 회원 정보 수정
//- 회원 탈퇴

import com.example.week02.Entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

public class UserDto {
    

    // 회원가입
    @Getter
    public class userSign{

        private String userName;
        private String password;
        private String email;
        private LocalDateTime signDate;

        public userSign(User user){
            this.userName = user.getName();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.signDate = user.getSignDate();

        }

    }
    
    // 로그인
    @Getter
    public class userLogin{

        public String email;
        public String password;

        public userLogin(String email, String password){
            this.email = email;
            this.password = password;
        }

    }

    // 유저 정보 조회
    @Getter
    public class userDto{
        private String userName;
        private String email;
        private LocalDateTime signDate;

        public userDto(User user){
            userName = user.getName();
            email = user.getEmail();
            signDate = LocalDateTime.now();
        }

    }

    // 유저 수정
    @Getter
    public class userUpdate{

        private String userName;
        private String email;

        public userUpdate(String userName, String email){
            this.userName = userName;
            this.email = email;
        }

    }
    // 회원 탈퇴
    @Getter
    public class userOut{
        private String userName;
        private String email;

        public userOut(String userName, String email){
            this.userName = userName;
            this.email = email;
        }
    }



}