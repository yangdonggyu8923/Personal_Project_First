package com.lawmate.personalproject.admin.service;

import com.lawmate.personalproject.common.component.Messenger;

public interface AdminService {
    Messenger deleteBylawyerId(Long id);

    Messenger deleteByuserId(Long id);
}
