package cput.ac.za.domain.people;

public class Employee {
    private String id, name, surname;

    public Employee(Builder builder){
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

        public Builder copy(Employee employee){
            this.id = employee.id;
            this.name = employee.name;
            this.surname = employee.surname;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public String toString(){
        return "ID : " + id + "\nName : " + name + "\nSurname : " + surname;
    }
}
