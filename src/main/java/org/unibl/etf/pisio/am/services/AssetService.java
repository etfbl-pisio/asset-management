package org.unibl.etf.pisio.am.services;

import org.unibl.etf.pisio.am.base.CrudService;
import org.unibl.etf.pisio.am.models.Asset;

import java.util.List;

public interface AssetService extends CrudService<Integer> {
    List<Asset> getAllAssetsByLocationId(Integer id);
}
