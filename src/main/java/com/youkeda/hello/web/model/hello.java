package com.youkeda.hello.web.model;

//import java.util.ArrayList;

//作用域 class关键词 类名
public class hello {
    //方法、属性等
    //ArrayList arrayList = new ArrayList();
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        sayHello();
        hello wenwen = new hello();
        System.out.println(wenwen.demo("hi"));
    }

    //权限 返回值 方法名 参数类型 参数名
    public String demo(String mes){
        //方法体
        return mes;
    }
    public static void sayHello(){
        System.out.println("HelloWorld");
    }
}
