package com.amdocs.project.techademy.service.serviceImpl;
import com.amdocs.project.techademy.exception.ResourceNotFoundException;
import com.amdocs.project.techademy.model.Admin;
import com.amdocs.project.techademy.repository.AdminRepository;
import com.amdocs.project.techademy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(int id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not found with id " +id));

        return admin;
    }

    @Override
    public Admin updateByWithNewAdmin(int id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not found with id " +id));

        admin.setEmail(adminDetails.getEmail());
        admin.setName(adminDetails.getName());
        admin.setPassword(adminDetails.getPassword());

        Admin adminUpdate = adminRepository.save(admin);
        return adminUpdate;
    }

    @Override
    public boolean deleteAdmin(int id) {
        boolean isDeleted = true;

        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not found with id " +id));

        adminRepository.delete(admin);
        if(admin == null){
            isDeleted = false;
        }
        return isDeleted;
    }

}
