/*
 * Created on 1-feb-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package bibtex;

import bibtex.pruebaAccion.*;

/**
 * @author Manuel Monge Martínez
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ContenedorAccionesPpal extends ContenedorAcciones {
    

    /**
     * Constructor
     */
    public ContenedorAccionesPpal() {
        super();
        
        this.addAccion("prueba",((Accion) new pruebaAccion()));
        this.addAccion("entrar", ((Accion) new EntrarAccion()));
        this.addAccion("listado", ((Accion)new ListadoAccion()));
        this.addAccion("endetalle", ((Accion)new EndetalleAccion()));
        this.addAccion("insertar", ((Accion)new InsertarAccion()));
        this.addAccion("modificar", ((Accion)new ModificarAccion()));
        this.addAccion("modificando", ((Accion)new ModificandoAccion()));
        this.addAccion("modificado", ((Accion)new ModificadoAccion()));
        this.addAccion("insertando", ((Accion)new InsertandoAccion()));
        this.addAccion("escribir", ((Accion)new EscribirAccion()));
        this.addAccion("buscado", ((Accion)new BuscadorAccion()));
        this.addAccion("borrar", ((Accion)new BorrarAccion()));
        this.addAccion("borrado", ((Accion)new BorradoAccion()));
    }
}
