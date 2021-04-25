package vehiclerentalservice.commands;

import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.service.VehicleService;
import vehiclerentalservice.storage.DataStore;

import java.util.ArrayList;
import java.util.List;

public class AddVehicleCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "addvehicle";
    public AddVehicleCommandExecutor(VehicleService vehicleService) {
        super(vehicleService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        List<String> list = command.getParams();
        if(DataStore.branchWithCapacity.containsKey(list.get(0))){
            for(Vehicle v : DataStore.branchWithCapacity.get(list.get(0))){
                if(v.getType().equalsIgnoreCase(list.get(2))){
                    v.setCount(v.getCount()+Integer.parseInt(list.get(1)));
                }
            }
        }else{
            System.err.println("Invalid branch");
        }
    }
}
