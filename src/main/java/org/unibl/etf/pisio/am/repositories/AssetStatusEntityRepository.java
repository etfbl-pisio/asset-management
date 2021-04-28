package org.unibl.etf.pisio.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.am.models.entities.AssetStatusEntity;

public interface AssetStatusEntityRepository extends JpaRepository<AssetStatusEntity, Integer> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Integer id);
}
