package fr.home;

/**
* Created by cpe on 28/10/2014.
*/
public class ErrorLine {
    private final String error ;
    public ErrorLine(String line) {
        this.error = line.substring(5, line.length()).trim();
    }

    @Override
    public boolean equals(Object obj) {
        return error.equals(((ErrorLine)obj).error) ;
    }

    @Override
    public int hashCode() {
        return error.hashCode() ;
    }

    @Override
    public String toString() {
        return error ;
    }
}
