package by.chebotar.bean;


public class Jetty{

  private int shipmentCapacity;
  private final int maxCapacity;
  private final long id;


  public Jetty(int startShipmentCapacity, int maxCapacity, long id) {
    shipmentCapacity = startShipmentCapacity;
    this.maxCapacity = maxCapacity;
    this.id = id;
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

  public long getId() {
    return id;
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
        "id=" + id +
        ", shipmentCapacity=" + shipmentCapacity +
        ", maxCapacity=" + maxCapacity +
        '}';
  }
}
