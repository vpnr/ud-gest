package fr.fo.ud.business.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessUser;
import fr.fo.ud.data.api.IDaoRole;
import fr.fo.ud.data.api.IDaoUser;
import fr.fo.ud.entity.Role;
import fr.fo.ud.entity.User;

@Service
public class BusinessUserImpl implements IBusinessUser {

	@Autowired
	private IDaoUser daoUser;
	
	@Autowired
	private IDaoRole daoRole;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User getUserByPseudo(String pseudo) {
		return daoUser.findByPseudo(pseudo);
	}

	@Override
	public User saveUser(User user, int idRole) {
		user.setMdp(bCryptPasswordEncoder.encode(user.getMdp()));
		Role userRole = daoRole.findById(idRole);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		daoUser.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return daoUser.findAll();
	}

	@Override
	public User getUserById(int id) {
		return daoUser.findById(id);
	}
	
	@Override
	public Role getRoleById(int id) {
		return daoRole.findById(id);
	}
	
	@Override
	public List<Role> getAllRole() {
		return daoRole.findAll();
	}

	@Override
	public void updateUser(int id, String pwd) {
		User user = daoUser.findById(id);
		String pwdCrypt = bCryptPasswordEncoder.encode(pwd);
		user.setMdp(pwdCrypt);
		daoUser.update(user);
	}

}
