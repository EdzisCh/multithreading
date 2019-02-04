package by.chebotar.service;

import by.chebotar.bean.Ship;
import by.chebotar.service.exception.ShipValidationServiceException;
import by.chebotar.service.parser.ShipParserFromJSON;
import java.util.List;

public class Service {

  public void startSimulation(String path) throws ShipValidationServiceException {
    List<Ship> ships = new ShipParserFromJSON().parse(path);
    ships.forEach( ship -> new Thread(ship).start());
  }
}
