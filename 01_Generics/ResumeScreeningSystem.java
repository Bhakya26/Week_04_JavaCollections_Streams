import java.util.*;
abstract class JobRole{
    public abstract String getJobRole();
}
class SoftwareEngineer extends JobRole{
    public String getJobRole(){
        return "Role: Software Engineer";
    }
}
class DataScientist extends JobRole{
    public String getJobRole(){
        return "Role: Data Scientist";
    }
}
class ProductManager extends JobRole{
    public String getJobRole(){
        return "Role: Product Manager";
    }
}
class Resume<T extends JobRole>{
    private String candidateName;
    private double experience;
    private T jobrole;
    public Resume(String candidateName,double experience,T jobrole){
        this.candidateName=candidateName;
        this.experience=experience;
        this.jobrole=jobrole;
    }
    public void displayInfo(){
        System.out.println("Candidate name "+candidateName+", Experience: "+experience+", Role of the job: "+jobrole.getJobRole());
    }
    public T getjobrole(){
        return jobrole;
    }
}
class ResumeProcessor {
    public static <T extends JobRole> Resume<T> createResume(String name, double exp, T role) {
        return new Resume<>(name, exp, role);
    }

    public static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayInfo();
        }
    }
}


public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

        Resume<SoftwareEngineer> r1 = ResumeProcessor.createResume("Alice", 3.5, new SoftwareEngineer());
        Resume<DataScientist> r2 = ResumeProcessor.createResume("Bob", 2.0, new DataScientist());
        Resume<ProductManager> r3 = ResumeProcessor.createResume("Charlie", 5.0, new ProductManager());

        resumeList.add(r1);
        resumeList.add(r2);
        resumeList.add(r3);

        System.out.println("Screening Resumes:");
        ResumeProcessor.screenResumes(resumeList);
    }
}
