package Springmvc9.test1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Springmvc9.test1.student.Company;
import Springmvc9.test1.student.CompanyRepository;
import Springmvc9.test1.student.Product;
import Springmvc9.test1.student.ProductRepository;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
	
	@Autowired
	CompanyRepository companyrepository;
	@Autowired
	ProductRepository productrepository;
	
	public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
	/*
	 * 創建Student orm
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Student id 10001->{}",studentrepository.findById(10001L));
		logger.info("All users 1->{}",studentrepository.findAll());
		logger.info("Inserting ->{}",studentrepository.save(new Student("John","A12345678")));
		logger.info("Update 10001 -> {}", studentrepository.save(new Student(10001L, "Name-Updated", "New-Passport")));
		studentrepository.deleteById(10002L);
		logger.info("All users 2 -> {}", studentrepository.findAll());
	}
    */

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//clearData();
		/*練習雙向多對一
		saveData();
		showData();
		*/
	}
	@Transactional
	private void showData() {
		// TODO Auto-generated method stub
		System.out.println("===============login showDate=========");
		//System.out.println(companyrepository.findOne((long) 1));
		logger.info("All company 1->{}",companyrepository.findOne((long) 1));
		
		List<Company> companyList=companyrepository.findAll();
		List<Product> productList=productrepository.findAll();
		System.out.println("===============獲取資料=========");
		System.out.println("===============Company List:=========");
		for(Product product:productList) {
			System.out.println(product.getCompany().getName());
		}
		System.out.println("===============Product List:=========");
		for(Company company:companyList) {
			System.out.println(company.getProduts().iterator().next().getName());
		}
		
		//companyList.forEach(System.out::println);
		
	}
	@Transactional
	private void saveData() {
		// TODO Auto-generated method stub
		saveDateWithApproach1();
		//saveDataWithApproach2();
		
	}
	@Transactional
	private void saveDateWithApproach1() {
		// TODO Auto-generated method stub
		Company apple=new Company("Apple");
		Company samsung=new Company("Samsung");
		
		Product iphone7=new Product("Iphone7",apple);
		Product iPadPro=new Product("IPadPro",apple);
		
		Product galaxyJ7=new Product("GalaxyJ7",samsung);
		Product galaxyTabA=new Product("GalaxyTabA",samsung);
		
		
		Set<Product> appleSet=new HashSet<Product>();
		appleSet.add(iphone7);
		appleSet.add(iPadPro);
		apple.setProduts(appleSet);
		
		Set<Product> samsungSet=new HashSet<Product>();
		samsungSet.add(galaxyJ7);
		samsungSet.add(galaxyTabA);
		samsung.setProduts(samsungSet);
		
		//save companies
		companyrepository.save(apple);
		companyrepository.save(samsung);
		
	}
	
	private void saveDataWithApproach2() {
		Company apple=new Company("Apple");
		Company samsung=new Company("Samsung");
		
		companyrepository.save(apple);
		companyrepository.save(samsung);
		
		
		Product iphone7=new Product("Iphone7",apple);
		Product iPadPro=new Product("IPadPro",apple);
		
		Product galaxyJ7=new Product("GalaxyJ7",samsung);
		Product galaxyTabA=new Product("GalaxyTabA",samsung);
		
		productrepository.save(iphone7);
		productrepository.save(iPadPro);
		
		productrepository.save(galaxyJ7);
		productrepository.save(galaxyTabA);
	}

	@Transactional
	public void clearData() {
		companyrepository.deleteAll();
		productrepository.deleteAll();
	}
	
    /*
    @Bean
    CommandLineRunner runner(StudentRepository repository) {
		return args->{
			repository.save(new Student((long) 5,"alan","qwerrtyuiop"));
			repository.save(new Student((long) 10001,"Ranga","A123456"));
			repository.save(new Student((long) 10002,"Ravi","B789456"));
		};
    }
    */
}
