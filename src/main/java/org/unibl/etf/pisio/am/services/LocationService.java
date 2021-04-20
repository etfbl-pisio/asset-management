package org.unibl.etf.pisio.am.services;

import org.unibl.etf.pisio.am.exceptions.NotFoundException;
import org.unibl.etf.pisio.am.models.Location;
import org.unibl.etf.pisio.am.models.SingleLocation;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    SingleLocation findById(Integer id) throws NotFoundException;
}
