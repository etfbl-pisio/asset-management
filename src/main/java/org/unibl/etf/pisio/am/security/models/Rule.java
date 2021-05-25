package org.unibl.etf.pisio.am.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
    private List<String> methods;
    private String pattern;
    private List<String> roles;
}
