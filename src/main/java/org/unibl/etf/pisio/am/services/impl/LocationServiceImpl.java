package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.base.CrudJpaService;
import org.unibl.etf.pisio.am.models.entities.LocationEntity;
import org.unibl.etf.pisio.am.repositories.LocationEntityRepository;
import org.unibl.etf.pisio.am.services.LocationService;

import javax.transaction.Transactional;

@Service
@Transactional
public class LocationServiceImpl extends CrudJpaService<LocationEntity, Integer> implements LocationService {

    public LocationServiceImpl(LocationEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, LocationEntity.class);
    }


}
