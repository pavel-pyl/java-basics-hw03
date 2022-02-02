import java.util.ArrayList;
import java.util.List;

public class Student {
  private int rating;
  private String name;
  private static int count;
  private int id;

  // implement Student class according to the instructions provided in the README.md file
  private static List<Student> students = new ArrayList<>();

  // initialize name
  public Student(String name) {
    this.name = name;
    students.add(this);
    id = ++count; // to differ student with same name
  }

  public Student() {
    this.name = "Unknown"; // for example, initialize name
    id = ++count; // to differ student with same name
    students.add(this);
  }

  // return average rating of all students
  public static double getAvgRating() {
    double res = 0;
    for (Student student : students) {
      res += student.rating;
    }
    // check to avoid devision by 0
    if (students.size() == 0) {
      return 0;
    } else {
      res /= students.size();
      res = (double) Math.round(res * 10) / 10;
      return res;
    }
    // it also works if students.size() == 0, but I don't know why (question for QA session)
    // res /= students.size();
    // res = (double) Math.round(res * 10) / 10;
    // return res;
  }

  // get student's name
  public String getName() {
    return name;
  }

  // set student's name
  public void setName(String name) {
    this.name = name;
  }

  // get student's rating
  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    if (rating > 0) {
      this.rating = rating;
    } else {
      // some error handling there
      System.out.println("Rating can't be less 0");
    }

  }

  // return the result of comparing this.student's rating with the student's rating
  // return false if rating is same, because there isn't better student
  public boolean betterStudent(Student student) {
    return this.rating > student.rating;
  }

  // change this student's rating (average rating of all students is calculated by getAvgRating()
  public void changeRating(int rating) {
    this.rating = rating;
  }

  // remove student
  public static void removeStudent(Student student) {
    students.remove(student);
  }

  // return String with name and rating of this student
  @Override
  public String toString() {
    return this.id + " " + this.name + " -> " + this.rating;
  }

  public static void main(String[] args) {
    int newRate = 30;
    // In the method main() create 3 objects of Student type
    System.out.println("Start to init Students");
    Student s1 = new Student("Petro");
    Student s2 = new Student("Pavlo");
    Student s3 = new Student();
    s1.setRating(10);
    s2.setRating(20);
    s3.setName("Ivan");
    s3.setRating(5);
    // and input information about them
    System.out.println("First student  : " + s1);
    System.out.println("Second student : " + s2);
    System.out.println("Third student  : " + s3);
    // Display the average rating of all students.
    System.out.println("Avarage rating is : " + Student.getAvgRating());
    // Change the rating of any student. Display the new average rating.
    String msg = String.format("Set new rating %s for %s", newRate, s2.getName());
    System.out.println(msg);
    s2.setRating(newRate);
    System.out.println("Avarage rating is : " + Student.getAvgRating());
  }
}
