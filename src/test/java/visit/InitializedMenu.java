//package visit;
//
//import static org.junit.Assert.assertNotEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import pol.dao.MenuDao;
//import pol.entity.MenuEntity;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:jpaContext.xml")
//public class InitializedMenu {
//
//	@Autowired
//	private MenuDao menuDao;
//
//	private MenuEntity menu;
//
//	@Before
//	public void setUp() {
//		menu = new MenuEntity();
//	}
//
//	@Test
//	public void shouldBeInitialize() throws Exception {
//		assertNotEquals(null, menu);
//	}
//
//	@Test
//	public void shouldSavedInDB() throws Exception {
//		setMenu();
//		menuDao.save(menu);
//		// menuDao.save(menu);
//	}
//
//	@After
//	public void tearDown() {
//		menuDao.flush();
//	}
//
//	private void setMenu() {
//		menu.setTitle("Menu");
//		menu.setUrl("menu.html");
//	}
//}
