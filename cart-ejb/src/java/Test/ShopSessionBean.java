/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import javax.ejb.Stateful;

/**
 *
 * @author hp
 */
@Stateful
public class ShopSessionBean implements ShopSessionBeanLocal {

    private int cost;

    public ShopSessionBean() {
    }

    public ShopSessionBean(int cost) {
        cost = 0;
    }

    @Override
    public void add(int amt) {
        cost = cost+amt;
    }

    

    @Override
    public Integer check() {
        return cost;
    }

    @Override
    public void remove(int amt) {
        cost = cost - amt;
    }
    
    

   
    
}
