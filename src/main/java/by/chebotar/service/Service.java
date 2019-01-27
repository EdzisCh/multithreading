package by.chebotar.service;

import by.chebotar.bean.Ship;
import by.chebotar.service.parser.ShipParserFromJSON;
import java.util.List;

public class Service {

  public void startSimulation(String path){
    List<Ship> ships = new ShipParserFromJSON().parse(path);
    ships.stream().forEach(Ship::run);
  }
}
