package com.lawmate.personalproject.common.service;

import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.user.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService <T> {


    public abstract List<T> findAll() throws SQLException;

    public abstract Optional<T> findById(long id);

    public abstract String count();


    public  abstract  String deleteAll();

    public  abstract  Boolean existsById(long id);


    public abstract Messenger insertMenuData(User user) throws SQLException;
    public  abstract  String delete(T t);
    public abstract Messenger save (T t);
}
