import socket
HOST = '10.0.2.15' # Endereco IP do Servidor
PORT = 8433 # Porta do Servidor
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
orig = (HOST, PORT)
tcp.bind(orig)
tcp.listen(1)
while True:
	con, cliente = tcp.accept()
	print ('Concetado por', cliente)
	while True:
		msg = con.recv(1024)
		if not msg: break
		print (cliente, msg)
		print ('Finalizando conexao do cliente', cliente)
	con.close()
