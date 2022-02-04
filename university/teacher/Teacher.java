package university.teacher;

import university.course.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leticia.ramirez
 */
public abstract class Teacher {

    private int id;
    private String name;
    private double baseSalary;
    private List<Course> courseList;
    private static int counter = 1;

    public Teacher(String name, double baseSalary) {
        this.id=counter;
        this.counter++;
        this.name = name;
        this.baseSalary = baseSalary;
        this.courseList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public abstract double getSalary();

    public void addCourse (Course course) {
        this.courseList.add(course);
    }

}
