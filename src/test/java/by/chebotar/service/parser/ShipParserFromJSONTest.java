package by.chebotar.service.parser;

import by.chebotar.bean.Ship;
import by.chebotar.service.exception.ServiceException;
import by.chebotar.service.exception.ShipValidationServiceException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipParserFromJSONTest {

  Parser<Ship> parser = new ShipParserFromJSON();

  @Test
  public void shouldReturnTrueShips() throws ShipValidationServiceException{
    String path = "resources/json/ships.json";
    Ship ship1 = new Ship("Titanic",1000,12000);
    Ship ship2 = new Ship("Flying Dutchman", 100, 1200);
    Ship ship3 = new Ship("Man", 4568,30000);
    Ship ship4 = new Ship("Bismark",7896,45689);
    Ship ship5 = new Ship("Scotland",775,11230);
    Ship ship6 = new Ship("Great England",0,4500);
    Ship ship7 = new Ship("name", 7838,65000);
    Ship ship8 = new Ship("another Great Ship",75,600);
    Ship ship9 = new Ship("Belorussia", 228,1488);

    List<Ship> shipsFromHardCode = new ArrayList<>(Arrays.asList(ship1,ship2,ship3,ship4,ship5,ship6,ship7,ship8,ship9));
    List<Ship> shipsFromJson = parser.parse(path);
    Assert.assertEquals(shipsFromHardCode.equals(shipsFromJson),true);
  }

  @Test(expectedExceptions = ShipValidationServiceException.class)
  public void shouldThrowValidationException() throws ShipValidationServiceException{
    String path = "resources/json/badShips.json";
    parser.parse(path);
  }
}
