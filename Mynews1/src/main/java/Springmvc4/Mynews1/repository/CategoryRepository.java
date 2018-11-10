package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.Photo;


public interface CategoryRepository extends CrudRepository<Springmvc4.Mynews1.entity.Category, Integer> {
	public List<Category> findByTopId(Integer tid);
	public Category findById(Integer id);
	//用name和topId查詢
	public List<Category> findByNameAndTopId(String name,Integer tid);
	//用2個數字作為範圍查詢
	public List<Category> findByIdBetween(Integer num1,Integer num2);
	//小於等於一個數字做查詢
	public List<Category> findByTopIdLessThanEqual(Integer num1);
	//大於等於一個數字做查詢
	public List<Category> findByTopIdGreaterThanEqual(Integer num1);
	//顯示指定日期之後的查詢
	public List<Category> findByStartdateAfter(Date date);
	//like查詢
	public List<Category> findByNameLike(String likeName);
	//Containing查詢
	public List<Category> findByNameContaining(String ContainingName);
	
	
	@Query(value="select name from category where topId=?1",nativeQuery = true)
	List<String> selectName(Integer topId);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into category values(null,?1,?2,?3,?4)",nativeQuery = true)
	int insertCategory(String categoryName,Integer categorTopid,Date date,String categoryContent);
	
	@Modifying
	@Transactional
	@Query(value="update category c set c.name=?1,c.topId=?2,c.content=?3 where c.id=?4",nativeQuery = true)
	int updateCategory(String categoryName,Integer categoryTopid,String categoryContent,Integer id);
	
	@Modifying
	@Transactional
	@Query(value="select * from category where topId=?1 limit ?2,"+1,nativeQuery=true)
	List<Category> getCategoryList(Integer topId,Integer pageNumber);
	
	
}
