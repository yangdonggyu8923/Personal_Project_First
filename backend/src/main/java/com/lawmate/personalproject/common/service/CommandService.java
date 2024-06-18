package com.lawmate.personalproject.common.service;

import com.lawmate.personalproject.common.component.Messenger;

public interface CommandService<T> {

    Messenger save(T t);
    Messenger deleteById(Long id);
    Messenger modify(T t);

}
