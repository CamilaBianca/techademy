package com.amdocs.project.techademy.service;

import com.amdocs.project.techademy.model.Course;
import com.amdocs.project.techademy.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {

    /**
     * @return list of all course
     */
    List<Course> getAllCourse();

    /**
     *
     * @param id
     * @return true if course with input id is deleted
     */
    boolean deleteCourse(int id);

    /**
     *
     * @param id
     * @param course
     * @return
     */
    Course updateByWithNewCourse(int id, Course course);

    /**
     *
     * @param id
     * @return
     */
    Course getCourseById(int id);

    /**
     *
     * @param course
     * @return
     */
    Course createCourse(Course course);

    Course updateResource(int id, MultipartFile cResource);
}
