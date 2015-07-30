package sweetwaterCity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simulation.Simulation;

/**
 *
 * @author ARTIOM TIURIN
 */
public class CityInitializationTest {
    
    public CityInitializationTest() {
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

    /**
     * Test of initialize method, of class CityInitialization.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        long seed = 10;
        Simulation S = new Simulation(seed);
        CityInitialization.initialize(S);
        assertNotNull(S);        
    }
    
    @Test(expected=java.lang.RuntimeException.class)
    public void testInitialize2() {
        System.out.println("initialize");              
        CityInitialization.initialize(null);        
    }
    /**
     * Test seed being initialized as type double, instead of long
     */
    @Test(expected=java.lang.RuntimeException.class)
    public void testInitialize3() {
        System.out.println("initialize");
        //long seed = 1.0;
        Simulation S = new Simulation(seed);      
    }
    
}
