


package com.cce.vietnguyen.model.core;
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
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_Config")
public class Tbl_Config implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
@Id
@GeneratedValue
private Long id;
  private String code;
  private String name;
  private String val;
  private String note;

//get/set
  public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getCode (){
return this.code;
}
public void setCode (String code){
this.code= code;
}
 
public String getName (){
return this.name;
}
public void setName (String name){
this.name= name;
}
 
public String getVal (){
return this.val;
}
public void setVal (String val){
this.val= val;
}
 
public String getNote (){
return this.note;
}
public void setNote (String note){
this.note= note;
}
}//endClass
