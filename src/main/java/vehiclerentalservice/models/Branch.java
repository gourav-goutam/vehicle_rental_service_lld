package vehiclerentalservice.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Branch {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return name.equals(branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private String name;
    public List<Vehicle> vehicles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Branch(String token) {
        this.name = token;
    }
    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

}
