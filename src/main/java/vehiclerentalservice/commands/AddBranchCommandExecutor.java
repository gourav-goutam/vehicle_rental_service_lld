package vehiclerentalservice.commands;

import vehiclerentalservice.models.Branch;
import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.service.VehicleService;
import vehiclerentalservice.storage.DataStore;

public class AddBranchCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "addbranch";
    public AddBranchCommandExecutor(final VehicleService vehicleService) {
        super(vehicleService);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        Branch branch = new Branch(command.getParams().get(0));
        for(int i=1; i<command.getParams().size(); i++ ){
            String[] attr = command.getParams().get(i).split(",");
            Vehicle v = new Vehicle(attr[0], attr[1], attr[2], branch.getName());
            branch.addVehicle(v);
        }
        if(!DataStore.branchWithCapacity.containsKey(branch.getName())){
            DataStore.branches.add(branch);
            DataStore.branchWithCapacity.put(branch.getName(), branch.getVehicles());
        }
    }
}
