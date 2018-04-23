/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


@Entity
@Table (name="view_QLDT_DKMH_DangKy_LopMonHoc_TuDo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class View_QLDT_DKMH_HocVien_DangKy_LopMonHoc_TuDo {
    private static final long serialVersionUID = -1989579066723007050L;
    //variable
 
    private Long id;
    private Long lopMonHocId;
    private Long khoiNganhId;
    private Long giaoVienId;
    private Long hocKyId;
    private Long monHocId;
    private String maMonHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Integer moLopYN;
    private Integer tongSoTiet;
    private Integer siSoMin;
    private Integer siSoMax;
    private String tenMonHoc;
    private Integer tietHoc;
    private Integer soTiet;
    private Integer ngayId;
    private String tenGV;
    private Long monHocKemId;
    private Integer siSoThuc;
    
    @Id
    @GeneratedValue
    public Long getId (){
    return this.id;
    }
    public void setId (Long id){
    this.id = id;
    }

    public Integer getNgayId() {
        return ngayId;
    }

    public void setNgayId(Integer ngayId) {
        this.ngayId = ngayId;
    }

    public Long getMonHocKemId() {
        return monHocKemId;
    }

    public void setMonHocKemId(Long monHocKemId) {
        this.monHocKemId = monHocKemId;
    }
    
    

    public Long getLopMonHocId() {
        return lopMonHocId;
    }

    public void setLopMonHocId(Long lopMonHocId) {
        this.lopMonHocId = lopMonHocId;
    }

    public Long getKhoiNganhId() {
        return khoiNganhId;
    }

    public void setKhoiNganhId(Long khoiNganhId) {
        this.khoiNganhId = khoiNganhId;
    }

    public Long getGiaoVienId() {
        return giaoVienId;
    }

    public void setGiaoVienId(Long giaoVienId) {
        this.giaoVienId = giaoVienId;
    }

    public Long getHocKyId() {
        return hocKyId;
    }

    public void setHocKyId(Long hocKyId) {
        this.hocKyId = hocKyId;
    }

    public Long getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(Long monHocId) {
        this.monHocId = monHocId;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getMoLopYN() {
        return moLopYN;
    }

    public void setMoLopYN(Integer moLopYN) {
        this.moLopYN = moLopYN;
    }

    public Integer getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(Integer tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public Integer getSiSoMin() {
        return siSoMin;
    }

    public void setSiSoMin(Integer siSoMin) {
        this.siSoMin = siSoMin;
    }

    public Integer getSiSoMax() {
        return siSoMax;
    }

    public void setSiSoMax(Integer siSoMax) {
        this.siSoMax = siSoMax;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getTietHoc() {
        return tietHoc;
    }

    public void setTietHoc(Integer tietHoc) {
        this.tietHoc = tietHoc;
    }

    public Integer getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(Integer soTiet) {
        this.soTiet = soTiet;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public Integer getSiSoThuc() {
        return siSoThuc;
    }

    public void setSiSoThuc(Integer siSoThuc) {
        this.siSoThuc = siSoThuc;
    }
    
}
