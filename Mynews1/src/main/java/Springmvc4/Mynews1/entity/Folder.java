package Springmvc4.Mynews1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //被註解@Entity，表明它是一個JPA實體
@Table(name = "t_folder")
public class Folder {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "folderName")
	private String folderName;
	@Column(name = "folderInfo")
	private String folderInfo;
	@Column(name = "limitid")
	private Integer limitid;
	@Column(name = "userid")
	private Integer userid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderInfo() {
		return folderInfo;
	}
	public void setFolderInfo(String folderInfo) {
		this.folderInfo = folderInfo;
	}
	public Integer getLimitid() {
		return limitid;
	}
	public void setLimitid(Integer limitid) {
		this.limitid = limitid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Folder [id=" + id + ", folderName=" + folderName + ", folderInfo=" + folderInfo + ", limitid=" + limitid
				+ ", userid=" + userid + "]";
	}
	
	
}
