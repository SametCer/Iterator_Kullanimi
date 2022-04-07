/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samet çerezci
 */
public class OfficerTest {
    Officer o1=new Officer("Hakan Demirel",250);
    
    public OfficerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testListeleme() {
        assertEquals("Hakan Demirel",o1.getAdSoyad());
    }


    @Test
    public void testMaliyetHesapla() {
        assertEquals(250,o1.maliyetHesapla());
    } 
}
