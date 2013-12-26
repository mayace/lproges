package com.github.lproges.compiler.es;

import com.github.lproges.compiler.Err;
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import java.lang.StringBuilder;

%%

%public
%class Scanner
%cup
%line
%column
%state YYSTRING YYCOMMENT YYCHAR

%{
    /** Errores **/
    LinkedList<Err> errores=new LinkedList<>();
    public LinkedList<Err> getErrores(){
        return errores;
    }
    private void error(String message) {
        Symbol sym = new Symbol(Sym.error, yyline, yycolumn, yytext());
        Err e = new Err(message,sym,Err.TIPO.LEXICO);
        getErrores().add(e);
    }
    /** Symbol **/
 
    private Symbol symbol(int type) {
            return new Symbol(type, yyline, yycolumn,yytext());
    }
    private Symbol symbol(int type, Object value) {
            return new Symbol(type, yyline, yycolumn, value);
    }

    /** String **/
    StringBuilder string=new StringBuilder();
%}

NEWLINE         = \n|\r|\r\n
SPACE           = [ \t]|{NEWLINE}
DIGIT           = [0-9]

INT             = {DIGIT}+
ID              = [:jletter:] [:jletterdigit:]*
BOOLEAN         = "true"|"false"
FLOAT           = {INT}"."{INT}

SIMPLE_COMMENT  = "&"[^\n\r]*{NEWLINE}

%%



<YYINITIAL>
{
    {SPACE}             {}
    {SIMPLE_COMMENT}    {}
    "["                 {yybegin(YYCOMMENT);} 

    "cadena"            {return symbol(Sym.KW_STRING);}
    "entero"            {return symbol(Sym.KW_INT);}
    "booleano"          {return symbol(Sym.KW_BOOLEAN);}
    "caracter"          {return symbol(Sym.KW_CHAR);}
    "decimal"           {return symbol(Sym.KW_FLOAT);}

    "="                 {return symbol(Sym.EQUAL);}
    ","                 {return symbol(Sym.COMA);}
    "."                 {return symbol(Sym.PUNTO);}
    ";"                 {return symbol(Sym.PCOMA);}
    
    "o"                 {return symbol(Sym.OR);}
    "y"                 {return symbol(Sym.AND);}
    "no"                {return symbol(Sym.NOT);}
    
    "=="                {return symbol(Sym.DEQUAL);}
    "#"                 {return symbol(Sym.NEQUAL);}
    ">"                 {return symbol(Sym.BTHAN);}
    "<"                 {return symbol(Sym.LTHAN);}
    ">="                {return symbol(Sym.BETHAN);}
    "<="                {return symbol(Sym.LETHAN);}
    
    "("                 {return symbol(Sym.LP);}
    ")"                 {return symbol(Sym.RP);}
    "{"                 {return symbol(Sym.LB);}
    "}"                 {return symbol(Sym.RB);}

    "-"                 {return symbol(Sym.MINUS);}
    "+"                 {return symbol(Sym.PLUS);}
    "*"                 {return symbol(Sym.MULTI);}
    "/"                 {return symbol(Sym.DIV);}

    "mientras"          {return symbol(Sym.WHILE);}
    "para"              {return symbol(Sym.FOR);}
    "si"                {return symbol(Sym.IF);}
    "sino"              {return symbol(Sym.ELSEIF);}
    "seleccionar"       {return symbol(Sym.SELECT);}
    "caso"              {return symbol(Sym.CASE);}
    "ninguno"           {return symbol(Sym.DEFAULT);}
    "salir"             {return symbol(Sym.EXIT);}
    
    "publica"           {return symbol(Sym.PUBLIC);}
    "privada"           {return symbol(Sym.PRIVATE);}

    \\                  {string.setLength(0); yybegin(YYSTRING);}
    "_"                 {string.setLength(0); yybegin(YYCHAR);}
    {INT}               {return symbol(Sym.INT);}
    {BOOLEAN}           {return symbol(Sym.BOOLEAN);}
    {FLOAT}             {return symbol(Sym.FLOAT);}
    {ID}                {return symbol(Sym.ID);}
    
        
}

<YYCOMMENT>{
    "]"     {yybegin(YYINITIAL);}
    .|\n    {}
}
<YYCHAR>{
    "_"          {
                    int lenght = string.length();
                    switch(lenght){
                        case 0:error("Caracter vacio...");break;
                        case 1:break;
                        default: error("No es un caracter...");
                    }
                    yybegin(YYINITIAL);
                    return symbol(Sym.CHAR,string.toString());
                }
    ":s"        { string.append('\n'); }
    ":t"        { string.append('\t'); }
    ":r"        { string.append('\r'); }
    ":_"        { string.append('_'); }
    ":\\"       { string.append('\\'); }
    [^\n\r\\]+  { string.append( yytext() ); }
}
<YYSTRING>{
    \\          {
                    yybegin(YYINITIAL);
                    return symbol(Sym.STRING,string.toString());
                }
    ":s"        { string.append('\n'); }
    ":t"        { string.append('\t'); }
    ":r"        { string.append('\r'); }
    ":_"        { string.append('_'); }
    ":\\"       { string.append('\\'); }
    [^\n\r\\]+  { string.append( yytext() ); }
}


.|\n        {error("Illegal character.");}


<<EOF>>     {return symbol(Sym.EOF);}