package org.unibl.etf.pisio.am.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocationRequest {


    private String name;

    private String description;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
