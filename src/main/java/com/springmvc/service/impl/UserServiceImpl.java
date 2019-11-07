package com.springmvc.service.impl;

import com.springmvc.controller.UpLoadOnTroller;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.apache.log4j.Logger;
import com.springmvc.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yalei.tian on 2018-01-16
 * 用户service实现类
 * @author lees
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    static Logger logger = Logger.getLogger( UpLoadOnTroller.class );
	@Resource(name = "UserDao")
	private UserDao userDao;

	@Override
	public User findByUsernameAndPwd(String name, String pwd) {

		return userDao.findByUsernameAndPwd(name, pwd);
	}

	@Override
	public List<User> find(User user){

		return userDao.find(user);
	}


	@Override
	public void add(User user) {

		userDao.add(user);
	}
	
	@Override
	public void update(User user) {

		userDao.update(user);
	}

	@Override
	public void delete(String id) {

		userDao.delete(id);
	}

    @Override
    public void beginUpload(MultipartFile file) {
        if (!file.isEmpty()) {
            logger.debug( "upload file : {}" + file.getOriginalFilename() );
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File( "/Users/tianyalei/Downloads/work/ ",System.currentTimeMillis() + file.getOriginalFilename() ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}