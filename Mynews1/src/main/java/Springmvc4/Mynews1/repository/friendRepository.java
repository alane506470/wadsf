package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Friend;

public interface friendRepository extends CrudRepository<Springmvc4.Mynews1.entity.Friend, Integer>{

	
	Friend findByUseridAndFriendid(Integer userid,Integer friendid);
	@Modifying
	@Transactional
	@Query(value="select friendid from t_friend where userid=?1",nativeQuery = true)
	List<Integer> findFriendId(Integer userid);
	
	@Modifying
	@Transactional
	@Query(value="insert into t_friend values(null,?1,?2)",nativeQuery = true)
	int addFriend(Integer userid,Integer friendid);
}
