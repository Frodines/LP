/**
 *
 * @author Frodines
 */

public final class ContaCorrente {
    private short numero;
    private double saldo;
    public Cliente titular;
    private String tipoDaConta;
    public double limiteInicial;
    public double limiteAtual;
    
    
    // Método para setar o valor do número da conta
    public void setNumero (short valorNumero){
        if (valorNumero > 0){
            this.numero = valorNumero;
        } else {
            System.out.print("Número da conta deve ser maior que zero\n");
        }
    }
    
    // Método booleano para realizar saques
    public boolean sacar(double valorSaque){
        // Verificar se possui saldo na conta
        if (valorSaque <= saldo){
            this.saldo -= valorSaque;
            return true;
        } else {
            if (valorSaque <= (limiteInicial + saldo)){
                double valorsaldo = this.saldo - valorSaque;
                limiteAtual += valorsaldo;
                this.saldo = 0;
                return true;
            } else {
                System.out.print("Saldo e limite insuficiente na conta\n");
                return false;
            }
        }  
    }
    
    // Método para realizar depósito
    public void depositar(double valorDeposito){
        this.saldo =+ valorDeposito;
    }
    
    // Método para imprimir as informaçoes da conta
    public void imprimeInfos(){
        System.out.print("Nome: " + this.titular.nome + "\n");
        System.out.print("Sobrenome: " + this.titular.sobrenome + "\n");
        System.out.print("CPF: " + this.titular.cpf + "\n");
        System.out.print("Número da Conta: " + numero + "\n");
        System.out.print("Tipo: " + this.tipoDaConta + "\n");
        System.out.print("Limite: " + this.limiteInicial + "\n");
    }
    
    // Método para imprimir saldo
    public void extrato(){
        System.out.print("Número da Conta: " + this.numero + "\n");
        System.out.print("Saldo atual: " + this.saldo + "\n");
        System.out.print("Limite atual: " + this.limiteAtual + "\n");
        System.out.print("Saldo com limite: " + (this.limiteAtual + this.saldo) + "\n");
    }
    
    // Método para transferir entre contas
    public void transfereValor(ContaCorrente contaDestino, double valorTransf){
        if (this.sacar(valorTransf) == true){
            contaDestino.saldo = contaDestino.saldo + valorTransf;
        } 
    }
    
    // Método para limitar saldo de acordo com o tipo de conta
    public void tipoConta(){
        if(tipoDaConta.equals("Corrente")){
            this.limiteInicial = 1000;
        }
        if(tipoDaConta.equals("Universitaria")){
            this.limiteInicial = 600;
        }
        if(tipoDaConta.equals("Poupança")){
            this.limiteInicial = 300;
        }
    }
    
    /**
     * Método para abrir nova conta
     * @param nomeConta
     * @param sobrenomeConta
     * @param cpfConta
     * @param numeroConta
     * @param tipo
     */
    public void abrirConta(String nomeConta, String sobrenomeConta, String cpfConta, short numeroConta, String tipo){
        Cliente titularConta = new Cliente();
        this.titular = titularConta;
        this.titular.nome = nomeConta;
        this.titular.sobrenome = sobrenomeConta;
        this.titular.cpf = cpfConta;
        this.setNumero(numeroConta);
        this.tipoDaConta = tipo;
        this.tipoConta();
        limiteAtual = limiteInicial;
    }
