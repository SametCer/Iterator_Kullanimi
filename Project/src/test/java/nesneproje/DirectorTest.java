/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

import java.util.ArrayList;
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
public class DirectorTest {

    Director d1 = new Director("Samet Çerezci", 5000);
    Director d2 = new Director("Kamil İşler", 1000);
    ArrayList<Director> calisanlar = new ArrayList<Director>();

    public DirectorTest() {

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
        assertEquals("Samet Çerezci", d1.getAdSoyad());
    }

    @Test
    public void testhasNext(){

        calisanlar.add(d1);
        calisanlar.add(d2);
        assertTrue(calisanlar.get(0).getIterator().hasNext());
    }
    @Test
    public void testMaliyetHesapla() {
        int x = d1.maliyetHesapla();
        assertEquals(5000, x);

    }

}
