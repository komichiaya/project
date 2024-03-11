package com.sevenbulb.webproject.service;

import com.sevenbulb.webproject.entity.UserForm;

import java.util.List;

public interface AdminReviewFormService {
    /**
     * 修改商品信息
     *
     * @param form
     * @return
     */
    String updateFormInfo(UserForm form);

    /**
     * 获取表单详情
     *
     * @param id
     * @return
     */
    UserForm getFormInfoById(Long id);

    /**
     * 修改审核状态(通过，不通过)
     *
     * @param id
     * @return
     */
    Boolean batchUpdateReviewStatus(Long id,int formStatus);
    /**
     * 获取所有form表单
     *
     * @param
     * @return
     */
    List<UserForm> getFormInfoPage();
}
