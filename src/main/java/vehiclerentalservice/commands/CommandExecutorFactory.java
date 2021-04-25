package vehiclerentalservice.commands;

import vehiclerentalservice.exceptions.InvalidCommandException;
import vehiclerentalservice.service.VehicleService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final VehicleService vehicleService){
        commands.put(AddBranchCommandExecutor.COMMAND_NAME, new AddBranchCommandExecutor(vehicleService));
        commands.put(AddVehicleCommandExecutor.COMMAND_NAME, new AddVehicleCommandExecutor(vehicleService));
        commands.put(RentVehicleCommandExecutor.COMMAND_NAME, new RentVehicleCommandExecutor(vehicleService));
        commands.put(PrintSystemViewCommandExecutor.COMMAND_NAME, new PrintSystemViewCommandExecutor(vehicleService));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException("Invalid command");
        }
        return commandExecutor;
    }
}
