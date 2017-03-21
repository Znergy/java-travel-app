import org.junit.*;
import static org.junit.Assert.*;

public class TravelTest {

  @Test
  public void Travel_instantiatesCorrectly_true(){
    Travel myTravel = new Travel("Thailand", "Sunny");
    assertEquals(true, myTravel instanceof Travel);
  }

  @Test
  public void Travel_instantiaitesWithDescription_String(){
    Travel myTravel = new Travel("Thailand", "Sunny");
    assertEquals("Thailand", myTravel.getDescription());
  }


}
