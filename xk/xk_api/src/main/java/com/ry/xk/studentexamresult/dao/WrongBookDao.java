package com.ry.xk.studentexamresult.dao;

import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.studentexamresult.bo.WrongBook;
import com.ry.xk.studentexamresult.bo.WrongQuestion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WrongBookDao implements IWrongBookDao
{
    /**
     * 获取用户错题本
     * 
     * @param userId
     * @param courseId
     * @return
     */
    @Override
    public WrongBook get(int userId, int courseId)
    {
        WrongBook wrongBook = new WrongBook();
        wrongBook.setUserId(userId);
        wrongBook.setCourseId(courseId);
        WrongBook userWrongBook = CouchBaseFactory.get(wrongBook.getClass(), wrongBook.key());
        if(userWrongBook == null){
            userWrongBook = new WrongBook();
            userWrongBook.setCourseId(courseId);
            userWrongBook.setUserId(userId);
        }
        if(userWrongBook.getWrongQuestions() == null) {
            userWrongBook.setWrongQuestions(new ArrayList<WrongQuestion>());
        }
        List<WrongQuestion> availabilityWrongQuestions = userWrongBook.getWrongQuestions().stream().filter(o->o.getStatusFlag() == 1).collect(Collectors.toList());
        userWrongBook.setWrongQuestions(availabilityWrongQuestions);
        return userWrongBook;
    }

    @Override
    public boolean update(WrongBook wrongBook)
    {
        return CouchBaseFactory.update(wrongBook);
    }
}
