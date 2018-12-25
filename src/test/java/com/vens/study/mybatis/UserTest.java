package com.vens.study.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/19
 */
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;
    private Reader reader;

    @Before
    public void init(){
        try {
            reader  = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.<UserMapper>getMapper(UserMapper.class);
            User user=userMapper.getById(1);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

   /* @Test
    public void testInsertUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User() ;
            //����ֵ�Ǽ�¼����
            int resultCount = session.insert("com.zf.mybatis.pojo.UserMapper.add", user );
            session.commit() ;
            System.out.printf("userID:%d,�ܼ�¼����:%d" , user.getId() , resultCount);  //��ȡ��������id
        } finally {
            session.close();
        }
    }

    @Test
    public void testUpdateUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User() ;
            //����ֵ���޸�����
            int updateCount = session.update("com.zf.mybatis.pojo.UserMapper.update", user );
            session.commit() ;
            System.out.printf("�޸�����:%d" ,updateCount);
        } finally {
            session.close();
        }
    }

    @Test
    public void testDelete(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //����ֵ��ɾ������
            int deleteCount = session.update("com.zf.mybatis.pojo.UserMapper.deleteById", 4 );
            session.commit() ;
            System.out.printf("ɾ������:%d" ,deleteCount );
        } finally {
            session.close();
        }
    }*/
}
