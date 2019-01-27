package by.chebotar.service.bean;

import by.chebotar.bean.Jetty;
import by.chebotar.bean.Ship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipTest {

  @Test
  public void shouldLoadAndUnloadShipmentInJetty(){
    Jetty jetty = new Jetty(200,500,1);
    Ship ship = new Ship("testShip",100,380);
    ship.unloadShip(jetty);
    boolean isMethodWorksCorrectly = jetty.getShipmentCapacity() == 0 && ship.getShipment() == 300;
    Assert.assertEquals(isMethodWorksCorrectly,true);
  }

  @Test
  public void shouldChangeShipment(){
    Ship ship1 = new Ship("Titanic",100,120);
    Ship ship2 = new Ship("Flying Dutchman", 10, 100);
    Ship ship3 = new Ship("Man", 5,30);
    Ship ship4 = new Ship("Bismark",70,100);
    Ship ship5 = new Ship("Avrora",45,50);

    List<Ship> ships = new ArrayList<>(Arrays.asList(ship1,ship2,ship3,ship4,ship5));
    ships.forEach(Ship::run);

    Assert.assertEquals(ship1.getShipment(),120);
    Assert.assertEquals(ship2.getShipment(),100);
    Assert.assertEquals(ship3.getShipment(),30);
    Assert.assertEquals(ship4.getShipment(),100);
    Assert.assertEquals(ship5.getShipment(),50);
  }
}
