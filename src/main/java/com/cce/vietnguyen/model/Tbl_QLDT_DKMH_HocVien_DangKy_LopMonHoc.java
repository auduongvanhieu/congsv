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
/**
 *
 * @author IVS
 */
@Entity
@Table (name="tbl_QLDT_DKMH_DangKy_LopMonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc implements Serializable{
    private static final long serialVersionUID = -1989579066723007050L;
    
    private Long id;
    private Long hocVienId;
    private Long lopMonHocId;
    private Long hocKyId;
    private Date ngayDangKy;
    private String ketQuaDK;
    private String hinhThucDK;
    private String ketQuaXuLy;
    private String noiDungXuLy;
    private Date ngayCapNhat;
    private String taiKhoanCapNhat;
    private Integer duyetYN;
    private String trangThai;
    
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public Long getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(Long hocVienId) {
        this.hocVienId = hocVienId;
    }

    public Long getLopMonHocId() {
        return lopMonHocId;
    }

    public void setLopMonHocId(Long lopMonHocId) {
        this.lopMonHocId = lopMonHocId;
    }

    public Long getHocKyId() {
        return hocKyId;
    }

    public void setHocKyId(Long hocKyId) {
        this.hocKyId = hocKyId;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getKetQuaDK() {
        return ketQuaDK;
    }

    public void setKetQuaDK(String ketQuaDK) {
        this.ketQuaDK = ketQuaDK;
    }

    public String getHinhThucDK() {
        return hinhThucDK;
    }

    public void setHinhThucDK(String hinhThucDK) {
        this.hinhThucDK = hinhThucDK;
    }

    public String getKetQuaXuLy() {
        return ketQuaXuLy;
    }

    public void setKetQuaXuLy(String ketQuaXuLy) {
        this.ketQuaXuLy = ketQuaXuLy;
    }

    public String getNoiDungXuLy() {
        return noiDungXuLy;
    }

    public void setNoiDungXuLy(String noiDungXuLy) {
        this.noiDungXuLy = noiDungXuLy;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getTaiKhoanCapNhat() {
        return taiKhoanCapNhat;
    }

    public void setTaiKhoanCapNhat(String taiKhoanCapNhat) {
        this.taiKhoanCapNhat = taiKhoanCapNhat;
    }

    public Integer getDuyetYN() {
        return duyetYN;
    }

    public void setDuyetYN(Integer duyetYN) {
        this.duyetYN = duyetYN;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
