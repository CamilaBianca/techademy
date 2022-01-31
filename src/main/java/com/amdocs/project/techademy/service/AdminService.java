package com.amdocs.project.techademy.service;

import com.amdocs.project.techademy.model.Admin;
import java.util.List;

public interface AdminService {

    /**
     * @return list of all admin
     */
    List<Admin> getAllAdmin();

    /**
     *
     * @param id
     * @return true if admin with input id is deleted
     */
    boolean deleteAdmin(int id);

    /**
     *
     * @param id
     * @param admin
     * @return
     */
    Admin updateByWithNewAdmin(int id, Admin admin);

    /**
     *
     * @param id
     * @return
     */
    Admin getAdminById(int id);

    /**
     *
     * @param admin
     * @return
     */
    Admin createAdmin(Admin admin);
}
