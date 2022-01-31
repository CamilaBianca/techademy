package com.amdocs.project.techademy.controller;

import com.amdocs.project.techademy.model.Course;
import com.amdocs.project.techademy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    // get all course
    @GetMapping(value = "/course")
    public ResponseEntity<?> getAllCourse(){
        return new ResponseEntity(courseService.getAllCourse(), HttpStatus.ACCEPTED);
    }

    // create course rest api
    @PostMapping("/course")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return new ResponseEntity(courseService.createCourse(course), HttpStatus.CREATED);
    }

    // get course by id rest api
    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        return new ResponseEntity(courseService.getCourseById(id), HttpStatus.ACCEPTED);
    }

    // update course rest api
    @PutMapping("/course/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course newCourseDetails) {
        return new ResponseEntity(courseService.updateByWithNewCourse(id, newCourseDetails), HttpStatus.ACCEPTED);
    }

    // delete course rest api
    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        return new ResponseEntity(courseService.deleteCourse(id), HttpStatus.GONE);
    }

    // update upload resource rest api
    @PutMapping("/course/upload/{id}")
    public ResponseEntity updateResource(@PathVariable int id, @RequestParam("cResource") MultipartFile cResource) {
        return new ResponseEntity(courseService.updateResource(id, cResource), HttpStatus.ACCEPTED);
    }
}
