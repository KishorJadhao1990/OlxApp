package com.zensar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zensar.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;
    @JsonIgnore
    private boolean deleted;

    public void setUU() {
        setUU(1L);
    }
    public void setCCUU() {
        this.deleted = false;
        setCCUU(1L);
    }
    public void setUU(Long userId) {
        this.updatedBy = userId;
        this.updatedAt = DateUtil.currentDateTimeInMillis();
    }
    public void setCCUU(Long userId) {
        this.deleted = false;
        setCCUU(userId, DateUtil.currentDateTimeInMillis());
    }
    public void setCCUU(Long userId, Long time) {
        this.deleted = false;
        this.createdBy = userId;
        this.updatedBy = userId;
        this.createdAt = time;
        this.updatedAt = time;
    }
}
