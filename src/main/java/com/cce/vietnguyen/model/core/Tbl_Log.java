package com.cce.vietnguyen.model.core;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="tbl_Log")
public class Tbl_Log implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private String username;

   private String tableName;
   

   @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
   private Date timeLog;
   private String oldData;
   private String newData;
   private Long dataId;
   private String op;
   private String description;
   
   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getTableName() {
	return tableName;
}
public void setTableName(String tableName) {
	this.tableName = tableName;
}
public Date getTimeLog() {
	return timeLog;
}
public void setTimeLog(Date timeLog) {
	this.timeLog = timeLog;
}
public String getOldData() {
	return oldData;
}
public void setOldData(String oldData) {
	this.oldData = oldData;
}
public String getNewData() {
	return newData;
}
public void setNewData(String newData) {
	this.newData = newData;
}
    public Long getDataId() {
	    return dataId;
   }
   public void setDataId(Long dataId) {
	    this.dataId= dataId;
   }   
   public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}public String getOp() {
	return op;
}
public void setOp(String op) {
	this.op = op;
}
   
}//endClass 

