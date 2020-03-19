package general;


 import java.io.*;
 import java.util.*;
 import java.util.concurrent.ConcurrentHashMap;

 class StudentDemo {
   public static void main(String[] args) {
		 StudentDemo solution = new StudentDemo();
     solution.demo();
   }

   private static class Student{

     private String name;
     private int studentNumber;

     public Student(){
       this.name="";
       this.studentNumber= -1;

     }

     public Student(String name, int number){
       this.name = name;
       this.studentNumber = number;
     }

     // Getters and Setters
     public String getName(){
       return this.name;
     }

     public int getStudentNumber(){
       return this.studentNumber;
     }

   }


   private static class StudentDao{

     private static final Map<Integer, Student> studentsTable =
       new ConcurrentHashMap<>();

     public StudentDao(){
       //Create connection to database
       // Connection conn = DriverManager.getConnection("url","user","password");
     }
     // Dao CRUD Methods

     public Student addStudent(String name, int number){
       Student student = new Student(name,number);

       // use conn to update in DB

       studentsTable.put(number, student);

       return student;

     }

     public Student getStudent(int studentNumber){
       Student student = studentsTable.get(studentNumber);
       return student==null? new Student():student;
     }

     public boolean updateStudent(int number, String newStudentName){
       Student student = studentsTable.get(number);

       if(student==null){
         addStudent(newStudentName, number);
       } else {
         studentsTable.put(number, new Student(newStudentName, number ));
       }

       return true;
     }

     public boolean deleteStudent(int number){
       studentsTable.remove(number);
       return true;
     }

     public List<Student> getAllStudents(){
       List<Student> students = new ArrayList<>(studentsTable.values());
       return Collections.unmodifiableList(new ArrayList<>(studentsTable.values()));
     }

   }

   private void demo(){

     /*
     Step 1: complete the code here to use your DAO to add three students:
       0, Robert
       1, Sam
       2, Mike
     */
     StudentDao dao = new StudentDao();
     dao.addStudent("Robert",0);
     dao.addStudent("Sam",1);
     dao.addStudent("Mike",2);


     /*
     Step 2: print all students
     */

     dao.getAllStudents().stream().map(Student::getName).forEach(System.out::println);

     /*
     Step 3: use your DAO to update Sam's name to Sammy and print the updated record
     */

     System.out.println("------------");
     dao.updateStudent(1, "Sammy");
     System.out.println(dao.getStudent(1).getName());

     /*
     Step 4: use your DAO to delete Sammy from the database
     */

     dao.deleteStudent(1);

     /*
     Step 5: print all students
     */

     System.out.println("------------");
     dao.getAllStudents().stream().map(Student::getName).forEach(System.out::println);
   }
 }