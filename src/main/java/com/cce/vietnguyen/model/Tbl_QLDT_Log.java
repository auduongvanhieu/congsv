


package com.cce.vietnguyen.model;
import java.io.Serializable;
import java.sql.Types;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_Log")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_Log implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String newData;
  private String oldData;
  private String tableName;
  private Date timeLog;
  private String username;
  private Double dataId;
  private String description;
  private String op;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getNewData (){
return this.newData;
}
public void setNewData (String newData){
this.newData= newData;
}
 
public String getOldData (){
return this.oldData;
}
public void setOldData (String oldData){
this.oldData= oldData;
}
 
public String getTableName (){
return this.tableName;
}
public void setTableName (String tableName){
this.tableName= tableName;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getTimeLog (){
return this.timeLog;
}
public void setTimeLog (Date timeLog){
this.timeLog= timeLog;
}
 
public String getUsername (){
return this.username;
}
public void setUsername (String username){
this.username= username;
}
 
public Double getDataId (){
return this.dataId;
}
public void setDataId (Double dataId){
this.dataId= dataId;
}
 
public String getDescription (){
return this.description;
}
public void setDescription (String description){
this.description= description;
}
 
public String getOp (){
return this.op;
}
public void setOp (String op){
this.op= op;
}
}//endClass
