# 💳 Sistema de Formas de Pagamento (Java)

Projeto em Java que simula diferentes formas de pagamento (**Pix**, **Débito** e **Crédito**) usando os pilares da Programação Orientada a Objetos: **herança**, **polimorfismo**, **abstração** e **encapsulamento**.

## O que o projeto demonstra

- **Classe abstrata** `FormaPagamento`, com os dados e o fluxo comuns a todo pagamento.
- **Template Method:** o método `pagar()` é `final` e define o fluxo padrão. Primeiro valida se o valor é maior que zero. Depois delega o processamento específico para `processarPagamento()`, que cada subclasse implementa.
- **Polimorfismo:** todas as formas de pagamento podem ser tratadas como `FormaPagamento`, e cada uma se comporta à sua maneira.
- **Encapsulamento:** atributos `protected`/`private`, com `final` onde o valor não deve mudar.
- **Controle de status:** cada pagamento passa de `Pendente` para `Aprovado` ou `Recusado`.

## Estrutura

```
src/
├── FormaPagamento.java   # classe abstrata (fluxo comum e regras gerais)
├── Pix.java              # aprovação instantânea
├── Debito.java           # verifica o saldo da conta
├── Credito.java          # verifica o limite e calcula as parcelas
└── Main.java
```

## Regras de negócio

| Forma    | Regra                                                                 |
|----------|-----------------------------------------------------------------------|
| Todas    | Valor igual ou menor que zero → pagamento **recusado**                |
| Pix      | Aprovado na hora, informando a chave Pix                              |
| Débito   | Aprovado se o valor for menor ou igual ao saldo; o saldo é debitado   |
| Crédito  | Aprovado se o valor couber no limite; mostra o valor de cada parcela  |

## Exemplo de uso

```java
FormaPagamento[] pagamentos = {
    new Pix(150.0, "vinicius@email.com"),
    new Debito(200.0, 120.0),
    new Credito(600.0, 3, 1000.0),
    new Pix(0, "vinicius@email.com")
};

for (FormaPagamento p : pagamentos) {
    p.pagar();
    p.exibirDetalhes();
    System.out.println();
}
```

Saída:

```
Transferindo R$150.0 via Pix para a chave vinicius@email.com...
Pix aprovado instantaneamente.
[PIX] Chave: vinicius@email.com | Valor: R$150.0 | Status: Aprovado

Saldo insuficiente: saldo de R$120.0 é menor que o valor da compra (R$200.0).
[DÉBITO] Valor: R$200.0 | Saldo atual da conta: R$120.0 | Status: Recusado

Crédito aprovado em 3x de R$200.0
[CRÉDITO] Valor total: R$600.0 | Parcelas: 3x de R$200.0 | Limite disponível: R$400.0 | Status: Aprovado

Pagamento recusado: o valor (0.0) deve ser maior que zero.
[PIX] Chave: vinicius@email.com | Valor: R$0.0 | Status: Recusado
```

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/vnfontes/entregavelPagamentos.git
   ```
2. Abra o projeto no IntelliJ IDEA (ou outra IDE Java) e use o JDK 21 ou superior.
3. Cole o exemplo acima no `Main.java` e execute.

## Tecnologias

- Java
- IntelliJ IDEA

## Autor

**Vinícius Fontes** · [GitHub](https://github.com/vnfontes) · [LinkedIn](https://www.linkedin.com/in/vnfontes/)
