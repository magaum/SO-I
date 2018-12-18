class Summation implements Runnable, java.lang.Runnable { //Interfaces necessarias para o funcionamento 
	//declara um inteiro com visibilidade privada
	private int upper;
	//criando referencia na memoria 
	private MutableInteger sumValue;
	//constructor da classe
	public Summation(int upper, MutableInteger sumValue) {
		this.upper = upper;
		this.sumValue = sumValue;
	}
	//metodo run, utilizado na thread
	public void run() {
		int sum = 0;
		for (int i = 0; i <= upper; i++) {
			sum += 1;
		}
		sumValue.setValue(sum);
	}
}
