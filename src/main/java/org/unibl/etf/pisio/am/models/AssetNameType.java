package org.unibl.etf.pisio.am.models;

import lombok.Data;

@Data
public class AssetNameType {
    private String name;
    private String type;
    public AssetNameType(String name,String type){
        this.name=name;
        this.type=type;
    }
}
