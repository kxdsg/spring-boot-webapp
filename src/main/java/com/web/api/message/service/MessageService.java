package com.web.api.message.service;

import com.web.api.message.dao.MessageDao;
import com.web.api.message.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xingding on 19/6/2.
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public void save(Message message){
        messageDao.insert(message);
    }
}
