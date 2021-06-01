package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.base.CrudJpaService;
import org.unibl.etf.pisio.am.exceptions.ConflictException;
import org.unibl.etf.pisio.am.exceptions.ForbiddenException;
import org.unibl.etf.pisio.am.models.dto.User;
import org.unibl.etf.pisio.am.models.entities.UserEntity;
import org.unibl.etf.pisio.am.models.enums.Role;
import org.unibl.etf.pisio.am.models.enums.UserStatus;
import org.unibl.etf.pisio.am.models.requests.ChangeRoleRequest;
import org.unibl.etf.pisio.am.models.requests.ChangeStatusRequest;
import org.unibl.etf.pisio.am.models.requests.SignUpRequest;
import org.unibl.etf.pisio.am.models.requests.UserUpdateRequest;
import org.unibl.etf.pisio.am.repositories.UserEntityRepository;
import org.unibl.etf.pisio.am.services.UserService;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends CrudJpaService<UserEntity, Integer> implements UserService {

    private final UserEntityRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Value("${authorization.default.username:}")
    private String defaultUsername;
    @Value("${authorization.default.first-name:}")
    private String defaultFirstName;
    @Value("${authorization.default.last-name:}")
    private String defaultLastName;
    @Value("${authorization.default.password:}")
    private String defaultPassword;
    @Value("${authorization.default.email:}")
    private String defaultEmail;


    public UserServiceImpl(UserEntityRepository repository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        super(repository, modelMapper, UserEntity.class);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void postConstruct() {
        if (repository.count() == 0) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(defaultUsername);
            userEntity.setPassword(passwordEncoder.encode(defaultPassword));
            userEntity.setEmail(defaultEmail);
            userEntity.setFirstName(defaultFirstName);
            userEntity.setLastName(defaultLastName);
            userEntity.setStatus(UserEntity.Status.ACTIVE);
            userEntity.setRole(Role.ADMIN);
            repository.saveAndFlush(userEntity);
        }
    }

    public void signUp(SignUpRequest request) {
        if (repository.existsByUsername(request.getUsername()))
            throw new ConflictException();
        UserEntity entity = getModelMapper().map(request, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setStatus(UserEntity.Status.REQUESTED);
        entity.setRole(Role.USER);
        insert(entity, UserEntity.class);
    }

    public User update(Integer id, UserUpdateRequest user) {
        if (repository.existsByUsernameAndIdNot(user.getUsername(), id))
            throw new ConflictException();
        UserEntity entity = findEntityById(id);
        entity.setUsername(user.getUsername());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        return update(id, entity, User.class);
    }

    @Override
    public void changeStatus(Integer userId, ChangeStatusRequest request) {
        if (UserStatus.REQUESTED.equals(request.getStatus()))
            throw new ForbiddenException();
        UserEntity entity = findEntityById(userId);
        entity.setStatus(getModelMapper().map(request.getStatus(), UserEntity.Status.class));
        repository.saveAndFlush(entity);
    }

    @Override
    public void changeRole(Integer userId, ChangeRoleRequest request) {
        UserEntity entity = findEntityById(userId);
        entity.setRole(request.getRole());
        repository.saveAndFlush(entity);
    }
}
