package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
  
    Optional<Course> findByCourseName(String courseName);

}
