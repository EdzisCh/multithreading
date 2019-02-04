package by.chebotar.presentation;

import by.chebotar.controller.Controller;
import by.chebotar.service.exception.ShipValidationServiceException;

public class Simulation {

  private static String path = "resources/json/ships.json";

  public static void main(String[] args) throws ShipValidationServiceException {
    Controller controller = new Controller();
    controller.startSimulation(path);
  }
}
