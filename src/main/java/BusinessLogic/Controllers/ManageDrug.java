/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;

import DataAccess.DAO.Imp.DrugDAO;
import DataAccess.Entities.Drug;

/**
 *
 * @author root
 */

public class ManageDrug {
    
    
    public Drug getMedicamento(long id){
        DrugDAO medDAO=new DrugDAO();
        Drug med= medDAO.get(id);
        return med;
    }
}
