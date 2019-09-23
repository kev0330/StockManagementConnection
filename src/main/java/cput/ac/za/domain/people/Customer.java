package cput.ac.za.domain.people;

public class Customer {
    private String id, name, surname;

    public Customer(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static class Builder{
        private String id, name, surname;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder copy(Customer customer){
            this.id = customer.id;
            this.name = customer.name;
            this.surname = customer.surname;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

    @Override
    public String toString(){
        return "ID : " + id + "\nName : " + name + "\nSurname : " + surname;
    }

}
