package com.lawmate.personalproject.common.service;

import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    Long count();
    Boolean existsById(Long id);
}
