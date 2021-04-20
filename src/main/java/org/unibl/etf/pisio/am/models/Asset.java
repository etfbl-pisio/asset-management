package org.unibl.etf.pisio.am.models;

import lombok.Data;

@Data
public class Asset {
    private Integer id;
    private String identifier;
    private String name;
    private String description;
    private String locationName;
    private String assetTypeName;
    private String assetStatusName;
}
