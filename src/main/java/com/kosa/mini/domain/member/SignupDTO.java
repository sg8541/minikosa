package com.kosa.mini.domain.member;

import lombok.Data;

@Data
public class SignupDTO {
   private String name;
   private String email;
   private String nickname;
   private String password;
   private String phone_number;

}

