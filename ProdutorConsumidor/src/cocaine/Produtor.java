package cocaine;
public class Produtor implements Runnable { //É implementada a interface Runnable para que seja criado tarefas nas Threads
	Pilha pilha; //Criando objeto pilha do tipo Pilha
	int bufferSize; //Declarando uma variável que contém o tamanho do buffer
	Produtor(Pilha pilha, int bufferSize) { //Criação de Construtor que irá receber pilha e buffersize
		this.pilha = pilha;
		this.bufferSize = bufferSize;
	}
	public void run() {
		while (true) {
			synchronized (this) { //O synchronized faz com que haja sincronização entre as threads
				try { //O try verifica se o programa é executável, caso haja algum erro o próximo comando executado será o que 
					//contém o catch
					wait();  // -----> 1
				} catch (InterruptedException e) { //Caso o try apresente erro essa linha será executada
					e.printStackTrace();
				}
				while (pilha.get() >= 0 && pilha.get() <= (bufferSize-1)) {
					pilha.put(pilha.get() + 1);
					System.out.println("Produzindo -> " + pilha.get());
				}
			}
		}
	}
	public void init() {
		new Thread(this, "Produtor").start();
	}
}