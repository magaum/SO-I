package cocaine;
public class Start {
	public static void main(String[] args) {
		new Runnable() {
			//O Runnable é uma interface que faz com que haja um 'contrato' entre as classes e diga que a classe é executável.
			@Override
			public void run() { //O método run do Runnable esta dizendo que pode executar a classe
				final int bufferSize = 10; //Declarando o tamanho do buffer
				Pilha pilha = new Pilha(); //Criando um objeto pilha do tipo Pilha
				Produtor p = new Produtor(pilha, bufferSize); //instanciando objeto p do tipo produtor
				Consumidor c = new Consumidor(pilha); //instanciando objeto c do tipo consumidor
				p.init(); //utilizando metodo init do objeto p
				c.init(); //utilizando metodo init do objeto c
				while (true) { //cria um loop infinito
					if (pilha.get() == 0) { // -----------> 2
						synchronized (p) {
							System.out.println("************************* Incializa Produção *************************");
							p.notify();
						}
					}
					if (pilha.get() == bufferSize) { // -------------> 3
						synchronized (c) {
							System.out.println("************************* Incializa Consumo *************************");
							c.notify();
						}
					}
				}
			}
		}.run();
	}
}