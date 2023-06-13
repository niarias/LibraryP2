package library;
import apis.ConjuntoTDA;
import impl.ConjuntoLD;

public class conjuntoHelper {
    public static ConjuntoTDA interseccion(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA resultado = new ConjuntoLD();
        resultado.inicializarConjunto();

        while (!conjuntoA.conjuntoVacio()) {
            int elemento = conjuntoA.elegir();
            conjuntoA.sacar(elemento);

            if (conjuntoB.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }

    public static ConjuntoTDA union(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA resultado = new ConjuntoLD();
        resultado.inicializarConjunto();

        while (!conjuntoA.conjuntoVacio()) {
            int elemento = conjuntoA.elegir();
            conjuntoA.sacar(elemento);
            resultado.agregar(elemento);
        }

        while (!conjuntoB.conjuntoVacio()) {
            int elemento = conjuntoB.elegir();
            conjuntoB.sacar(elemento);
            resultado.agregar(elemento);
        }

        return resultado;
    }

    public static ConjuntoTDA diferencia(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA resultado = new ConjuntoLD();
        resultado.inicializarConjunto();

        while (!conjuntoA.conjuntoVacio()) {
            int elemento = conjuntoA.elegir();
            conjuntoA.sacar(elemento);

            if (!conjuntoB.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }

    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA union = union(conjuntoA, conjuntoB);
        ConjuntoTDA interseccion = interseccion(conjuntoA, conjuntoB);

        return diferencia(union, interseccion);
    }

    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        ConjuntoTDA difAB = diferencia(conjuntoA, conjuntoB);
        ConjuntoTDA difBA = diferencia(conjuntoB, conjuntoA);

        return union(difAB, difBA);
    }

    public static boolean conjuntosSonIguales(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB) {
        if (conjuntoA.conjuntoVacio() && conjuntoB.conjuntoVacio()) {
            return true;
        } else if (conjuntoA.conjuntoVacio() || conjuntoB.conjuntoVacio()) {
            return false;
        }

        ConjuntoTDA conjuntoCopiaA = copiarConjunto(conjuntoA);
        ConjuntoTDA conjuntoCopiaB = copiarConjunto(conjuntoB);

        while (!conjuntoCopiaA.conjuntoVacio()) {
            int elemento = conjuntoCopiaA.elegir();
            conjuntoCopiaA.sacar(elemento);

            if (!conjuntoCopiaB.pertenece(elemento)) {
                return false;
            }
        }

        while (!conjuntoCopiaB.conjuntoVacio()) {
            int elemento = conjuntoCopiaB.elegir();
            conjuntoCopiaB.sacar(elemento);

            if (!conjuntoA.pertenece(elemento)) {
                return false;
            }
        }

        return true;
    }

    public static int cardinalidad(ConjuntoTDA conjunto) {
        int cardinalidad = 0;

        ConjuntoTDA conjuntoCopia = copiarConjunto(conjunto);

        while (!conjuntoCopia.conjuntoVacio()) {
            int elemento = conjuntoCopia.elegir();
            conjuntoCopia.sacar(elemento);
            cardinalidad++;
        }

        return cardinalidad;
    }

    public static ConjuntoTDA elementosEnComun(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoElementos = new MiConjunto(); // Creamos un conjunto para almacenar los elementos

        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();

            if (cola.pertenece(elemento)) {
                conjuntoElementos.agregar(elemento);
            }
        }

        // Restauramos la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        return conjuntoElementos;
    }


    public static boolean elementosSonIguales(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoPila = new MiConjunto();
        ConjuntoTDA conjuntoCola = new MiConjunto();

        // Agregamos los elementos de la pila al conjunto de la pila
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            conjuntoPila.agregar(elemento);
            pila.desapilar();
        }

        // Agregamos los elementos de la cola al conjunto de la cola
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            conjuntoCola.agregar(elemento);
            cola.desacolar();
        }

        // Verificamos si los conjuntos son iguales
        return conjuntosSonIguales(conjuntoPila, conjuntoCola);
    }











}
