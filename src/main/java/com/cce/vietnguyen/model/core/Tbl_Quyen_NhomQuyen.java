package com.cce.vietnguyen.model.core;
import java.io.Serializable;
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
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name="tbl_Quyen_NhomQuyen")
public class Tbl_Quyen_NhomQuyen implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private Tbl_NhomQuyen nhomQuyenId = null;
   private Tbl_Quyen quyenId = null;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   @ManyToOne
   @JoinColumn(name="nhomQuyenId")
   @JsonBackReference
   public Tbl_NhomQuyen getNhomQuyenId() {
	return nhomQuyenId;
}
public void setNhomQuyenId(Tbl_NhomQuyen nhomQuyenId) {
	this.nhomQuyenId = nhomQuyenId;
}


   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="quyenId")
   public Tbl_Quyen getQuyenId() {
	    return quyenId;
   }
public void setQuyenId(Tbl_Quyen maQuyen) {
	    this.quyenId = maQuyen;
   }
}//endClass 

