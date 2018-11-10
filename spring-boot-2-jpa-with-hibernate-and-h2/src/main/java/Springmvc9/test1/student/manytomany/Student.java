package Springmvc9.test1.student.manytomany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

@Entity
@Table(name="students")
public class Student{

	
	@Id
	private Long id;
	
	private String name;
	private String country;
	private String email;
	
	@Column(name="created_at")
	private String createdAt;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="student_course",
			joinColumns= {@JoinColumn(name = "student_id", referencedColumnName = "id")},
					   inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")}
			)
	
	private List<Course> course;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, String country, String email, String createdAt, List<Course> course) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.email = email;
		this.createdAt = createdAt;
		this.course = course;
	}

	public Student(Long id, String name, String country, String email, String createdAt) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	
}
