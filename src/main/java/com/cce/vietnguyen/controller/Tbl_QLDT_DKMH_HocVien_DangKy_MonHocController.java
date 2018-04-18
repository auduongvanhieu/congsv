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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc;

import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_MonHocMoDangKy;


/*
* Controller Template: Template/Server/ControllerTemplate.java
 */
@RestController
public class Tbl_QLDT_DKMH_HocVien_DangKy_MonHocController {

    @Autowired
    private GenericDao genericDAO;
    @Autowired
    private GenericRepository genericRepository;

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc", method = RequestMethod.GET)
    public List getAll() {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        {
            MyFilter con = new MyFilter();
            con.setOperator("order");
            con.setValue1("desc");
            con.setCol("id");
            cons.add(con);
        }
        return genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc.class, cons, 20, 1);
    }

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc/find", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
             @RequestParam(required = false) Integer page,
             HttpServletRequest request,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "xem")) {
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
            if (page == 0) {
                page = 1;
            }
            return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc.class, cons, pageSize, page), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc/{id}", method = RequestMethod.GET)
    public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "xem")) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc obj = (Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc) genericDAO.get(Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc.class, id);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc", method = RequestMethod.POST)
    public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc obj,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
//        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "them")) {
//            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
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

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteObj(@PathVariable Long id,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "xoa")) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        genericDAO.delete(Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc.class, id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc", method = RequestMethod.PUT)
    public ResponseEntity updateObj(@RequestBody Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc obj,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "sua")) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            genericDAO.saveOrUpdate(obj);
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            System.out.println("object already exist");
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/tbl_qldt_dkmh_hocvien_dangky_monhoc/count", method = RequestMethod.GET)
    public ResponseEntity count(HttpServletRequest request,
             @AuthenticationPrincipal Tbl_TaiKhoan user) {
        if (!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_dangky_monhoc", "xem")) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        List<MyFilter> cons = new ArrayList<MyFilter>();
        cons = buildFilter(request);
        return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc.class, cons), HttpStatus.OK);
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
        if (request.getParameter("maDieuChinh") != null) {
            MyFilter con = new MyFilter();
            con.setCol("maDieuChinh");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("maDieuChinh") + "%");
            cons.add(con);
        }
        if (request.getParameter("ketQua") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ketQua");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("ketQua") + "%");
            cons.add(con);
        }
        if (request.getParameter("xacNhanYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("xacNhanYN");
            con.setOperator("eq");
            con.setValue1(Integer.parseInt(request.getParameter("xacNhanYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("fromXacNhanYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("xacNhanYN");
            con.setOperator("ge");
            con.setValue1(Integer.parseInt(request.getParameter("fromXacNhanYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("toXacNhanYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("xacNhanYN");
            con.setOperator("le");
            con.setValue1(Integer.parseInt(request.getParameter("toXacNhanYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("ngayDangKy") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ngayDangKy");
            con.setType("Date");
            con.setOperator("eq");
            con.setValue1(request.getParameter("ngayDangKy").toString());
            cons.add(con);
        }
        if (request.getParameter("fromNgayDangKy") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ngayDangKy");
            con.setType("Date");
            con.setOperator("ge");
            con.setValue1(request.getParameter("fromNgayDangKy").toString());
            cons.add(con);
        }
        if (request.getParameter("toNgayDangKy") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ngayDangKy");
            con.setType("Date");
            con.setOperator("le");
            con.setValue1(request.getParameter("toNgayDangKy").toString());
            cons.add(con);
        }

        if (request.getParameter("hocPhi") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocPhi");
            con.setOperator("eq");
            con.setValue1(Double.parseDouble(request.getParameter("hocPhi").toString()));
            cons.add(con);
        }
        if (request.getParameter("fromHocPhi") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocPhi");
            con.setOperator("ge");
            con.setValue1(Double.parseDouble(request.getParameter("fromHocPhi").toString()));
            cons.add(con);
        }
        if (request.getParameter("toHocPhi") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocPhi");
            con.setOperator("le");
            con.setValue1(Double.parseDouble(request.getParameter("toHocPhi").toString()));
            cons.add(con);
        }
        if (request.getParameter("ketQuaDKLyDo") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ketQuaDKLyDo");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("ketQuaDKLyDo") + "%");
            cons.add(con);
        }
        if (request.getParameter("khoaKetQuaYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("khoaKetQuaYN");
            con.setOperator("eq");
            con.setValue1(Integer.parseInt(request.getParameter("khoaKetQuaYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("fromKhoaKetQuaYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("khoaKetQuaYN");
            con.setOperator("ge");
            con.setValue1(Integer.parseInt(request.getParameter("fromKhoaKetQuaYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("toKhoaKetQuaYN") != null) {
            MyFilter con = new MyFilter();
            con.setCol("khoaKetQuaYN");
            con.setOperator("le");
            con.setValue1(Integer.parseInt(request.getParameter("toKhoaKetQuaYN").toString()));
            cons.add(con);
        }
        if (request.getParameter("tinhTrang") != null) {
            MyFilter con = new MyFilter();
            con.setCol("tinhTrang");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("tinhTrang") + "%");
            cons.add(con);
        }
        if (request.getParameter("ketQuaXepLop") != null) {
            MyFilter con = new MyFilter();
            con.setCol("ketQuaXepLop");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("ketQuaXepLop") + "%");
            cons.add(con);
        }
        if (request.getParameter("lyDoXepLop") != null) {
            MyFilter con = new MyFilter();
            con.setCol("lyDoXepLop");
            con.setOperator("like");
            con.setValue1("%" + (String) request.getParameter("lyDoXepLop") + "%");
            cons.add(con);
        }
        if (request.getParameter("hocVienId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocVienId");
            con.setOperator("eq");
            con.setValue1(Double.parseDouble(request.getParameter("hocVienId").toString()));
            cons.add(con);
        }
        if (request.getParameter("fromHocVienId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocVienId");
            con.setOperator("ge");
            con.setValue1(Double.parseDouble(request.getParameter("fromHocVienId").toString()));
            cons.add(con);
        }
        if (request.getParameter("toHocVienId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocVienId");
            con.setOperator("le");
            con.setValue1(Double.parseDouble(request.getParameter("toHocVienId").toString()));
            cons.add(con);
        }
        try {
            if (request.getParameter("monHocMoDangKyId") != null) {
                Tbl_QLDT_DKMH_MonHocMoDangKy obj
                        = new ObjectMapper().readValue(
                                request.getParameter("monHocMoDangKyId"),
                                 Tbl_QLDT_DKMH_MonHocMoDangKy.class
                        );
                if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
                    MyFilter con = new MyFilter();
                    con.setCol("monHocMoDangKyId.id");
                    con.setOperator("eq");
                    con.setValue1(obj.getId());
                    cons.add(con);
                }
            }
        } catch (Exception e) {
        }
        if (request.getParameter("hocKyId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocKyId");
            con.setOperator("eq");
            con.setValue1(Double.parseDouble(request.getParameter("hocKyId").toString()));
            cons.add(con);
        }
        if (request.getParameter("fromHocKyId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocKyId");
            con.setOperator("ge");
            con.setValue1(Double.parseDouble(request.getParameter("fromHocKyId").toString()));
            cons.add(con);
        }
        if (request.getParameter("toHocKyId") != null) {
            MyFilter con = new MyFilter();
            con.setCol("hocKyId");
            con.setOperator("le");
            con.setValue1(Double.parseDouble(request.getParameter("toHocKyId").toString()));
            cons.add(con);
        }

        return cons;
    }
//việt
}
