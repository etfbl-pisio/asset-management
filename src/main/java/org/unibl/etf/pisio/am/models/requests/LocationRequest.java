package org.unibl.etf.pisio.am.models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class LocationRequest {

    @NotBlank
    private String name;
    private String description;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}
