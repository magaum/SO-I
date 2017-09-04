#importando biblioteca Sisitema operacional
import os
#cria processo filho em sistemas POSIX
proc = os.fork()
#verifica qual processo é filho e qual é pai, respectivamente
if(proc == 0):
    print("Processo filho")
#retorna o PID do processo atual/retorna PID do processo Pai
    print("PID do processo filho %d" %(os.getpid()))
    print("Processo filho executa o 'ls' para listar os arquivos do diretório atual")
#atribui um comando ao processo filho
    os.execl("/bin/ls","")
#O processo filho encerra, o processo pai voltará a fila de prontos para aguardar sua vez de executar
    exit()
else:
    print("Programa foi direcionado para o processo pai primeiro")
    print("PID do processo pai %d" %os.getpid())
    print("O programa será direcionado ao processo filho por causa do comando wait")
#espera o processo filho finalizar
    os.wait()
    print("Se o comando wait não tivesse sido declarado o processo pai seria encerrado,\ne após isso o filho seria executado")
    print("O comando wait faz o processo pai ir para a fila de bloqueados, e espera o filho encerrar para volta a executar")
    exit()
