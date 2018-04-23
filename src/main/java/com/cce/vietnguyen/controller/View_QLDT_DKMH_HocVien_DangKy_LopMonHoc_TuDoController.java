/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cce.vietnguyen.controller;

import com.cce.vietnguyen.model.View_QLDT_DKMH_HocVien_DangKy_LopMonHoc_TuDo;
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


@RestController
public class View_QLDT_DKMH_HocVien_DangKy_LopMonHoc_TuDoController {
    @Autowired
    private GenericDao genericDAO;
    @Autowired
    private GenericRepository genericRepository;
    
    @RequestMapping(value = "/view_qldt_dkmh_hocvien_dangky_lopmonhoc_tudo", method = RequestMethod.GET)
    public List getAll() {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        {
            MyFilter con = new MyFilter();
            con.setOperator("order");
            con.setValue1("desc");
            con.setCol("id");
            cons.add(con);
        }
        return genericDAO.findByCondition(View_QLDT_DKMH_HocVien_DangKy_LopMonHoc_TuDo.class, cons, 20, 1);
    }
    
    @RequestMapping(value = "/view_qldt_dkmh_hocvien_dangky_lopmonhoc_tudo/find", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
             @RequestParam(required = false) Integer page,
             HttpServletRequest request,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        
        if (user == null || user.getId().equals(new Long(0))) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
        
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
            if (page == null ||page == 0) {
                page = 1;
            }
            return new ResponseEntity(genericDAO.findByCondition(View_QLDT_DKMH_HocVien_DangKy_LopMonHoc_TuDo.class, cons, pageSize, page), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
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
        if (request.getParameter("lopMonHocId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("lopMonHocId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("lopMonHocId").toString()));
                cons.add(con);
        }
        if (request.getParameter("monHocId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("monHocId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("monHocId").toString()));
                cons.add(con);
        }
        if (request.getParameter("maMonHoc") != null) {
            MyFilter con = new MyFilter();
            con.setCol("maMonHoc");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("maMonHoc") + "%");
            cons.add(con);
        }
        if (request.getParameter("tenMonHoc") != null) {
            MyFilter con = new MyFilter();
            con.setCol("tenMonHoc");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("tenMonHoc") + "%");
            cons.add(con);
        }
        if (request.getParameter("tenGV") != null) {
            MyFilter con = new MyFilter();
            con.setCol("tenGV");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("tenGV") + "%");
            cons.add(con);
        }
        if (request.getParameter("monHocKemId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("monHocKemId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("monHocKemId").toString()));
                cons.add(con);
        }
        return cons;
    }
}