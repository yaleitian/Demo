package com.springmvc.dao;

import com.springmvc.entity.Employee;

public class EmployeeDao {
    public interface EmployeeMapper {
        public Employee getEmployee(Long id);

        public Employee getEmployee2(Long id);
    }

}
