
package com.samuel.estruturadedados._BuscaBinaria_BuscaSequencial;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BuscaSequencial_BuscaBinaria {
    
    private int N = 9;
    private String[] A = new String[] {"Ucránia", "Turquia", "Suiça", "México", "França", "Espanha", "Chile", "Brasil", "Argentina"};
    private String[] B = new String[] {"Argentina", "Brasil", "Chile", "Dinamarca", "Espanha", "França", "Inglaterra", "Turquia", "Uruguai"};
    private String[] C = new String[] {"Canada", "Austria", "Chile", "Italia", "Portugal", "Grecia", "Angola", "Moçambique", "Rússia"};
    private String[] D = new String[N];
    
    
    public static void main(String[] args) {
        
        BuscaSequencial_BuscaBinaria principal = new BuscaSequencial_BuscaBinaria(); 
    }
    
    public BuscaSequencial_BuscaBinaria(){
        pesquisa();         
    }
    
    public void pesquisa(){
           int opcao;
           String[] lista = new String[] {"A", "B", "C"};
           
           opcao = JOptionPane.showOptionDialog(null, "Escolha a Lista que deseja consultar: ", "Listas: ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, lista, 0);
       
            switch(opcao){
                case 0:
                    mostraListaOriginal(A);
                    tiposBuscas(A);
                    break;
                  
                case 1:
                    mostraListaOriginal(B);
                    tiposBuscas(B);
                    break;
                    
                case 2:
                    mostraListaOriginal(C);
                    tiposBuscas(C);
                    break;
            }  
    }
    
    public void tiposBuscas(String[] vetNovo){
        String[] busca = new String[] {"Busca Sequêncial", "Busca Binária Crescente", "Busca Binária Decrescente"};
        String pais = "";
        int opcao;
        D = vetNovo;
        
        opcao = JOptionPane.showOptionDialog(null, "Escolha o tipo de Busca: ", "Tipos de Buscas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, busca, 0);
        pais = JOptionPane.showInputDialog(null, "Digite o País para a busca: ");
        switch(opcao){
            case 0:
                mostraListaOriginal(D);
                buscaSequencial(D, pais);
                break;
                
            case 1:
                mostraListaCrescente(D);
                buscaBinariaEmListaCrescente(D, pais);
                break;
                
            case 2:
                mostraListaDecrescente(D);
                buscaBinariaEmListaDecrescente(D, pais);
                break;
        }
       
    }
        
    public int buscaSequencial(String[] vet, String buscado){
        for (int i = 0; i < vet.length; i++) {
            if (vet[i].toUpperCase().equals(buscado.toUpperCase())){
                JOptionPane.showMessageDialog(null, "País Buscado: " + vet[i].toString() + " -- " + "Índice: " + i);
                return i;
            }  
        }
        JOptionPane.showMessageDialog(null, "País não encontrado na busca sequencial! ");
        return -1;
    }
    
    public int buscaBinariaEmListaCrescente(String[] vet, String buscado){
        listaOrdenadaCrescente(vet);
        int inf = 0;
        int sup = N - 1;
        int meio = 0;
        
        while(inf <= sup){
            meio = (inf + sup) / 2;
            if (buscado.toUpperCase().equals(vet[meio].toUpperCase())) {
                JOptionPane.showMessageDialog(null, "País Buscado: " + vet[meio].toString() + " -- " + "Índice: " + meio);
                return meio;                                
            }
            else if (buscado.toUpperCase().compareTo(vet[meio].toUpperCase()) < 0) {
                sup = meio - 1;
            }
            else{
                inf = meio + 1;
            }
        }
        JOptionPane.showMessageDialog(null, "País não encontrado na busca binária Crescente! ", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
    
    public int buscaBinariaEmListaDecrescente(String[] vet, String buscado){
        listaOrdenadaDecrescente(vet);
        int inf = 0;
        int sup = N - 1;
        int meio = 0;
        
        while(inf <= sup){
            meio = (inf + sup) / 2;
            if (buscado.toUpperCase().equals(vet[meio].toUpperCase().toString())) {
                JOptionPane.showMessageDialog(null, "País Buscado: " + vet[meio].toString() + " -- " + "Índice: " + meio);
                return meio;                                
            }
            else if (buscado.toUpperCase().compareTo(vet[meio].toUpperCase().toString()) > 0) {
                sup = meio - 1;
            }
            else{
                inf = meio + 1;
            }
        }
        JOptionPane.showMessageDialog(null, "País não encontrado na busca binária Decrescente! ", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        return -1;
        
    }
    
    public void listaOrdenadaCrescente(String[] vet){
        String aux;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if(vet[j].toString().compareTo(vet[j + 1].toString()) > 0){
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }  
            } 
        }
        
    }
    
    public void listaOrdenadaDecrescente(String[]vet){
        String aux;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if(vet[j].toString().compareTo(vet[j + 1].toString()) < 0){
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }  
            } 
        }        
    }
    
    public void mostraListaOriginal(String[] vetor){
        String lista = "";
        for (int i = 0; i < N; i++) {
            lista += vetor[i].toString() + "\n";
        }
        JTextArea outputArea = new JTextArea(10,35);  //15 linhas e 40 colunas
        outputArea.setText(lista);
        JScrollPane rolagem = new JScrollPane(outputArea);
        JOptionPane.showMessageDialog(null,rolagem," Lista Original do Vetor:! ", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
     public void mostraListaCrescente(String[] vetor){
         listaOrdenadaCrescente(vetor);
         
         String lista = "";
         for (int i = 0; i < N; i++) {
             lista += vetor[i].toString() + "\n";
         }
         JTextArea outputArea = new JTextArea(10,35);  //15 linhas e 40 colunas
         outputArea.setText(lista);
         JScrollPane rolagem = new JScrollPane(outputArea);
         JOptionPane.showMessageDialog(null,rolagem," Lista Ordem Crescente do Vetor:! ", JOptionPane.INFORMATION_MESSAGE);
    }
     
     public void mostraListaDecrescente(String[] vetor){
         listaOrdenadaDecrescente(vetor);
         
         String lista = "";
         for (int i = 0; i < N; i++) {
             lista += vetor[i].toString() + "\n";
         }
         JTextArea outputArea = new JTextArea(10,35);  //15 linhas e 40 colunas
         outputArea.setText(lista);
         JScrollPane rolagem = new JScrollPane(outputArea);
         JOptionPane.showMessageDialog(null,rolagem," Lista Ordem Crescente do Vetor:! ", JOptionPane.INFORMATION_MESSAGE);
    }
}

