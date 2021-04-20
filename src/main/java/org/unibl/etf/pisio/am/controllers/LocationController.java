package org.unibl.etf.pisio.am.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.Asset;
import org.unibl.etf.pisio.am.models.Location;
import org.unibl.etf.pisio.am.models.SingleLocation;
import org.unibl.etf.pisio.am.models.entities.LocationEntity;
import org.unibl.etf.pisio.am.repositories.LocationEntityRepository;
import org.unibl.etf.pisio.am.services.AssetService;
import org.unibl.etf.pisio.am.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    private final AssetService assetService;

    public LocationController(LocationService locationService, AssetService assetService) {
        this.locationService = locationService;
        this.assetService = assetService;
    }

    @GetMapping
    public List<Location> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public SingleLocation findById(@PathVariable Integer id) throws NotFoundException {
        return locationService.findById(id);
    }

    @GetMapping("/{id}/assets")
    public List<Asset> getAllAssetsByLocationId(@PathVariable Integer id ){
        return assetService.getAllAssetsByLocationId(id);
    }

}
