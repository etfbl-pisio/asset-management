package org.unibl.etf.pisio.am.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.am.base.CrudController;
import org.unibl.etf.pisio.am.models.dto.AssetType;
import org.unibl.etf.pisio.am.models.requests.AssetTypeRequest;
import org.unibl.etf.pisio.am.services.AssetTypeService;

@RestController
@RequestMapping("/asset-types")
public class AssetTypeController extends CrudController<Integer, AssetTypeRequest, AssetType> {
    public AssetTypeController(AssetTypeService service) {
        super(service, AssetType.class);
    }
}
