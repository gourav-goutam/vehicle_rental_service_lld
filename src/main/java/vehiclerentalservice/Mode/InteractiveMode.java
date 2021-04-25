package vehiclerentalservice.Mode;

import vehiclerentalservice.commands.Command;
import vehiclerentalservice.commands.CommandExecutorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(final CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() {
        try{
            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String input = reader.readLine();
                if(input.contains("exit")){
                    break;
                }
                final Command command = new Command(input);
                processCommand(command);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
