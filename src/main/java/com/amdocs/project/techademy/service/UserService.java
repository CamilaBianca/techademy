package com.amdocs.project.techademy.service;

import com.amdocs.project.techademy.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    /**
     * @return list of all users
     */
    List<User> getAllUser();

    /**
     *
     * @param id
     * @return true if user with input id is deleted
     */
    boolean deleteUser(int id);

    /**
     *
     * @param id
     * @param user
     * @return
     */
    User updateByWithNewUser(int id, User user);

    /**
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     *
     * @param user
     * @return
     */
    User createUser(User user);

    User updateUploadPhoto(int id, MultipartFile uploadPhoto);

}
