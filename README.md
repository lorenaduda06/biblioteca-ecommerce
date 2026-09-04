# Biblioteca-E-Commerce

Sistema de regras de negócio reutilizável, desenvolvido como atividade prática de revisão de Orientação a Objetos, na disciplina de Arquitetura de Software (UTFPR - Cornélio Procópio).

A biblioteca **não tem interface gráfica nem banco de dados** - é composta apenas por classes Java que representam os cálculos, ciclos de compra e regras operacionais de um e-commerce, projetada para ser facilmente integrada a outras aplicações.

## Funcionalidades
- **Produtos e Carrinho**: cadastro de produtos e gerenciamento de itens (adicionar, remover e alterar) em um carrinho de compras.
- **Logística**: cálculo de frete simulado por múltiplas transportadoras, com base na região de destino e peso/volume total do carrinho, além de seleção automática da opção mais rápida, com menores custos ou dentro de um prazo limite.
- **Cupons de desconto**: cadastro central de cupons percentuais ou fixos, contendo validação por código e data de validade.
- **Pedidos e modalidades de pagamento**: consolidação de um pedido (itens + cupom + frete) com suporte a múltiplas formas de pagamento e alteração de status conforme o andamento do pedido.
- **Devoluções e estornos**: solicitação e aprovação de devolução de um pedido pago, com estorno do valor exato cobrado de acordo com a forma de pagamento.

## Execução

A demonstração das funcionalidades da biblioteca está concentrada na classe
`TesteRotinas`, localizada em `src/main/java`.

A classe contém as três rotinas solicitadas na atividade:

1. criação dos produtos, transportadoras e cupom, cálculo e seleção do frete e criação do pedido;
2. pagamento de 60% via cartão de crédito e 40% via Pix;
3. solicitação e aprovação da devolução, com estorno dos valores de cada forma de pagamento.

Para executar, basta abrir o projeto em uma IDE compatível com Java/Maven e executar
a classe `TesteRotinas`.

## Documentação
- [RELATORIO.md](./RELATORIO.md) - desafios encontrados e aprendizados durante o desenvolvimento.
- [PROMPTS.md](./PROMPTS.md) - lista de prompts utilizados para auxiliar a resolução da atividade.