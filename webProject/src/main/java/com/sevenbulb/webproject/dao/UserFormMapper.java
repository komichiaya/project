package com.sevenbulb.webproject.dao;

import com.sevenbulb.webproject.entity.UserForm;

public interface UserFormMapper {
    /**
     * 保存一条新记录
     * @param record
     * @return
     */
    int insertSelective(UserForm record);

    /**
     * 根据主键id获取记录
     * @param goodsId
     * @return
     */
    UserForm selectByPrimaryKey(Long goodsId);

    /**
     * 修改一条记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserForm record);

}
