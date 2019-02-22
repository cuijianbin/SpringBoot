package com.boot.entity.zdrdata;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * group_label_relation 实体类
 * Mon Jul 23 11:43:31 CST 2018
 * @cuijianbin
 */ 
@Entity
@Table(name = "group_label_relation", schema = "zdr_data", catalog = "")
public class GroupLabelRelation  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "auto_id")
	private Integer autoId;

	@NotNull
	@Column(name = "gid")
	private Integer gid;

	@NotNull
	@Column(name = "lid")
	private Integer lid;

	@NotNull
	@Column(name = "label_level")
	private Short labelLevel;


	public Integer getAutoId(){
		return autoId;
	}

	public void setAutoId(Integer autoId){
		this.autoId=autoId;
	}

	public Integer getGid(){
		return gid;
	}

	public void setGid(Integer gid){
		this.gid=gid;
	}

	public Integer getLid(){
		return lid;
	}

	public void setLid(Integer lid){
		this.lid=lid;
	}

	public Short getLabelLevel(){
		return labelLevel;
	}

	public void setLabelLevel(Short labelLevel){
		this.labelLevel=labelLevel;
	}

}

