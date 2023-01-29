import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Functional {

	public static void main(String[] args) {
		
		
		//Task1
		System.out.println("Task 1:\n");
		//student array
		Student[] studentArray = {
				 new Student("Vijay","Kumar",48, "IT"),
				 new Student("Inder","Sidhu",66, "Science"),
				 new Student("Gurkirat","Singh",94, "IT"),
				 new Student("Rohit","Sharma",91, "Accounts"),
				 new Student("John","Jacobs",79, "Accounts"),
				 new Student("Gurpreet","Chahal",93, "Science"),
				 new Student("Rakesh","Singh",90, "IT")};
		
		//students arraylist
		List<Student> students = Arrays.asList(studentArray);
		System.out.println("Complete Student list:\n");
		students.stream().forEach(Student::display);
		
		//Task2
		System.out.println("Task 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		students.stream().filter(s -> (s.grade>=50.0 && s.grade<=100)).sorted(Comparator.comparingDouble(Student:: getGrade)).forEach(Student::display);
		
		//Task3
		System.out.println("\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		students.stream().filter(s -> (s.grade>=50.0 && s.grade<=100)).findFirst().get().display();

		//Task4
		System.out.println("\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		List<Student> sortedList = students.stream().
				sorted((stu1, stu2) -> {
	            if(stu1.getLastName().compareTo(stu2.getLastName())==0)
	                return stu1.getFirstName().compareTo(stu2.getFirstName());
	            else if(stu1.getLastName().compareTo(stu2.getLastName())>0)
	                return 1;
	            else return -1;
		}).collect(Collectors.toList());
		sortedList.forEach(Student::display);
		
		System.out.println("\nStudents in descending order by last name then first:");
		List<Student> sortedListDesc = students.stream().
				sorted((stu1, stu2) -> {
	            if(stu1.getLastName().compareTo(stu2.getLastName())==0)
	                return stu1.getFirstName().compareTo(stu2.getFirstName());
	            else if(stu1.getLastName().compareTo(stu2.getLastName())>0)
	                return -1;
	            else return 1;
		}).collect(Collectors.toList());
		sortedListDesc.forEach(Student::display);

		//Task5
		System.out.println("\nTask 5:\n");
		System.out.println("Unique Student last names:");
		Set<String> uniquelastnames = students.stream().map(s -> s.lastName).collect(Collectors.toSet());
		uniquelastnames.stream().sorted().forEach(System.out::println);
		

	}

}

