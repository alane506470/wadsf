package Springmvc4.Mynews1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //被註解@Entity，表明它是一個JPA實體
@Table(name = "t_photo")
public class Photo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "photoName")
	private String photoName;
	
	@Column(name = "photoPath")
	private String photoPath;
	
	@Column(name = "photoInfo")
	private String photoInfo;
	
	@Column(name = "createTime")
	private Date createTime;
	
	@Column(name = "folderid")
	private 	Integer folderid;
	
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getPhotoInfo() {
		return photoInfo;
	}
	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getFolderid() {
		return folderid;
	}
	public void setFolderid(Integer folderid) {
		this.folderid = folderid;
	}
	@Override
	public String toString() {
		return "Photo [id=" + id + ", photoName=" + photoName + ", photoPath=" + photoPath + ", photoInfo=" + photoInfo
				+ ", createTime=" + createTime + ", folderid=" + folderid + "]";
	}
	
	
}
