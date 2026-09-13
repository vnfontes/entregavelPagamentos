public class Credito extends FormaPagamento {

    private final int parcelas;
    private double limiteDisponivel;

    public Credito(double valor, int parcelas, double limiteDisponivel) {
        super(valor);
        this.parcelas = parcelas;
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    protected boolean processarPagamento() {
        if (valor > limiteDisponivel) {
            System.out.println("Limite insuficiente: limite de R$" + limiteDisponivel
                    + " é menor que o valor da compra (R$" + valor + ").");
            return false;
        }
        limiteDisponivel -= valor;
        double valorParcela = valor / parcelas;
        System.out.println("Crédito aprovado em " + parcelas + "x de R$" + valorParcela);
        return true;
    }

    @Override
    public void exibirDetalhes() {
        double valorParcela = valor / parcelas;
        System.out.println("[CRÉDITO] Valor total: R$" + valor
                + " | Parcelas: " + parcelas + "x de R$" + valorParcela
                + " | Limite disponível: R$" + limiteDisponivel
                + " | Status: " + status);
    }
}
