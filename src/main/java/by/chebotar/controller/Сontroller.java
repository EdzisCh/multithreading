package by.chebotar.controller;

import by.chebotar.service.Service;
import by.chebotar.service.exception.ShipValidationServiceException;

public class Сontroller {
  private Service service = new Service();

  public void startSimulation(String path) throws ShipValidationServiceException {
    service.startSimulation(path);
  }
}
