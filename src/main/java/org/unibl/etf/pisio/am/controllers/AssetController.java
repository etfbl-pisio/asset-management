package org.unibl.etf.pisio.am.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.Asset;
import org.unibl.etf.pisio.am.models.AssetRequest;
import org.unibl.etf.pisio.am.services.AssetService;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }


    @GetMapping
    List<Asset> findAll() {
        return assetService.findAll();
    }

    @GetMapping("/{id}")
    public Asset findById(@PathVariable Integer id) throws NotFoundException {
        return assetService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        assetService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Asset insert(@RequestBody AssetRequest assetRequest) throws NotFoundException {
        return assetService.insert(assetRequest);
    }

    @PutMapping("/{id}")
    public Asset update(@PathVariable Integer id, @RequestBody AssetRequest assetRequest) throws NotFoundException {
        return assetService.update(id, assetRequest);
    }
}
