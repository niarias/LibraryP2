//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package impl;

import apis.ABBTDA;

public class ABB implements ABBTDA {
    NodoABB nodo;

    public ABB() {
    }

    public int raiz() {
        return this.nodo.info;
    }

    public ABBTDA hijoIzq() {
        return this.nodo.HijoIzq;
    }

    public ABBTDA hijoDer() {
        return this.nodo.HijoDer;
    }

    public boolean arbolVacio() {
        return this.nodo == null;
    }

    public void inicializarArbol() {
        this.nodo = null;
    }

    public void agregarElem(int x) {
        if (this.nodo == null) {
            this.nodo = new NodoABB();
            this.nodo.info = x;
            this.nodo.HijoIzq = new ABB();
            this.nodo.HijoIzq.inicializarArbol();
            this.nodo.HijoDer = new ABB();
            this.nodo.HijoDer.inicializarArbol();
        } else if (this.nodo.info > x) {
            this.nodo.HijoIzq.agregarElem(x);
        } else if (this.nodo.info < x) {
            this.nodo.HijoDer.agregarElem(x);
        }

    }

    public void eliminarElem(int x) {
        if (this.nodo != null) {
            if (this.nodo.info == x) {
                if (this.nodo.HijoIzq.arbolVacio() && this.nodo.HijoDer.arbolVacio()) {
                    this.nodo = null;
                } else if (!this.nodo.HijoIzq.arbolVacio()) {
                    this.nodo.info = this.mayor(this.nodo.HijoIzq);
                    this.nodo.HijoIzq.eliminarElem(this.nodo.info);
                } else {
                    this.nodo.info = this.menor(this.nodo.HijoDer);
                    this.nodo.HijoDer.eliminarElem(this.nodo.info);
                }
            } else if (this.nodo.info < x) {
                this.nodo.HijoDer.eliminarElem(x);
            } else {
                this.nodo.HijoIzq.eliminarElem(x);
            }
        }

    }

    private int mayor(ABBTDA a) {
        return a.hijoDer().arbolVacio() ? a.raiz() : this.mayor(a.hijoDer());
    }

    private int menor(ABBTDA a) {
        int retorno;
        if (a.hijoIzq().arbolVacio()) {
            retorno = a.raiz();
        } else {
            retorno = this.menor(a.hijoIzq());
        }

        return retorno;
    }
}
