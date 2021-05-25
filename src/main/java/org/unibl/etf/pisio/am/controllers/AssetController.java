package org.unibl.etf.pisio.am.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.dto.Asset;
import org.unibl.etf.pisio.am.models.requests.AssetRequest;
import org.unibl.etf.pisio.am.services.AssetService;

import javax.validation.Valid;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }


    @GetMapping
    Page<Asset> findAll(Pageable page) {
        return assetService.findAll(page, Asset.class);
    }

    @GetMapping("/{id}")
    public Asset findById(@PathVariable Integer id) throws NotFoundException {
        return assetService.findById(id, Asset.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        assetService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Asset insert(@RequestBody @Valid AssetRequest assetRequest) throws NotFoundException {
        return assetService.insert(assetRequest, Asset.class);
    }

    @PutMapping("/{id}")
    public Asset update(@PathVariable Integer id, @Valid @RequestBody AssetRequest assetRequest) throws NotFoundException {
        return assetService.update(id, assetRequest, Asset.class);
    }
}
