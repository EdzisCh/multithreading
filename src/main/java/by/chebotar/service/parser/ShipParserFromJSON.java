package by.chebotar.service.parser;

import by.chebotar.bean.Ship;
import by.chebotar.service.exception.ShipValidationServiceException;
import by.chebotar.service.validation.ShipValidator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShipParserFromJSON implements Parser<Ship> {

  private static final Logger LOGGER = LogManager.getLogger(ShipParserFromJSON.class);
  @Override
  public List<Ship> parse(String path) throws ShipValidationServiceException{
    List<Ship> ships = new ArrayList<>();
    Gson gson = new Gson();
    try {
      Type shipsListType = new TypeToken<List<Ship>>(){}.getType();
      ships = gson.fromJson(new BufferedReader(new FileReader(path)), shipsListType);
      ShipValidator validator = new ShipValidator();
      validator.isValid(ships);
    } catch (FileNotFoundException e) {
      LOGGER.error(e);
    }
    return ships;
  }
}
