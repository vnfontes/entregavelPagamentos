public class Pix extends FormaPagamento {

    private final String chavePix;

    public Pix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    protected boolean processarPagamento() {
        System.out.println("Transferindo R$" + valor + " via Pix para a chave " + chavePix + "...");
        System.out.println("Pix aprovado instantaneamente.");
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[PIX] Chave: " + chavePix
                + " | Valor: R$" + valor
                + " | Status: " + status);
    }
}
