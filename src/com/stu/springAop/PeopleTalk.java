package com.stu.springAop;

import org.omg.CORBA.SystemException;

import javax.lang.model.element.NestingKind;
import java.awt.*;

public class PeopleTalk implements ITalk{

    public String username;
    private String age;

    public PeopleTalk(){

    }

    public PeopleTalk(String username, String age){
        this.username = username;
        this.age = age;
    }

    public void talk(String msg){
        System.out.println(msg+"你好，我是"+username +"我年龄是"+age);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
