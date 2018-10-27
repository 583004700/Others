package com.ry.xk.studentexamresult.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.WrongBook;

@Component
public interface IWrongBookDao
{
    /**
     * 获取用户错题本
     * 
     * @param userId
     * @param courseId
     * @return
     */
    public WrongBook get(int userId, int courseId);

    /**
     * 更新错题本
     * 
     * @param wrongBook
     * @return
     */
    public boolean update(WrongBook wrongBook);
}
