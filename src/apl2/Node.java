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
    private Node next;
    private float nota;
    private Node prev;
    private String Saux;
    private boolean isnot10;


    public Node() throws Exception {
        this(null, -1 , "" , 0 , 0 , null);
    }

    public Node(Node prev,int id, String nome, int inteiro, int decimal, Node next) throws Exception {
        isnot10 = true;

        //variavel auxiliar para juntar o cabeçario e o id
        Saux = "25.S1-" + String.valueOf(id);

        // filtrando id
        if(id>0 && id<999){
            this.id = Saux;
        }
        else{
            throw new Exception("id inválido" + id);
        }

        this.nome = nome;
        // quando inteiro ´ou decimal for -1(falta) coloca 99.9 na nota
        if(inteiro == -1 || decimal == -1){
            this.nota = 99.9F;
        }
        // quando é 10.0
        else if (inteiro == 10 && decimal == 0){
            Saux = String.valueOf(inteiro) + String.valueOf(decimal);
            nota = (float)Integer.parseInt(Saux)/10;
            isnot10 = false;
        }
        // quando é 0 á 9.9, porque é filtrado por obção acima
        else if (inteiro >= 0 && inteiro <= 10 && decimal >= 0 && decimal <= 9 && isnot10){
            Saux = String.valueOf(inteiro) + String.valueOf(decimal);
            nota = (float)Integer.parseInt(Saux)/10;
        }
        else{
            throw new Exception("dado forá do intervalo dado:" + inteiro + "." + decimal);
        }

        this.prev = prev;
        this.next = next;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        Saux = "25.S1-" + String.valueOf(id);
        if(id>0 && id<999){
            this.id = Saux;
        }
        else{
            throw new Exception("id inválido" + id);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[dados: (" + id + ";" + nome + ";" + nota + ") | next: " + next + "]" + "| prev: " + prev + "]";
    }

}