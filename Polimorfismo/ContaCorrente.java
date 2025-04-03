import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {
    private String cliente;
    private String numeroConta;

    private BigDecimal saldo;

    private BigDecimal limite;

   private BigDecimal maxLim;

    public String getClienteConta() {
        return cliente;
    }
    public ContaCorrente(String nome, String numConta, BigDecimal limite){
        this.cliente = nome;
        this.numeroConta = numConta;
        this.saldo = BigDecimal.valueOf(0);
        this.limite = limite;
        this.maxLim = limite;

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
            System.out.println("Saque Realizado com Sucesso");
        }else{
            System.out.println("Saldo Insuficiente");
        }
        if(this.saldo.compareTo(BigDecimal.ZERO)<=0){
            this.limite = this.saldo.add(this.limite);

        }
    }
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Depósito Inválido");
        }else{
        this.saldo = this.saldo.add(valor);
        this.limite = this.limite.add(valor);
            System.out.println("Depósito Realizado com Sucesso");
    }
        if(this.limite.compareTo(maxLim)>0){
            this.limite = this.maxLim;
        }
    }
    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
