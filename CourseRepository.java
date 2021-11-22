package com.app.repo;

import com.app.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public  interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.courseName like %:courseName%")
    List<Course> findAllByCourseName(@Param("courseName") String courseName, Pageable pageable );

    @Query("SELECT count(c) FROM Course c")
    Integer recordCount();
}

// Crud vs Jpa!!!
//public interface CourseRepository extends CrudRepository<Course,Integer> {
//
//    List<Course> findAllByCourseName(String courseName );
//}
/*
Batch support ->	JPA also provides some extra methods related to JPA such as delete records in batch and flushing data directly to a database.	It provides only CRUD functions like findOne, saves, etc.
Pagination support ->	JPA repository also extends the PagingAndSorting repository. It provides all the method for which are useful for implementing pagination.	Crud Repository doesn't provide methods for implementing pagination and sorting.

JPA handaltuud ni hyalbar bas hurdan!!

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}

 */

