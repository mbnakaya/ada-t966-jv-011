# CRUD Pedidos (e-commerce)

## Pedido
O pedido deve conter os seguintes atributos:

* Id
* Cliente
* Quantidade de Produtos
* Localidade (IF)
* Valor Total

## Regras

* Para pedidos para fora de SP, o valor do frete de R$ 15,00 deve ser aplicado no valor total do pedido.
* Para pedidos de SP e com o valor total acima de R$ 100,00, não será cobrado frete.
* Para pedidos com o valor total acima de R$ 500,00, deve ser aplicado um desconto de 15% sobre o preço final.