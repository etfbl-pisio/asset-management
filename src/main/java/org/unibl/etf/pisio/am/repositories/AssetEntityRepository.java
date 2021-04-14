package org.unibl.etf.pisio.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.am.models.entities.AssetEntity;

public interface AssetEntityRepository extends JpaRepository<AssetEntity, Integer> {
}
