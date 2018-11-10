package Springmvc9.test1.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Springmvc9.test1.student.manytomany.Course;
import Springmvc9.test1.student.manytomany.CourseRepository;
import Springmvc9.test1.student.manytomany.Student;
import Springmvc9.test1.student.manytomany.StudentRepository;



@RestController
public class CompanyController {
	
	@Autowired
	CourseRepository courserepository;
	@Autowired
	StudentRepository studentrepository;
	
	@GetMapping("/Company")
	public List<Company> getAllCompany(){
		Course cour1=new Course();
		cour1.setMajor("必修");
		cour1.setDescription("大學部");
		cour1.setTitle("微積分");
		cour1.setCreatedAt("20181002");
		
		Course cour2=new Course();
		cour2.setMajor("必修");
		cour2.setDescription("碩士部");
		cour2.setTitle("偏微分");
		cour2.setCreatedAt("20181002");
		
		Student stu1=new Student(1l, "陳凱文", "台灣", "A123456@yahoo.com.tw", "20181002");
		Student stu2=new Student(2l, "陳思璇", "台灣", "P123456@yahoo.com.tw", "20181002");
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(cour1);
		courses.add(cour2);
		
		List<Course> courses2=new ArrayList<Course>();
		courses.add(cour1);
		
		stu1.setCourse(courses);
		stu2.setCourse(courses2);
		studentrepository.save(stu1);
		studentrepository.save(stu2);
		
		
		List<Student> students1=new ArrayList<Student>();
		students1.add(stu1);
		students1.add(stu2);
		
		List<Student> students2=new ArrayList<Student>();
		students2.add(stu1);
		
		cour1.setStudents(students1);
		cour2.setStudents(students2);
		
		//courserepository.save(cour1);
		//courserepository.save(cour2);
		/*
		stu1.getCourse().add(cour1);
		cour1.getStudents().add(stu1);
		
		stu1.getCourse().add(cour2);
		cour2.getStudents().add(stu1);
		
		stu2.getCourse().add(cour1);
		cour1.getStudents().add(stu2);
		*/
		
		/*
		studentrepository.save(stu1);
		studentrepository.save(stu2);
		*/
		showData();
		return Arrays.asList(new Company(1l,"apple"));
		
	}
	
	@Transactional
	private void showData() {
		// TODO Auto-generated method stub
		System.out.println("===============login showDate=========");
		//System.out.println(companyrepository.findOne((long) 1));
		
		List<Course> companyList=courserepository.findAll();
		List<Student> productList=studentrepository.findAll();
		System.out.println("===============獲取資料=========");
		System.out.println("===============Company List:=========");
		for(Student product:productList) {
			System.out.println(product.getCourse().iterator().next().getTitle());
		}
		System.out.println("===============Course List:=========");
		for(Course company:companyList) {
			System.out.println(company.getStudents().iterator().next().getName());
		}
		
		//companyList.forEach(System.out::println);
		
	}
}
