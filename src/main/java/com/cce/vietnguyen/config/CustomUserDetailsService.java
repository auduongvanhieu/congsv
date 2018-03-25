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

package com.cce.vietnguyen.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cce.vietnguyen.model.core.Tbl_NhomQuyen;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.cce.vietnguyen.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Tbl_TaiKhoan user = userRepository.findByLogin(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("Tbl_TaiKhoan %s does not exist!", username));
		}
		return new UserRepositoryUserDetails(user);
	}

	private final static class UserRepositoryUserDetails extends Tbl_TaiKhoan implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(Tbl_TaiKhoan user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<Tbl_NhomQuyen> roles = new ArrayList<>();
			
			if(getNhomQuyenId() != null)
				roles.add(getNhomQuyenId());
			
			return roles;
		}

		@Override
		public String getUsername() {
			return getLogin();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
