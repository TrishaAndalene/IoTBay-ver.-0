/* import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import dao.ProductDAO;
import model.Categories;
import model.Product;

public class ProductTest {
    private Connection conn;
    private Statement st;
    private ProductDAO productManager;
    private Product testProduct1;

@Before
public void setUp() throws Exception{
    conn = DriverManager.getConnection("jdbc:sqlite:/Users/elle/Documents/ISD/IoTBay-ver.-0/iotbaygp1/database/iotbay_test.db");
    st = conn.createStatement();
    productManager = new ProductDAO(conn);
    testProduct1 = new Product("1238475824", "Test Name", 12.99, "Test Brand", "None", "None", "https://iot-store.com.au/cdn/shop/products/usr-iot-iot-comms-industrial-4g-3g-lte-modem-router-serial-to-cellular-modem-usr-g781-au-30973970874553.jpg?height=720&v=1635982964", 4, Categories.ACTIVITY_TRACKERS, "Test description");

}


@Test
public void testAddProduct() throws SQLException{
    productManager.addProduct(testProduct1);
    Product product2 = productManager.findProduct("1238475824");
    assertEquals("Test Name", product2.getName());
}

@Test
public void testFindProduct() throws SQLException{
    Product testProduct = productManager.findProduct("196163749051");
    assertNotNull(testProduct);
    assertEquals("Seeed Studio", testProduct.getBrand());
}


@Test
public void testGetAll() throws SQLException {
    List<Product> testList = productManager.listAllProducts();
    assertNotNull(testList);
    assertEquals(27, testList.size());
}

// failed
@Test
public void testGetByCat() throws SQLException {
    List<Product> testList = productManager.getProductsByCat("WIFI");
    assertNotNull(testList);
    assertEquals(4, testList.size());   
}

@Test
public void testRemoveProduct() throws SQLException {
    productManager.removeProduct("1238475824");
    Product deletedProduct = productManager.findProduct("1238475824");
    assertNull(deletedProduct);
}

// failed
@Test
public void testUpdateProduct() throws SQLException {
    productManager.updateProduct("name", "196237764294", "NewName");
    Product product3 = productManager.findProduct("196237764294");
    assertEquals("NewName", product3.getName());   
}

// failed
@Test
public void testUpdateStock() throws SQLException {
    productManager.updateStock("196237764294", 2);
    Product product3 = productManager.findProduct("196237764294");
    assertEquals(5, product3.getQuantity());   
}

// failed
@Test
public void testSearchProduct() throws SQLException {
    List<Product> testList3 = productManager.productSearch("home");
    assertNotNull(testList3);
    assertEquals(2, testList3.size());
}

@After
public void setDown() throws Exception {
        conn.close();
    }

}

*/
