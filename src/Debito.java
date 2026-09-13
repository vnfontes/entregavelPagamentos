public class Debito extends FormaPagamento {

    private double saldoConta;

    public Debito(double valor, double saldoConta) {
        super(valor);
        this.saldoConta = saldoConta;
    }

    @Override
    protected boolean processarPagamento() {
        if (valor > saldoConta) {
            System.out.println("Saldo insuficiente: saldo de R$" + saldoConta
                    + " é menor que o valor da compra (R$" + valor + ").");
            return false;
        }
        saldoConta -= valor;
        System.out.println("Débito aprovado. Saldo restante: R$" + saldoConta);
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[DÉBITO] Valor: R$" + valor
                + " | Saldo atual da conta: R$" + saldoConta
                + " | Status: " + status);
    }
}
