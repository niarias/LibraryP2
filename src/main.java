import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import impl.ConjuntoLD;
import impl.DicMultipleL;
import library.diccionarioMultipleHelper;
import library.conjuntoHelper;
public class main {


    public static void main(String[] args){
      DiccionarioMultipleTDA dic = new DicMultipleL();
      dic.inicializarDiccionario();

      dic.agregar(1,1);
      dic.agregar(1,2);

      DiccionarioMultipleTDA dic2 = new DicMultipleL();
      dic2.inicializarDiccionario();

      dic2.agregar(2,1);
      dic2.agregar(2,2);


      DiccionarioMultipleTDA fusion = diccionarioMultipleHelper.fusionarDiccionarios(dic,dic2);




      diccionarioMultipleHelper.printDicMultiple(fusion);




    }
}
