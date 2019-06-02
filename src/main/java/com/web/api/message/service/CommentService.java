package com.web.api.message.service;

import com.web.api.message.aop.Action;
import org.springframework.stereotype.Service;

/**
 * Created by xingding on 19/6/2.
 */
@Service
public class CommentService {

    @Action(name="comment")
    public void comment(String who){
        System.out.println(who + " add some comments");
    }
}
