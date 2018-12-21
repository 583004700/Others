package com.byefan.xhoa.entity.workbench;

import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 */
@Table(name = "t_index_message")
public class Message implements Serializable{
    private Integer id;
    //图标
    private String pic;
    //内容
    private String content;
    //发起部门
    private Integer initiatorDept;
    //发起人
    private Integer initiatorWorker;
    //创建时间
    private Date createTime;
    //状态1未读2已读
    private Integer state;
    //接收部门
    private Integer acceptDept;
    //接收人
    private Integer acceptWorker;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getInitiatorDept() {
        return initiatorDept;
    }

    public void setInitiatorDept(Integer initiatorDept) {
        this.initiatorDept = initiatorDept;
    }

    public Integer getInitiatorWorker() {
        return initiatorWorker;
    }

    public void setInitiatorWorker(Integer initiatorWorker) {
        this.initiatorWorker = initiatorWorker;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAcceptDept() {
        return acceptDept;
    }

    public void setAcceptDept(Integer acceptDept) {
        this.acceptDept = acceptDept;
    }

    public Integer getAcceptWorker() {
        return acceptWorker;
    }

    public void setAcceptWorker(Integer acceptWorker) {
        this.acceptWorker = acceptWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (pic != null ? !pic.equals(message.pic) : message.pic != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (initiatorDept != null ? !initiatorDept.equals(message.initiatorDept) : message.initiatorDept != null)
            return false;
        if (initiatorWorker != null ? !initiatorWorker.equals(message.initiatorWorker) : message.initiatorWorker != null)
            return false;
        if (createTime != null ? !createTime.equals(message.createTime) : message.createTime != null) return false;
        if (state != null ? !state.equals(message.state) : message.state != null) return false;
        if (acceptDept != null ? !acceptDept.equals(message.acceptDept) : message.acceptDept != null) return false;
        return acceptWorker != null ? acceptWorker.equals(message.acceptWorker) : message.acceptWorker == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (initiatorDept != null ? initiatorDept.hashCode() : 0);
        result = 31 * result + (initiatorWorker != null ? initiatorWorker.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (acceptDept != null ? acceptDept.hashCode() : 0);
        result = 31 * result + (acceptWorker != null ? acceptWorker.hashCode() : 0);
        return result;
    }
}
