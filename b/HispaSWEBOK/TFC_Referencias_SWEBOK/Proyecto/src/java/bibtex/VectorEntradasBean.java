/*
 * VectorEntradasBean.java
 *
 * Created on 26 de enero de 2006, 16:48
 *
 * 
 */

package bibtex;

import java.io.*;
import java.util.*;

/**
 *
 * @author Manuel Monge Martínez
 */
public class VectorEntradasBean implements Serializable{
    
    Vector vEntradas;
    int numeroEntradas=0;
    
    /** Creates a new instance of VectorEntradasBean */
    public VectorEntradasBean() 
    {
        vEntradas = new Vector(); 
    }
    

    public Vector getVEntradas() 
    {
	return vEntradas;
    }

    public void setVEntradas(Vector vEntradas) 
    {
	this.vEntradas = vEntradas;
    }
    
    public void InsertaEntrada(EntradaBean nueva)
    {
        //Para insertar una nueva entrada
        this.vEntradas.add(nueva);
    }
    
    // Método que rellena el Vector con los datos del archivo
    public void VectorEntradas()
    {
        //Aqui es donde se rellena el vector con los datos del .bib
        File fichFuente = new File("ref.bib");
		BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            
            

            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                String key="";
                String tipo="";
                String title="";
                String author="";
                String year="";
                String journal="";
                String volume="";
                String pages="";
                String editor="";
                String publisher="";
                String chapter="";
                String institution="";
                String booktitle="";
                String url="";
                
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else 
                            if (atributo.equals("author"))
                            {
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                year = valor;
                            } else
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                journal = valor;
                            } else
                            if (atributo.equals("volume"))
                            {
                                volume = valor;
                            } else
                            if (atributo.equals("pages"))
                            {
                                pages = valor;
                            } else
                            if (atributo.equals("editor"))
                            {
                                editor = valor;
                            } else
                            if (atributo.equals("publisher"))
                            {
                                publisher = valor;
                            } else
                            if (atributo.equals("chapter"))
                            {
                                chapter = valor;
                            } else
                            if (atributo.equals("institution"))
                            {
                                institution = valor;
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                booktitle = valor;
                            } else
                            if (atributo.equals("url"))
                            {
                                url = valor;
                            }
                            cont++;
                    }
                    linea = flujoE.readLine();
                }
                
                EntradaBean entrada = new EntradaBean();
                
                entrada.setKey(key);
                entrada.setTipo(tipo);
                entrada.setTitle(title);
                entrada.setAuthor(author);
                entrada.setYear(year);
                entrada.setJournal(journal);
                entrada.setVolume(volume);
                entrada.setPages(pages);
                entrada.setEditor(editor);
                entrada.setPublisher(publisher);
                entrada.setChapter(chapter);
                entrada.setInstitution(institution);
                entrada.setBooktitle(booktitle);
                entrada.setUrl(url);
                
                InsertaEntrada(entrada);
                
                numeroEntradas++;
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);
           
	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    //Método que inserta en el vector la nueva entrada ordenada por Autor
    public void EscribeInsercion(String key2, String tipo2, String title2, String author2, String year2,
                String journal2, String volume2, String pages2, String editor2, String publisher2,
                String chapter2, String institution2, String booktitle2, String url2)
    {
        boolean escrito=false;
        File fichFuente = new File("ref.bib");
	BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            
            

            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                String key="";
                String tipo="";
                String title="";
                String author="";
                String year="";
                String journal="";
                String volume="";
                String pages="";
                String editor="";
                String publisher="";
                String chapter="";
                String institution="";
                String booktitle="";
                String url="";
                
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else 
                            if (atributo.equals("author"))
                            {
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                year = valor;
                            } else
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                journal = valor;
                            } else
                            if (atributo.equals("volume"))
                            {
                                volume = valor;
                            } else
                            if (atributo.equals("pages"))
                            {
                                pages = valor;
                            } else
                            if (atributo.equals("editor"))
                            {
                                editor = valor;
                            } else
                            if (atributo.equals("publisher"))
                            {
                                publisher = valor;
                            } else
                            if (atributo.equals("chapter"))
                            {
                                chapter = valor;
                            } else
                            if (atributo.equals("institution"))
                            {
                                institution = valor;
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                booktitle = valor;
                            } else
                            if (atributo.equals("url"))
                            {
                                url = valor;
                            }
                            cont++;
                    }
                    linea = flujoE.readLine();
                }
                
                EntradaBean entrada = new EntradaBean();
                
                if ((author.compareToIgnoreCase(author2)>0)&&(!escrito))
                {
                    EntradaBean aux = new EntradaBean();
                    
                    aux.setKey(key2);
                    aux.setTipo(tipo2);
                    aux.setTitle(title2);
                    aux.setAuthor(author2);
                    aux.setYear(year2);
                    aux.setJournal(journal2);
                    aux.setVolume(volume2);
                    aux.setPages(pages2);
                    aux.setEditor(editor2);
                    aux.setPublisher(publisher2);
                    aux.setChapter(chapter2);
                    aux.setInstitution(institution2);
                    aux.setBooktitle(booktitle2);
                    aux.setUrl(url2);
                    
                    InsertaEntrada(aux);
                    
                    numeroEntradas++;
                    
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);
                    
                    InsertaEntrada(entrada);
                    
                    numeroEntradas++;
                    
                    escrito=true;
                }
                else
                {
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);
                    
                    InsertaEntrada(entrada);
                    
                    numeroEntradas++;
                } 
                
                
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);
           
	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    // Método que escribe en el vector la modificación 
    public void EscribeModificacion(String key2, String tipo2, String title2, String author2, String year2,
                String journal2, String volume2, String pages2, String editor2, String publisher2,
                String chapter2, String institution2, String booktitle2, String url2, String clave)
    {
        File fichFuente = new File("ref.bib");
	BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            
            

            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                String key="";
                String tipo="";
                String title="";
                String author="";
                String year="";
                String journal="";
                String volume="";
                String pages="";
                String editor="";
                String publisher="";
                String chapter="";
                String institution="";
                String booktitle="";
                String url="";
                
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else 
                            if (atributo.equals("author"))
                            {
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                year = valor;
                            } else
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                journal = valor;
                            } else
                            if (atributo.equals("volume"))
                            {
                                volume = valor;
                            } else
                            if (atributo.equals("pages"))
                            {
                                pages = valor;
                            } else
                            if (atributo.equals("editor"))
                            {
                                editor = valor;
                            } else
                            if (atributo.equals("publisher"))
                            {
                                publisher = valor;
                            } else
                            if (atributo.equals("chapter"))
                            {
                                chapter = valor;
                            } else
                            if (atributo.equals("institution"))
                            {
                                institution = valor;
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                booktitle = valor;
                            } else
                            if (atributo.equals("url"))
                            {
                                url = valor;
                            }
                            cont++;
                    }
                    linea = flujoE.readLine();
                }
                
                EntradaBean entrada = new EntradaBean();
                
                if (key.equals(clave))
                {
                    entrada.setKey(key2);
                    entrada.setTipo(tipo2);
                    entrada.setTitle(title2);
                    entrada.setAuthor(author2);
                    entrada.setYear(year2);
                    entrada.setJournal(journal2);
                    entrada.setVolume(volume2);
                    entrada.setPages(pages2);
                    entrada.setEditor(editor2);
                    entrada.setPublisher(publisher2);
                    entrada.setChapter(chapter2);
                    entrada.setInstitution(institution2);
                    entrada.setBooktitle(booktitle2);
                    entrada.setUrl(url2);
                }
                else
                {
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);
                }
                
                InsertaEntrada(entrada);
                
                numeroEntradas++;
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);
           
	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    //Método que rellena el vector con la entrada de la clave pasada eliminada
    public void EscribeBorrado(String clave)
    {
        File fichFuente = new File("ref.bib");
	BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            
            

            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                String key="";
                String tipo="";
                String title="";
                String author="";
                String year="";
                String journal="";
                String volume="";
                String pages="";
                String editor="";
                String publisher="";
                String chapter="";
                String institution="";
                String booktitle="";
                String url="";
                
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else 
                            if (atributo.equals("author"))
                            {
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                year = valor;
                            } else
                            if (atributo.equals("title"))
                            {
                                title = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                journal = valor;
                            } else
                            if (atributo.equals("volume"))
                            {
                                volume = valor;
                            } else
                            if (atributo.equals("pages"))
                            {
                                pages = valor;
                            } else
                            if (atributo.equals("editor"))
                            {
                                editor = valor;
                            } else
                            if (atributo.equals("publisher"))
                            {
                                publisher = valor;
                            } else
                            if (atributo.equals("chapter"))
                            {
                                chapter = valor;
                            } else
                            if (atributo.equals("institution"))
                            {
                                institution = valor;
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                booktitle = valor;
                            } else
                            if (atributo.equals("url"))
                            {
                                url = valor;
                            }
                            cont++;
                    }
                    linea = flujoE.readLine();
                }
                
                EntradaBean entrada = new EntradaBean();
                
                if (!key.equals(clave))
                {    
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);
                    
                    InsertaEntrada(entrada);
                
                    numeroEntradas++;
                }
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);
           
	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    // Método que escribe el valor del vector en el archivo .bib
    public void EscribeFichero()
    {
        File fichFuente = new File("ref.bib");
	BufferedWriter flujoE = null;
	
	try
	{		
		FileOutputStream fis = new FileOutputStream(fichFuente);
		OutputStreamWriter isr = new OutputStreamWriter(fis);
		flujoE = new BufferedWriter(isr);
				 	
		String linea;
                String key;
                String tipo;
                String title;
                String author;
                String year;
                String journal;
                String volume;
                String pages;
                String editor;
                String publisher;
                String chapter;
                String institution;
                String booktitle;
                String url;
                
                int cont=0;
                EntradaBean e = new EntradaBean();
                
                do
                {
                    e = (EntradaBean)vEntradas.get(cont);
                    if (!e.getKey().equals(""))
                    {
                        flujoE.write("@"+e.getTipo().toUpperCase()+"{"+e.getKey()+",");
                        flujoE.newLine();
                        if (!e.getTitle().equals(""))
                        {
                            flujoE.write("  title = {"+e.getTitle()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getAuthor().equals(""))
                        {
                            flujoE.write("  author = {"+e.getAuthor()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getYear().equals(""))
                        {
                            flujoE.write("  year = {"+e.getYear()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getJournal().equals(""))
                        {
                            flujoE.write("  journal = {"+e.getJournal()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getVolume().equals(""))
                        {
                            flujoE.write("  volume = {"+e.getVolume()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getPages().equals(""))
                        {
                            flujoE.write("  pages = {"+e.getPages()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getEditor().equals(""))
                        {
                            flujoE.write("  editor = {"+e.getEditor()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getPublisher().equals(""))
                        {
                            flujoE.write("  publisher = {"+e.getPublisher()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getChapter().equals(""))
                        {
                            flujoE.write("  chapter = {"+e.getChapter()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getInstitution().equals(""))
                        {
                            flujoE.write("  institution = {"+e.getInstitution()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getBooktitle().equals(""))
                        {
                            flujoE.write("  booktitle = {"+e.getBooktitle()+"},");
                            flujoE.newLine();
                        }
                        if (!e.getUrl().equals(""))
                        {
                            flujoE.write("  url = {"+e.getUrl()+"},");
                            flujoE.newLine();
                        }
                        flujoE.write("}");
                        flujoE.newLine();
                    }
                    cont++;
                    e.vaciaEntrada();
                }
		while (cont<vEntradas.size());	 
                flujoE.write("#");
                
		flujoE.close();
	}
	 
		catch(IOException ioe)
		{
		 	System.out.println(" ERROR de transmision de datos "+ioe.toString());
		}
		catch( Exception e )
		{
			System.out.println(" ERROR al Escribir Datos "+e.toString());
		}	  
	}
    
	// Método que Borra del Vector la entrada con la clave q se pasa
    public void BorraEntrada(String clave)
    {
        //Borra del Vector la entrada con la clave q se pasa
        EntradaBean ent = new EntradaBean();
        ent = DameEntrada(clave);
        vEntradas.remove(ent);
    }
    
    // Método que devuelve la entrada con key pasada
    public EntradaBean DameEntrada (String key)
    {
        EntradaBean ent = new EntradaBean();
        int i=0;
        boolean terminar=false;
        while ((i<numeroEntradas)&&(!terminar))
        {
            ent.vaciaEntrada();
            ent = (EntradaBean)this.getVEntradas().get(i);
            if (ent.getKey().equals(key))
            {
                terminar=true;
            }
            i++;
        }   
        return ent;
    }
    
    // Método booleano que indica si la clave esta en el vector
    public boolean ClaveExistente(String key)
    {
        boolean esta=false;        
        int cont=0;
        EntradaBean ent = new EntradaBean();
        while ((!esta)&&(cont<numeroEntradas))
        {            
            ent = (EntradaBean)vEntradas.get(cont);
            if(ent.getKey().equals(key))
            {
                esta=true;
            }
            cont++;
        }
        return esta;
    }
    
    // Método que devuelve el vector de busqueda según la cadena de busqueda
    public void vectorBuscados(String busqueda) //Busca en todos los campos
    {   
        File fichFuente = new File("ref.bib");
	BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            boolean intro;

            String key="";
            String tipo="";
            String title="";
            String author="";
            String year="";
            String journal="";
            String volume="";
            String pages="";
            String editor="";
            String publisher="";
            String chapter="";
            String institution="";
            String booktitle="";
            String url="";
            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                intro=false;
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                title = valor;                            
                            } else
                            if (atributo.equals("author"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                year = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                journal = valor;
                            } else
                            if (atributo.equals("volume"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                volume = valor;                                
                            } else
                            if (atributo.equals("pages"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                pages = valor;                                
                            } else
                            if (atributo.equals("editor"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                editor = valor;                                
                            } else
                            if (atributo.equals("publisher"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                publisher = valor;                                
                            } else
                            if (atributo.equals("chapter"))
                            {
                                chapter = valor;                                
                            } else
                            if (atributo.equals("institution"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                institution = valor;                                
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                booktitle = valor;                                
                            } else
                            if (atributo.equals("url"))
                            {
                                if (esta(busqueda,valor))
                                {
                                    intro=true;
                                }
                                url = valor;                                
                            }
                            cont++;
                    }

                    linea = flujoE.readLine();
                }
                
                if (intro)
                {
                    EntradaBean entrada = new EntradaBean();
                
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);

                    InsertaEntrada(entrada);

                    numeroEntradas++;
                }
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);

	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    // Método que devuelve el vector de busqueda según la cadena de busqueda y el campo en el que buscar
    public void vectorBuscados(String busqueda, String campo) //Busca en un campo exclusivo
    {
        File fichFuente = new File("ref.bib");
	BufferedReader flujoE = null;

	try
	{		   
            FileInputStream fis = new FileInputStream(fichFuente);
            InputStreamReader isr = new InputStreamReader(fis);
            flujoE = new BufferedReader(isr);
            
            int cont=1;
            String linea;
            String atributo="";
            String valor="";
            boolean intro;

            String key="";
            String tipo="";
            String title="";
            String author="";
            String year="";
            String journal="";
            String volume="";
            String pages="";
            String editor="";
            String publisher="";
            String chapter="";
            String institution="";
            String booktitle="";
            String url="";
            
            linea = flujoE.readLine();
            while (!linea.equals("#"))
            {
                intro=false;
                StringTokenizer st = new StringTokenizer(linea,"{");
                while (st.hasMoreTokens())
                {
                    tipo = st.nextToken();
                    tipo = tipo.substring(1, tipo.length());
                    key = st.nextToken();
                    key = key.substring(0, key.length()-1);
                }

                linea = flujoE.readLine();
                while (!linea.equals("}"))
                {
                    StringTokenizer str = new StringTokenizer(linea,"=");

                    while (str.hasMoreTokens())
                    {
                            atributo = str.nextToken();
                            atributo = atributo.substring(2, atributo.length()-1);
                            valor = str.nextToken();
                            valor = valor.substring(2, valor.length()-2);
                            //System.out.println(atributo);
                            if (atributo.equals("title"))
                            {
                                
                                if ((campo.equals("title"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                title = valor;                            
                            } else 
                            if (atributo.equals("author"))
                            {
                                if ((campo.equals("author"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                author = valor;
                            } else 
                            if (atributo.equals("year"))
                            {
                                if ((campo.equals("year"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                year = valor;
                            } else
                            if (atributo.equals("journal"))
                            {
                                if ((campo.equals("journal"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                journal = valor;
                            } else
                            if (atributo.equals("editor"))
                            {
                                if ((campo.equals("editor"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                editor = valor;                                
                            } else
                            if (atributo.equals("publisher"))
                            {
                                if ((campo.equals("publisher"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                publisher = valor;                                
                            } else
                            if (atributo.equals("institution"))
                            {
                                if ((campo.equals("institution"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                institution = valor;                                
                            } else
                            if (atributo.equals("booktitle"))
                            {
                                if ((campo.equals("booktitle"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                booktitle = valor;                                
                            } else
                            if (atributo.equals("url"))
                            {
                                if ((campo.equals("url"))&&(esta(busqueda,valor)))
                                {
                                    intro=true;
                                }
                                url = valor;                                
                            }
                            cont++;
                    }

                    linea = flujoE.readLine();
                }
                
                if (intro)
                {
                    EntradaBean entrada = new EntradaBean();
                
                    entrada.setKey(key);
                    entrada.setTipo(tipo);
                    entrada.setTitle(title);
                    entrada.setAuthor(author);
                    entrada.setYear(year);
                    entrada.setJournal(journal);
                    entrada.setVolume(volume);
                    entrada.setPages(pages);
                    entrada.setEditor(editor);
                    entrada.setPublisher(publisher);
                    entrada.setChapter(chapter);
                    entrada.setInstitution(institution);
                    entrada.setBooktitle(booktitle);
                    entrada.setUrl(url);

                    InsertaEntrada(entrada);

                    numeroEntradas++;
                }
                
                linea = flujoE.readLine();
            }
            
            setNumeroEntradas(numeroEntradas);

	 }
         catch (EOFException eoef)
	 {
            System.out.println(" ERROR al leer el fichero "+eoef.toString());
	 }
	 catch(IOException e)
	 {
            System.out.println(" ERROR de transmision de datos "+e.toString());
	 }
    }
    
    public boolean esta(String busqueda, String valor)
    {
        boolean esta=false;
        int v;
        
        busqueda = busqueda.toLowerCase();
        valor = valor.toLowerCase();
        
        v=valor.indexOf(busqueda);
        if (v<0)
        {
            esta=false;
        }
        else
        {
            esta=true;
        }
        return esta;
    }   
    
    public void setNumeroEntradas(int numeroEntradas) 
    {
	this.numeroEntradas = numeroEntradas;
    }
    
    public int getNumeroEntradas() 
    {
	return numeroEntradas;
    }
}
