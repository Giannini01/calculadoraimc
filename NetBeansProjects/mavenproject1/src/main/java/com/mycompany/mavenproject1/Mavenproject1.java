import javax.swing.JOptionPane;

public class Mavenproject1 {
    public static void main(String[] args) {
        try {
            // Solicitação do peso
            String inputPeso = JOptionPane.showInputDialog("Digite seu peso (em kg):");
            double peso = Double.parseDouble(inputPeso);

            // Solicitação da altura
            String inputAltura = JOptionPane.showInputDialog("Digite sua altura (em metros):");
            double altura = Double.parseDouble(inputAltura);

            // Cálculo do IMC
            double imc = peso / (altura * altura);

            // Definindo o status do IMC
            String status;
            if (imc < 18.5) {
                status = "Abaixo do peso";
            } else if (imc >= 18.5 && imc < 25) {
                status = "Peso normal";
            } else if (imc >= 25 && imc < 30) {
                status = "Sobrepeso";
            } else {
                status = "Obesidade";
            }

            // Exibição do resultado
            JOptionPane.showMessageDialog(null, "Seu IMC é: " + String.format("%.2f", imc) + "\nStatus: " + status);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
