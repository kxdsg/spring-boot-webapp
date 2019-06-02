package com.web.api.message.controller;

import com.web.api.message.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xingding on 19/6/2.
 */
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment")
    public String comment(String name){
        commentService.comment(name);
        return "success";
    }
}
