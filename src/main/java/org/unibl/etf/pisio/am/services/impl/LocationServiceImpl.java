package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.Location;
import org.unibl.etf.pisio.am.models.SingleLocation;
import org.unibl.etf.pisio.am.repositories.LocationEntityRepository;
import org.unibl.etf.pisio.am.services.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final ModelMapper modelMapper;

    private final LocationEntityRepository repository;

    public LocationServiceImpl(LocationEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll().stream().map(l->modelMapper.map(l,Location.class)).collect(Collectors.toList());
    }

    @Override
    public SingleLocation findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleLocation.class);
    }
}
