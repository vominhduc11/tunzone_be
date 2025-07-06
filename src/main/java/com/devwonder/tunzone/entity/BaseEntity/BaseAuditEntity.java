package com.devwonder.tunzone.entity.BaseEntity;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditEntity implements Serializable {
    // Tự động ghi lại thời điểm đầu tiên khi entity được tạo (persist lần đầu).
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    // Ghi thời gian lần cuối cùng entity được thay đổi.
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    //  Ghi thông tin tên người tạo.
    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    // Ghi ra tên người cuối cùng sửa (update) bản ghi.
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}
