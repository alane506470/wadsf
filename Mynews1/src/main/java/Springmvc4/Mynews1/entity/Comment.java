package Springmvc4.Mynews1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //被註解@Entity，表明它是一個JPA實體
@Table(name = "t_comment")
public class Comment {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "photoid")
	private Integer photoid;
	
	@Column(name = "folderid")
	private Integer folderid;
	
	
	@Column(name = "friendid")
	private Integer friendid;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "photo_comment")
	private String photo_comment;
	
	@Column(name = "comment_time")
	private Date comment_time;
	
	@Column(name = "statu_s")
	private Integer statu_s;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPhotoid() {
		return photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public Integer getFolderid() {
		return folderid;
	}

	public void setFolderid(Integer folderid) {
		this.folderid = folderid;
	}

	public Integer getFriendid() {
		return friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPhoto_comment() {
		return photo_comment;
	}

	public void setPhoto_comment(String photo_comment) {
		this.photo_comment = photo_comment;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public Integer getStatu_s() {
		return statu_s;
	}

	public void setStatu_s(Integer statu_s) {
		this.statu_s = statu_s;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", photoid=" + photoid + ", folderid=" + folderid + ", friendid=" + friendid
				+ ", userid=" + userid + ", photo_comment=" + photo_comment + ", comment_time=" + comment_time
				+ ", statu_s=" + statu_s + "]";
	}
	
	
	
	
	
}
