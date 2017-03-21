public class Travel {
  private String mDescription;
  private String mLocation;

  public Travel(String description, String location){
    mDescription = description;
    mLocation = location;
  }

  public String getDescription(){
    return mDescription;
  }

  public String getLocation(){
    return mLocation;
  }
}
