package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.News;

public interface NewsRepository extends CrudRepository<News, Integer>{

	News findById(Integer id);
	
	@Query(value="select * from news n join category c on n.cid=c.id where c.topId=?1",nativeQuery=true)
	List<News> selectTopIdList(int topId);
	
	@Query(value="select count(n) from News n where n.category.topId=?1")
	int getPageCount(Integer topId);
	
	@Query(value="select * from news n join category c on n.cid=c.id where c.topId=?1 limit ?2,?3",nativeQuery=true)
	List<News> selectListByTopId(int topId,int pageNo,int pageSize);
	
	@Modifying
	@Transactional
	@Query("update News n set n.title = ?1 where n.id = ?2")
	int updateTitle(String title, Integer id);

	@Modifying
	@Transactional
	@Query("update News n set n.title=?1,n.content = ?2,n.createTime=?3,n.category=?4 where n.id = ?5")
	int updateNew(String newTiltle,String newContent,Date newcreeateTime,Category category,Integer id);

	@Modifying
	@Transactional
	@Query("DELETE News n WHERE n.id=?1")
	int deleteNews(Integer id);
	
	
	
	
	
	
	
}
