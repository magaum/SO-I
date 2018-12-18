

public class Driver {
	public static void main(String[] args) {
		//testa se foram passados argumentos na linha de comando
		if(args.length > 0) {
			//se o número for menor que 0 um erro é exibido
			if(Integer.parseInt(args[0])<0) {
				System.err.println(args[0]+ "precisa ser >= 0");
			}else {
				//instancia objeto sum
				MutableInteger sum = new MutableInteger();
				//converte o argumento 0 em int
				int upper = Integer.parseInt(args[0]);
				//cria uma thread com o constructor com o argumento passado por linha de comando e o objeto criado
				Thread thread = new Thread(new Summation(upper, sum));
				thread.start();
				try {
					thread.join();
					//retorna o valor do arg 0 e da thread que foi iniciada e nela a variavel do arg 0 é incrementada
					System.out.println("A soma de "+upper+" e "+sum.getVaule());
				}catch (Exception a) {
					
				}
			}
		}else
			System.err.println("Utilizacao: Summation <integer value>");
	}

}
