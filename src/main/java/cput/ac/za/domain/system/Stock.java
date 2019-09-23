package cput.ac.za.domain.system;

public class Stock {
    private String id, description, price;

    public Stock(Builder builder){
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

        public Builder copy(Stock stock){
            this.id = stock.id;
            this.description = stock.description;
            this.price = stock.price;
            return this;
        }

        public Stock build(){
            return new Stock(this);
        }
    }

    @Override
    public String toString(){
        return "ID : " + id + "\nDescription : " + description + "\nPrice : " + price;
    }
}
