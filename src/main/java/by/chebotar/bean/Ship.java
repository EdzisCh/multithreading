package by.chebotar.bean;

public class Ship implements Runnable{

  private int shipment;
  private String name;

  public Ship(String name, int shipment) {
    this.shipment = shipment;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getShipment() {
    return shipment;
  }

  @Override
  public void run() {

  }
}
