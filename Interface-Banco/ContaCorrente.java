import java.math.BigDecimal;

public class ContaCorrente implements ContaBancaria {
    private String cliente;
    private String numeroConta;

    private BigDecimal saldo;

    private BigDecimal limite;



    public String getClienteConta() {
        return cliente;
    }
    public ContaCorrente(String nome, String numConta, BigDecimal limite){
        this.cliente = nome;
        this.numeroConta = numConta;
        this.saldo = BigDecimal.valueOf(0);
        this.limite = limite;

    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Saque Inválido");
        }else{
        BigDecimal saldoTotal = this.saldo.add(this.limite);
        if (valor.compareTo(saldoTotal) <= 0) {
            this.saldo = this.saldo.subtract(valor);
        }else{
            System.out.println("Saldo Insuficiente");
        }
    }
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Depósito Inválido");
        }else{
        this.saldo = this.saldo.add(valor);
            System.out.println("Depósito Realizado com Sucesso");
    }
    }
    public BigDecimal getSaldo() {
        return saldo;
    }

}
