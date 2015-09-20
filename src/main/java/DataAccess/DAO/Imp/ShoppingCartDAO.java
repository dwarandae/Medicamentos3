package DataAccess.DAO.Imp;

import DataAccess.DAO.*;
import DataAccess.Entities.ShoppingCart;
import java.util.List;
import org.hibernate.Session;

public class ShoppingCartDAO extends GenericDAO<ShoppingCart> implements IShoppingCartDAO {
    
    @Override
    public ShoppingCart get(long id) {
        Session session = getSession();
        ShoppingCart shoppingCart = session.get(ShoppingCart.class, id);
        return shoppingCart;
    }
    
    @Override
    public List<ShoppingCart> getAll() {
        Session session = getSession();
        List<ShoppingCart> shoppingCarts = session.createQuery("FROM ShoppingCart").list();
        return shoppingCarts;
    }
    
}
