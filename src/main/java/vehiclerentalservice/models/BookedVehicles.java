package vehiclerentalservice.models;

import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BookedVehicles {
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private String branch;

    public BookedVehicles(String type, String branch, LocalDateTime start, LocalDateTime end){
        this.type = type;
        this.branch = branch;
        this.start = start;
        this.end = end;
    }

    public String getBranch() {
        return branch;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getStart() {
        return start;
    }


    public LocalDateTime getEnd() {
        return end;
    }


}


//Date date = StringToDate("2015-12-06 17:03:00");