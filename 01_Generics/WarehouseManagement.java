import java.util.*;
abstract class WarehouseItem{
    private String name;
    public WarehouseItem(String name){
        this.name=name;
    }
    public String getname(){
        return name;
    }
   public abstract void displayInfo();
}
 class Electronics extends WarehouseItem{
    private String brand;
    public Electronics(String brand,String name){
        super(name);
        this.brand=brand;
    }
    public void displayInfo(){
        System.out.println("Electronics: "+getname()+ " , Brand: "+brand);
    }
}
 class Groceries extends WarehouseItem{
    private String expiryDate;
    public Groceries(String name,String expiryDate){
        super(name);
        this.expiryDate=expiryDate;
    }
    public void displayInfo(){
        System.out.println("Groceries: "+getname()+" , Expiry date: "+expiryDate);
    }

}
class Furniture extends WarehouseItem{
    private String material;
    public Furniture(String name,String material){
        super(name);
        this.material=material;
    }
    public void displayInfo(){
        System.out.println("Furniture: "+getname()+"Material "+material);
    }
}
class Storage<T extends WarehouseItem>{
   private List<T> items=new ArrayList<>();
   public void addItem(T item){
    items.add(item);
   }
   public List<T> getItem(){
    return items;
}
}
public class WarehouseManagement{
    public static void main(String[] args){
        Storage<Electronics> electroStorage=new Storage<>();
        electroStorage.addItem(new Electronics("Laptop","Dell"));
        electroStorage.addItem(new Electronics("TV","LG"));

        Storage<Groceries> groceryStorage=new Storage<>();
        groceryStorage.addItem(new Groceries("Milk","2025-05-10"));
        groceryStorage.addItem(new Groceries("Egg","2025-05-10"));

        Storage<Furniture> furnitureStorage=new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair","Wood"));
        furnitureStorage.addItem(new Furniture("Bed","Steel"));
        System.out.println("Electronics Items>>>>>");
        displayAllItems(electroStorage.getItem());
        System.out.println("Groceries Items>>>>>>");
        displayAllItems(groceryStorage.getItem());
        System.out.println("Furniture Items>>>>>>");
        displayAllItems(furnitureStorage.getItem());
    }
        public static void displayAllItems(List<? extends WarehouseItem> items){
            for(WarehouseItem item: items){
                item.displayInfo();
            }
        }


    }
