package org.unibl.etf.pisio.am.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.am.base.CrudController;
import org.unibl.etf.pisio.am.models.dto.AssetStatus;
import org.unibl.etf.pisio.am.models.requests.AssetStatusRequest;
import org.unibl.etf.pisio.am.services.AssetStatusService;

@RestController
@RequestMapping("/asset-statuses")
public class AssetStatusController extends CrudController<Integer, AssetStatusRequest, AssetStatus> {
    public AssetStatusController(AssetStatusService service) {
        super(service, AssetStatus.class);
    }
}
