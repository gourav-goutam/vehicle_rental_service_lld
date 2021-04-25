package vehiclerentalservice.Mode;

import vehiclerentalservice.commands.Command;
import vehiclerentalservice.commands.CommandExecutor;
import vehiclerentalservice.commands.CommandExecutorFactory;
import vehiclerentalservice.exceptions.InvalidCommandException;

import java.io.IOException;

public abstract class Mode {
    private CommandExecutorFactory commandExecutorFactory;

    public Mode(
            final CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    public abstract void process() throws IOException;

    protected void processCommand(final Command command){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)){
            commandExecutor.execute(command);
        }else{
            throw new InvalidCommandException("Invalid Command.");
        }
    }
}
