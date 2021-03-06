package org.unibl.etf.pisio.am.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.dto.Asset;
import org.unibl.etf.pisio.am.models.dto.Location;
import org.unibl.etf.pisio.am.models.dto.SingleLocation;
import org.unibl.etf.pisio.am.models.requests.LocationRequest;
import org.unibl.etf.pisio.am.services.AssetService;
import org.unibl.etf.pisio.am.services.LocationService;

import javax.validation.Valid;
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
    public List<Location> findAll() {
        return locationService.findAll(Location.class);
    }

    @GetMapping("/{id}")
    public SingleLocation findById(@PathVariable Integer id) throws NotFoundException {
        return locationService.findById(id, SingleLocation.class);
    }

    @GetMapping("/{id}/assets")
    @ApiOperation(value = "Returns all assets related to supplied location")
    public List<Asset> getAllAssetsByLocationId(@ApiParam(value = "Location ID", required = true) @PathVariable Integer id) {
        return assetService.getAllAssetsByLocationId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SingleLocation insert(@RequestBody @Valid LocationRequest location) throws NotFoundException {
        return locationService.insert(location, SingleLocation.class);
    }

    @PutMapping("/{id}")
    public SingleLocation update(@PathVariable Integer id, @RequestBody @Valid LocationRequest location) throws NotFoundException {
        return locationService.update(id, location, SingleLocation.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        locationService.delete(id);
    }


}
