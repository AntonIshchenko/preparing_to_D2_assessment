package streams;

import javax.swing.JPanel;
import java.time.LocalDate;

public class Employee {

   private final String firsName;
   private final String secondName;
   private final LocalDate birthday;

   private EmployeeGender gender;
   private JobPositions jobPosition;
   private Integer workExperience;

   public Employee(String firsName, String secondName, LocalDate birthday, EmployeeGender gender) {
      this.firsName = firsName;
      this.secondName = secondName;
      this.birthday = birthday;
      this.gender = gender;
   }

   public EmployeeGender getGender() {
      return gender;
   }

   public void setGender(EmployeeGender gender) {
      this.gender = gender;
   }

   public String getFirsName() {
      return firsName;
   }

   public String getSecondName() {
      return secondName;
   }

   public JobPositions getJobPosition() {
      return jobPosition;
   }

   public void setJobPosition(JobPositions jobPosition) {
      this.jobPosition = jobPosition;
   }

   public Integer getWorkExperience() {
      return workExperience;
   }

   public void setWorkExperience(Integer workExperience) {
      this.workExperience = workExperience;
   }

   public Integer getAge() {
      return LocalDate.now().compareTo(birthday);
   }

   @Override public String toString() {
      return "Employee{" +
            "firsName='" + firsName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", age=" + getAge() +
            ", gender=" + gender +
            ", jobPosition=" + jobPosition +
            ", workExperience=" + workExperience +
            '}';
   }
}
