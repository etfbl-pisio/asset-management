package org.unibl.etf.pisio.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.am.models.entities.LocationEntity;

public interface LocationEntityRepository extends JpaRepository<LocationEntity, Integer> {
}
