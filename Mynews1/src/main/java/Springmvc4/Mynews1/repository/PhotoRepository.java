package Springmvc4.Mynews1.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import Springmvc4.Mynews1.entity.Photo;

public interface PhotoRepository  extends CrudRepository<Springmvc4.Mynews1.entity.Photo, Integer>{

	List<Photo> findByFolderid(Integer folderid);
	int countByFolderid(Integer folderid);
	Photo findById(Integer photoId);
	
	@Modifying
	@Transactional
	@Query(value="update photo p set p.photoName=?1,p.photoInfo=?2 where p.id=?3",nativeQuery = true)
	int updatePhoto(String photoName,String photoInfo,Integer id);
	
	
	
	
	@Modifying
	@Transactional
	@Query(value="select * from t_photo limit ?1,"+1,nativeQuery=true)
	List<Photo> getPhoto(Integer pageNumber);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into t_photo values(null,?1,?2,?3,?4,?5)",nativeQuery = true)
	int addPhoto(String photoName,String photoPath,String photoInfo,Date createTime,Integer folderid);

	
	@Modifying
	@Transactional
	@Query(value="delete from t_photo where id=?1",nativeQuery=true)
	int delPhoto(Integer photoid);
	
	//這個不能用
	@Modifying
	@Transactional
	@Query(value="select count(*) from t_photo where folderid=?1",nativeQuery=true)
	int totalpage(Integer folderid);
	
	@Modifying
	@Transactional
	@Query(value="select * from t_photo where folderid=?1 limit ?2,"+2,nativeQuery=true)
	List<Photo> getPhotoList(Integer folderid,Integer pageNumber);
}
