package viikko2.t3.model;

public class Friend {

    String firstName, lastName;

    public Friend() {
        firstName = "";
        lastName = "";
    }

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Friend [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
