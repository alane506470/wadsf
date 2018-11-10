package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.User;

public interface UserRepository extends CrudRepository<Springmvc4.Mynews1.entity.User, Integer>{

	//判別用戶是否存在
	User findByUserName(String userName);
	//登陸驗證
	User findByUserNameAndUserPassword(String userName,String userPassword);
	//查找個人資料
	User findById(Integer id);
	
	//顯示所有用戶
	@Query(value="select * from t_user",nativeQuery=true)
	List<User> findAllUser();
	
	@Modifying
	@Transactional
	@Query(value="update User u set u.number=?1 where u.id=?2")
	int addUserNumber(Integer number,Integer id);
	
	@Modifying
	@Transactional
	@Query(value="insert into t_user values(null,?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
	int insertUser(String userName,String userPassword,String sex,Date birthday,String telephone,String email,String address,String remark);

	@Modifying
	@Transactional
	@Query(value="update t_user u set u.userPassword=?1 where u.id=?2",nativeQuery=true)
	int updatePassword(String password,Integer userid);
	
	@Modifying
	@Transactional
	@Query(value="update t_user u set u.userName=?1,u.telephone=?2,u.email=?3,u.address=?4,u.remark=?5 where u.id=?6",nativeQuery=true)
	int updateUser(String username,String telephone,String email,String address,String remark,Integer userid);
	
}
