package org.unibl.etf.pisio.am.models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AssetRequest {
    @NotBlank
    private String identifier;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Integer locationId;
    @NotNull
    private Integer assetTypeId;
    @NotNull
    private Integer assetStatusId;
}
