package com.ry.xk.studentexamresult.bo;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;
import io.protostuff.Tag;

import java.util.List;

/**
 * 错题本
 */
public class WrongBook implements ICouchBaseStoredObject {
    /**
     * 用户ID
     */
    @Tag(1)
    private int userId;
    /**
     * 科目ID
     */
    @Tag(2)
    private int courseId;
    /**
     * 错题列表
     */
    @Tag(3)
    private List<WrongQuestion> wrongQuestions;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<WrongQuestion> getWrongQuestions() {
        return wrongQuestions;
    }

    public void setWrongQuestions(List<WrongQuestion> wrongQuestions) {
        this.wrongQuestions = wrongQuestions;
    }

    public static String _key = "WrongBook_%s_%s";

    @Override
    public String key() {
        return String.format(keyFormat(), userId,courseId);
    }

    @Override
    public String keyFormat() {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection() {
        return CouchBaseSectionType.EXAMRESULT;
    }
}
