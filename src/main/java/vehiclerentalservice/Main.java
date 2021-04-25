package vehiclerentalservice;

import vehiclerentalservice.Mode.FileMode;
import vehiclerentalservice.Mode.InteractiveMode;
import vehiclerentalservice.commands.CommandExecutorFactory;
import vehiclerentalservice.exceptions.InvalidModeException;
import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.service.VehicleService;
import vehiclerentalservice.storage.DataStore;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final VehicleService vehicleService = new VehicleService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(vehicleService);

        if(isInteractiveMode(args)){
            new InteractiveMode(commandExecutorFactory).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, args[0]).process();
        }else{
            throw new InvalidModeException("Invalid mode, only Interactive mode is supported.");
        }


    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args){
        return args.length == 0;
    }
}
