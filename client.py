#importando biblioteca socket
import socket
HOST = '10.0.2.15' # Endereco IP do Servidor
PORT = 8433 # Porta do Servidor
udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) #udp é o protocolo de comunicação (protocolo assincrono)
dest = (HOST, PORT) #host de destino
print ('Para sair use CTRL+X\n') #imprime na tela a mensagem entre ''
msg = input() #aguarda o input do usuário
while (msg != '\x18'):#repete até o input do usuário ser ctrl+x
	udp.sendto (msg.encode(), dest)#envia mensagem para o host de destino
	msg = input()#aguarda o input do usuário
udp.close()#fecha a conexão
