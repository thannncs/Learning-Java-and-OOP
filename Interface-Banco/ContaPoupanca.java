import java.math.BigDecimal;

public class ContaPoupanca implements ContaBancaria {

    private String cliente;
    private String numeroConta;

    private BigDecimal saldo;

    private int diaRendimento;

    public String getClienteConta() {
        return cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public ContaPoupanca(String nome, String numConta, int diaRendimento){
       this.cliente = nome;
       this.numeroConta = numConta;
       this.saldo = BigDecimal.valueOf(0);
       this.diaRendimento = diaRendimento;
   }
    public void sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Saque Inválido");
        }else{
        if (valor.compareTo(this.saldo) <= 0) {
            this.saldo = this.saldo.subtract(valor);
            System.out.println("Saque Realizado com Sucesso");
        }else{
            System.out.println("Saldo Insuficiente");
        }
        }
    }


    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Depósito Inválido");
        } else {
            this.saldo = this.saldo.add(valor);
            System.out.println("Depósito Realizado com Sucesso");
        }
    }

    public void calculaNovoSaldo(BigDecimal taxaRendimento) {
        this.saldo = this.saldo.multiply(taxaRendimento);
        System.out.println("Operação Realizada Com Sucesso!");

    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
