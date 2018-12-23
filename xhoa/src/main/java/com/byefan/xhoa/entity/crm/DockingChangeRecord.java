package com.byefan.xhoa.entity.crm;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 对接人变更记录
 */
@Table(name = "t_crm_docking_change_record")
public class DockingChangeRecord implements Serializable{
    @Id
    @Column(name = "id")
    private Integer id;
    //对接人ID，外键
    @Column(name = "docking_id")
    private Integer dockingId;
    //当前负责人
    @Column(name = "current_worker")
    private Integer currentWorker;
    //新的负责人
    @Column(name = "new_worker")
    private Integer newWorker;
    //变更时间
    @Column(name = "change_time")
    private Date changeTime;
    //备注
    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDockingId() {
        return dockingId;
    }

    public void setDockingId(Integer dockingId) {
        this.dockingId = dockingId;
    }

    public Integer getCurrentWorker() {
        return currentWorker;
    }

    public void setCurrentWorker(Integer currentWorker) {
        this.currentWorker = currentWorker;
    }

    public Integer getNewWorker() {
        return newWorker;
    }

    public void setNewWorker(Integer newWorker) {
        this.newWorker = newWorker;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DockingChangeRecord that = (DockingChangeRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dockingId != null ? !dockingId.equals(that.dockingId) : that.dockingId != null) return false;
        if (currentWorker != null ? !currentWorker.equals(that.currentWorker) : that.currentWorker != null)
            return false;
        if (newWorker != null ? !newWorker.equals(that.newWorker) : that.newWorker != null) return false;
        if (changeTime != null ? !changeTime.equals(that.changeTime) : that.changeTime != null) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dockingId != null ? dockingId.hashCode() : 0);
        result = 31 * result + (currentWorker != null ? currentWorker.hashCode() : 0);
        result = 31 * result + (newWorker != null ? newWorker.hashCode() : 0);
        result = 31 * result + (changeTime != null ? changeTime.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
