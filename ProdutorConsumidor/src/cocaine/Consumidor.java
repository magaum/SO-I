package cocaine;
public class Consumidor implements Runnable { //Implementado Runnable
	Pilha pilha; 
	public Consumidor(Pilha pilha) { //Criado um objeto Consumidor que recebe o valor de pilha
		this.pilha = pilha;
	}
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait();  // ---------------- 1
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while (pilha.get() != 0) {
					System.out.println("Consumindo -> " + pilha.get());
					pilha.put(pilha.get() - 1);
				}
			}
		}
	}
	public void init() {
		new Thread(this, "Consumidor").start();
	}
}