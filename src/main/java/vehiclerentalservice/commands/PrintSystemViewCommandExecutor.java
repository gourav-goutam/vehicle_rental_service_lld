package vehiclerentalservice.commands;

import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.service.VehicleService;
import vehiclerentalservice.storage.DataStore;

import java.util.List;
import java.util.Map;

public class PrintSystemViewCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "printsystemview";
    public PrintSystemViewCommandExecutor(VehicleService vehicleService) {
        super(vehicleService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        for(Map.Entry<String , List<Vehicle>> entry : DataStore.branchWithCapacity.entrySet()){
            System.out.println("\t -> "+entry.getKey());
            for(Vehicle v : entry.getValue()){
                if(v.getCount() == 0){
                    System.out.println("\t\t * All "+v.getType() + " are booked.");
                }else{
                    System.out.println("\t\t * "+v.getCount()+" "+v.getType() + " are available for Rs "+v.getRent());
                }

            }
        }
    }
}
