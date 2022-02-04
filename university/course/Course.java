package university.course;

import university.student.Student;
import university.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leticia.ramirez
 */
public class Course {

    private int id;
    private String name;
    private String assignedClassroom;
    private List<Student> studentList;
    private Teacher teacher;
    private static int counter = 1;

    public Course(String name, String assignedClassroom) {
        this.id = counter;
        this.counter++;
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.studentList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    private void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student newStudent) {
        this.studentList.add(newStudent);
    }

    public void addTeacher(Teacher teacher) {
        setTeacher(teacher);
    }

    public String toString() {
        return "{Id: " + this.getId() +
                " Name: " + this.getName() +
                " Assigned Classroom: " + this.getAssignedClassroom() + "}";
    }

    public String getStringAllDataCourse() {
        String dataCourse = "";
        dataCourse = ("Id: " + this.getId() +
                "  Name: " + this.getName() +
                "  Assigned Classroom: " + this.getAssignedClassroom());
        if (this.getTeacher() != null)
            dataCourse = dataCourse + "  Teacher: " + this.getTeacher().getName();
        else
            dataCourse = dataCourse + "  Teacher: No assigned teacher";
        dataCourse = dataCourse + "\nStudents: " + this.getStudentList();
        return dataCourse;
    }

}
