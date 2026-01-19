# Ordenação de Lista com Comparator e Expressões Lambda em Java

Este projeto demonstra diferentes formas de ordenar uma lista de objetos em Java utilizando a interface `Comparator`, desde abordagens mais verbosas até as mais modernas com **expressões lambda**.

O objetivo é apresentar, de forma didática, como aplicar regras de ordenação **sem modificar a entidade**, seguindo boas práticas de design.

---

## 🛠 Tecnologias utilizadas

- Java 8+
- Collections Framework
- Interface Funcional `Comparator`
- Expressões Lambda

---

## 🚩 Contexto

Em Java, existem duas formas principais de ordenar objetos:

- **Comparable** → define uma ordem natural dentro da própria classe
- **Comparator** → define regras de ordenação externas à entidade

Neste projeto, foi utilizado o `Comparator`, pois ele oferece maior flexibilidade e evita acoplamento da regra de ordenação à classe `Product`.

---

## 📂 Estrutura do projeto

```text
src/
├── application/
│   └── Program.java
├── entity/
│   └── Product.java
└── service/
    └── ComparatorObj.java
```

## 🧱 Classe Product

A classe Product representa um produto simples, contendo nome e preço.
Ela não implementa `Comparable`, o que permite que diferentes regras de ordenação sejam aplicadas externamente por meio de `Comparator`.


## 🔄 Formas de ordenação apresentadas

### 1️⃣ `Comparator` em classe separada

Utiliza uma classe específica que implementa `Comparator<Product>`.

**Vantagens:**
- Reutilizável
- Ideal para regras mais complexas

```java
prod.sort(new ComparatorObj());
```


### 2️⃣ `Comparator` com classe anônima

Implementação direta da interface Comparator no momento da instanciação.

```java
Comparator<Product> compProd = new Comparator<Product>() {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase()
                 .compareTo(p2.getName().toUpperCase());
    }
};
```

### 3️⃣ `Comparator` com expressão lambda (com chaves)

Uso de expressão lambda para reduzir a verbosidade.

```java
Comparator<Product> compExp1 = (p1, p2) -> {
    return p1.getName().toUpperCase()
             .compareTo(p2.getName().toUpperCase());
};
```

### 4️⃣ Expressão lambda com corpo reduzido

Forma ainda mais concisa, utilizada quando há apenas uma expressão de retorno.

```
Comparator<Product> compExp2 =
    (p1, p2) -> p1.getName().toUpperCase()
                 .compareTo(p2.getName().toUpperCase());

```

### 5️⃣ Expressão lambda diretamente no método `sort`

Forma mais comum no uso profissional moderno.

```java
prod.sort((p1, p2) ->
    p1.getName().toUpperCase()
      .compareTo(p2.getName().toUpperCase())
);
```

## 📌 Resumo

Todas as formas apresentadas possuem o mesmo comportamento e desempenho
A diferença entre elas está apenas na legibilidade e verbosidade
Em projetos modernos, o uso de lambda diretamente no `sort` ou `Comparator.comparing` é o mais recomendado
