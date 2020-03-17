package com.springmvc.dao;

import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yalei.tian on 2018-01-16
 * 用户dao接口.
 */
@Repository("UserDao")
public interface UserDao {

    /**
     * 	Created by yalei.tian on 2018-01-16
     * 	根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 	Created by yalei.tian on 2018-01-16
     * 	根据用户id
     * @param id
     * @return
     */
    public User findUserById(@Param("id") Integer id);

    /**
     * 	Created by yalei.tian on 2018-01-16
     * 	获取用户
     * @return
     */
    public List<User> find(User User);

    /**
     * 	Created by yalei.tian on 2018-01-16
     * 	新增
     * @param User
     */
    public void add(User User);

    /**
     * 	Created by yalei.tian on 2018-01-16
     * 	修改
     * @param User
     */
    public void update(User User);

    /**
     * 	Created yalei.tian on 2018-01-16
     * 	删除
     * @param id
     */
    public void delete(String id);
}