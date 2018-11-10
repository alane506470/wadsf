package Springmvc9.test1.student;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Product> products;
	
	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;

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
	public Set<Product> getProduts() {
		return products;
	}
	public void setProduts(Set<Product> products) {
		this.products = products;
	}
	
	
	public Company(Long id, String name, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	public Company(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	
}
