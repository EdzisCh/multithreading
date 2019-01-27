package by.chebotar.bean;


public class Jetty{

  private int shipmentCapacity;
  private final int maxCapacity;


  public Jetty(int startShipmentCapacity, int maxCapacity) {
    shipmentCapacity = startShipmentCapacity;
    this.maxCapacity = maxCapacity;
  }

  public boolean setShipmentIntoJetty(int shipmentCapacity) {
    if(this.shipmentCapacity + shipmentCapacity > maxCapacity){
     return false;
    }
    this.shipmentCapacity += shipmentCapacity;
    return true;
  }

  public boolean removeShipmentFromJetty(int shipmentCapacity){
    if(this.shipmentCapacity - shipmentCapacity < 0){
      return false;
    }
    this.shipmentCapacity -= shipmentCapacity;
    return true;
  }

  public int getShipmentCapacity() {
    return shipmentCapacity;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  @Override
  public String toString() {
    return "Jetty{" +
        ", shipmentCapacity=" + shipmentCapacity +
        ", maxCapacity=" + maxCapacity +
        '}';
  }
}
