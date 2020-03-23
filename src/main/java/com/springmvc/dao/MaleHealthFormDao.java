package com.springmvc.dao;

import com.springmvc.entity.MaleHealthForm;

public class MaleHealthFormDao {
    public interface MaleHealthFormMapper {
        public MaleHealthForm getMaleHealthForm(Long empId);
    }
}
