package vehiclerentalservice.Mode;

import vehiclerentalservice.commands.Command;
import vehiclerentalservice.commands.CommandExecutorFactory;

import java.io.*;

public class FileMode extends Mode{

    private String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory, String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }
    @Override
    public void process() {

        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            return;
        }
        try {
            String input = reader.readLine().trim();
            while (input != null) {
                final Command command = new Command(input);
                if(!input.equalsIgnoreCase(""))
                    processCommand(command);
                input = reader.readLine();
                if(input.contains("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
