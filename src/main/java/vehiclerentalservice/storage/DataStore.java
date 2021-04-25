package vehiclerentalservice.storage;

import vehiclerentalservice.models.Branch;
import vehiclerentalservice.models.Vehicle;

import java.util.*;

public interface DataStore {

    Set<Branch> branches = new HashSet<>();
    HashMap<String, List<Vehicle>> branchWithCapacity = new HashMap<>();

    HashMap<String, List<Vehicle>> bookings = new HashMap<>();

}
