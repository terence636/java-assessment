package com.generation;

import static org.junit.jupiter.api.Assertions.*;

import com.generation.model.Student;
import com.generation.service.StudentService;
import org.junit.jupiter.api.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentServiceTest {


    @Test
    public void Should_FindNoStudent_When_StudentListEmpty() throws ParseException {
        // given
        StudentService studentService = new StudentService();

        // when
        Student actual = studentService.findStudent("1234");

        // then
        assertNull(actual);
    }

    @Test
    public void Should_FindAStudent_When_StudentListNotEmpty() throws ParseException {
        // given
        StudentService studentService = new StudentService();
        Date birthDate = new SimpleDateFormat("MM/dd/yyyy").parse("12/12/2011");
        Student expected = new  Student("1234", "terence", "terence@gmail", birthDate);
        studentService.subscribeStudent(expected);

        // when
        Student actual = studentService.findStudent("1234");

        // then
        assertAll (
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getEmail(), actual.getEmail()),
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getBirthDate(), actual.getBirthDate())
        );
    }

    @Test
    public void Should_ReturnTrueFalse_When_StudentIsSubscribedNotSubscribed() throws ParseException {
        //given
        StudentService studentService = new StudentService();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = formatter.parse("12/12/2011");
        Student student = new  Student("1234", "terence", "terence@gmail", birthDate);
        studentService.subscribeStudent(student);

        //when
        Boolean actual1 = studentService.isSubscribed("1234");
        Boolean actual2 = studentService.isSubscribed("1");

        //then
        assertAll (
                ()-> assertTrue(actual1),
                ()-> assertFalse(actual2)
        );
    }

}
