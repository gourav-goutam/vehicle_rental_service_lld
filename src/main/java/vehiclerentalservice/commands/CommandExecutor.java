package vehiclerentalservice.commands;

import vehiclerentalservice.service.VehicleService;

public abstract class CommandExecutor {

    protected VehicleService vehicleService;

    public CommandExecutor(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
