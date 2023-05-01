package br.com.arcatalog.parser.vb6;


import java.io.File;
import java.util.Scanner;

//import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;



public class Vb6Teste
{

    public static void main(String[] args) throws Exception 
    {
        String content = new Scanner(new File("C:\\Users\\josez\\eclipse-workspace_2303_03\\parser-vb\\src\\test\\resources\\vb6Teste.frm")).useDelimiter("\\Z").next();
        System.out.println( "Vb6 File:\n" + content + "\n\n");
        
//        ANTLRInputStream input = new ANTLRInputStream( content );
//        
//        JSONLexer lexer = new JSONLexer(input);
//        
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        
//        JSONParser parser = new JSONParser(tokens);
//        
//        ParseTree tree = parser.json();
//        
//        System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n"); 
        
        CharStream codePointCharStream = CharStreams.fromString(content);
        Vb6Lexer lexer = new Vb6Lexer(codePointCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        Vb6Parser parser = new Vb6Parser(tokens); 
        
        ParseTree tree = parser.startRule();
        
        
        System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n");
        }

}