package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.base.CrudJpaService;
import org.unibl.etf.pisio.am.models.entities.AssetTypeEntity;
import org.unibl.etf.pisio.am.services.AssetTypeService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AssetTypeServiceImpl extends CrudJpaService<AssetTypeEntity, Integer> implements AssetTypeService {
    public AssetTypeServiceImpl(JpaRepository<AssetTypeEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AssetTypeEntity.class);
    }
}
