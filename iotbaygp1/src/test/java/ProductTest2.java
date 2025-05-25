/* import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;

import dao.ProductDAO;
import model.Categories;
import model.Product;

public class ProductTest2 {
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



@After
public void setDown() throws Exception {
        conn.close();
    }

}
*/
