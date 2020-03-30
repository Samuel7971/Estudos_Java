package com.samuel.estruturadedados.trabalhadoresempresa;
import javax.swing.*;

public class TrabalhadoresEmpresa {
    //Armazenaremos os dados dos trabalhadores da empresa em um vetor:
    private Trabalhador trab[];
    private int N;
    
public static void main(String[] args) {
    TrabalhadoresEmpresa principal = new TrabalhadoresEmpresa();  
}

public TrabalhadoresEmpresa () {
	simulacaoLeituraDeDados() ;
	mostraTrabalhadoresCadastrados(); 
        ordenarNome(trab, 0, N);
        mostraTrabalhadoresNomeOrdenados();
        ordenarSalario(trab, 0, N);
        mostraTrabalhadoresSalariosOrdenados();
        
}

public void simulacaoLeituraDeDados() {
    //para efetuar testes rápidos, criamos um vetor de objetos com dados fixos:
    N = 7;
    trab = new Trabalhador[N];
    trab[0] = new Trabalhador("Julio",  2000f, 'M');
    trab[1] = new Trabalhador("Mariana",  1000, 'F');
    trab[2] = new Trabalhador("Renata",  800, 'F');
    trab[3] = new Trabalhador("Pedro",  1500f, 'M');
    trab[4] = new Trabalhador("Amilton",  6000f, 'M');
    trab[5] = new Trabalhador("Jorge",  2200f, 'M');
    trab[6] = new Trabalhador("Carlos",  3500f, 'M');
    
}

public void leituraDeDados () {
    String umNome; float umSalario;  char umSexo;
    N = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de trabalhadores:"));
    trab = new Trabalhador[N];   //aloca memória para o vetor

    for (int i = 0; i < N; i++){
	      umNome = JOptionPane.showInputDialog( "Digite o nome do trabalhador " + (i+1) + ": ");
	      umSalario = Float.parseFloat(JOptionPane.showInputDialog( "Digite o salário de " + umNome + ": "));
	      umSexo = JOptionPane.showInputDialog( "Digite o sexo deste trabalhador: ").charAt(0);
	      umSexo = Character.toUpperCase(umSexo);
    	  trab[i] = new Trabalhador(umNome, umSalario, umSexo); //aloca memória para o objeto (e executa o método construtor com parâmetros)
    	  // a inicialização anterior do objeto poderia ser em etapas:
    	  //	trab[i] = new Trabalhador();  //usando o construtor sem parâmetros
    	  //	trab[i].setNome(umNome);
    	  //	trab[i].setSalario(umSalario);
    	  //	trab[i].setSexo(umSexo);
    }
}

public void mostraTrabalhadoresCadastrados () {
    String cad = "";
    for (int i=0; i<N; i++) {
      cad +=  trab[i].toString()+ "\n";
    }    
    JTextArea outputArea = new JTextArea(15,40);  //15 linhas e 40 colunas
    outputArea.setText(cad);
    JScrollPane rolagem = new JScrollPane(outputArea);
    JOptionPane.showMessageDialog(null,rolagem,"Dados dos trabalhadores cadastrados", JOptionPane.INFORMATION_MESSAGE);
}

public void mostraTrabalhadoresNomeOrdenados() { //Método para mostrar Nomes Ordenados;
    String cad = "";
    for (int i=0; i<N; i++) {
      cad +=  trab[i].toString()+ "\n";
    }    
    JTextArea outputArea = new JTextArea(10,40);  
    outputArea.setText(cad);
    JScrollPane rolagem = new JScrollPane(outputArea);
    JOptionPane.showMessageDialog(null,rolagem,"Nome dos trabalhadores Ordenados", JOptionPane.INFORMATION_MESSAGE);
}

public void mostraTrabalhadoresSalariosOrdenados() { //Método para mostrar salários Ordenados;
    String cad = "";
    for (int i=0; i<N; i++) {
      cad +=  trab[i].toString()+ "\n";
    }    
    JTextArea outputArea = new JTextArea(10,40);  
    outputArea.setText(cad);
    JScrollPane rolagem = new JScrollPane(outputArea);
    JOptionPane.showMessageDialog(null,rolagem,"Salário dos trabalhadores Ordenados", JOptionPane.INFORMATION_MESSAGE);
}

public void ordenarSalario(Object[] t, int inicio, int fim){ // Método para Ordenar Salário;
    Object aux = trab;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - 1 - i; j++) {
            if (trab[j].getSalario() < trab[j + 1].getSalario()) {
                aux = t[j];
                t[j] = t[j + 1];
                t[j + 1] = aux;
            }  
        }
    }
}

public void ordenarNome(Object[] t, int inicio, int fim){ //Método para Ordenar Nomes;
    Object aux = trab;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - 1 - i; j++) {
            if (trab[j].toString().compareTo(trab[j + 1].toString()) > 0) {
                aux = t[j];
                t[j] = t[j + 1];
                t[j + 1] = aux;
            } 
        }
    }
}

 public boolean quickSort (double[] vetor, int inicio, int fim) {
        //  Este método ordena um vetor de elementos de tipo double.
        //  Crie dois métodos para ordenar o vetor de objetos Trabalhador trab[]
        //  1) pelo atributo salário, 2) pelo atributo nome. 
        if (vetor == null) return false;   
        if (inicio < fim) {
           int posicaoPivo = separar (vetor, inicio, fim);
           quickSort(vetor, inicio, posicaoPivo - 1);
           quickSort(vetor, posicaoPivo + 1, fim);
        }        
        return true;
    }
 
 private int separar (double[] vetor, int inicio, int fim) {
      double pivo = vetor[inicio];
      int i = inicio + 1, f = fim;
      while (i <= f) {
         if (vetor[i] <= pivo) i++;
         else if (pivo > vetor[f]) f--;
         else {
                double troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
         }
      }
      vetor[inicio] = vetor[f];
      vetor[f] = pivo;
      return f;
   }
}
