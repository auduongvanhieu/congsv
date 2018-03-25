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

package com.cce.vietnguyen.controller.core;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;
import com.cce.vietnguyen.repository.UserRepository;

import javassist.compiler.ast.CondExpr;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GenericDao genericDao;

	@RequestMapping("/users")
	public List<Tbl_TaiKhoan> getUsers() {
		
		try {
			List<MyFilter> filters = new ArrayList<>();
		{
			MyFilter mf = new MyFilter<>();
			mf.setCol("login");
			mf.setOperator("like");
			mf.setValue1("%r%");
			
			filters.add(mf);
		}
		
		
		List<Tbl_TaiKhoan> users = (List<Tbl_TaiKhoan>) genericDao.findByCondition(Tbl_TaiKhoan.class, filters, 20, 1);
		
		System.out.println(users.size());
		return users;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		
	}
	@RequestMapping("/me")
	  public Principal user(Principal principal) {
	    return principal;
	  }

}
