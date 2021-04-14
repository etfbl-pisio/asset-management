package org.unibl.etf.pisio.am.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.am.models.entities.AssetEntity;
import org.unibl.etf.pisio.am.repositories.AssetEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetEntityRepository repository;

    public AssetController(AssetEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<AssetEntity> findAll(){
        return repository.findAll();
    }
}
