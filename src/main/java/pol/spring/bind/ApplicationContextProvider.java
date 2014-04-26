package pol.spring.bind;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;
 
	public static ApplicationContext getContext() {
        return context;
    }
 
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }
}