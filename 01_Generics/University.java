import java.util.*;

abstract class CourseType {
    public abstract String getEvaluationtype();
}

class ExamCourse extends CourseType {
    public String getEvaluationtype() {
        return "Exam based evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public String getEvaluationtype() {
        return "Assignment based evaluation";
    }
}

class ResearchCourse extends CourseType {
    public String getEvaluationtype() {
        return "Research based evaluation";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T evaluation;

    public Course(String courseName, String department, T evaluation) {
        this.courseName = courseName;
        this.department = department;
        this.evaluation = evaluation;
    }

    public void displayInfo() {
        System.out.println("Name of the course: " + courseName);
        System.out.println("Department: " + department);
        System.out.println("Evaluation type: " + evaluation.getEvaluationtype());
    }

    public T getEvaluationtype() {
        return evaluation;
    }
}

class DisplayAllClass {
    public static void displayCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            course.displayInfo();
            System.out.println();
        }
    }
}

public class University {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courselist = new ArrayList<>();

        Course<ExamCourse> math = new Course<>("Math 101", "Science", new ExamCourse());
        Course<Assignmentcourse> literature = new Course<>("Literature 202", "Arts", new Assignmentcourse());
        Course<ResearchCourse> ai = new Course<>("AI Research", "Engineering", new ResearchCourse());

        courselist.add(math);
        courselist.add(literature);
        courselist.add(ai);

        System.out.println("University catalog:");
        DisplayAllClass.displayCourses(courselist);
    }
}
