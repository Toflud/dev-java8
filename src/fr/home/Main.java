package fr.home;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {
            Stream<ErrorLine> lines = Files.lines(Paths.get("file.log"))
                    .filter((String line) ->line.contains("ERROR"))
                    // Map to error message
                    .map(line -> new ErrorLine(line));

            // group by and count
            Map<ErrorLine, Long> counted = lines.collect(Collectors.groupingBy(Function.<ErrorLine>identity(), Collectors.counting()));

            System.out.println(counted);

            //long c = lines.map(line->{System.out.println(line);return line;}).count() ;
            //System.out.println(c + " line(s)") ;
            //List<String> errors = lines.collect(Collectors.toList()) ;
            //for (String err : errors) System.out.println(err) ;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
