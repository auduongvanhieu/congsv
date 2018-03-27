package com.cce.vietnguyen.controller.core;

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
import com.cce.vietnguyen.model.core.Tbl_Quyen_NhomQuyen;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class Tbl_Quyen_NhomQuyenController {

    @Autowired
    private GenericDao genericDAO;

    @RequestMapping(value = "/tbl_quyen_nhomquyen", method = RequestMethod.GET)
    public List getAll() {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        {
            MyFilter con = new MyFilter();
            con.setOperator("order");
            con.setValue1("desc");
            con.setCol("id");
            cons.add(con);
        }
        return genericDAO.findByCondition(Tbl_Quyen_NhomQuyen.class, cons, 20, 1);
    }

    @RequestMapping(value = "/tbl_quyen_nhomquyen/find", method = RequestMethod.GET)
    public List find(@RequestParam(required = false) Integer pageSize,
             @RequestParam(required = false) Integer page,
             HttpServletRequest request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
//variable
        if (request.getParameter("id") != null) {
            MyFilter con = new MyFilter();
            con.setCol("id");
            con.setOperator("eq");
            con.setValue1(request.getParameter("id"));
            cons.add(con);
        }
        try {
            if (request.getParameter("nhomQuyenId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("nhomQuyenId.id");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("nhomQuyenId").toString()));
                cons.add(con);
            }
        } catch (Exception e) {
        }
        try {
            if (request.getParameter("quyenId") != null) {
                MyFilter con = new MyFilter();
                con.setCol("quyenId.id");
                con.setOperator("eq");
                con.setValue1(new Long(request.getParameter("quyenId").toString()));
                cons.add(con);
            }
        } catch (Exception e) {
        }

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
        return genericDAO.findByCondition(Tbl_Quyen_NhomQuyen.class, cons, pageSize, page);
    }

    @RequestMapping(value = "/tbl_quyen_nhomquyen/{id}", method = RequestMethod.GET)
    public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
        Tbl_Quyen_NhomQuyen obj = (Tbl_Quyen_NhomQuyen) genericDAO.get(Tbl_Quyen_NhomQuyen.class, id);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/tbl_quyen_nhomquyen", method = RequestMethod.POST)
    public ResponseEntity createObj(@RequestBody Tbl_Quyen_NhomQuyen obj) {
        Long id = genericDAO.save(obj);
        obj.setId(id);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/tbl_quyen_nhomquyen/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteObj(@PathVariable Long id) {
        genericDAO.delete(Tbl_Quyen_NhomQuyen.class, id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/tbl_quyen_nhomquyen", method = RequestMethod.PUT)
    public ResponseEntity updateObj(@RequestBody Tbl_Quyen_NhomQuyen obj) {
        genericDAO.saveOrUpdate(obj);
        return new ResponseEntity(obj, HttpStatus.OK);
    }
}
