package library;
import apis.PilaTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import impl.ColaLD;
import impl.ConjuntoLD;
import impl.PilaLD;

public class colaHelper {
    public static void pasarCola(ColaTDA colaOrigen, ColaTDA colaDestino) {
        while (!colaOrigen.colaVacia()) {
            int elemento = colaOrigen.primero();
            colaDestino.acolar(elemento);
            colaOrigen.desacolar();
        }
    }

    public static void invertirColaConPilas(ColaTDA cola) {
        PilaTDA pilaAuxiliar = new PilaLD();
        pilaAuxiliar.inicializarPila();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            pilaAuxiliar.apilar(elemento);
            cola.desacolar();
        }

        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            cola.acolar(elemento);
            pilaAuxiliar.desapilar();
        }
    }


    public static void invertirColaSinPilas(ColaTDA cola) {
        if (cola.colaVacia()) {
            return; // No hay elementos en la cola, no es necesario invertir
        }

        int elemento = cola.primero();
        cola.desacolar();

        invertirColaSinPilas(cola); // Llamada recursiva para invertir el resto de la cola

        cola.acolar(elemento); // Añadir el elemento al final después de invertir el resto de la cola
    }

    public static boolean coincidenElementosFinales(ColaTDA cola1, ColaTDA cola2) {
        if (cola1.colaVacia() || cola2.colaVacia()) {
            return false; // Al menos una de las colas está vacía, no hay elementos finales para comparar
        }

        int longitud1 = contarElementos(cola1);
        int longitud2 = contarElementos(cola2);

        if (longitud1 < longitud2) {
            return coincidenElementosFinales(cola2, cola1); // Asegurarse de que cola2 sea la más corta o igual en longitud
        }

        // Desplazar los primeros elementos de la cola1 hasta que tengan la misma longitud que cola2
        for (int i = 0; i < longitud1 - longitud2; i++) {
            cola1.desacolar();
        }

        // Comparar los elementos finales de ambas colas
        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            if (cola1.primero() != cola2.primero()) {
                return false; // Los elementos finales no coinciden
            }

            cola1.desacolar();
            cola2.desacolar();
        }

        return true; // Los elementos finales coinciden
    }

    private static int contarElementos(ColaTDA cola) {
        int contador = 0;

        ColaTDA colaAuxiliar = new ColaLD(); // Creamos una cola auxiliar
        colaAuxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            colaAuxiliar.acolar(elemento);
            cola.desacolar();
            contador++;
        }

        // Restaurar la cola original
        while (!colaAuxiliar.colaVacia()) {
            int elemento = colaAuxiliar.primero();
            cola.acolar(elemento);
            colaAuxiliar.desacolar();
        }

        return contador;
    }

    public static boolean esCapicua(ColaTDA cola) {
        ColaTDA colaAuxiliar = new ColaLD(); // Creamos una cola auxiliar
        colaAuxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            colaAuxiliar.acolar(elemento);
            cola.desacolar();
        }

        boolean capicua = true;

        while (!colaAuxiliar.colaVacia() && capicua) {
            int elemento1 = colaAuxiliar.primero();
            cola.acolar(elemento1);
            colaAuxiliar.desacolar();

            if (!colaAuxiliar.colaVacia()) {
                int elemento2 = colaAuxiliar.primero();

                if (elemento1 != elemento2) {
                    capicua = false;
                }

                cola.acolar(elemento2);
                colaAuxiliar.desacolar();
            }
        }

        return capicua;
    }

    public static boolean sonInversas(ColaTDA cola1, ColaTDA cola2) {
        if (cola1.colaVacia() || cola2.colaVacia()) {
            return false; // Al menos una de las colas está vacía
        }

        ColaTDA colaAuxiliar = new ColaLD(); // Creamos una cola auxiliar
        colaAuxiliar.inicializarCola();

        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            int elemento1 = cola1.primero();
            int elemento2 = cola2.primero();

            if (elemento1 != elemento2) {
                return false; // Los elementos no son iguales, no son inversas
            }

            colaAuxiliar.acolar(elemento1);
            cola1.desacolar();
            cola2.desacolar();
        }

        // Restaurar las colas originales
        while (!colaAuxiliar.colaVacia()) {
            int elemento = colaAuxiliar.primero();
            cola1.acolar(elemento);
            cola2.acolar(elemento);
            colaAuxiliar.desacolar();
        }

        return cola1.colaVacia() && cola2.colaVacia();
    }

    public static void eliminarRepeticiones(ColaTDA cola) {
        ColaTDA colaAuxiliar = new ColaLD(); // Creamos una cola auxiliar
        colaAuxiliar.inicializarCola();
        ConjuntoTDA conjuntoElementos = new ConjuntoLD(); // Creamos un conjunto para almacenar los elementos
        conjuntoElementos.inicializarConjunto();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();

            // Si el elemento no está en el conjunto, lo agregamos a la cola auxiliar y al conjunto
            if (!conjuntoElementos.pertenece(elemento)) {
                colaAuxiliar.acolar(elemento);
                conjuntoElementos.agregar(elemento);
            }

            cola.desacolar();
        }

        // Restaurar la cola original
        while (!colaAuxiliar.colaVacia()) {
            int elemento = colaAuxiliar.primero();
            cola.acolar(elemento);
            colaAuxiliar.desacolar();
        }
    }


    public static void repartirEnMitades(ColaTDA cola, ColaTDA m1, ColaTDA m2) {
        int tamano = cola.primero(); // Obtener el tamaño de la cola
        int mitad = tamano / 2; // Obtener la mitad del tamaño de la cola

        // Pasar los elementos a la cola m1 hasta la mitad
        for (int i = 0; i < mitad; i++) {
            int elemento = cola.primero();
            m1.acolar(elemento);
            cola.desacolar();
        }

        // Pasar los elementos restantes a la cola m2
        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            m2.acolar(elemento);
            cola.desacolar();
        }
    }

    public static ConjuntoTDA elementosRepetidos(ColaTDA cola) {
        ConjuntoTDA conjuntoElementos = new ConjuntoLD(); // Creamos un conjunto para almacenar los elementos
        conjuntoElementos.inicializarConjunto();
        ConjuntoTDA conjuntoRepetidos = new ConjuntoLD(); // Creamos un conjunto para almacenar los elementos repetidos
        conjuntoRepetidos.inicializarConjunto();
        while (!cola.colaVacia()) {
            int elemento = cola.primero();

            // Si el elemento está en el conjunto de elementos, lo agregamos al conjunto de repetidos
            if (conjuntoElementos.pertenece(elemento)) {
                conjuntoRepetidos.agregar(elemento);
            } else {
                conjuntoElementos.agregar(elemento);
            }

            cola.desacolar();
        }

        // Restaurar la cola original
        while (!conjuntoElementos.conjuntoVacio()) {
            int elemento = conjuntoElementos.elegir();
            cola.acolar(elemento);
            conjuntoElementos.sacar(elemento);
        }

        return conjuntoRepetidos;
    }















}
