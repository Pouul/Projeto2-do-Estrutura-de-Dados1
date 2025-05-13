// arquivo: src/apl2/DLinkedList.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	private Node head; 
	private Node tail;
 	private int count;
	

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		head = null ;
		tail = null ;
		count = 0;
		
		
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
// Neste método, a gente quer colocar um novo nó no começo da lista. Pra isso a gente
// cria um novo Node, e apontar ele para o head, se a lista estiver vazia (se isEmpty() retornar
// true), significa que o novo nó será o único da lista então ele vira também o tail. Aí atualizamos o
// head para apontar para esse novo nó.Por fim, a gente incrementa o count, porque agora a lista
// tem mais um elemento 

	public void insert(String id, String nome,  int inteiro, int decimal) {
		Node node = new Node(id, nome, inteiro, decimal); // nó aponta pro antigo head
		if (isEmpty()) {
			tail = node; // se a lista estiver vazia head e tail vão ser iguais
		} 
		else {
			head.setPrevious(node); // conecta o head antigo no novo head
		}
		head = node;
		count++;
		
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
// Aqui a gente adiciona um novo nó no final da lista.Primeiro a gente cria o nó, e o next
// dele já é null, porque ele vai ser o último. se a lista estiver vazia, ele vira o head também.Mas
// se já tiver coisa, a gente pega o tail, faz ele apontar pro novo nó com setNext, e o novo nó
// aponta de volta pro antigo tail com setPrevious .Aí a gente atualiza o tail para ser o novo nó, e
// aumenta o count.  

	public void append(/*dados da pessoa*/) {
		
		Node node = new Node(id, nome, nota, null); // novo nó não tem próximo
		if (isEmpty()) {
			head = node; // se a lista tava vazia head vira esse nó
		}
		 else {
			tail.setNext(node); // tail atual aponta pro novo nó
			node.setPrev(tail); // novo nó aponta pro tail antigo
		}
		tail = node; // atualiza o tail
		count++;

		
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
// Aqui a gente quer remover o primeiro nó da lista. Então, a gente começa verificando se
// a lista está vazia se tiver, já retorna null.Se não estiver, a gente guarda o head atual numa
// variável chamada toRemove, porque ele vai ser o nó que vamos retirar.Depois disso, o head é
// atualizado para o próximo nó (head.getNext()).A gente diminui o count em 1, porque
// removemos um elemento.Se depois disso a lista ficou vazia (ou seja, head == null), então o tail
// também precisa ser atualizado para null.Por fim, desconectamos o toRemove da lista (pra
// evitar ponteiros perdidos) e retornamos ele.

	public Node removeHead() {
		if (isEmpty()) {
			return null;
		}
		Node toRemove = head;
		head = head.getNext(); // head agora é o próximo
		if (head != null) {
			head.setPrev(null); // desconecta o anterior
		} else {
			tail = null; // se não tem head, a lista ficou vazia
		}
		toRemove.setNext(null); // limpa a referência
		count--;
		return toRemove;

	}	


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
// Esse método remove o último nó da lista. Primeiro, ele verifica se só tem um nó (ou
// seja, head == tail) se for o caso, ele simplesmente chama o removeHead() porque é o mesmo
// processo. Mas se tiver mais de um nó, ele guarda o tail atual na variável toRemove. Depois, o
// novo tail passa a ser o anterior do toRemove, que a gente obtém com getPrevious().
// Desconectamos o toRemove da lista, atualizando o next do novo tail pra null, e depois
// limpamos os ponteiros do toRemovee no final também diminui o count e retorna o nó removido.

	public Node removeTail() {
		if (isEmpty()) {
			return null;
		}
		if (head == tail) {
			return removeHead(); // se só tem um nó, é igual ao removeHead
		}
		Node toRemove = tail;
		tail = tail.getPrev(); // tail agora é o anterior
		tail.setNext(null); // desconecta o final
		toRemove.setPrev(null);
		count--;
		return toRemove;

		
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
// Nesse método, a ideia é remover um nó específico, procurando ele pelo id.A gente
// começa no head e vai percorrendo a lista com um laço while, até encontrar o nó com o id
// correspondente.Se ele não for encontrado (ou seja, chegamos no fim e o toRemove ficou null),
// retorna null.Se o nó a ser removido for o head, a gente chama removeHead().Se for o tail,
// chama removeTail().Se estiver no meio da lista, a gente pega o previous e o next do nó e faz
// um "encaixe", pulando o toRemove da corrente.Diminui o count, desconecta o toRemove da
// lista, e retorna ele.

	public Node removeNode(String id) {
		Node current = head;
		while (current != null && !current.getId().equals(id)) {
			current = current.getNext();
		}
		if (current == null) {
			return null; // não encontrou
		}
		if (current == head) {
			return removeHead();
		}
		if (current == tail) {
			return removeTail();
		}
		// Se estiver no meio da lista
		current.getPrevious().setNext(current.getNext());
		current.getNext().setPrevious(current.getPrevious());
		current.setNext(null);
		current.setPrevious(null);
		count--;
		return current;
		
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.


	public Node getHead() {
		return head;
		
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.


public Node getTail() {
		return tail;
		
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
// Esse método procura um nó com o id que foi passado.Começa no head e vai
// passando pro next, um por um, até encontrar o id correspondente.Se achar, retorna o nó. Se
// não achar, retorna null

public Node getNode(String id) {
		Node current = head;
		while (current != null) {
			if (current.getId().equals(id)) {
				return current;
			}
 		current = current.getNext();
		}
		return null; // não achou
	}	


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return count;;
		
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
// Verifica se a lista está vazia.Isso acontece quando o head é null.Se for, retorna true;
// caso contrário, retorna false

	public boolean isEmpty() {
		return head == null;
		
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
// Aqui a gente vai limpando a lista, removendo todos os elementos um por
// um.Enquanto a lista não estiver vazia (!isEmpty()), a gente chama removeHead().Quando o
// laço termina, head e tail viram null, e o count é 0.

	public void clear() {
		while (!isEmpty()) {
			removeHead(); // reaproveita o método já feito
		}
		
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista 
// node recebe o valor do Head e enquando o nó não for null será pego o id que inclui ano semestre e o id do aluno 
// nome e nota do aluno guardado com ; e ()  e node receberá o valor do próximo.					

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + count + ") \n");
		
		Node node = head;
		while (node != null) {
			sb.append("(")
			.append(node.getId())
			.append(" ; ")
			.append(node.getNome())
			.append(" ; ")
			.append(node.getNota())
			.append(" ; ")
			.append(") -> \n");
			node = node.getNext();
		}
		sb.append("null.");
		
		return sb.toString();
		
	}

}