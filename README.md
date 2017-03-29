# AMARO Android challenge
O objetivo do desafio é construir um app de catálogo para alguns dos *best-sellers* da história da [AMARO](https://amaro.com/).

## Algumas regras
* O app não pode ser estático. Ela deve possuir alguma inteligência para exibir todos os produtos dinamicamente baseados no JSON.
* Todos os produtos do arquivo [products.json](https://github.com/amarofashion/mobile-ios-challenge/blob/master/products.json) devem ser exibidos no catálogo.
* Se você estiver com dúvidas, busque por referências no Google, ou pergunte para amigos. Mas não peça para eles resolverem o desafio para você.

## Requisitos
* Para cada item de produto, as seguintes informações devem estar presentes no catálogo:
 * Imagem.
 * Nome.
 * Preço.
 * Status de promoção.
 * Preço promocional (se houver).
 * Tamanhos disponíveis.
* Deve ser possível adicionar produtos ao carrinho do usuário.
* Deve ser possível verificar quantos e quais produtos do carrinho.
* Utilizar [Java-Android](https://developer.android.com/about/versions/nougat/android-7.0.html) como linguagem principal.
* Deve utilizar os guidelines de [material desgin](https://getmdl.io/components/index.html) para os desenhos das distintas areas.
* Deve Utilizar o [Android-Expresso](https://google.github.io/android-testing-support-library/docs/espresso/) para UITest e [JUnit](https://developer.android.com/studio/test/index.html) para testes unitarios.

## Diferenciais
* Foi moleza? Então permita que os usuários interajam com o carrinho removendo produtos e alterando a quantidade de itens.
* Ah! Não se esqueça de mostrar o valor total do carrinho.
* Achou o teste até aqui fácil? Que tal adicionar um filtro para mostrar só os produtos em promoção (`on_sale`)?
* Alguns produtos não tem sua grade completa (todos os tamanhos disponíveis). Mostre somente os tamanhos em estoque.
* Todos gostamos de código limpo e testável, certo? Então esse é um grande diferencial.

## Critérios de avaliação
* O código será avaliado considerando: semântica, estruturação, legibilidade, implementação, entre outros fatores.
* O histórico do *git* também será avaliado.
* Estamos buscando um desenvolvedor Android que saiba utilizar as guidelines, padrões da google e ao mesmo tempo, possua um conhecimento solido em Java-Android, por isso aproveite a oportunidade para nos mostrar que você tem conhecimento nessas áreas.
