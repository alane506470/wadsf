package Springmvc4.Mynews1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Folder;

public interface FolderRepository extends CrudRepository<Springmvc4.Mynews1.entity.Folder, Integer>{

	
	@Modifying
	@Transactional
	@Query(value="insert into t_folder values(null,?1,?2,?3,?4)",nativeQuery = true)
	int addFolder(String folderName,String folderInfo,Integer limitid,Integer useid);

	List<Folder> findByUserid(Integer userid);
	
	Folder findById(Integer folderid);
	
	//用藥評論的相冊id去獲得好友id
	//sql exception Can not issue executeUpdate for SELECTs with SELECT query
	@Modifying
	@Transactional
	@Query(value="select userid from t_folder where id=?1",nativeQuery=true)
	int getfriendId(Integer folderid);
	
	/*
	@Modifying
	@Transactional
	@Query(value="select count(*) from t_folder",nativeQuery=true)
	int countNumber();
	
	*/
}
