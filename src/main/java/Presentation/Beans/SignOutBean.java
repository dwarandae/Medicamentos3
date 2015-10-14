package Presentation.Beans;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class SignOutBean extends ActionSupport implements SessionAware {
    
    Map<String, Object> userSession;
    
    public String index() {
        userSession.clear();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
    
}
