package library;
import apis.DiccionarioMultipleTDA;
import apis.ConjuntoTDA;

public class diccionarioMultipleHelper {
    public static DiccionarioMultipleTDA fusionarDiccionarios(DiccionarioMultipleTDA diccionario1, DiccionarioMultipleTDA diccionario2) {
        DiccionarioMultipleTDA diccionarioFusionado = new MiDiccionarioMultiple();

        // Agregar las claves y valores de D1 al diccionario fusionado
        ConjuntoTDA clavesD1 = diccionario1.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);
            ConjuntoTDA valores = diccionario1.recuperar(clave);
            diccionarioFusionado.agregar(clave, valores);
        }

        // Agregar las claves y valores de D2 al diccionario fusionado
        ConjuntoTDA clavesD2 = diccionario2.claves();
        while (!clavesD2.conjuntoVacio()) {
            int clave = clavesD2.elegir();
            clavesD2.sacar(clave);
            ConjuntoTDA valores = diccionario2.recuperar(clave);
            diccionarioFusionado.agregar(clave, valores);
        }

        return diccionarioFusionado;
    }

    public static DiccionarioMultipleTDA generarDiccionarioSinonimos(DiccionarioSimpleTDA diccionarioSimple) {
        DiccionarioMultipleTDA diccionarioSinonimos = new MiDiccionarioMultiple();

        // Recorrer todas las claves y valores del diccionario simple
        ConjuntoTDA claves = diccionarioSimple.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            int valor = diccionarioSimple.recuperar(clave);

            // Verificar si el valor ya existe como clave en el diccionario de sinónimos
            if (diccionarioSinonimos.claves().pertenece(valor)) {
                ConjuntoTDA sinonimos = diccionarioSinonimos.recuperar(valor);
                sinonimos.agregar(clave);
            } else {
                ConjuntoTDA sinonimos = new MiConjunto();
                sinonimos.agregar(clave);
                diccionarioSinonimos.agregar(valor, sinonimos);
            }
        }

        return diccionarioSinonimos;
    }


}
