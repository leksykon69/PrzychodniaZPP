package pol.user.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.RoleEntity;
import pol.entity.UserEntity;
import pol.role.dao.RoleDao;
import pol.user.dao.UserDao;
import pol.user.service.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<UserEntity> implements
		UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	protected AbstractDao<UserEntity> getDao() {
		return userDao;
	}

}
