package com.example.mutiple.service;

import com.example.mutiple.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;

    public String idCheck(String userid) {
        int result = loginMapper.idCheck(userid);

        String str = "";
        if(result > 0) {
            str = "No";
        }else {
            str = "Yes";
        }

        return str;
    }
}
