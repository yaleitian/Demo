package com.springmvc.dao;

import com.springmvc.entity.FemaleHealthForm;

public class FemalethHealthFormDao {
    public interface FemaleHealthFormMapper {
        public FemaleHealthForm getFemaleHealthForm(Long empId);
    }

}
