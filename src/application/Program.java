package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entity.Product;
import service.ComparatorObj;

public class Program {

    public static void main(String[] args) {

        List<Product> prod = new ArrayList<>();

        prod.add(new Product("TV", 1200.0));
        prod.add(new Product("Smartphone", 1000.0));
        prod.add(new Product("Notebook", 1500.0));
        prod.add(new Product("Tablet", 400.0));

        /*
         * Collections.sort() realiza a ordenação da lista.
         * Para utilizá-lo sem fornecer um Comparator, a classe Product
         * precisa implementar a interface Comparable<Product>.
         *
         * Quando não queremos alterar a entidade ou precisamos de
         * múltiplas regras de ordenação, utilizamos Comparator.
         */
        // Collections.sort(prod);

        /*
         * Comparator é uma interface funcional (possui apenas um método
         * abstrato: compare).
         * Ele permite definir regras de ordenação externas à entidade,
         * oferecendo maior flexibilidade.
         */

        // --------------------------------------------------------------------
        // Formas de utilizar o Comparator
        // --------------------------------------------------------------------

        /*
         * 1ª forma: implementação do Comparator em uma classe separada.
         * Indicada quando a regra de ordenação é reutilizável ou
         * possui lógica mais complexa.
         */
        prod.sort(new ComparatorObj());

        /*
         * 2ª forma: implementação usando classe anônima.
         * Cria-se uma implementação de Comparator no momento da
         * instanciação, sem a necessidade de uma classe nomeada.
         */
        Comparator<Product> compProd = new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase()
                         .compareTo(p2.getName().toUpperCase());
            }
        };

        prod.sort(compProd);

        /*
         * 3ª forma: implementação usando expressão lambda.
         * Reduz a verbosidade ao utilizar uma interface funcional.
         */
        Comparator<Product> compExp1 = (p1, p2) -> {
            return p1.getName().toUpperCase()
                     .compareTo(p2.getName().toUpperCase());
        };

        prod.sort(compExp1);

        /*
         * 4ª forma: expressão lambda com corpo reduzido.
         * Pode ser utilizada quando há apenas uma expressão de retorno.
         */
        Comparator<Product> compExp2 =
                (p1, p2) -> p1.getName().toUpperCase()
                             .compareTo(p2.getName().toUpperCase());

        prod.sort(compExp2);

        /*
         * 5ª forma: expressão lambda passada diretamente como argumento.
         * O compilador realiza a inferência de tipos com base
         * no contexto do método sort.
         *
         * Essa abordagem possui o mesmo comportamento e desempenho
         * das formas anteriores, apenas com menor verbosidade.
         */
        prod.sort((p1, p2) ->
                p1.getName().toUpperCase()
                  .compareTo(p2.getName().toUpperCase())
        );

        for (Product p : prod) {
            System.out.println(p);
        }
    }
}
