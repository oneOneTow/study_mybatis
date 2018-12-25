package com.vens.study.mybatis;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/19
 */
public interface UserMapper {
    User getById(int id);
    int add(User user);
}
