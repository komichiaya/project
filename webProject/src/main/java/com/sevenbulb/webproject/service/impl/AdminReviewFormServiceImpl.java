package com.sevenbulb.webproject.service.impl;

import com.sevenbulb.webproject.common.ServiceResultEnum;
import com.sevenbulb.webproject.dao.AdminReviewFormMapper;
import com.sevenbulb.webproject.entity.UserForm;
import com.sevenbulb.webproject.service.AdminReviewFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminReviewFormServiceImpl implements AdminReviewFormService {

    @Autowired
    private AdminReviewFormMapper adminReviewFormMapper;
    @Override
    public String updateFormInfo(UserForm form) {
        UserForm temp = adminReviewFormMapper.selectByPrimaryKey(form.getFormId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        //form.setUpdateTime(new Date());
        if (adminReviewFormMapper.updateByPrimaryKeySelective(form) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public UserForm getFormInfoById(Long id) {
        return adminReviewFormMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean batchUpdateReviewStatus(Long id, int formStatus) {
        return adminReviewFormMapper.batchFormStatus(id, formStatus) > 0;
    }

    @Override
    public List<UserForm> getFormInfoPage() {
        List<UserForm> goodsList = adminReviewFormMapper.findFormList();
        return goodsList;
    }


}
