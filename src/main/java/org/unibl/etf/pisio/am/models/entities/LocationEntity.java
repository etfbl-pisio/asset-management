package org.unibl.etf.pisio.am.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.unibl.etf.pisio.am.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "location")
public class LocationEntity implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "latitude", nullable = false, precision = 6)
    private BigDecimal latitude;
    @Basic
    @Column(name = "longitude", nullable = false, precision = 6)
    private BigDecimal longitude;
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<AssetEntity> assets;

}
