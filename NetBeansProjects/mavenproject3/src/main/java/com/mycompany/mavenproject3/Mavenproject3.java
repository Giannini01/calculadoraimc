/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;
import javax.swing.JOptionPane;
/**
 *
 * @author LeonardoGiannini
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        String firstNumber;//caixa para inserir o n1
        String secondnumber;//caixa para inserir a n2
        int number1;//numero inserido na ciaxa 1
        int number2;//numero inserido na ciaxa 2
        int soma;// resultado 
        firstNumber=JOptionPane.showInputDialog("insira o primeiro número","numero1");
        secondnumber=JOptionPane.showInputDialog("insira o segundo número","numero2");
        number1=Integer.parseInt(firstNumber);//converte ciaxa 1 inteiro
        number2=Integer.parseInt(secondnumber);//converte ciaxa 2 inteiro
        //soma
        soma=number1+number2;
        //resultado
        JOptionPane.showMessageDialog(null,"A soma é: "+soma,"Resultado",
        JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
