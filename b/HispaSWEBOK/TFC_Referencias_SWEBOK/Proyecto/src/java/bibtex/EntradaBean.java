/*
 * EntradaBean.java
 *
 * Created on 26 de enero de 2006, 15:44
 *
 * Clase EntradaBean
 *
 */

package bibtex;

import java.io.*;
import java.util.*;

/**
 *
 * @author Manuel Monge Martínez
 */
public class EntradaBean implements Serializable{
    
    //************************************
    //******* Atributos de la clase ******
    //************************************
    
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
    
    //Constructor
    public EntradaBean()
   {     
        this.key="";
        this.tipo="";
        this.title="";
        this.author="";
        this.year="";
        this.journal="";
        this.volume="";
        this.pages="";
        this.editor="";
        this.publisher="";
        this.chapter="";
        this.institution="";
        this.booktitle="";
        this.url="";     
   }
    
    public void vaciaEntrada()
    {
        this.setKey("");
        this.setTipo("");
        this.setTitle("");
        this.setAuthor("");
        this.setYear("");
        this.setJournal("");
        this.setVolume("");
        this.setPages("");
        this.setEditor("");
        this.setPublisher("");
        this.setChapter("");
        this.setInstitution("");
        this.setBooktitle("");
        this.setUrl("");
    }
    
    //************************************
    //********** Métodos geters **********
    //************************************
    
    
    public String getKey() 
    {
	return key;
    }
    
    public String getTipo() 
    {
	return tipo;
    }
    
    public String getTitle() 
    {
	return title;
    }
    
    public String getAuthor() 
    {
	return author;
    }
    
    public String getYear() 
    {
	return year;
    }
    
    public String getJournal() 
    {
	return journal;
    }
    
    public String getVolume() 
    {
	return volume;
    }
    
    public String getPages() 
    {
	return pages;
    }
    
    public String getEditor() 
    {
	return editor;
    }
    
    public String getPublisher() 
    {
	return publisher;
    }
    
    public String getChapter() 
    {
	return chapter;
    }
    
    public String getInstitution() 
    {
	return institution;
    }
    
    public String getBooktitle() 
    {
	return booktitle;
    }
    
    public String getUrl() 
    {
	return url;
    }
    
    
    //*************************************
    //************ Metodos seters *********
    //*************************************
    

    
    public void setKey(String key)
    {
        this.key = key;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setYear(String year)
    {
        this.year = year;
    }
    
    public void setJournal(String journal)
    {
        this.journal = journal;
    }
    
    public void setVolume(String volume)
    {
        this.volume = volume;
    }
    
    public void setPages(String pages)
    {
        this.pages = pages;
    }
    
    public void setEditor(String editor)
    {
        this.editor = editor;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public void setChapter(String chapter)
    {
        this.chapter = chapter;
    }
    
    public void setInstitution(String institution)
    {
        this.institution = institution;
    }
    
    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
}
