/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

import java.util.ArrayList;

/**
 *
 * @author samet çerezci
 */
public class Context {
    
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

   
    public ArrayList<String> executeStrategy(String dataPath) {

        return strategy.readData(dataPath);
    }
    
}
