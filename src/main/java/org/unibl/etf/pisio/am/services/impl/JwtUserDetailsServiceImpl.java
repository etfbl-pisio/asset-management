package org.unibl.etf.pisio.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.am.models.dto.JwtUser;
import org.unibl.etf.pisio.am.models.entities.UserEntity;
import org.unibl.etf.pisio.am.repositories.UserEntityRepository;
import org.unibl.etf.pisio.am.services.JwtUserDetailsService;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper modelMapper;

    public JwtUserDetailsServiceImpl(UserEntityRepository userEntityRepository, ModelMapper modelMapper) {
        this.userEntityRepository = userEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {

        return modelMapper.map(userEntityRepository.findByUsernameAndStatus(username, UserEntity.Status.ACTIVE).
                orElseThrow(() -> new UsernameNotFoundException(username)), JwtUser.class);
    }
}
