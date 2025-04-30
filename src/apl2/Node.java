// arquivo: src/apl2/Node.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
	
	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.
    private String id;
    private String nome;
    private int inteiro;
    private int decimo;
    private Node next;
    private float nota;
    private String AnoESementre;
    private Node prev;
    private String aux;

//    public Node() {
//        this( -1 , "" , 0 , 0 , null);
//    }

    public Node(Node prev,String AnoESementre,int id, String nome, int inteiro, int decimo, Node next) {

        aux = "23.S1" + String.valueOf(id);

        if(id>000 && id<999){
            this.id = aux;
        }

        this.nome = nome;

        if(inteiro == -1 || decimal == -1){
            this.nota = 99.9F;
        }
        else if (){

        }


        this.next = next;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public int getInteiro() {
//        return inteiro;
//    }
//
//    public void setInteiro(int inteiro) {
//        this.inteiro = inteiro;
//    }
//
//    public int getDecimo() {
//        return decimo;
//    }
//
//    public void setDecimo(int decimo) {
//        this.decimo = decimo;
//    }
//
//    public NodeOriginal getNext() {
//        return next;
//    }
//
//    public void setNext(NodeOriginal next) {
//        this.next = next;
//    }
//
//    @Override
//    public String toString() {
//        return "[dados: (" + id + ";" + nome + ";" + inteiro + ";" + decimo + ") | next: " + next + "]";
//    }

}