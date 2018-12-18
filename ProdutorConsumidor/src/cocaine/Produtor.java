package cocaine;
public class Produtor implements Runnable { //� implementada a interface Runnable para que seja criado tarefas nas Threads
	Pilha pilha; //Criando objeto pilha do tipo Pilha
	int bufferSize; //Declarando uma vari�vel que cont�m o tamanho do buffer
	Produtor(Pilha pilha, int bufferSize) { //Cria��o de Construtor que ir� receber pilha e buffersize
		this.pilha = pilha;
		this.bufferSize = bufferSize;
	}
	public void run() {
		while (true) {
			synchronized (this) { //O synchronized faz com que haja sincroniza��o entre as threads
				try { //O try verifica se o programa � execut�vel, caso haja algum erro o pr�ximo comando executado ser� o que 
					//cont�m o catch
					wait();  // -----> 1
				} catch (InterruptedException e) { //Caso o try apresente erro essa linha ser� executada
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