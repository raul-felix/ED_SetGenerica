package br.edu.fateczl.set;

public class Node<T> {
	
	T dado;
	Node<T> proximo;
	
	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public Node<T> getProximo() {
		return proximo;
	}

	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "Node [" + dado + "]";
	}

}
