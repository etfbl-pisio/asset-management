package org.unibl.etf.pisio.am.services;

import org.unibl.etf.pisio.am.models.dto.LoginResponse;
import org.unibl.etf.pisio.am.models.requests.LoginRequest;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
