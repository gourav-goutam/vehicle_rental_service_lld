package vehiclerentalservice.exceptions;

public class InvalidModeException extends RuntimeException{

    public InvalidModeException(String msg){
        System.err.println(msg);
    }
}
