package vehiclerentalservice.models;

public class Vehicle {
    private double rent;
    private int count;
    private String type;
    private String branch;
    private boolean isBooked = false;

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getBranch() {
        return branch;
    }


    public Vehicle(String count, String type, String rent, String branch) {
        this.count = Integer.parseInt(count);
        this.type = type;
        this.rent = Double.parseDouble(rent);
        this.branch = branch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
