package library;
import apis.DiccionarioMultipleTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import impl.ConjuntoLD;
import impl.DicMultipleL;
import library.conjuntoHelper;
public class diccionarioMultipleHelper {
    public static DiccionarioMultipleTDA transpasarValores(DiccionarioMultipleTDA dict_viejo,DiccionarioMultipleTDA dict_nuevo){
        ConjuntoTDA clavesD1 = dict_viejo.claves();
        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);
            ConjuntoTDA valores = dict_viejo.recuperar(clave);

            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                dict_nuevo.agregar(clave, valor);
                valores.sacar(valor);
            }
        }

        return dict_nuevo;
    }
    public static DiccionarioMultipleTDA fusionarDiccionarios(DiccionarioMultipleTDA diccionario1, DiccionarioMultipleTDA diccionario2) {
        DiccionarioMultipleTDA diccionarioFusionado = new DicMultipleL();
        diccionarioFusionado.inicializarDiccionario();

        diccionarioFusionado = transpasarValores(diccionario1,diccionarioFusionado);

        diccionarioFusionado = transpasarValores(diccionario2,diccionarioFusionado);

        return diccionarioFusionado;
    }

    public static DiccionarioMultipleTDA generarDiccionarioSinonimos(DiccionarioSimpleTDA diccionarioSimple) {
        DiccionarioMultipleTDA diccionarioSinonimos = new DicMultipleL();

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
                ConjuntoTDA sinonimos = new ConjuntoLD();
                sinonimos.agregar(clave);
                diccionarioSinonimos = agregarClaveValor(diccionarioSinonimos,valor, sinonimos);
            }
        }

        return diccionarioSinonimos;
    }

    public static DiccionarioMultipleTDA agregarClaveValor(DiccionarioMultipleTDA dic,int clave,ConjuntoTDA valores){
        while (!valores.conjuntoVacio()){
            int valor = valores.elegir();
            dic.agregar(clave,valor);
            valores.sacar(valor);
        }
        return dic;
    }

    public static void printDicMultiple(DiccionarioMultipleTDA dic){
        ConjuntoTDA conj = dic.claves();
        while (!conj.conjuntoVacio()){
            int clave = conj.elegir();
            System.out.println("Clave: "+clave);
            conjuntoHelper.printConjunto(dic.recuperar(clave));
            conj.sacar(clave);
        }
    }


}
