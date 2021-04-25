package vehiclerentalservice.commands;

import vehiclerentalservice.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private static final String delimiter = "#";
    private String commandName;
    private List<String> params;

    public Command(String inputLine) {
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(delimiter))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException("Invalid Command");
        }

        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        params = tokensList;
    }


    public List<String> getParams() {
        return params;
    }

    public String getCommandName() { return commandName; }
}
