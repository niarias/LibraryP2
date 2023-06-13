package library.implementaciones.impl;

import apis.ColaTDA;
import impl.Nodo;

public class ColaLD implements ColaTDA {
    Nodo primero;
    Nodo fin;

    public ColaLD() {
    }

    public void inicializarCola() {
        this.primero = null;
        this.fin = null;
    }

    public void acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (this.primero != null) {
            nuevo.sig = null;
            this.fin.sig = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.sig = null;
            this.primero = nuevo;
            this.fin = nuevo;
        }

    }

    public void desacolar() {
        this.primero = this.primero.sig;
        if (this.colaVacia()) {
            this.fin = null;
        }

    }

    public boolean colaVacia() {
        return this.primero == null;
    }

    public int primero() {
        return this.primero.info;
    }
}