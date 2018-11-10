package Springmvc3.test.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc3.test.entity.Category;
import Springmvc3.test.entity.News;

public interface NewsRepository extends CrudRepository<News, Integer>{

	@Modifying
	@Transactional
	@Query("update News n set n.title = ?1 where n.id = ?2")
	int updateTitle(String title, Integer id);
	
	@Modifying
	@Transactional
	@Query("update News n set n.category = ?1 where n.id = ?2")
	int updateCategory(Integer cid, Integer id);
	
	@Modifying
	@Transactional
	@Query("update News n set n.title=?1,n.content = ?2,n.createTime=?3 where n.id = ?4")
	int updateNew(String newTiltle,String newContent,Date newcreeateTime ,Integer id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE News n WHERE n.id=?1")
	int deleteNews(Integer id);
	
	
	
	
	
}
