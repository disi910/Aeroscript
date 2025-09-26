package no.uio.aeroscript.ast.stmt;

import java.util.ArrayList;

public class Execution {
    private String execName;
    private ArrayList<Statement> statements = new ArrayList<>();

    public Execution(String execName, ArrayList<Statement> statements){
        this.execName = execName;
        this.statements = statements;
    }

    public String getExecName(){
        return this.execName;
    }

    public ArrayList<Statement> getStatements(){
        return this.statements;
    }


}
