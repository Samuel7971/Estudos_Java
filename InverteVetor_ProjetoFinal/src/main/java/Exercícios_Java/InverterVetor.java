package Exercícios_Java;


/*
   * Samuel Rodrigues de Souza -  RGM: 22977996
   * Exercício Aula 03 - Inverter Vetor.
*/
public class InverterVetor {

    public static void main(String[] args) {
         
        double vetor[] = {5.5, 7.2, 2.4, 1.9, 0.1, 6.1, 4.3};
        int qtda_elementos = 7;
        System.out.println("Vetor Original: ");  
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);    
        }
        //Chamada do método;
        inverte(vetor, qtda_elementos);   
    }
     
    //Método para efetuar a inversão do vetor;
    static void inverte(double vet[], int n){
   
        double aux;
        int inf = 0;
        int sup = n;
        int meio;
        
        if ((inf + sup) % 2 != 0) {
            meio = (inf + sup) / 2 + 1;
                
            while ((inf <= meio - 1) && (sup >= meio))
            {
                aux = vet[inf];
                vet[inf] = vet[sup - 1];
                vet[sup - 1] = aux;
                inf++;
                sup--;
            }   
        }
        else{
            meio = (inf + sup) / 2;
            while ((inf <= meio) && (sup >= meio + 1))
            {
                aux = vet[inf];
                vet[inf] = vet[sup - 1];
                vet[sup - 1] = aux;
                inf++;
                sup--;
            }
        }
        
        System.out.println("Vetor Invertido: ");
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    } 
}
