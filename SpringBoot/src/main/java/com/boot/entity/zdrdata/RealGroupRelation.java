package com.boot.entity.zdrdata;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * real_group_relation 实体类
 * Mon Jul 23 11:43:32 CST 2018
 * @cuijianbin
 */ 
@Entity
@Table(name = "real_group_relation", schema = "zdr_data", catalog = "")
public class RealGroupRelation  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "auto_id")
	private Long autoId;

	@NotNull
	@Column(name = "gid")
	private Long gid;

	@NotNull
	@Column(name = "rid")
	private Long rid;

	@NotNull
	@Column(name = "sysuser_id")
	private Integer sysuserId;


	public Long getAutoId(){
		return autoId;
	}

	public void setAutoId(Long autoId){
		this.autoId=autoId;
	}

	public Long getGid(){
		return gid;
	}

	public void setGid(Long gid){
		this.gid=gid;
	}

	public Long getRid(){
		return rid;
	}

	public void setRid(Long rid){
		this.rid=rid;
	}

	public Integer getSysuserId(){
		return sysuserId;
	}

	public void setSysuserId(Integer sysuserId){
		this.sysuserId=sysuserId;
	}

}

