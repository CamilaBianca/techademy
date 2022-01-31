package com.amdocs.project.techademy.service.serviceImpl;

import com.amdocs.project.techademy.exception.ResourceNotFoundException;
import com.amdocs.project.techademy.model.Course;
import com.amdocs.project.techademy.model.Feedback;
import com.amdocs.project.techademy.model.User;
import com.amdocs.project.techademy.repository.CourseRepository;
import com.amdocs.project.techademy.repository.UserRepository;
import com.amdocs.project.techademy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with id " +id));

        return course;
    }

    @Override
    public Course updateByWithNewCourse(int id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with id " +id));

        course.setcDesp(courseDetails.getcDesp());
        course.setcFees(courseDetails.getcFees());
        course.setcName(courseDetails.getcName());

        Course courseUpdate = courseRepository.save(course);
        return courseUpdate;
    }

    @Override
    public Course updateResource(int id, MultipartFile cResource) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with id " +id));
        try {
            course.setcResource(cResource.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Course updateCourse = courseRepository.save(course);
        return updateCourse;
    }

    @Override
    public boolean deleteCourse(int id) {
        boolean isDeleted = true;

        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with id " +id));

        courseRepository.delete(course);
        if(course == null){
            isDeleted = false;
        }
        return isDeleted;
    }

}
