package com.amdocs.project.techademy.service.serviceImpl;

import com.amdocs.project.techademy.exception.ResourceNotFoundException;
import com.amdocs.project.techademy.model.User;
import com.amdocs.project.techademy.repository.UserRepository;
import com.amdocs.project.techademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id " +id));
        return user;
    }

    @Override
    public User updateByWithNewUser(int id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id " +id));

        user.setAddress(userDetails.getAddress());
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setPhoneNo(userDetails.getPhoneNo());

        User updateUser = userRepository.save(user);
        return updateUser;
    }

    @Override
    public User updateUploadPhoto(int id, MultipartFile uploadPhoto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id " +id));
        try {
            user.setUploadPhoto(uploadPhoto.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        User updateUser = userRepository.save(user);
        return updateUser;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean isDeleted = true;

        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id " +id));

        userRepository.delete(user);
        if(user == null){
            isDeleted = false;
        }
        return isDeleted;
    }

}
