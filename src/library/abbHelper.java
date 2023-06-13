package library;
import apis.ABBTDA;
import apis.ConjuntoTDA;

public class abbHelper {
    // Versión iterativa
    public static boolean elementoEnABBIterativo(ABBTDA arbol, int elemento) {
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == elemento) {
                return true;
            } else if (elemento < arbol.raiz()) {
                arbol = arbol.hijoIzq();
            } else {
                arbol = arbol.hijoDer();
            }
        }

        return false;
    }

    // Versión recursiva
    public static boolean elementoEnABBRecursivo(ABBTDA arbol, int elemento) {
        if (arbol.arbolVacio()) {
            return false;
        } else if (arbol.raiz() == elemento) {
            return true;
        } else if (elemento < arbol.raiz()) {
            return elementoEnABBRecursivo(arbol.hijoIzq(), elemento);
        } else {
            return elementoEnABBRecursivo(arbol.hijoDer(), elemento);
        }
    }

    // Versión iterativa
    public static boolean esHojaIterativo(ABBTDA arbol, int elemento) {
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == elemento) {
                return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();
            } else if (elemento < arbol.raiz()) {
                arbol = arbol.hijoIzq();
            } else {
                arbol = arbol.hijoDer();
            }
        }

        return false;
    }

    // Versión recursiva
    public static boolean esHojaRecursivo(ABBTDA arbol, int elemento) {
        if (arbol.arbolVacio()) {
            return false;
        } else if (arbol.raiz() == elemento) {
            return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();
        } else if (elemento < arbol.raiz()) {
            return esHojaRecursivo(arbol.hijoIzq(), elemento);
        } else {
            return esHojaRecursivo(arbol.hijoDer(), elemento);
        }
    }

    // Versión iterativa
    public static int calcularProfundidadIterativo(ABBTDA arbol, int elemento) {
        int profundidad = 0;

        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == elemento) {
                return profundidad;
            } else if (elemento < arbol.raiz()) {
                arbol = arbol.hijoIzq();
            } else {
                arbol = arbol.hijoDer();
            }

            profundidad++;
        }

        return -1; // Elemento no encontrado en el árbol
    }

    // Versión recursiva
    public static int calcularProfundidadRecursivo(ABBTDA arbol, int elemento) {
        return calcularProfundidadRecursivoAux(arbol, elemento, 0);
    }

    private static int calcularProfundidadRecursivoAux(ABBTDA arbol, int elemento, int profundidad) {
        if (arbol.arbolVacio()) {
            return -1; // Elemento no encontrado en el árbol
        } else if (arbol.raiz() == elemento) {
            return profundidad;
        } else if (elemento < arbol.raiz()) {
            return calcularProfundidadRecursivoAux(arbol.hijoIzq(), elemento, profundidad + 1);
        } else {
            return calcularProfundidadRecursivoAux(arbol.hijoDer(), elemento, profundidad + 1);
        }
    }

    // Versión iterativa
    public static int obtenerMenorElementoIterativo(ABBTDA arbol) {
        while (!arbol.hijoIzq().arbolVacio()) {
            arbol = arbol.hijoIzq();
        }

        return arbol.raiz();
    }

    // Versión recursiva
    public static int obtenerMenorElementoRecursivo(ABBTDA arbol) {
        if (arbol.hijoIzq().arbolVacio()) {
            return arbol.raiz();
        } else {
            return obtenerMenorElementoRecursivo(arbol.hijoIzq());
        }
    }

    // Versión iterativa
    public static int calcularCantidadElementosIterativo(ABBTDA arbol) {
        int cantidad = 0;

        Stack<ABBTDA> pila = new Stack<>();
        pila.push(arbol);

        while (!pila.isEmpty()) {
            ABBTDA nodo = pila.pop();

            if (!nodo.arbolVacio()) {
                cantidad++;
                pila.push(nodo.hijoDer());
                pila.push(nodo.hijoIzq());
            }
        }

        return cantidad;
    }

    // Versión recursiva
    public static int calcularCantidadElementosRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        } else {
            return 1 + calcularCantidadElementosRecursivo(arbol.hijoIzq()) + calcularCantidadElementosRecursivo(arbol.hijoDer());
        }
    }

    // Versión iterativa
    public static int calcularSumaElementosIterativo(ABBTDA arbol) {
        int suma = 0;

        Stack<ABBTDA> pila = new Stack<>();
        pila.push(arbol);

        while (!pila.isEmpty()) {
            ABBTDA nodo = pila.pop();

            if (!nodo.arbolVacio()) {
                suma += nodo.raiz();
                pila.push(nodo.hijoDer());
                pila.push(nodo.hijoIzq());
            }
        }

        return suma;
    }

    // Versión recursiva
    public static int calcularSumaElementosRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        } else {
            return arbol.raiz() + calcularSumaElementosRecursivo(arbol.hijoIzq()) + calcularSumaElementosRecursivo(arbol.hijoDer());
        }
    }

    // Versión iterativa
    public static int calcularCantidadHojasIterativo(ABBTDA arbol) {
        int cantidad = 0;

        Stack<ABBTDA> pila = new Stack<>();
        pila.push(arbol);

        while (!pila.isEmpty()) {
            ABBTDA nodo = pila.pop();

            if (!nodo.arbolVacio()) {
                if (nodo.hijoIzq().arbolVacio() && nodo.hijoDer().arbolVacio()) {
                    cantidad++;
                } else {
                    pila.push(nodo.hijoDer());
                    pila.push(nodo.hijoIzq());
                }
            }
        }

        return cantidad;
    }

    // Versión recursiva
    public static int calcularCantidadHojasRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        } else if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return 1;
        } else {
            return calcularCantidadHojasRecursivo(arbol.hijoIzq()) + calcularCantidadHojasRecursivo(arbol.hijoDer());
        }
    }

    // Versión iterativa
    public static int calcularAlturaIterativo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }

        int altura = 0;

        Queue<ABBTDA> cola = new LinkedList<>();
        cola.offer(arbol);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();

            for (int i = 0; i < nivelSize; i++) {
                ABBTDA nodo = cola.poll();

                if (!nodo.hijoIzq().arbolVacio()) {
                    cola.offer(nodo.hijoIzq());
                }

                if (!nodo.hijoDer().arbolVacio()) {
                    cola.offer(nodo.hijoDer());
                }
            }

            altura++;
        }

        return altura;
    }

    // Versión recursiva
    public static int calcularAlturaRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        } else {
            int alturaIzq = calcularAlturaRecursivo(arbol.hijoIzq());
            int alturaDer = calcularAlturaRecursivo(arbol.hijoDer());
            return Math.max(alturaIzq, alturaDer) + 1;
        }
    }

    // Versión iterativa
    public static boolean tienenMismaFormaIterativo(ABBTDA arbol1, ABBTDA arbol2) {
        Stack<ABBTDA> pila1 = new Stack<>();
        Stack<ABBTDA> pila2 = new Stack<>();

        pila1.push(arbol1);
        pila2.push(arbol2);

        while (!pila1.isEmpty() && !pila2.isEmpty()) {
            ABBTDA nodo1 = pila1.pop();
            ABBTDA nodo2 = pila2.pop();

            if (nodo1.arbolVacio() && nodo2.arbolVacio()) {
                continue;
            } else if (nodo1.arbolVacio() || nodo2.arbolVacio()) {
                return false;
            }

            pila1.push(nodo1.hijoDer());
            pila1.push(nodo1.hijoIzq());
            pila2.push(nodo2.hijoDer());
            pila2.push(nodo2.hijoIzq());
        }

        return pila1.isEmpty() && pila2.isEmpty();
    }

    // Versión recursiva
    public static boolean tienenMismaFormaRecursivo(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        } else if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        } else {
            return tienenMismaFormaRecursivo(arbol1.hijoIzq(), arbol2.hijoIzq()) && tienenMismaFormaRecursivo(arbol1.hijoDer(), arbol2.hijoDer());
        }
    }

    // Versión iterativa
    public static boolean sonIgualesIterativo(ABBTDA arbol1, ABBTDA arbol2) {
        Stack<ABBTDA> pila1 = new Stack<>();
        Stack<ABBTDA> pila2 = new Stack<>();

        pila1.push(arbol1);
        pila2.push(arbol2);

        while (!pila1.isEmpty() && !pila2.isEmpty()) {
            ABBTDA nodo1 = pila1.pop();
            ABBTDA nodo2 = pila2.pop();

            if (nodo1.arbolVacio() && nodo2.arbolVacio()) {
                continue;
            } else if (nodo1.arbolVacio() || nodo2.arbolVacio() || nodo1.raiz() != nodo2.raiz()) {
                return false;
            }

            pila1.push(nodo1.hijoDer());
            pila1.push(nodo1.hijoIzq());
            pila2.push(nodo2.hijoDer());
            pila2.push(nodo2.hijoIzq());
        }

        return pila1.isEmpty() && pila2.isEmpty();
    }

    // Versión recursiva
    public static boolean sonIgualesRecursivo(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        } else if (arbol1.arbolVacio() || arbol2.arbolVacio() || arbol1.raiz() != arbol2.raiz()) {
            return false;
        } else {
            return sonIgualesRecursivo(arbol1.hijoIzq(), arbol2.hijoIzq()) && sonIgualesRecursivo(arbol1.hijoDer(), arbol2.hijoDer());
        }
    }

    // Versión iterativa
    public static int contarElementosEnNivelIterativo(ABBTDA arbol, int nivel) {
        int cantidad = 0;
        int nivelActual = 0;

        Queue<ABBTDA> cola = new LinkedList<>();
        cola.offer(arbol);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();

            if (nivelActual == nivel) {
                cantidad = nivelSize;
                break;
            }

            for (int i = 0; i < nivelSize; i++) {
                ABBTDA nodo = cola.poll();

                if (!nodo.hijoIzq().arbolVacio()) {
                    cola.offer(nodo.hijoIzq());
                }

                if (!nodo.hijoDer().arbolVacio()) {
                    cola.offer(nodo.hijoDer());
                }
            }

            nivelActual++;
        }

        return cantidad;
    }

    // Versión recursiva
    public static int contarElementosEnNivelRecursivo(ABBTDA arbol, int nivel) {
        return contarElementosEnNivelRecursivoAux(arbol, nivel, 0);
    }

    private static int contarElementosEnNivelRecursivoAux(ABBTDA arbol, int nivel, int nivelActual) {
        if (arbol.arbolVacio()) {
            return 0;
        } else if (nivelActual == nivel) {
            return 1;
        } else {
            return contarElementosEnNivelRecursivoAux(arbol.hijoIzq(), nivel, nivelActual + 1) + contarElementosEnNivelRecursivoAux(arbol.hijoDer(), nivel, nivelActual + 1);
        }
    }

    // In-orden
    public static void imprimirInOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            imprimirInOrden(arbol.hijoIzq());
            System.out.print(arbol.raiz() + " ");
            imprimirInOrden(arbol.hijoDer());
        }
    }

    // Pre-orden
    public static void imprimirPreOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.raiz() + " ");
            imprimirPreOrden(arbol.hijoIzq());
            imprimirPreOrden(arbol.hijoDer());
        }
    }

    // Post-orden
    public static void imprimirPostOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            imprimirPostOrden(arbol.hijoIzq());
            imprimirPostOrden(arbol.hijoDer());
            System.out.print(arbol.raiz() + " ");
        }
    }


    public static ConjuntoTDA obtenerElementosMayoresQueK(ABBTDA arbol, int k) {
        ConjuntoTDA conjunto = new MiConjunto();
        obtenerElementosMayoresQueKAux(arbol, k, conjunto);
        return conjunto;
    }

    private static void obtenerElementosMayoresQueKAux(ABBTDA arbol, int k, ConjuntoTDA conjunto) {
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() > k) {
                conjunto.agregar(arbol.raiz());
            }

            obtenerElementosMayoresQueKAux(arbol.hijoIzq(), k, conjunto);
            obtenerElementosMayoresQueKAux(arbol.hijoDer(), k, conjunto);
        }
    }

    public static int obtenerElementoAnterior(ABBTDA arbol, int v) {
        int elementoAnterior = -1;

        while (!arbol.arbolVacio()) {
            if (arbol.raiz() >= v) {
                arbol = arbol.hijoIzq();
            } else {
                elementoAnterior = arbol.raiz();
                arbol = arbol.hijoDer();
            }
        }

        return elementoAnterior;
    }








}





