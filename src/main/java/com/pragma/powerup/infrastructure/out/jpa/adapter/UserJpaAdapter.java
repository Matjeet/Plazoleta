package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.User;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.infrastructure.exception.UserAlreadyExistsException;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    @Override
    public void saveUser(User user) {
        if(userRepository.findById(userEntityMapper.toEntity(user).getId()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        userRepository.save(userEntityMapper.toEntity(user));
    }
}
