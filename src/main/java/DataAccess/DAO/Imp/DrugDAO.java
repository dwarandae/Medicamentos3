package DataAccess.DAO.Imp;

import DataAccess.DAO.IDrugDAO;

import DataAccess.Entities.Drug;
import java.util.List;
import org.hibernate.Session;

public class DrugDAO extends GenericDAO<Drug> implements IDrugDAO {
    
    @Override
    public Drug get(long id) {
        Session session = getSession();
        Drug drug = session.get(Drug.class, id);
        return drug;
    }
    
    @Override
    public List<Drug> getAll() {
        Session session = getSession();
        List<Drug> drugs = session.createQuery("FROM Drug").list();
        return drugs;
    }
    
}
