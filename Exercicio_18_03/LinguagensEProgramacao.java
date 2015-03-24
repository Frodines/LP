/**
 *
 * @author Frodines
 */

public class LinguagensEProgramacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();
        
        conta1.abrirConta("Lucas", "Martins", "098.316.509-80", ((short) 01), "Corrente");
        conta2.abrirConta("Frodo", "Frodines", "675.097.435-80", ((short) 02), "Universitaria");
        
        /**
         * Operações nas Contas
         */
        conta1.depositar(500);
        conta2.depositar(200);
        conta1.sacar(600);
        conta2.sacar(700);
        
        /**
         * Informções das Contas
         */
        conta1.imprimeInfos();
        System.out.print("\n");
        conta2.imprimeInfos();
        System.out.print("\n");
        conta1.extrato();
        System.out.print("\n");
        conta2.extrato();
        System.out.print("\n");
    }
    
