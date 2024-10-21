package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraimcTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.calculadoraimc.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraimcTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCCalculator(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IMCCalculator(modifier: Modifier = Modifier) {
    var altura by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

     Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)  // Define o fundo branco
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter  // Centraliza no topo
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),  // Espaçamento para posicionar mais para cima
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)  // Espaçamento entre os itens
        ) {
            Text(
                text = "Calculadora de IMC",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo de entrada para altura
            BasicTextField(
                value = altura,
                onValueChange = { altura = it },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        if (altura.isEmpty()) {
                            Text("Digite sua altura (m)", fontSize = 16.sp)
                        }
                        innerTextField()
                    }
                }
            )

            // Campo de entrada para peso
            BasicTextField(
                value = peso,
                onValueChange = { peso = it },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        if (peso.isEmpty()) {
                            Text("Digite seu peso (kg)", fontSize = 16.sp)
                        }
                        innerTextField()
                    }
                }
            )

            // Botão para calcular IMC
            Button(
                onClick = {
                    val imc = calcularIMC(altura, peso)
                    resultado = when {
                        imc < 18.5 -> "Seu IMC é $imc: Abaixo do peso"
                        imc in 18.5..24.9 -> "Seu IMC é $imc: Peso normal"
                        imc in 25.0..29.9 -> "Seu IMC é $imc: Sobrepeso"
                        else -> "Seu IMC é $imc: Obesidade"
                    }
                },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Calcular IMC", fontSize = 16.sp)
            }

            // Exibição do resultado
            Text(
                text = resultado,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Exibição da imagem centralizada
            Image(
                painter = painterResource(id = R.drawable.foto1),
                contentDescription = "Tabela de IMC",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 16.dp)
            )
        }
     }
}

// Função para calcular o IMC
fun calcularIMC(altura: String, peso: String): Double {
    val alturaDouble = altura.toDoubleOrNull() ?: return 0.0
    val pesoDouble = peso.toDoubleOrNull() ?: return 0.0
    return pesoDouble / (alturaDouble * alturaDouble)
}

@Preview(showBackground = true)
@Composable
fun IMCCalculatorPreview() {
    CalculadoraimcTheme {
        IMCCalculator()
    }
}


