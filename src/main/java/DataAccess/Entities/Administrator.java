package DataAccess.Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator extends Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //We'll have big troubles with this "role per inheritance" model here. Ummm, mmm

    public Administrator() {
    }

    public Administrator(String name, String lastName, String username, String password, String email) {
        super(name, lastName, username, password, email);
    }
    
}
