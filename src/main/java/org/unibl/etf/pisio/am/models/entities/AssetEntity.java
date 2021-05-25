package org.unibl.etf.pisio.am.models.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.unibl.etf.pisio.am.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "asset")
@EntityListeners(AuditingEntityListener.class)
public class AssetEntity implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "identifier", nullable = false, length = 50)
    private String identifier;
    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private LocationEntity location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id", referencedColumnName = "id", nullable = false)
    private AssetTypeEntity assetType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_status_id", referencedColumnName = "id", nullable = false)
    private AssetStatusEntity assetStatus;
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private Date createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private Date modifiedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    @JoinColumn(name = "created_by", referencedColumnName = "id", updatable = false)
    private UserEntity createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

}
