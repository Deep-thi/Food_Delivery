/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface ShopSessionBeanLocal {

    void add(int amt);

   
    

    Integer check();

    void remove(int amt);
    
}
