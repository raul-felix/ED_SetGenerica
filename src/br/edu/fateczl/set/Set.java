package br.edu.fateczl.set;

public class Set<T> {
	
	Node<T> primeiro = null;
	
	public boolean listaVazia() {
		if (primeiro == null) {
			return true;
		}
		return false;
	}
	
	public int size() {
		int cont = 0;
		
		if (!listaVazia()) {
			Node<T> auxiliar = primeiro;
			
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	public Node<T> getNode(int pos) throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		Node<T> auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			cont++;
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}
	
	public void addFirst(T valor) throws Exception {
		if (contains(valor)) {
			return;
		}
		
		Node<T> elemento = new Node<T>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(T valor) throws Exception {
		if (contains(valor)) {
			return;
		}
		
		if (listaVazia()) {
			addFirst(valor);
		} else {
			int tamanho = size();
			Node<T> elemento = new Node<T>();
			elemento.dado = valor;
			elemento.proximo = null;
			Node<T> ultimo = getNode(tamanho - 1);
			ultimo.proximo = elemento;
		}
	}
	
	public void add(T valor, int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		if (contains(valor)) {
			return;
		}
		
		if (pos == 0) {
			addFirst(valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
			Node<T> elemento = new Node<T>();
			elemento.dado = valor;
			Node<T> anterior = getNode(pos - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}
	
	public void removeFirst() throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}
	
	public void removeLast() throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			Node<T> penultimo = getNode(tamanho - 2);
			penultimo.proximo = null;
		}
	}
	
	public void remove(int pos) throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho - 1) {
			removeLast();
		} else {
			Node<T> anterior = getNode(pos - 1);
			Node<T> atual = getNode(pos);
			anterior.proximo = atual.proximo;
		}
	}
	
	public T get(int pos) throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		Node<T> auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			cont++;
			auxiliar = auxiliar.proximo;
		}
		return auxiliar.dado;
	}
	
	public void clean() throws Exception {
		if (listaVazia()) {
			throw new Exception("Lista Vazia");
		}
		
		primeiro = null;
	}
	
	public boolean contains(T valor) throws Exception {
		if (listaVazia()) {
			return false;
		}
		
		Node<T> auxiliar = primeiro;
		while (auxiliar != null) {
			if (auxiliar.dado == valor) {
				return true;
			}
			auxiliar = auxiliar.proximo;
		}
		return false;
	}
}
