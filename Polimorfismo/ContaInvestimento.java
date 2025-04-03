import java.math.BigDecimal;

public class ContaInvestimento extends Tributavel{

 private String cliente;
 private String numeroConta;

 private BigDecimal saldo;



    public String getNumeroConta() {
        return numeroConta;
    }

    public String getClienteConta() {
        return cliente;
    }



    public ContaInvestimento(String nome, String numConta){
        this.cliente = nome;
        this.numeroConta = numConta;
        this.saldo = BigDecimal.valueOf(0);
    }
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Saque Inválido");
        } else {
            if (valor.compareTo(this.saldo) <= 0) {
                this.saldo = this.saldo.subtract(valor);
                System.out.println("Saque Realizado com Sucesso");
            } else {
                System.out.println("Saldo Insuficiente");
            }
        }
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Deposito Inválido");
        }else {
            this.saldo = this.saldo.add(valor);
            System.out.println("Depósito Realizado com Sucesso");
        }
    }

    public void calcularNovoSaldo(BigDecimal taxaRendimento){
     this.saldo = this.saldo.multiply(taxaRendimento);
    }

    public BigDecimal calcularTaxaAdministracao(BigDecimal taxaRendimento){
        BigDecimal rendimento =this.saldo.multiply(taxaRendimento);
        System.out.println("Operação Realizada Com Sucesso!");
        return rendimento.multiply(BigDecimal.valueOf(0.01));
    }
    public BigDecimal calcularTributo(BigDecimal taxaRendimento) {
        BigDecimal rendimento =this.saldo.multiply(taxaRendimento);
        System.out.println("Operação Realizada Com Sucesso!");
        return rendimento.multiply(BigDecimal.valueOf(0.05));

    }

    public BigDecimal getSaldo() {
        return saldo;
    }


}
