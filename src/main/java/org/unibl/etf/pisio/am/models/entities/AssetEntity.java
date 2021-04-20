package org.unibl.etf.pisio.am.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asset")
public class AssetEntity {
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

}
