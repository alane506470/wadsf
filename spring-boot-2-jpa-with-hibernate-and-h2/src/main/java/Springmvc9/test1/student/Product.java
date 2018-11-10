package Springmvc9.test1.student;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	// Some other code

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="company_id")
	private Company company;
	public Product() {
		super();
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Product(Long id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	public Product(String name, Company company) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.company = company;
	}

	
	
}
