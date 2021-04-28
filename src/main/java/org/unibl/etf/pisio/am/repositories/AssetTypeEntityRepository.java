package org.unibl.etf.pisio.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.am.models.entities.AssetTypeEntity;

public interface AssetTypeEntityRepository extends JpaRepository<AssetTypeEntity, Integer> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Integer id);
}
