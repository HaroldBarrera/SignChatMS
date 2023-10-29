package com.usbbog.SignchatMS.interfaces;

import com.usbbog.SignchatMS.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessage extends CrudRepository<Message, Long>{
}