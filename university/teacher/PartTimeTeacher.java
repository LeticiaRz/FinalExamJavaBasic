package university.teacher;

/**
 * @author leticia.ramirez
 */
public class PartTimeTeacher extends Teacher {

    private double activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, double activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public double getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    @Override
    public double getSalary() {
        return this.getBaseSalary() * getActiveHoursPerWeek();
    }

    public String toString () {
        return "Id: " + this.getId() +
                "  Name: " + this.getName() +
                "  Salary: " + this.getSalary() +
                "  Active Hours Per Week: " + this.getActiveHoursPerWeek() +
                "  Courses: " + this.getCourseList();
    }
}
