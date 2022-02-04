package university.student;

import university.course.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leticia.ramirez
 */
public class Student {

    private int id;
    private String name;
    private int age;
    private static int counter = 1;
    private List<Course> courseList;

    public Student(String name, int age) {
        this.id = counter;
        this.counter++;
        this.name = name;
        this.age = age;
        this.courseList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course newCourse) {
        this.courseList.add(newCourse);
    }

    public String toString() {
        return "{Id: " + this.getId() +
                "  Name: " + this.getName() +
                "  Age: " + this.getAge() + "}";
    }

}