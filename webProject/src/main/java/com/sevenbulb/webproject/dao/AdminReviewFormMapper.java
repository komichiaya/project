package com.sevenbulb.webproject.dao;

import com.sevenbulb.webproject.entity.UserForm;

import java.util.List;

public interface AdminReviewFormMapper {
    /**
     * 根据主键id获取记录
     * @param formId
     * @return
     */
    UserForm selectByPrimaryKey(Long formId);

    /**
     * 修改一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserForm record);

    int batchFormStatus(Long id, int formStatus);
    /**
     * 查询form数据
     * @param
     * @return
     */
    List<UserForm> findFormList();
}
