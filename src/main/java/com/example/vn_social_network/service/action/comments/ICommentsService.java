package com.example.vn_social_network.service.action.comments;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.service.IGeneralService;


public interface ICommentsService extends IGeneralService<Comments> {

    Iterable<Comments> findAllByPosts(Posts posts);
}
