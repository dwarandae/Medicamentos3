package Test;

import DataAccess.DAO.AccountDAO;
import DataAccess.Entities.Account;

public class AccountDAOTest {

    public static void main(String... args) {

        Account account = new Account("name", "lastName", "userName", "password", "email");
        System.out.println("En main");
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.save(account);
        System.out.println("Fin");

    }

}
