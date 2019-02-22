package com.boot.entity.zdrdata;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * group_infos 实体类
 * Mon Jul 23 11:43:31 CST 2018
 * @cuijianbin
 */ 
@Entity
@Table(name = "group_infos", schema = "zdr_data", catalog = "")
public class GroupInfos  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "gid")
	private Long gid;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_type")
	private String groupType;

	@Column(name = "group_key_words")
	private String groupKeyWords;

	@Column(name = "group_img_path")
	private String groupImgPath;

	@Column(name = "comment")
	private String comment;

	@Column(name = "status")
	private Short status;

	@Column(name = "group_address")
	private String groupAddress;

	@Column(name = "group_target")
	private String groupTarget;

	@Column(name = "official_website")
	private String officialWebsite;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time")
	private Date createTime;

	@NotNull
	@Column(name = "sysuser_id")
	private Long sysuserId;


	public Long getGid(){
		return gid;
	}

	public void setGid(Long gid){
		this.gid=gid;
	}

	public String getGroupName(){
		return groupName;
	}

	public void setGroupName(String groupName){
		this.groupName=groupName;
	}

	public String getGroupType(){
		return groupType;
	}

	public void setGroupType(String groupType){
		this.groupType=groupType;
	}

	public String getGroupKeyWords(){
		return groupKeyWords;
	}

	public void setGroupKeyWords(String groupKeyWords){
		this.groupKeyWords=groupKeyWords;
	}

	public String getGroupImgPath(){
		return groupImgPath;
	}

	public void setGroupImgPath(String groupImgPath){
		this.groupImgPath=groupImgPath;
	}

	public String getComment(){
		return comment;
	}

	public void setComment(String comment){
		this.comment=comment;
	}

	public Short getStatus(){
		return status;
	}

	public void setStatus(Short status){
		this.status=status;
	}

	public String getGroupAddress(){
		return groupAddress;
	}

	public void setGroupAddress(String groupAddress){
		this.groupAddress=groupAddress;
	}

	public String getGroupTarget(){
		return groupTarget;
	}

	public void setGroupTarget(String groupTarget){
		this.groupTarget=groupTarget;
	}

	public String getOfficialWebsite(){
		return officialWebsite;
	}

	public void setOfficialWebsite(String officialWebsite){
		this.officialWebsite=officialWebsite;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Long getSysuserId(){
		return sysuserId;
	}

	public void setSysuserId(Long sysuserId){
		this.sysuserId=sysuserId;
	}

}

