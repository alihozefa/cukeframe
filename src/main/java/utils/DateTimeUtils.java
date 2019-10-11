package utils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public LocalDateTime getFutureDate(int noOfDays){
        return LocalDateTime.now().plusDays(noOfDays);
    }

    public LocalDateTime getPastDate(int noOfDays){
        return LocalDateTime.now().minusDays(noOfDays);
    }

    public boolean verifySameMonth(LocalDate  expectedDate, LocalDate actualDate){
        boolean matched = false;
        if(expectedDate.getMonth() == actualDate.getMonth() && expectedDate.getYear() == actualDate.getYear()){
            matched = true;
        }
        return matched;
    }

    public boolean verifySameYear(LocalDateTime  expectedDate, LocalDateTime actualDate){
        boolean matched = false;
        if(expectedDate.getYear() == actualDate.getYear()){
            matched = true;
        }
        return matched;
    }

    public LocalDate stringToDate(String strDate, String inputFormat, String outputFormat){
        if(inputFormat == null || inputFormat.isEmpty()){
            inputFormat = "dd-MMM-yyyy";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern(outputFormat);
        String newDate = LocalDate.parse(strDate, formatter).format(outFormat);
        return LocalDate.parse(newDate,outFormat);
    }
}
