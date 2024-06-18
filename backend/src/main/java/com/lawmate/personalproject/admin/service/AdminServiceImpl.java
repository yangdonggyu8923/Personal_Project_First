package com.lawmate.personalproject.admin.service;

import com.lawmate.personalproject.admin.repository.AdminRepository;
import com.lawmate.personalproject.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository repository;

    @Override
    public Messenger deleteBylawyerId(Long id) {
        repository.deleteById(id);
        return Messenger.builder()
                .message(repository.findById(id).isPresent()?"SUCCESS":"FAILURE")
                .build();
    }

    @Override
    public Messenger deleteByuserId(Long id) {
        repository.deleteById(id);
        return Messenger.builder()
                .message(repository.findById(id).isPresent()?"SUCCESS":"FAILURE")
                .build();
    }
}
