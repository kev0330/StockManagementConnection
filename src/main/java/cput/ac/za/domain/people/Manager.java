package cput.ac.za.domain.people;

public class Manager {
    private String id, name, surname;

    public Manager(Builder builder){
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

        public Builder copy(Manager manager){
            this.id = manager.id;
            this.name = manager.name;
            this.surname = manager.surname;
            return this;
        }

        public Manager build(){
            return new Manager(this);
        }
    }

    @Override
    public String toString(){
        return "ID : " + id + "\n : " + name + "\nSurname : " + surname;
    }
}
