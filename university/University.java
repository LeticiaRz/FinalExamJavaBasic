package university;

import university.course.Course;
import university.student.Student;
import university.teacher.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leticia.ramirez
 */
public class University {

    private String name;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Course> courseList;

    public University(String name) {
        this.name = name;
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTeacher(Teacher newTeacher) {
        this.teacherList.add(newTeacher);
    }

    public void addCourse(Course newCourse) {
        this.courseList.add(newCourse);
    }

    public void addStudent(Student newStudent) {
        this.studentList.add(newStudent);
    }

    public String getListOfTeachers() {
        String teachersList = "";
        for (Teacher teacher : this.teacherList) {
            if (!teacher.getName().equals(""))
                teachersList = teachersList + teacher.toString() + "\n";
        }
        return teachersList;
    }

    public String getListOfStudents() {
        String studentsList = "";
        for (Student student : this.studentList) {
            if (!student.getName().equals(""))
                studentsList = studentsList + student.toString() + "\n";
        }
        return studentsList;
    }

    public String getListOfCourses() {
        String coursesList = "";
        for (Course course : this.courseList) {
            if (!course.getName().equals(""))
                coursesList = coursesList + course.toString() + "\n";
        }
        return coursesList;
    }

    public String getCoursesOfAStudentById(int idStudent) {
        String courseList = "";
        for (Course course: findStudentById(idStudent).getCourseList()) {
            courseList = courseList + course.toString() + "\n";
        }
        return courseList;
    }

    public Course findCourseById(int idCourse) {
        Course courseFound = null;
        for (Course course : this.courseList) {
            if (course.getId() == idCourse)
                courseFound = course;
        }
        if (courseFound == null)
            courseFound = new Course("","");
        return courseFound;
    }

    public Teacher findTeacherById(int idTeacher) {
        Teacher teacherFound = null;
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idTeacher)
                teacherFound = teacher;
        }
        if (teacherFound == null)
            teacherFound = new PartTimeTeacher("", 0, 0);
        return teacherFound;
    }

    public Student findStudentById(int idStudent) {
        Student studentFound = null;
        for (Student student : this.studentList) {
            if (student.getId() == idStudent)
                studentFound = student;
        }
        if (studentFound == null)
            studentFound = new Student("", 0);
        return studentFound;
    }

    public void addStudentToCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudent(student);
    }

    public void addTeacherToCourse(Teacher teacher, Course course) {
        teacher.addCourse(course);
        course.addTeacher(teacher);
    }
}
