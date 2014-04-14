package pol.menu;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pol.entity.MenuEntity;
import pol.menu.dao.MenuDao;
import pol.menu.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
public class InitializedMenu {

	@Autowired
	private MenuDao dao;

	@Autowired
	private MenuService service;

	private MenuEntity menu;

	@Before
	public void setUp() {
		menu = new MenuEntity();
	}

	@Test
	public void shouldBeInitialize() throws Exception {
		assertNotEquals(null, menu);
	}

	@Test
	public void shouldSavedInDB() throws Exception {
		setMenu();
		service.save(menu);
	}

	@After
	public void tearDown() {
	}

	private void setMenu() {
		menu.setTitle("Dupa");
		menu.setUrl("www.dupa.pl");
	}
}
