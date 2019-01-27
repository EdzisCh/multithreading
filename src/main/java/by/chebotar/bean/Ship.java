package by.chebotar.bean;

import by.chebotar.service.exception.ServiceException;
import by.chebotar.service.port.Port;
import java.io.Serializable;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship implements Runnable, Serializable {

  private static final Logger LOGGER = LogManager.getLogger(Ship.class);
  private static final int ATTEMPTS = 10;

  private String name;
  private int shipment;
  private final int maxCapacity;
  private transient Port port;

  public Ship(String name, int shipment, int maxCapacity) {
    this.shipment = shipment;
    this.maxCapacity = maxCapacity;
    this.name = name;
  }

  public void setShipment(int shipment) {
    this.shipment = shipment;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Port getPort() {
    return port;
  }

  public void setPort(Port port) {
    this.port = port;
  }

  public String getName() {
    return name;
  }

  public int getShipment() {
    return shipment;
  }

  @Override
  public void run() {
    port = Port.getInstance();
    LOGGER.info("Ship " + this.name + " come into port");
    boolean shipmentUnloaded = false;
    int numberOfCurrentJetties = 0;
    while(!shipmentUnloaded) {
      Jetty currentJetty = port.getJetty();
      numberOfCurrentJetties++;
      shipmentUnloaded = unloadShip(currentJetty);
      port.exemptJetty(currentJetty);
      if (numberOfCurrentJetties >= ATTEMPTS){
        try{
          throw new  ServiceException("All jetties cannot serve ship" + name);
        } catch (ServiceException e){
          LOGGER.error(e);
          return;
        }
      }
    }

  }

  private boolean unloadShip(Jetty jetty){
    int currentShipmentInJetty = jetty.getShipmentCapacity();
    boolean success = jetty.setShipmentIntoJetty(shipment);

    if (success){
      if (currentShipmentInJetty >= this.maxCapacity) {
        this.setShipment(this.maxCapacity);
        success = jetty.removeShipmentFromJetty(this.maxCapacity);
      } else if (currentShipmentInJetty == 0){
        return true;
      } else {
        this.setShipment(currentShipmentInJetty);
        success = jetty.removeShipmentFromJetty(currentShipmentInJetty);
      }
    }
    if(success){
      LOGGER.info("Ship " + this.name + " unload successfully");
    }
    return success;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ship ship = (Ship) o;
    return shipment == ship.shipment &&
        maxCapacity == ship.maxCapacity &&
        name.equals(ship.name) &&
        Objects.equals(port, ship.port);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipment, maxCapacity, name, port);
  }

  @Override
  public String toString() {
    return "Ship{" +
        "name='" + name + '\'' +
        ", shipment=" + shipment +
        ", maxCapacity=" + maxCapacity +
        ", port=" + port +
        '}';
  }
}
