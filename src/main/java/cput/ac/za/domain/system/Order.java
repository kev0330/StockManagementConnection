package cput.ac.za.domain.system;

public class Order {
    private String id, description, price;

    public Order(Builder builder){
        this.id = builder.id;
        this.description = builder.description;
        this.price = builder.price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder{
        private String id, description, price;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder price(String price){
            this.price = price;
            return this;
        }

        public Builder copy(Order order){
            this.id = order.id;
            this.description = order.description;
            this.price = order.price;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

    @Override
    public String toString(){
        return "ID : " + id + "\nDescription : " + description + "\nPrice : " + price;
    }
}
