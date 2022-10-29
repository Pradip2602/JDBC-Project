package SourceCode;

public class Vehicle {
    int id;
    String name;
    String owner;
    String contact;

    public Vehicle(int id, String name, String owner, String contact) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.contact = contact;
    }

    public Vehicle(String name, String owner, String contact) {
        this.name = name;
        this.owner = owner;
        this.contact = contact;
    }

    public Vehicle() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
