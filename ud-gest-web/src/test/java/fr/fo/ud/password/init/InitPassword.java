package fr.fo.ud.password.init;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.fo.ud.entity.User;

public class InitPassword {

	@Test
	public void initAdminPassword() {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		User user = new User();
		user.setLogin("test");
		user.setMdp("user");
		user.setMdp(bc.encode(user.getMdp()));
		System.out.println(user.getMdp());
	}
	
}
