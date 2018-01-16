# AMARO Android Challenge
In this exercise, the proposed challenge is to create a catalogue app that displays [AMARO](https://amaro.com/)'s all-time *best-sellers*.

## A few guidelines
* The app must read product data from this mocked [products resource API](http://www.mocky.io/v2/59b6a65a0f0000e90471257d).
* All products from the resource must be displayed.
* To initiate the test, just fork this repository, and once you're done, please use the words *DONE!* in your last commit.
* You may use any third-party libraries as you see fit.
* Use Java as the main programming language.
* In case you need any help, feel free to search for reference materials on Google or ask your friends, but do not ask them to work on the challenge for you, which is obvisously unethical behavior.

## Basic requirements
1. Display a vertical scrollable list of products with the following data:
    - Image
    - Name
    - Price 
2. Each product on the list must be clickable. 
3. Upon a click event on any displayed product, a product detail window is to be presented with following data:
    - Image
    - Name
    - Price
    - Promotion status (on sale or not)
    - Promotional price (if available)
    - Available sizes

## Additional requirements
* Some products lack a complete size grid (sizes are out of stock). Display only the sizes that are in stock.
* Add a filter to display only products that are on sale (on_sale).
* Add a sorting feature that allows the list to be sorted by price (lowest first)
* Be creative and perfectionist with the layout.
* Don't forget to follow Google's [material design](https://getmdl.io/components/index.html) guidelines.
 
## Bonus point
* Is all very easy so far? We all enjoy clean, comprehensible and testable code, don't we? This is a major plus, so refactor your code if necessary and add unit tests where possible.

## Examination criteria
* The code will be examined according to following main criterias: semantics, structure and legibility.
* Organization and comments of the *git* commit history will be considered.
* We're looking for an experienced Java developer who knows how to use Google's guidelines and is able to write clean and working software, so take this chance to show us what you're made of.

-------------------------------

# Desafio Android AMARO
O objetivo deste desafio é construir um app de catálogo para alguns dos *best-sellers* da história da [AMARO](https://amaro.com/).

## Algumas regras
* O app deve consumir o serviço [products service](http://www.mocky.io/v2/59b6a65a0f0000e90471257d) como uma API Rest.
* Todos os produtos carregados do serviço devem ser exibidos no catálogo.
* Para iniciar o teste faça o fork do repositório, e para finalizar nomeie o último commit com  *DONE!*.
* É permitido utilizar quaisquer bibliotecas que você esteja familiarizado.
* Utilize Java como linguagem principal.
* Se você estiver com dúvidas, busque por referências no Google, ou pergunte para amigos.
Mas não peça para eles resolverem o desafio para você.

## Requisitos básicos
1. Exibir uma lista de produtos em forma de catálogo vertical com as seguintes informações:
    - Imagem
    - Nome
    - Preço 
2. Cada produto do catálogo deve ser clicável. 
3. Quando o produto for clicado, o usuário deve ser direcionado para uma área, onde serão exibidos os detalhes do produto, com as seguintes informações:
    - Imagem
    - Nome
    - Preço
    - Status de promoção
    - Preço promocional (se houver)
    - Tamanhos disponíveis

## Requisitos adicionais
* Alguns produtos não tem sua grade completa (todos os tamanhos disponíveis). Mostre somente os tamanhos em estoque.
* Adicione um filtro para mostrar só os produtos em promoção (`on_sale`).
* Adicione uma funcionalidade de ordenção que permite ordenar a list por preço (menor para maior).
* Seja criativo e perfeccionista com o layout.
* Utilize os guidelines de [material design](https://getmdl.io/components/index.html).
 
## Ponto extra
* Achou o desafio até aqui fácil? Todos gostamos de código limpo, facilmente compreensível e testável, certo? Então esse é um grande diferencial. Refatore seu código se necessário, e adicione testes unitários onde possível.

## Critérios de avaliação
* O código será avaliado considerando: semântica, estruturação e legibilidade.
* O histórico do *git* também será avaliado.
* Estamos buscando um desenvolvedor Android que saiba utilizar as guidelines, padrões da Google e ao mesmo tempo, possua um conhecimento sólido em Java-Android. Por isso, aproveite a oportunidade para nos mostrar que você tem conhecimento nessas áreas.
