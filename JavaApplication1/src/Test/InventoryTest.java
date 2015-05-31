/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author c0654437
 */
public class InventoryTest {
    private Object Inventory;
     public InventoryTest() {
    }

    @Test
    public void testGetQuantityForIdReturnsErrorForNegativeID() {
        int id = -100;
        int expResult = -1;
        int result = Inventory.getQuantityForId(id);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testGetQuantityForIdReturnsValidResultForPositiveID() {
        int id = 4;
        int result = Inventory.getQuantityForId(id);
        assertTrue(result >= 0);        
    }

    private void assertEquals(int expResult, int result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertTrue(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

    

