package com.byefan.xhoa.entity.media;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;

@Table(name = "t_media_industry")
public class Industry implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    private String name;

    private Integer mediaTypeId;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Integer mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}