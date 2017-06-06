package pl.edu.agh.compilers;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static pl.edu.agh.compilers.simpleLexer.names;

/**
 * Created by ceeminor on 04.06.17.
 */
public class MyListener extends simpleBaseListener {
    private StringBuilder sb = new StringBuilder();
    private String resultProgramInC;

    @Override
    public void enterBlock(simpleParser.BlockContext ctx) { sb.append(" {\n"); }
    @Override
    public void exitBlock(simpleParser.BlockContext ctx) { sb.append("\n}\n"); }

    @Override
    public void enterConditionalStatement(simpleParser.ConditionalStatementContext ctx) {
        sb.append("if (");
    }

    @Override
    public void exitConditionalStatement(simpleParser.ConditionalStatementContext ctx) {
        sb.append(")");
    }
    public String getCSource() {
        return sb.toString();
    }

    @Override
    public void enterProgram(simpleParser.ProgramContext ctx) {
        sb.append("#include <stdio.h>\n\nint main(int argc, char* argv[])");
    }

    @Override
    public void enterAddition(simpleParser.AdditionContext ctx) {

    }

    @Override
    // function performs basic identification of assigned type so as to prepare (declare and define those )
    public void enterAssignment(simpleParser.AssignmentContext ctx) {
        int depth = ctx.expression().depth();
        String type;
        String evalValue = ctx.expression()
                .getChild(0).getText();
//                .getChild(0);
                //.getChild(0)
               // .getChild(0); //getClass().getCanonicalName());
        if (evalValue.matches("[0-9]+\\.[0-9]*")) type = "double";
        else if (evalValue.matches("[0-9]+")) type = "int";
        else if (evalValue.replaceAll("\\s+","") == "false" || evalValue.replaceAll("\\s+","") == "true") type = "bool";
        else type = "string";
        names.put(ctx.NAME().toString(), type);
    }
}
