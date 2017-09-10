import socket
HOST = '10.0.2.15' # Endereco IP do Servidor
PORT = 8433 # Porta do Servidor
tcp = socket.socket(socket.AF_INET,
socket.SOCK_STREAM)
dest = (HOST, PORT)
tcp.connect(dest)
print ('Para sair use CTRL+X\n')
msg = input()
while (msg != '\x18'):
	tcp.send (msg.encode())
	msg = input()
tcp.close()
