package Springmvc3.test.entity;

public class Photo {

	private Integer id;
	private String photoName;
	private String photoPath;
	private String photoInfo;
	private String createTime;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
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
