package cput.ac.za.domain.people;

public class Administrator {
    private String userID, firstName, lastName, email;

    public Administrator(Builder builder) {
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
    }

    public Administrator(){

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static class Builder{
        private String userID, firstName, lastName, email;

        public Builder userID(String userID){
            this.userID = userID;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Administrator.Builder copy(Administrator administrator){
            this.userID = administrator.userID;
            this.firstName = administrator.firstName;
            this.lastName = administrator.lastName;
            this.email = administrator.email;
            return this;
        }

        public Administrator build(){
            return new Administrator(this);
        }
    }

    @Override
    public String toString() {
        return "AdministratorFactory{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrator)) return false;

        Administrator administrator = (Administrator) o;

        if (getUserID() != null ? !getUserID().equals(administrator.getUserID()) : administrator.getUserID() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(administrator.getFirstName()) : administrator.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(administrator.getLastName()) : administrator.getLastName() != null)
            return false;
        return getEmail() != null ? getEmail().equals(administrator.getEmail()) : administrator.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserID() != null ? getUserID().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
