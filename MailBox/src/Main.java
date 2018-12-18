public class Main {

	public static void main(String[] args) {
		
		//instanciando objeto
		MessageQueue msg=new MessageQueue();
		//utilizando metodo para encaminhar mensagens 
		msg.send("teste");
		msg.send("teste1");
		msg.send("teste2");
		//saída impressa na tela
		System.out.println(msg.receive());
	}

}
