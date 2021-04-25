package vehiclerentalservice.exceptions;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(String msg){
        System.err.println(msg);
    }
}
