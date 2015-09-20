package DataAccess.DAO;

import DataAccess.Entities.Drug;
import java.util.List;

public interface IDrugDAO extends IGenericDAO<Drug> {

    public Drug get(long id);
    public List<Drug> getAll();

}
