package com.springmvc.controller;

import com.springmvc.dao.EmployeeDao;
import com.springmvc.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import test.SqlSessionFactoryUtils;


public class TestAssocition {

        public static void main(String[] args) {
            testPdFindRole();
        }

        public static void testPdFindRole() {
            SqlSession sqlSession = null;
            try {
                Logger logger = Logger.getLogger(TestAssocition.class);
                sqlSession = SqlSessionFactoryUtils.openSqlSession();
                EmployeeDao employeeDao = sqlSession.getMapper( EmployeeDao.class );
                Employee employee = employeeDao.getEmployee( 1L );
                logger.info(employee.getBirthday());
            }catch(Exception ex) {
                ex.printStackTrace();
            }finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
        }

}
