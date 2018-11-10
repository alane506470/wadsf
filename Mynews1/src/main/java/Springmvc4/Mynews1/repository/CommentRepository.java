package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Comment;

public interface CommentRepository extends CrudRepository<Springmvc4.Mynews1.entity.Comment, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="insert into t_comment values(null,?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
	int addComment(Integer photoid,Integer folderid,Integer friendid,Integer userid,String photo_comment,Date comment_time,Integer statu_s);
	
	List<Comment> findByUserid(Integer userid);
	Comment findById(Integer id);
}
