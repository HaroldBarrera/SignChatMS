package com.usbbog.SignchatMS.interfaces;

import com.usbbog.SignchatMS.models.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends CrudRepository<User, Long> {

    List<User> findByUserNicknameAndUserPassword(String nickname, String password);

}