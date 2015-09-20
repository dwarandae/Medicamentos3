package DataAccess.DAO;

import DataAccess.Entities.ShoppingCart;
import java.util.List;

public interface IShoppingCartDAO extends IGenericDAO<ShoppingCart> {
    
    public ShoppingCart get(long id);
    public List<ShoppingCart> getAll();
    
}
