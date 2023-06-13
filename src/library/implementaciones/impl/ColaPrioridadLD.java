//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package impl;

import apis.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
    NodoPrioridad primero;

    public ColaPrioridadLD() {
    }

    public void inicializarCola() {
        this.primero = null;
    }

    public void acolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.prioridad = prioridad;
        nuevo.info = x;
        if (!this.colaVacia() && prioridad <= this.primero.prioridad) {
            NodoPrioridad aux;
            for(aux = this.primero; aux.sig != null && aux.sig.prioridad >= prioridad; aux = aux.sig) {
            }

            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        } else {
            nuevo.sig = this.primero;
            this.primero = nuevo;
        }

    }

    public void desacolar() {
        this.primero = this.primero.sig;
    }

    public boolean colaVacia() {
        return this.primero == null;
    }

    public int primero() {
        return this.primero.info;
    }

    public int prioridad() {
        return this.primero.prioridad;
    }

    private class NodoPrioridad {
        int info;
        int prioridad;
        NodoPrioridad sig;

        private NodoPrioridad() {
        }
    }
}
