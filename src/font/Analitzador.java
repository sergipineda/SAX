/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author profe
 */
public class Analitzador extends DefaultHandler{
    
    private ArrayList<Jugador> dades=new ArrayList<>();
    private Jugador element;
     private Jugador element2;
    private String text;
    private String fitxerXML;
    
    public Analitzador(String fitxer){
        fitxerXML=fitxer;
        
        
    }
    
    public int numeroJugadors(){
        int njugadors=0;
        if ( element._4amt== "Alcoyano"){
            
            njugadors++;
        }
        return njugadors;
                
        
}

    //Mètode que engegarà l'anàlisis o parsing del fitxer XML
    public void analitza(){        
        try {
            XMLReader processador=XMLReaderFactory.createXMLReader();
            processador.setContentHandler(this);
            processador.parse(new InputSource(fitxerXML));
        } catch (SAXException ex) {
            Logger.getLogger(Analitzador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Analitzador.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public ArrayList<Jugador> getDades() {
        return dades;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text=new String(ch, start, length); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        switch(qName){
            case "Jugador":
                dades.add(element);
                
                break;
       
            case "Nom":
                element.set1id(text);
                break;
            case "Cognom":
                element.set3name(text);
                break;
            case "Equip":
                element.set4amt(text);
                break;
        }
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        if(qName.equals("Jugador")){
                element=new Jugador();
                if(attributes.getLength()!=0){ 
                    element.set2type(attributes.getValue(0));
                     element.set3edat(attributes.getValue(1));
                }
        }
    }    
}

/*
    Classe que representa les dades contingudes al fitxer XML.
    El _n en que comencen el nom de les propietats servix per forçar l'ordre d'aparició de les dades a la taula
    És necessari incloure tots els accessors (getters i setters)
*/

class Jugador {

   private String _3name;
   private String _1id;
   public String _4amt;
    private String _3edat;
   private String _2type;

    public String get3edat() {
        return _3edat;
    }

    public void set3edat(String _5edat) {
        this._3edat = _5edat;
    }
  

   public Jugador() {
   }

    public String get3name() {
        return _3name;
    }

    public void set3name(String _3name) {
        this._3name = _3name;
    }

    public String get1id() {
        return _1id;
    }

    public void set1id(String _1id) {
        this._1id = _1id;
    }

    public String get4amt() {
        return _4amt;
    }

    public void set4amt(String _4amt) {
        this._4amt = _4amt;
    }

    public String get2type() {
        return _2type;
    }

    public void set2type(String _2type) {
        this._2type = _2type;
    }
       
}
