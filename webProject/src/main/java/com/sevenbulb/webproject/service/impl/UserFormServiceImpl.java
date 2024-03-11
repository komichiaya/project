package com.sevenbulb.webproject.service.impl;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.dao.UserFormMapper;
import com.sevenbulb.webproject.entity.UserForm;
import com.sevenbulb.webproject.service.UserFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFormServiceImpl implements UserFormService {
    @Autowired
    private UserFormMapper userFormMapper;

    @Override
    public String saveUserForm(UserForm from) {
       if(userFormMapper.insertSelective(from) >0){
           return ServiceResultEnum.SUCCESS.getResult();
       }
       return ServiceResultEnum.DB_ERROR.getResult();
    }
}
