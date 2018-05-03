/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cce.vietnguyen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
import com.cce.vietnguyen.util.Constants;
import java.util.HashMap;
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
    public String createObj(@RequestBody Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc obj,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
//        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", "them")) {
//        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//        }
        try {
            
            HashMap<String,Object> result=new HashMap();
            
            //Kiểm tra tồn tại
            List<MyFilter> cons = new ArrayList<MyFilter>();
            cons = buildFilter(obj);
            List<Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc> dkmh= genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons, 20, 1);
            if(dkmh.size()>0)
            {
                result.put(Constants.RESULT_FLAG, "false");
                result.put(Constants.RESULT_MESSAGE,Constants.REGISTER_ISEXIST);
                return (new JSONObject(result)).toString();
            }
            
            //Lấy lớp môn học
            List<MyFilter> cons2 = new ArrayList<MyFilter>();
            cons2 = buildFilterLopMonHoc(obj);
            List<Tbl_QLDT_TKB_LopMonHoc> dkmh2= genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc.class, cons2, -1, 1);

            //Kiểm tra sỉ số
            List<MyFilter> cons3 = new ArrayList<MyFilter>();
            cons3 = buildFilterLopMonHocDK(obj);
            List<Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc> dkmh3= genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons3, -1, 1);
            if(dkmh3.size()>=dkmh2.get(0).getSiSoMax())
            {
                result.put(Constants.RESULT_FLAG, "false");
                result.put(Constants.RESULT_MESSAGE,Constants.CLASS_ISFULL);
                return (new JSONObject(result)).toString();
            }
            
            //Thực hiện insert
            Long id = genericDAO.save(obj);
            obj.setId(id);
            
            //Thoã mãn
            result.put(Constants.RESULT_FLAG, "true");
            result.put(Constants.RESULT_MESSAGE,Constants.REGISTER_SUCCESS);
            return (new JSONObject(result)).toString();
        } catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return (new ResponseEntity(HttpStatus.EXPECTATION_FAILED)).toString();
        }
    }
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc/list", method = RequestMethod.POST)
    public String createObj(@RequestBody List<Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc> objs,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
//        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", "them")) {
//        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//        }
           HashMap<String,Object> result=new HashMap();
           
            for (Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc obj : objs) {
                //Kiểm tra tồn tại
                List<MyFilter> cons = new ArrayList<MyFilter>();
                cons = buildFilter(obj);
                List<Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc> dkmh= genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons, 20, 1);
                if(dkmh.size()>0)
                {
                    result.put(Constants.RESULT_FLAG, "false");
                    result.put(Constants.RESULT_MESSAGE,Constants.REGISTER_ISEXIST);
                    return (new JSONObject(result)).toString();
                }        
                //Lấy lớp môn học
                List<MyFilter> cons2 = new ArrayList<MyFilter>();
                cons2 = buildFilterLopMonHoc(obj);
                List<Tbl_QLDT_TKB_LopMonHoc> dkmh2= genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc.class, cons2, -1, 1);

                //Kiểm tra sỉ số
                List<MyFilter> cons3 = new ArrayList<MyFilter>();
                cons3 = buildFilterLopMonHocDK(obj);
                List<Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc> dkmh3= genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, cons3, -1, 1);
                if(dkmh3.size()>=dkmh2.get(0).getSiSoMax())
                {
                    result.put(Constants.RESULT_FLAG, "false");
                    result.put(Constants.RESULT_MESSAGE,Constants.CLASS_ISFULL);
                    return (new JSONObject(result)).toString();
                }
            }
        for (Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc obj : objs) {
            //Thực hiện insert
            try {
            Long id = genericDAO.save(obj);
            obj.setId(id);
            } catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return (new ResponseEntity(HttpStatus.EXPECTATION_FAILED)).toString();
        }
        }
        //Thoã mãn
        result.put(Constants.RESULT_FLAG, "true");
        result.put(Constants.RESULT_MESSAGE,Constants.REGISTER_SUCCESS);
        return (new JSONObject(result)).toString();
    }
    
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc/{id}", method = RequestMethod.DELETE)
    public String deleteObj(@PathVariable Long id,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (user == null || user.getId().equals(new Long(0))) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE).toString();
        }
        try{
            genericDAO.delete(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, id);
            HashMap<String,Object> result=new HashMap();
            //Thoã mãn
            result.put(Constants.RESULT_FLAG, "true");
            result.put(Constants.RESULT_MESSAGE,Constants.DELETE_SUCCESS);
            return (new JSONObject(result)).toString();
        }catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED).toString();
        }
    }
    
    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_lopmonhoc", method = RequestMethod.DELETE)
    public String deleteObj(@RequestParam(required = false) Long id1,@RequestParam(required = false) Long id2,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        
        if (user == null || user.getId().equals(new Long(0))) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE).toString();
        }
        try{
            if(id1 != null)
                genericDAO.delete(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, id1);
            if(id2 != null)
                genericDAO.delete(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc.class, id2);
        }catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED).toString();
        }
        
        HashMap<String,Object> result=new HashMap();
        //Thoã mãn
        result.put(Constants.RESULT_FLAG, "true");
        result.put(Constants.RESULT_MESSAGE,Constants.DELETE_SUCCESS);
        return (new JSONObject(result)).toString();
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
    
    private List<MyFilter> buildFilter(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        if (request.getHocVienId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("hocVienId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getHocVienId().toString()));
                cons.add(con);
            }
        if (request.getLopMonHocId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("lopMonHocId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getLopMonHocId().toString()));
                cons.add(con);
            }
        if (request.getHocKyId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("hocKyId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getHocKyId().toString()));
                cons.add(con);
            }
        return cons;
    }
    private List<MyFilter> buildFilterLopMonHocDK(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        if (request.getLopMonHocId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("lopMonHocId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getLopMonHocId().toString()));
                cons.add(con);
            }
        if (request.getHocKyId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("hocKyId");
                con.setOperator("eq");
                con.setValue1(new Long(request.getHocKyId().toString()));
                cons.add(con);
            }
        return cons;
    }
    private List<MyFilter> buildFilterLopMonHoc(Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        if (request.getLopMonHocId() != null) {
                MyFilter con = new MyFilter();
                con.setCol("id");
                con.setOperator("eq");
                con.setValue1(new Long(request.getLopMonHocId().toString()));
                cons.add(con);
            }
        return cons;
    }
    
}
