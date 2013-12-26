
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Dec 25 15:39:05 CST 2013
//----------------------------------------------------

package com.github.lproges.compiler.es;

import com.github.lproges.compiler.Attr;
import com.github.lproges.compiler.Err;
import java.util.LinkedList;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Wed Dec 25 15:39:05 CST 2013
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\002\003\000\002\002\004\000\002\002" +
    "\002\000\002\003\003\000\002\004\004\000\002\004\003" +
    "\000\002\005\004\000\002\005\006\000\002\014\004\000" +
    "\002\016\003\000\002\016\003\000\002\016\003\000\002" +
    "\016\003\000\002\016\003\000\002\016\003\000\002\015" +
    "\005\000\002\015\003\000\002\013\003\000\002\012\003" +
    "\000\002\011\003\000\002\010\003\000\002\007\003\000" +
    "\002\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\020\002\uffff\003\011\004\015\005\007\006" +
    "\012\007\017\010\004\001\002\000\004\016\ufff8\001\002" +
    "\000\004\002\032\001\002\000\020\002\ufffc\003\ufffc\004" +
    "\ufffc\005\ufffc\006\ufffc\007\ufffc\010\ufffc\001\002\000\004" +
    "\016\ufff6\001\002\000\006\020\027\021\026\001\002\000" +
    "\004\016\ufff3\001\002\000\004\016\ufff7\001\002\000\004" +
    "\002\001\001\002\000\004\016\021\001\002\000\004\016" +
    "\ufff5\001\002\000\020\002\ufffe\003\011\004\015\005\007" +
    "\006\012\007\017\010\004\001\002\000\004\016\ufff4\001" +
    "\002\000\020\002\ufffd\003\ufffd\004\ufffd\005\ufffd\006\ufffd" +
    "\007\ufffd\010\ufffd\001\002\000\010\017\uffeb\020\uffeb\021" +
    "\uffeb\001\002\000\010\017\024\020\ufff9\021\ufff9\001\002" +
    "\000\010\017\ufff1\020\ufff1\021\ufff1\001\002\000\004\016" +
    "\021\001\002\000\010\017\ufff2\020\ufff2\021\ufff2\001\002" +
    "\000\002\001\002\000\020\002\ufffb\003\ufffb\004\ufffb\005" +
    "\ufffb\006\ufffb\007\ufffb\010\ufffb\001\002\000\004\020\031" +
    "\001\002\000\020\002\ufffa\003\ufffa\004\ufffa\005\ufffa\006" +
    "\ufffa\007\ufffa\010\ufffa\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\016\002\004\003\012\004\015\005\005\014" +
    "\007\016\013\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\006\022\015\021\001\001\000\002\001\001\000\010\005" +
    "\017\014\007\016\013\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\024\001\001\000\002\001\001\000\004" +
    "\017\027\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


 
    LinkedList<Err> errores = new LinkedList<>();
    LinkedList<String> tres = new LinkedList<>();

    public LinkedList<Err> getErrores(){
        return errores;
    }
    public LinkedList<String> getTres(){
        return tres;
    }

    public void report_error(String message, Object info){
        Err e = new Err(message,null,Err.TIPO.SINTACTICO);

        if(info instanceof java_cup.runtime.Symbol){
            e.setSym((java_cup.runtime.Symbol)info);
        }
        getErrores().add(e);
    }
    public void report_fatal_error(String message,Object info){
        report_error(message,info);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {



    void report_error(String msg,Object info){
        parser.report_error(msg,info);
    }
    void addTres(String tres){
        parser.getTres().add(tres);
    }
    void addError(String msg,Object info,Err.TIPO tipo){
        parser.getErrores().add(new Err(msg,info,tipo));
    }

  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // id ::= ID 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("id",true);
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("id",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // int ::= INT 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("tipo","int");
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("int",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // string ::= STRING 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("tipo","string");
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("string",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // boolean ::= BOOLEAN 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("tipo","boolean");
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("boolean",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // float ::= FLOAT 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("tipo","float");
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("float",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // char ::= CHAR 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String x = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    Attr a = new Attr();
                    a.set("val",x);
                    a.set("tipo","char");
                    a.set("info",CUP$Parser$stack.peek());
                    RESULT = a;
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("char",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // id_list ::= id 
            {
              Attr RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("id_list",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // id_list ::= id_list COMA id 
            {
              Attr RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("id_list",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // tipo ::= error 
            {
              Attr RESULT =null;
		RESULT = new Attr();
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // tipo ::= KW_FLOAT 
            {
              Attr RESULT =null;
		RESULT = new Attr("tipo","float");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // tipo ::= KW_INT 
            {
              Attr RESULT =null;
		RESULT = new Attr("tipo","int");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tipo ::= KW_STRING 
            {
              Attr RESULT =null;
		RESULT = new Attr("tipo","string");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tipo ::= KW_BOOLEAN 
            {
              Attr RESULT =null;
		RESULT = new Attr("tipo","boolean");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo ::= KW_CHAR 
            {
              Attr RESULT =null;
		RESULT = new Attr("tipo","char");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // declaracion ::= tipo id_list 
            {
              Attr RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Attr t = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Attr l = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaracion",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // stmt ::= declaracion EQUAL expr PCOMA 
            {
              Attr RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // stmt ::= declaracion PCOMA 
            {
              Attr RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmt_list ::= stmt 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Attr x = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt_list",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmt_list ::= stmt_list stmt 
            {
              Attr RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Attr l = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Attr x = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt_list",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // input ::= stmt_list 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Attr x = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("input",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // begin ::= 
            {
              Attr RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("begin",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= begin EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Attr start_val = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // begin ::= input 
            {
              Attr RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int xright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Attr x = (Attr)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                    System.out.println("Compiled...");
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("begin",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
