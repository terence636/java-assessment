package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    // Map<Course>
    private final ArrayList<Course> courses = new ArrayList<>();

    //Map<Course ID, Course>
    private final Map<String, Course> approvedCourses = new HashMap<>();

    // Map<Course ID, Grade>ar
    private final Map<String, Integer> grades = new HashMap();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        courses.add( course );
        grades.put( course.getCode(), -999);
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
        return approvedCourses.containsKey( courseCode );
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
//    public List<Course> findPassedCourses( Course course )
    public List<Course> findPassedCourses( )
    {
        //TODO implement this method
        ArrayList<Course> passedCourses = new ArrayList<>();
        for(String courseId : grades.keySet()) {
            if(grades.get(courseId) >= 50) {
                passedCourses.add(approvedCourses.get(courseId));
            }
        }
        return passedCourses;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        for(Course course: courses) {
            if(course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public void showSummary() {
        System.out.println(toString());
        System.out.println("Courses Enrolled");

        if(courses.size() > 0) {
            for (Course course : courses) {
                Integer grade = grades.get(course.getCode());
                String gradeDisplay = grade == -999 ? "NA" : Integer.toString(grade);
                System.out.println("Course ID: " + course.getCode() + " (Grade: " + gradeDisplay + ")");
            }
        } else {
            System.out.println("NIL");
        }
    }

    public void showApprovedCourses() {
        System.out.println( "Approved Courses:" );
        for ( String key : approvedCourses.keySet() )
        {
            Course course = approvedCourses.get( key );
            System.out.println( course );
        }
    }

    public void setGrade(String courseId, Integer grade) {
        // check if grade already exist. If yes overwrite it
        if ( grades.containsKey( courseId ) )
        {
            grades.replace(courseId,grade);
            System.out.println("Successfully update grade");
            return;
        }
        grades.put(courseId, grade);
        System.out.println("Successfully insert grade");
    }

    public Integer getGrade(String courseId) {
        return grades.get(courseId);
    }


    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        if(approvedCourses.size() != 0)
            return (List<Course>)approvedCourses.values();
        return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
