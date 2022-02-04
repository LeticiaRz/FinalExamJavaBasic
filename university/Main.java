package university;

import university.course.Course;
import university.student.Student;
import university.teacher.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author leticia.ramirez
 */
public class Main {
    public static void main(String[] args) {
        University university = new University("Globant");
        initialization(university);
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option != 10) {
            System.out.print("-----------\n" + university.getName() +
                    " University Menu: \n\t" +
                    "1. See all teachers\n\t" +
                    "2. See all courses\n\t" +
                    "3. See all students\n\t" +
                    "4. Create a new student\n\t" +
                    "5. Create a new course\n\t" +
                    "6. List all courses of a student by Id (student code)\n\t" +
                    "7. Exit\n\t" +
                    "Enter an option: ");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        seeAllTeachers(university);
                        break;
                    case 2:
                        seeAllCourses(university);
                        break;
                    case 3:
                        seeAllStudents(university);
                        break;
                    case 4:
                        createNewStudent(university);
                        break;
                    case 5:
                        createNewCourse(university);
                        break;
                    case 6:
                        coursesOfAStudentById(university);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Please enter only one valid menu option: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("You can only enter numbers of the menu. Please try again.");
                option = 0;
                scanner = new Scanner(System.in);
            }
        }
    }

    public static void initialization(University university) {
        Teacher maria = new FullTimeTeacher("Maria Martinez", 3000000, 5);
        Teacher fernanda = new FullTimeTeacher("Fernanda Garcia", 3500000, 8);
        Teacher juan = new PartTimeTeacher("Juan Gomez", 1500000, 16);
        Teacher pablo = new PartTimeTeacher("Pablo Lopez", 1700000, 10);
        Student pedro = new Student("Pedro Gonzalez", 22);
        Student jesus = new Student("Jesus Hernandez", 20);
        Student sasha = new Student("Sasha Ramirez", 21);
        Student lina = new Student("Lina Sanchez", 19);
        Student camila = new Student("Camila Perez", 20);
        Student taylor = new Student("Taylor Swift", 22);
        Course chemistry = new Course("Chemistry", "203A");
        Course communication = new Course("Communication", "302C");
        Course calculus = new Course("Calculus", "202B");
        Course physics = new Course("Physics", "101B");

        university.addTeacher(maria);
        university.addTeacher(fernanda);
        university.addTeacher(juan);
        university.addTeacher(pablo);
        university.addCourse(chemistry);
        university.addCourse(communication);
        university.addCourse(calculus);
        university.addCourse(physics);
        university.addStudent(pedro);
        university.addStudent(jesus);
        university.addStudent(sasha);
        university.addStudent(lina);
        university.addStudent(camila);
        university.addStudent(taylor);
        university.addTeacherToCourse(maria, chemistry);
        university.addTeacherToCourse(fernanda, communication);
        university.addTeacherToCourse(juan, calculus);
        university.addTeacherToCourse(pablo, physics);
        university.addStudentToCourse(pedro, chemistry);
        university.addStudentToCourse(pedro, physics);
        university.addStudentToCourse(jesus, chemistry);
        university.addStudentToCourse(jesus, communication);
        university.addStudentToCourse(sasha, communication);
        university.addStudentToCourse(sasha, calculus);
        university.addStudentToCourse(lina, calculus);
        university.addStudentToCourse(lina, physics);
        university.addStudentToCourse(camila, physics);
        university.addStudentToCourse(camila, chemistry);
        university.addStudentToCourse(taylor, communication);
        university.addStudentToCourse(taylor, calculus);
    }

    public static void seeAllTeachers(University university) {
        System.out.println(university.getListOfTeachers());
    }

    public static void seeAllStudents(University university) {
        System.out.println(university.getListOfStudents());
    }

    public static void seeAllCourses(University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(university.getListOfCourses());
        System.out.println("-----------\nEnter Id of the course to see all information, " +
                "or 0 to come back to menu: ");
        try {
            int idCourse = scanner.nextInt();
            if (idCourse != 0) {
                Course courseFound = university.findCourseById(idCourse);
                System.out.println(courseFound.getName());
                if (!courseFound.getName().equals(""))
                    System.out.println(courseFound.getStringAllDataCourse());
                else {
                    System.out.println("--- Course no found ---");
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("You can only enter numbers to search the Id. Please try again.");
            scanner = new Scanner(System.in);
        }
    }

    public static void coursesOfAStudentById(University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id of the student: ");
        try {
            int idStudentToSearchForCourses = scanner.nextInt();
            Student studentFound = university.findStudentById(idStudentToSearchForCourses);
            if (!studentFound.getName().equals("")) {
                System.out.println("Courses to which " +
                        studentFound.getName() +
                        " is included:\n" +
                        university.getCoursesOfAStudentById(idStudentToSearchForCourses));
            } else
                System.out.println("--- Student no found ---");
        } catch (InputMismatchException e) {
            System.err.println("You can only enter numbers to search the Id. Please try again.");
            scanner = new Scanner(System.in);
        }
    }

    public static void createNewStudent(University university) {
        Scanner scanner = new Scanner(System.in);
        boolean EnrolledStudent = false;
        while (!EnrolledStudent) {
            try {
                System.out.println("Name of the new Student: ");
                String nameNewStudent = scanner.nextLine();
                System.out.println("Age of " + nameNewStudent + ": ");
                Student newStudent = null;
                boolean studentCreated = false;
                while (!studentCreated) {
                    int ageNewStudent = scanner.nextInt();
                    if (ageNewStudent > 0) {
                        newStudent = new Student(nameNewStudent, ageNewStudent);
                        studentCreated = true;
                        university.addStudent(newStudent);
                    } else {
                        System.out.println("The age must be greater than 0");
                    }
                }
                boolean courseConfirmation = false;
                while (!courseConfirmation) {
                    try {
                        System.out.println("Current courses are:\n" + university.getListOfCourses() +
                                "To enroll " + newStudent.getName() +
                                " in a course enter the id of te course or enter '0' to not enroll");
                        int idCourseToAdd = scanner.nextInt();
                        if (idCourseToAdd != 0) {
                            Course courseToAdd = university.findCourseById(idCourseToAdd);
                            university.addStudentToCourse(newStudent, courseToAdd);
                            System.out.println("Student created successfully and enrolled in "
                                    + courseToAdd.getName());
                        } else
                            System.out.println("Student created successfully");
                        EnrolledStudent = true;
                        courseConfirmation = true;
                    } catch (InputMismatchException e) {
                        System.err.println("You can only enter numbers for Id. Please try again.");
                        scanner = new Scanner(System.in);
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("You can only enter numbers for age. Please try again.");
                scanner = new Scanner(System.in);
            }
        }
    }

    public static void createNewCourse(University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the new Course: ");
        String nameCourse = scanner.nextLine();
        System.out.println("Assigned classroom of " + nameCourse + ": ");
        String assignedClassroomOfTheNewCourse = scanner.nextLine();
        Course newCourse = new Course(nameCourse, assignedClassroomOfTheNewCourse);
        university.addCourse(newCourse);
        boolean confirmedTeacher = false;
        while (!confirmedTeacher) {
            try {
                System.out.println("To add a teacher to this course enter " +
                        "Id of the teacher or enter '0' to add none: ");
                int idTeacherToFind = scanner.nextInt();
                if (idTeacherToFind != 0) {
                    Teacher teacherFound = university.findTeacherById(idTeacherToFind);
                    if (!teacherFound.getName().equals("")) {
                        university.addTeacherToCourse(teacherFound, newCourse);
                        System.out.println("Teacher added successfully");
                    }
                }
                confirmedTeacher = true;
                boolean confirmedStudent = false;
                while (!confirmedStudent) {
                    try {
                        int idStudentToFind = 1;
                        while (idStudentToFind != 0) {
                            System.out.println("To add a student to this course enter " +
                                    "Id of the student or enter '0' to add none: ");
                            idStudentToFind = scanner.nextInt();
                            if (idStudentToFind != 0) {
                                Student studentFound = university.findStudentById(idStudentToFind);
                                if (!studentFound.getName().equals("")) {
                                    university.addStudentToCourse(studentFound, newCourse);
                                    System.out.println("Student added successfully");
                                }
                            } else
                                confirmedStudent = true;
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("You can only enter numbers for the Id of the student. Please try again.");
                        scanner = new Scanner(System.in);
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("You can only enter numbers for the Id of the teacher. Please try again.");
                scanner = new Scanner(System.in);
            }
        }
    }

}



