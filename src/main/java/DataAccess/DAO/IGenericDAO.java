package DataAccess.DAO;

public interface IGenericDAO <T>{
    
    	public boolean save(T object);
        
        public boolean update(T object);
	
	public boolean delete(T object);
        
}
