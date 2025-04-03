import java.math.BigDecimal;

public abstract class  ContaBancaria {

    public abstract void sacar(BigDecimal valor);

    public abstract void depositar(BigDecimal valor);

    public abstract String getNumeroConta();

    public abstract String getClienteConta();

    public abstract BigDecimal getSaldo();
}
