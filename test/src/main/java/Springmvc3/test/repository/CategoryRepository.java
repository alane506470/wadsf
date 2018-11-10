package Springmvc3.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Springmvc3.test.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public Category findByTopId(Integer tid);
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
	
	
	
}
