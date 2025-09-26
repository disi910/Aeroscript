package no.uio.aeroscript.ast.stmt;

import java.util.ArrayList;

public class Execution {
    private String modename;
    private ArrayList<Statement> statements = new ArrayList<>();

    public Execution(String modename, ArrayList<Statement> statements){
        this.modename = modename;
        this.statements = statements;
    }
    

}
