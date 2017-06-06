package pl.edu.agh.compilers;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static pl.edu.agh.compilers.simpleLexer.names;

/**
 * Created by ceeminor on 04.06.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String input = null;
        FileInputStream fis;
        if (args.length == 2) {
            System.out.println("Usage: java Main <source>");
            return;
        } else {

            fis = new FileInputStream( new File ("pythonSrc.txt")/*new File(args[1])*/);
            input = fis.toString();
        }
        ANTLRInputStream ais = new ANTLRInputStream(fis);
        simpleLexer lexer = new simpleLexer(ais);

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        simpleParser parser = new simpleParser(tokens);

        // Specify our entry point
        simpleParser.ProgramContext ctx = parser.program();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener();
//        simpleListener listener = new simpleBaseListener();
        walker.walk(listener, ctx);
        System.out.println(listener.getCSource());
        Iterator it = names.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println("Key: " + pair.getKey() + " value: " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
