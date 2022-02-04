package university.teacher;

/**
 * @author leticia.ramirez
 */
public class FullTimeTeacher extends Teacher {

    private double experienceYears;

    public FullTimeTeacher(String name, double baseSalary, double experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    @Override
    public double getSalary() {
        return this.getBaseSalary() * (this.getExperienceYears() * 1.1);
    }

    public String toString() {
        return "Id: " + this.getId() +
                "  Name: " + this.getName() +
                "  Salary: " + this.getSalary() +
                "  Years of Experience: " + this.getExperienceYears() +
                "  Courses: " + this.getCourseList();
    }

}
