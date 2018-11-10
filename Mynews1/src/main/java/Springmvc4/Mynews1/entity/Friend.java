package Springmvc4.Mynews1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //被註解@Entity，表明它是一個JPA實體
@Table(name = "t_friend")
public class Friend {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "friendid")
	private Integer friendid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFriendid() {
		return friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", userid=" + userid + ", friendid=" + friendid + "]";
	}
	
	
}
