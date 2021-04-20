package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.Asset;
import org.unibl.etf.pisio.am.models.AssetRequest;
import org.unibl.etf.pisio.am.models.entities.AssetEntity;
import org.unibl.etf.pisio.am.repositories.AssetEntityRepository;
import org.unibl.etf.pisio.am.services.AssetService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {
    private final ModelMapper modelMapper;
    private final AssetEntityRepository assetEntityRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public AssetServiceImpl(ModelMapper modelMapper, AssetEntityRepository assetEntityRepository) {
        this.modelMapper = modelMapper;
        this.assetEntityRepository = assetEntityRepository;
    }

    @Override
    public List<Asset> findAll() {
        return assetEntityRepository.findAll().stream().map(a->modelMapper.map(a,Asset.class)).collect(Collectors.toList());
    }

    @Override
    public Asset findById(Integer id) throws NotFoundException {
        return modelMapper.map(assetEntityRepository.findById(id).orElseThrow(NotFoundException::new),Asset.class);
    }

    @Override
    public List<Asset> getAllAssetsByLocationId(Integer id) {
        return assetEntityRepository.getAllByLocation_Id(id).stream().map(a->modelMapper.map(a,Asset.class)).collect(Collectors.toList());
    }

    @Override
    public Asset insert(AssetRequest assetRequest) throws NotFoundException {
        AssetEntity assetEntity=modelMapper.map(assetRequest,AssetEntity.class);
        assetEntity.setId(null);
        assetEntity=assetEntityRepository.saveAndFlush(assetEntity);
        entityManager.refresh(assetEntity);
        return findById(assetEntity.getId());
    }

    @Override
    public Asset update(Integer id,AssetRequest assetRequest) throws NotFoundException {
        AssetEntity assetEntity=modelMapper.map(assetRequest,AssetEntity.class);
        assetEntity.setId(id);
        assetEntity=assetEntityRepository.saveAndFlush(assetEntity);
        entityManager.refresh(assetEntity);
        return findById(assetEntity.getId());
    }

    @Override
    public void delete(Integer id) {
        assetEntityRepository.deleteById(id);
    }
}
