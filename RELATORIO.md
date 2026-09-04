# Relatório de Desenvolvimento — Biblioteca de E-Commerce

## 1. Desafios encontrados

- Relação entre Logística e Múltiplas Transportadoras: entender que uma Transportadora individual não deveria saber que outras transportadoras existem (cada uma só sabe calcular o próprio frete e verificar se atende determinada região). Minha dificuldade foi compreender que a lógica de consultar todas as transportadoras cadastradas e comparar os resultados deveria estar numa nova classe, Logistica, que seria responsável por manter a lista de transportadoras cadastradas, acionar o cálculo de cada uma e aplicar a lógica de comparação (para escolha do frete).
- Uso de FormaPagamento como um conjunto de constantes: para Cupom optei por uma classe abstrata com subclasses (CupomPercentual e CupomFixo), já que cada modalidade de cupom tem uma fórmula de cálculo própria. Mas para FormaPagamento, decidi usar um conjunto fixo de valores possíveis para aplicar uma abordagem diferente e representar um conjunto fechado de valores.
- Onde validar e aplicar o cupom: outro desafio foi decidir quem deveria ser responsável por buscar e validar um cupom a partir do código informado. A classe RepositorioCupons seria responsável por conhecer todos os cupons cadastrados e por validá-los. Optei por não fazer o Carrinho se relacionar diretamente com RepositorioCupons para manter baixo acoplamento entre as classes (para que um Carrinho saiba apenas que um Cupom foi aplicado a ele, mas não como esse cupom é validado ou buscado).
- Uso do status do pedido no processo de devolução e estorno: foi preciso garantir que a devolução só pudesse ocorrer quando o pedido estivesse com status PAGO. Além disso, o estorno não poderia ser um valor genérico dividido igualmente entre as formas de pagamento, mas sim o valor exato que cada meio recebeu - por esse motivo Pedido mantém uma lista de todos os pagamentos recebidos, essa lista é percorrida no momento do estorno, para garantir que cartão de crédito e pix recebam de volta exatamente o que cobraram. No final do processo o status muda para DEVOLVIDA, fechando o ciclo de venda.
- Definir se o desconto do cupom incidiria sobre os produtos ou sobre o valor total (produto + frete): optei por aplicar o desconto apenas sobre o valor dos produtos, somando o frete integralmente depois, sem desconto.
- Distinguir "solicitação" de "aprovação" da devolução: notei que o enunciado menciona esses dois momentos separadamente, então separei em dois métodos na classe Pedido - solicitarDevolucao(), que apenas valida se o pedido pode ser devolvido, e aprovarDevolucao(), que executa o estorno detalhado por forma de pagamento e muda o status para DEVOLVIDA.

## 2. Prompts utilizados

A lista completa dos prompts utilizados para o desenvolvimento dessa atividade está disponível no arquivo [PROMPTS.md](./PROMPTS.md).

## 3. O que foi possível aprender

Essa atividade permitiu aprender novos conceitos de Orientação a Objetos, além de revisar conceitos que havia aprendido nas aulas de POO. Entre eles:

- Herança e Abstração: aplicadas na classe Cupom, porque cada modalidade (percentual e fixo) tem seu próprio modo de cálculo. Essa também poderia ser uma alternativa para aplicar em FormaPagamento, porém optei por criar uma classe onde as variáveis são só rótulos sem comportamento próprio.
- Interfaces: atuam como um "contrato" que pode ser implementado pelas classes, que devem obrigatoriamente, implementar as funções assinadas na interface.
- Diferença entre entidade e serviço: foi um aprendizado principalmente a partir de uma das perguntas norteadoras do professor, refletir sobre ela me ajudou a compreender que nem toda classe representa "uma coisa do mundo real", algumas existem apenas para auxiliar outras (ex: Logistica, RepositorioCupons).
- Encapsulamento como proteção real: compreender por que Carrinho.getItens() não deveria retornar a lista interna diretamente (mas sim uma cópia).
- Congelamento de dados em transações: ItemPedido foi criado como um registro independente dos dados relevantes de Produto no momento da compra, para garantir que se o preço de um produto mudar no futuro, pedidos já realizados não sejam afetados.
- Comparar minhas próprias decisões com a resolução de referência da atividade: nessa comparação, pude perceber que existem várias formas corretas de resolver o mesmo problema (ex: localização da validação do cupom).
- Formatação de saída com printf: aprendi uma nova sintaxe de formatação do System.out.printf - %-18s para alinhamento de texto à esquerda com largura fixa, %.2f para casas decimais e %n para quebra de linha - usada para exibir as informações sobre o estorno de forma mais legível.