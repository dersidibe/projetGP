/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Comment;
import java.util.List;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public abstract class CommentDao {

    public abstract List<Comment> getComments();

    public abstract List<Comment> getCommentsByEvent(int idEvent);

    public abstract Comment getCommentById(int id);

    public abstract Integer insertComment(Comment comment);

    public abstract boolean deleteComment(Comment comment);

    public abstract boolean updateComment(Comment comment);
}
