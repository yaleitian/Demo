package com.springmvc.dao;


import com.springmvc.entity.WorkCard;

public interface WokCardDao {

    public WorkCard getWorkCardByEmpId(Long empId);
}
