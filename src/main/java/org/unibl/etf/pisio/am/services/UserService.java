package org.unibl.etf.pisio.am.services;

import org.unibl.etf.pisio.am.base.CrudService;
import org.unibl.etf.pisio.am.models.dto.User;
import org.unibl.etf.pisio.am.models.requests.ChangeRoleRequest;
import org.unibl.etf.pisio.am.models.requests.ChangeStatusRequest;
import org.unibl.etf.pisio.am.models.requests.SignUpRequest;
import org.unibl.etf.pisio.am.models.requests.UserUpdateRequest;

public interface UserService extends CrudService<Integer> {
    void signUp(SignUpRequest request);

    void changeStatus(Integer userId, ChangeStatusRequest request);

    void changeRole(Integer userId, ChangeRoleRequest request);

    User update(Integer id, UserUpdateRequest user);
}
