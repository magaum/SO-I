
import java.util.Vector;

public class MessageQueue implements Channel {
	//cria um vetor
	private Vector queue;
	//Constructor da classe
	public MessageQueue() {
		queue = new Vector();
	}
	//metodo para enviar mensagens
	public void send(Object item) {
		queue.addElement(item);
	}
	//metodo para remover mensagens utilizando FIFO (first in first out)
	public Object receive() {
		if (queue.size() == 0)
			return null;
		else
			return queue.remove(0);
	}
	
}
