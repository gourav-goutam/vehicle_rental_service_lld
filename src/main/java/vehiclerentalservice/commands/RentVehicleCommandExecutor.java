package vehiclerentalservice.commands;

import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.service.VehicleService;
import vehiclerentalservice.storage.DataStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RentVehicleCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "rentvehicle";
    public RentVehicleCommandExecutor(VehicleService vehicleService) {
        super(vehicleService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        List<Vehicle> desired = new ArrayList<>();

        for(Map.Entry<String , List<Vehicle>> entry : DataStore.branchWithCapacity.entrySet()){
            for(Vehicle v : entry.getValue()){
                if(v.getType().equalsIgnoreCase(command.getParams().get(0))){
                    desired.add(v);
                }
            }
        }
        Collections.sort(desired,(a, b) -> (int) (a.getRent() - b.getRent()));
        for (Vehicle v : desired){
            if(v.getCount() > 0 && !v.isBooked()){
                v.setBooked(true);
                v.setCount(v.getCount() - 1);
                System.out.println("Booked from "+v.getBranch());
                return;
            }
        }
        System.out.println("No availability");
    }
}
