package no.uio.aeroscript.type;

public enum Direction {
    RIGHT("Right"),
    LEFT("Left");

    private final String description;

    Direction(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
