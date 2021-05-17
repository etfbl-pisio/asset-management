package org.unibl.etf.pisio.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.pisio.am.models.AssetNameType;
import org.unibl.etf.pisio.am.models.entities.AssetEntity;

import java.util.List;

public interface AssetEntityRepository extends JpaRepository<AssetEntity, Integer> {
    List<AssetEntity> getAllByLocation_Id(Integer id);

    @Query("SELECT new org.unibl.etf.pisio.am.models.AssetNameType(a.name,a.assetType.name) from AssetEntity a")
    List<AssetNameType> getAllNameTypes();

    Boolean existsByIdentifier(String identifier);
    Boolean existsByIdentifierAndIdNot(String identifier,Integer id);

}
