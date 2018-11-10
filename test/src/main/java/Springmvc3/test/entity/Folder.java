package Springmvc3.test.entity;

public class Folder {

	private Integer id;
	private String folderName;
	private String folderInfo;
	private Integer limitid;
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
