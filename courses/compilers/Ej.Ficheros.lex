import java.io.*;
import java.lang.*;
%%
%{
    static PrintStream PStr = null;
    static FileInputStream FInStr = null;
    public static void main (String argv[]) throws java.io.IOException {
        String fInName ; //nombre del fichero de entrada
        String fOutName ; //nombre del fichero de salida
        int numparams = argv.length; //número de argumentos pasados
        int i; //posición del puntero dentro del nombre
        //Obtención de parámetros pasados en línea de comandos
        if ( numparams != 1)
        { //error: nr. parámetros incorrecto
            System.out.print ("Nro parámetros incorrecto!");
            System.out.println ("Uso: \r\n java txt2html FICHERO.EXT");
            return;
        }
        else { //Creación del fichero de salida
            fInName = argv[0];
            if ((i =fInName.lastIndexOf(".")) <0)
            fOutName = new String(fInName).concat(".html");
        else
            fOutName=new String(fInName).substring(0,i).concat(".html");
        try {
            PStr=new PrintStream(new FileOutputStream(fOutName, false));
        }
        catch (FileNotFoundException e) {
                    System.out.println (fOutName + ": Imposible crear fichero!");
        }
        PStr.print("<HTML>\n<HEAD>\n<TITLE>"+fOutName);
        PStr.print ("</TITLE>\n</HEAD>\n<BODY>\n");
        txt2html yy = new txt2html(new FileInputStream(fInName));
        while (yy.yylex() != -1) ;
        // Cierre del fichero html
        PStr.print("</BODY>\n</HTML>");
        if (PStr!=null) PStr.close();
        }
    } //Final main
%}
%integer
%class txt2html
%%
\r\n { PStr.println("<BR>"); }
\< { PStr.print("&lt;"); }
\> { PStr.print("&gt;"); }
[^\r\n\<\>]+ { PStr.print(yytext()); }
