import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Scanner scan = new Scanner(System.in)) {
            while(true) {
                String menu = "Escolha o tipo de figura:\n"+
                        "1- Quadrado\n"+
                        "2- Retângulo\n"+
                        "3- Triângulo\n"+
                        "4- Círculo";
                System.out.println(menu);
                Figura figura = null;
                int opt = scan.nextInt();
                switch (opt){
                    case 1: figura = criarQuadrado(scan);
                    break;
                    case 2: figura = criarRetangulo(scan);
                    break;
                    case 3: figura = criarTriangulo(scan);
                    break;
                    case 4: figura = criarCirculo(scan);
                    break;
                }
                exibirArea(figura);
            }
        }catch (InputMismatchException e){
            System.out.println("O valor digitado é inválido");
        }
    }

    public static Figura criarQuadrado(Scanner scan){
        System.out.println("Digite o valor do lado do quadrado: ");
        double value = scan.nextDouble();
        return new Quadrado(value);
    }

    public static Figura criarRetangulo(Scanner scan){
        System.out.println("Digite o valor da base do Retângulo: ");
        double base = scan.nextDouble();
        System.out.println("Digite o valor da altura do Retângulo: ");
        double altura = scan.nextDouble();
        return new Retangulo(base,altura);
    }

    public static Figura criarTriangulo(Scanner scan){
        System.out.println("Digite o valor da base do Triângulo");
        double base = scan.nextDouble();
        System.out.println("Digite o valor da altura do Triângulo: ");
        double altura = scan.nextDouble();
        return new Triangulo(base,altura);
    }

    public static Figura criarCirculo(Scanner scan){
        System.out.println("Digite o valor do raio do Círculo");
        double raio = scan.nextDouble();
        return new Circulo(raio);
    }

    public static void exibirArea(Figura figura){
        String out = String.format("A área da figura é de %.3f",figura.calcularArea());
        System.out.println(out);
    }

}
