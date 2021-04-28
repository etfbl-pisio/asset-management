package org.unibl.etf.pisio.am.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.unibl.etf.pisio.am.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "asset_status")
public class AssetStatusEntity implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @OneToMany(mappedBy = "assetStatus")
    @JsonIgnore
    private List<AssetEntity> assets;

}
