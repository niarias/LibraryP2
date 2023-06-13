package library;
import apis.ColaPrioridadTDA;
import apis.DiccionarioMultipleTDA;
import impl.ColaPrioridadLD;
import impl.DicMultipleL;

public class colaPrioridadHelper {
    public static ColaPrioridadTDA combinarColasPrioridad(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        ColaPrioridadTDA nuevaCola = new ColaPrioridadLD();
        nuevaCola.inicializarCola();

        // Pasamos los elementos de la CP1 a la nueva cola
        while (!cp1.colaVacia()) {
            int elemento = cp1.primero();
            int prioridad = cp1.prioridad();
            nuevaCola.acolarPrioridad(elemento, prioridad);
            cp1.desacolar();
        }

        // Pasamos los elementos de la CP2 a la nueva cola, con una prioridad menor
        while (!cp2.colaVacia()) {
            int elemento = cp2.primero();
            int prioridad = cp2.prioridad();
            nuevaCola.acolarPrioridad(elemento, prioridad - 1);
            cp2.desacolar();
        }

        return nuevaCola;
    }


    public static DiccionarioMultipleTDA generarDiccionarioDesdeColaPrioridad(ColaPrioridadTDA colaPrioridad) {
        DiccionarioMultipleTDA diccionario = new DicMultipleL();
        diccionario.inicializarDiccionario();

        while (!colaPrioridad.colaVacia()) {
            int elemento = colaPrioridad.primero();
            int prioridad = colaPrioridad.prioridad();

            // Si la clave no existe en el diccionario, la agregamos junto con su primer valor
            if (!diccionario.claves().pertenece(elemento)) {
                diccionario.agregar(elemento, prioridad);
            } else {
                // Si la clave ya existe, agregamos el valor como otro valor asociado a la clave
                diccionario.recuperar(elemento).agregar(prioridad);
            }

            colaPrioridad.desacolar();
        }

        return diccionario;
    }


}
