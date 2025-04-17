package model;

public class Item {
    private String id;
    private String name;
    private Integer quantity;
    private String desc;
    private Double price;


    public Item (String id, String name,  Integer quantity, Double price ,String desc) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.desc = desc ;

}

public Item(){

}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getQuantity() {
    return quantity;
}

public void setQuantity(Integer quantity) {
    this.quantity = quantity;
}

public String getDesc() {
    return desc;
}

public void setDesc(String desc) {
    this.desc = desc;
}
public Double getPrice() {
    return price;
}

public void setPrice(Double price) {
    this.price = price;
}

@Override
public String toString (){
    return "Item{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", quantity='" + quantity + '\'' +
            ", desc='" + desc + '\'' +
            ", price='" + price +
            '}';
}
}
