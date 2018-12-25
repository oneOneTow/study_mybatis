package com.vens.study.mybatis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/11/12
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    List<Object> collapseSingleResultList(List<Object> multipleResults) {
        return multipleResults.size() == 1 ? (List<Object>) multipleResults.get(0) : multipleResults;
    }

    public static void main(String[] args) {
        List<Object> list=new ArrayList<Object>();
        List<Object> list1=new ArrayList<Object>();

        list1.add("sdfsdf");
        list.add(list1);
        List<Object> a=new User().collapseSingleResultList(list);
        System.out.println(a);
    }
}
