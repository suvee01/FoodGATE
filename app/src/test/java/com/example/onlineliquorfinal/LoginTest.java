package com.example.onlineliquorfinal;

import com.example.onlineliquorfinal.bll.LoginBLL;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void LoginTest(){
        LoginBLL loginBLL=new LoginBLL("suve123","suve123");
        boolean result= loginBLL.checkUser();
        assertEquals(true,result);

    }



    }

