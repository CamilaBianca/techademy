package com.amdocs.project.techademy.controller;

import com.amdocs.project.techademy.model.Admin;
import com.amdocs.project.techademy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    // get all admin
    @GetMapping(value = "/admin")
    public ResponseEntity<?> getAllAdmin(){
        return new ResponseEntity(adminService.getAllAdmin(), HttpStatus.ACCEPTED);
    }

    // create admin rest api
    @PostMapping("/admin")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        return new ResponseEntity(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    // get admin by id rest api
    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable int id) {
        return new ResponseEntity(adminService.getAdminById(id), HttpStatus.ACCEPTED);
    }

    // update admin rest api
    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable int id, @RequestBody Admin newAdminDetails) {
        return new ResponseEntity(adminService.updateByWithNewAdmin(id, newAdminDetails), HttpStatus.ACCEPTED);
    }

    // delete admin rest api
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id){
        return new ResponseEntity(adminService.deleteAdmin(id), HttpStatus.GONE);
    }
}
