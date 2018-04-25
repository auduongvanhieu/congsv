/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cce.vietnguyen.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc;

@RestController
public class Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHocController {
    
    @Autowired
    private GenericDao genericDAO;
    @Autowired
    private GenericRepository genericRepository;
    
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", method = RequestMethod.GET)
    public List getAll() {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        {
            MyFilter con = new MyFilter();
            con.setOperator("order");
            con.setValue1("desc");
            con.setCol("id");
            cons.add(con);
        }
        return genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons, 20, 1);
    }
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc/find", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
             @RequestParam(required = false) Integer page,
             HttpServletRequest request,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        
        try {
            List<MyFilter> cons = new ArrayList<MyFilter>();
            cons = buildFilter(request);
            {
                MyFilter con = new MyFilter();
                con.setOperator("order");
                con.setValue1("desc");
                con.setCol("id");
                cons.add(con);
            }
            if (pageSize == null || pageSize == 0) {
                pageSize = 20;
            } else if (pageSize == -1) {
                pageSize = 0;
            }
            if (page == null || page == 0) {
                page = 1;
            }
            return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons, pageSize, page), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", method = RequestMethod.POST)
    public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc obj,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
//        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", "them")) {
//        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//        }
        try {
            Long id = genericDAO.save(obj);
            obj.setId(id);
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteObj(@PathVariable Long id,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (user == null || user.getId().equals(new Long(0))) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        genericDAO.delete(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
    
    private List<MyFilter> buildFilter(HttpServletRequest request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        //variable
        try {
            if (request.getParameter("id") != null) {
                MyFilter con = new MyFilter();
                con.setCol("id");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("id").toString()));
                cons.add(con);
            }
        } catch (Exception e) {
        }
        if (request.getParameter("hocVienId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("hocVienId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("hocVienId").toString()));
                cons.add(con);
            }
        return cons;
    }
}
