package pol.userGenerator.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.UserEntity;
import pol.role.dao.RoleDao;
import pol.user.dao.UserDao;
import pol.userGenerator.GeneratedUserData;
import pol.userGenerator.UserGenerator;


@Service
public class UserGeneratorImpl extends AbstractServiceImpl<UserEntity> implements UserGenerator {
	
	private static final String GENERATOR_URL = "http://pl.fakenamegenerator.com/gen-random-pl-pl.php";
	
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	
	@Override
	protected AbstractDao<UserEntity> getDao() {
		return userDao;
	}

	public GeneratedUserData getGeneratedUserData() throws IOException{
		GeneratedUserData data = new GeneratedUserData();
		String pageCode = getWebPageSource();
		data.setPage(pageCode);
		data.setUser(parseForUser(pageCode));
		data.setPesel(parseForPesel(pageCode));
		return data;
	}
	
	
	private String getWebPageSource() throws IOException {
		URL yahoo = new URL(GENERATOR_URL);
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();

		return a.toString();
	}

	private UserEntity parseForUser(String source) {
		UserEntity user = new UserEntity();
		Document jsoup = Jsoup.parse(source);
		String nameAndSurname = jsoup.select("h3").get(0).text();
		user.setName(nameAndSurname.split(" ")[0]);
		user.setSurname(nameAndSurname.split(" ")[1]);
		user.setEmail(jsoup.getElementsContainingText("Email Address:").get(14).nextElementSibling().child(0).text());
		
		try {
			user.setLogin(jsoup.getElementsContainingText("Username:").get(14).nextElementSibling().child(0).text());
		} catch (Exception e) {
				user.setLogin(user.getEmail());
			}
		user.setPassword("123");
		
		user.setRole(roleDao.find(2));
	
		return user;
	}
	
	private String parseForPesel(String source){
		Document jsoup = Jsoup.parse(source);
		return jsoup.getElementsContainingText("PESEL:").get(14).nextElementSibling().child(0).text();
	}


}
