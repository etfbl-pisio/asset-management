package org.unibl.etf.pisio.am.models.requests;

import lombok.Data;
import org.unibl.etf.pisio.am.models.enums.Role;

import javax.validation.constraints.NotNull;

@Data
public class ChangeRoleRequest {
    @NotNull
    private Role role;
}
