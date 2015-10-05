package BusinessLogic.Controllers;

import DataAccess.Entities.Account;
import java.util.Map;

public class SessionController {
    
    public void attachSession(Map<String, Object> sessionMap, String role, Account account) {
        sessionMap.put("username", account.getUsername());
        sessionMap.put("accountId", account.getAccountId());
        sessionMap.put("role", role);
    }
    
}
