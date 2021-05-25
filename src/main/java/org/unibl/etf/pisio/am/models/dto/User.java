package org.unibl.etf.pisio.am.models.dto;

import lombok.Data;
import org.unibl.etf.pisio.am.models.enums.Role;
import org.unibl.etf.pisio.am.models.enums.UserStatus;

@Data
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserStatus status;
}
