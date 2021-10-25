package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.utils.PrinterHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService
{
    // Map<ID, Student>
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        //TODO implement
        if(students.size() == 0)
            System.out.println("No Student Found");
        else {
            System.out.println("Students Summary:");
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }



}
