package br.com.arcatalog.parser.vb6;

import org.antlr.v4.gui.TestRig;

public class Teste2 {
	public static void main(String[] args) throws Exception {
		String a[] = new String[] { 
				  "br.com.arcatalog.parser.vb6.Vb6", "startRule", "-gui", "C:\\Users\\josez\\eclipse-workspace_2303_03\\parser-vb\\src\\test\\resources\\vb6Teste.frm"
				  };
		
		TestRig tr = new TestRig(a);
		tr.process();
	}
}