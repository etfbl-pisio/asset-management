package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.base.CrudJpaService;
import org.unibl.etf.pisio.am.exceptions.ConflictException;
import org.unibl.etf.pisio.am.models.Asset;
import org.unibl.etf.pisio.am.models.entities.AssetEntity;
import org.unibl.etf.pisio.am.repositories.AssetEntityRepository;
import org.unibl.etf.pisio.am.services.AssetService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssetServiceImpl extends CrudJpaService<AssetEntity, Integer> implements AssetService {
    private final ModelMapper modelMapper;
    private final AssetEntityRepository repository;

    public AssetServiceImpl(ModelMapper modelMapper, AssetEntityRepository repository) {
        super(repository, modelMapper, AssetEntity.class);
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByIdentifier(getModelMapper().map(object, getEntityClass()).getIdentifier()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByIdentifierAndIdNot(getModelMapper().map(object, getEntityClass()).getIdentifier(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

    @Override
    public List<Asset> getAllAssetsByLocationId(Integer id) {
        return repository.getAllByLocation_Id(id).stream().map(a -> modelMapper.map(a, Asset.class)).collect(Collectors.toList());
    }
}
