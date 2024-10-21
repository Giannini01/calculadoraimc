import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir o peso em quilogramas
        System.out.print("Digite o peso em quilogramas: ");
        double peso = scanner.nextDouble();
        
        // Pedir a altura em metros
        System.out.print("Digite a altura em metros: ");
        double altura = scanner.nextDouble();
        
        // Calcular o IMC
        double imc = calcularIMC(peso, altura);
        
        // Exibir o IMC
        System.out.printf("O IMC é: %.2f\n", imc);
        
        // Classificar como "gordinho" ou "magrinho"
        if (imc >= 30) {
            System.out.println("Você é considerado(a) 'gordinho'.");
        } else {
            System.out.println("Você é considerado(a) 'magrinho'.");
        }
        
        scanner.close();
    }
    
    // Método para calcular o IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
}


