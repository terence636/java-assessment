package com.generation;

import static org.junit.jupiter.api.Assertions.*;

import com.generation.model.Module;
import org.junit.jupiter.api.*;

import com.generation.model.Course;
import com.generation.service.CourseService;

public class CourseServiceTest {

    @Test
    public void Should_ReturnNull_When_CourseIsEmptyOrNonValidID () {
        // Begin
        CourseService courseService = new CourseService();

        // When
        Course actual = courseService.getCourse("AnyCode");

        // Then
        assertNull(actual);

    }

    @Test
    public void Should_ReturnACourse_When_CourseIsNotEmptyAndValidID () {
        // Begin
        CourseService courseService = new CourseService();
        Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs" );
        Course expected = new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module );
        courseService.registerCourse( expected );

        // When
        Course actual = courseService.getCourse("INTRO-CS-1");

        // Then
        assertAll (
                () -> assertEquals(expected.getCode(), actual.getCode()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getCredits(), actual.getCredits()),
                () -> assertEquals(expected.getModule(), actual.getModule())
        );


    }
}
