package library;
import apis.PilaTDA;
import impl.PilaLD;
public class pilaHelper {
    public static void pasarPila(PilaTDA pilaOrigen, PilaTDA pilaDestino) {
        PilaTDA pilaAuxiliar = new PilaLD(); // Creamos una pila auxiliar
        pilaAuxiliar.inicializarPila();
        while (!pilaOrigen.pilaVacia()) {
            int elemento = pilaOrigen.tope();
            pilaAuxiliar.apilar(elemento);
            pilaOrigen.desapilar();
        }

        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pilaDestino.apilar(elemento);
            pilaAuxiliar.desapilar();
        }
    }

    public static void copiarPila(PilaTDA pilaOrigen, PilaTDA pilaDestino) {
        PilaTDA pilaAuxiliar = new PilaLD(); // Creamos una pila auxiliar
        pilaAuxiliar.inicializarPila();
        while (!pilaOrigen.pilaVacia()) {
            int elemento = pilaOrigen.tope();
            pilaAuxiliar.apilar(elemento);
            pilaDestino.apilar(elemento);
            pilaOrigen.desapilar();
        }

        // Volvemos a colocar los elementos en la pila original en el orden original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pilaOrigen.apilar(elemento);
            pilaAuxiliar.desapilar();
        }
    }

    public static void invertirPila(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new PilaLD(); // Creamos una pila auxiliar
        pilaAuxiliar.inicializarPila();
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
        }

        // Colocamos los elementos en la pila original en el orden inverso
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }
    }

    public static int contarElementos(PilaTDA pila) {
        int contador = 0;

        PilaTDA pilaAuxiliar = new PilaLD(); // Creamos una pila auxiliar
        pilaAuxiliar.inicializarPila();
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
            contador++;
        }

        // Restauramos la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        return contador;
    }

    public static int sumarElementos(PilaTDA pila) {
        int suma = 0;

        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
            suma += elemento;
        }

        // Restauramos la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        return suma;
    }

    public static double calcularPromedio(PilaTDA pila) {
        int suma = 0;
        int contador = 0;

        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
            suma += elemento;
            contador++;
        }

        // Restauramos la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        if (contador != 0) {
            return (double) suma / contador;
        } else {
            return 0.0; // Si la pila está vacía, retornamos 0 como promedio
        }
    }

    public static boolean esCapicua(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar
        boolean capicua = true;

        // Invertir la pila y almacenarla en la pila auxiliar
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
        }

        // Comparar los elementos de la pila original con los de la pila auxiliar
        while (!pilaAuxiliar.pilaVacia() && capicua) {
            int elementoOriginal = pila.tope();
            int elementoAuxiliar = pilaAuxiliar.tope();

            if (elementoOriginal != elementoAuxiliar) {
                capicua = false;
            }

            pila.desapilar();
            pilaAuxiliar.desapilar();
        }

        // Restaurar la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        return capicua;
    }

    public static void eliminarRepeticiones(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar
        ConjuntoTDA conjuntoElementos = new MiConjunto(); // Creamos un conjunto para almacenar los elementos

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();

            // Si el elemento no está en el conjunto, lo agregamos a la pila auxiliar y al conjunto
            if (!conjuntoElementos.pertenece(elemento)) {
                pilaAuxiliar.apilar(elemento);
                conjuntoElementos.agregar(elemento);
            }

            pila.desapilar();
        }

        // Restaurar la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            pila.apilar(elemento);
            pilaAuxiliar.desapilar();
        }
    }

    public static void repartirEnMitades(PilaTDA pila, PilaTDA m1, PilaTDA m2) {
        PilaTDA pilaAuxiliar = new MiPila(); // Creamos una pila auxiliar

        int mitad = pila.tamanio() / 2; // Obtener la mitad del tamaño de la pila

        // Pasar los elementos a la pila auxiliar hasta la mitad
        for (int i = 0; i < mitad; i++) {
            int elemento = pila.tope();
            pilaAuxiliar.apilar(elemento);
            pila.desapilar();
        }

        // Pasar los elementos restantes a la pila m1
        while (!pilaAuxiliar.pilaVacia()) {
            int elemento = pilaAuxiliar.tope();
            m1.apilar(elemento);
            pilaAuxiliar.desapilar();
        }

        // Pasar los elementos de la pila original a la pila m2
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            m2.apilar(elemento);
            pila.desapilar();
        }

        public static ConjuntoTDA elementosRepetidos(PilaTDA pila) {
            ConjuntoTDA conjuntoElementos = new MiConjunto(); // Creamos un conjunto para almacenar los elementos
            ConjuntoTDA conjuntoRepetidos = new MiConjunto(); // Creamos un conjunto para almacenar los elementos repetidos

            while (!pila.pilaVacia()) {
                int elemento = pila.tope();

                // Si el elemento está en el conjunto de elementos, lo agregamos al conjunto de repetidos
                if (conjuntoElementos.pertenece(elemento)) {
                    conjuntoRepetidos.agregar(elemento);
                } else {
                    conjuntoElementos.agregar(elemento);
                }

                pila.desapilar();
            }

            // Restaurar la pila original
            while (!conjuntoElementos.conjuntoVacio()) {
                int elemento = conjuntoElementos.elegir();
                pila.apilar(elemento);
                conjuntoElementos.sacar(elemento);
            }

            return conjuntoRepetidos;
        }

    }










}
