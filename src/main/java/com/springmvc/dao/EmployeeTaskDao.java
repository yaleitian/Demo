package com.springmvc.dao;


import com.springmvc.entity.EmployeeTask;

public interface EmployeeTaskDao {

    public EmployeeTask getEmployeeTaskByEmpId(Long empId);
}
