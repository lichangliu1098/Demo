package com.stu.springAop;

public class DynamicTest {
    public static void main(String[] args){
        ITalk iTalk = (ITalk)new DyniamicProxy().bind(new PeopleTalk());
         iTalk.talk("业务说明");
    }
}
