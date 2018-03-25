/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cce.vietnguyen.model.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Tbl_NhomQuyen")
public class Tbl_NhomQuyen implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String ma;

	@NotEmpty
	private String name;
	
	@OneToMany(mappedBy = "nhomQuyenId", orphanRemoval=true,fetch=FetchType.EAGER)
	@JsonManagedReference
	private Set<Tbl_Quyen_NhomQuyen> tblQuyenNhomQuyens = new HashSet<Tbl_Quyen_NhomQuyen>();

	@Transient
    private List<Tbl_Quyen> tblQuyens = new ArrayList<>();


	@Override
	public String getAuthority() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

    public Set<Tbl_Quyen_NhomQuyen> getTblQuyenNhomQuyens() {
		return tblQuyenNhomQuyens;
	}
    public void setTblQuyenNhomQuyens(Set<Tbl_Quyen_NhomQuyen> tblQuyenNhomQuyens) {
		this.tblQuyenNhomQuyens = tblQuyenNhomQuyens;
		for(Tbl_Quyen_NhomQuyen it : tblQuyenNhomQuyens){
			tblQuyens.add(it.getQuyenId());
		}
	}

	public List<Tbl_Quyen> getTblQuyens() {
		return tblQuyens;
	}

	public void setTblQuyens(List<Tbl_Quyen> tblQuyens) {
		this.tblQuyens = tblQuyens;
	}
    
    

}
