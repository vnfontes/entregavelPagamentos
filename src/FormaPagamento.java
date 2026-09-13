public abstract class FormaPagamento {

    protected final double valor;
    protected String status; // "Pendente", "Aprovado" ou "Recusado"

    protected FormaPagamento(double valor) {
        this.valor = valor;
        this.status = "Pendente";
    }

    /**
     * Método "template": todo pagamento passa pela mesma validação antes
     * de ser processado. Por isso é final — cada subclasse não reimplementa
     * pagar(), apenas customiza a parte específica em processarPagamento().
     *
     * Regra de negócio: se o valor for zero ou negativo, o pagamento é
     * recusado imediatamente e uma mensagem é exibida no console.
     */
    public final void pagar() {
        if (valor <= 0) {
            status = "Recusado";
            System.out.println("Pagamento recusado: o valor (" + valor
                    + ") deve ser maior que zero.");
            return;
        }

        boolean aprovado = processarPagamento();
        status = aprovado ? "Aprovado" : "Recusado";
    }

    /**
     * Cada tipo de pagamento implementa sua própria lógica de processamento
     * (ex.: Débito verifica saldo, Crédito verifica limite, Pix aprova na hora).
     *
     * @return true se o pagamento foi aprovado, false caso contrário
     */
    protected abstract boolean processarPagamento();

    /**
     * Cada tipo de pagamento exibe seus próprios detalhes no console,
     * refletindo suas características específicas.
     */
    public abstract void exibirDetalhes();

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }
}
