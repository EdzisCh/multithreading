package by.chebotar.bean;


public class Jetty{

  private boolean isFree;
  private int shipmentCapacity = 0;

  public Jetty(){

  }

  public Jetty(int startShipmentCapacity){
    shipmentCapacity = startShipmentCapacity;
  }
  public void changeJettyState(boolean free) {
    isFree = free;
  }

  public boolean isFree(){
    return isFree;
  }

  public void setShipmentIntoJetty(int shipmentCapacity) {
    this.shipmentCapacity += shipmentCapacity;
  }
}
