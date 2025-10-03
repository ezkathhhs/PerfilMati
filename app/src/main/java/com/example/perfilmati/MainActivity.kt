package com.example.perfilmati

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perfilmati.ui.theme.PerfilMatiTheme
import org.w3c.dom.Text
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilMatiTheme {
                PantallaPerfil()
            }
        }
    }
}

@Composable
fun PantallaPerfil(){
    var nombre by remember{ mutableStateOf ("Mati") }
    var correo by remember{ mutableStateOf("mat.loyolac@duoc.cl")}
    var bio by remember { mutableStateOf("soy mati y me gusta el jugar jueguitos uwu") }
    var ciudad by remember { mutableStateOf("Puerto Montt") }
    var guardado by remember { mutableStateOf(false) }

    LaunchedEffect(guardado) {
        if (guardado) {
            kotlinx.coroutines.delay(3000)
            guardado = false
        }
    }

    fun clearForm() {
        nombre = ""
        correo = ""
        bio = ""
        ciudad = ""
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFCCECC5)
    ) {
        Column (
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.gatoalien),
                contentDescription = "Foto",
                modifier = Modifier.size(120.dp).clip(CircleShape).background(Color.Magenta)

            )
            Spacer(modifier = Modifier.height(16.dp))

            Text("Mi perfil", fontSize = 24.sp, color = Color(0xFF7988E3))

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = {nombre= it},
                label = {Text("Nombre")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = correo,
                onValueChange = {correo = it},
                label = {Text("Correo")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = ciudad,
                onValueChange = {ciudad = it},
                label = {Text("Ciudad")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = bio,
                onValueChange = {bio=it},
                label = {Text("Biografia")},
                modifier = Modifier.fillMaxWidth().height(100.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {guardado = true},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.Black
                )
            ) {
                Text("Guardar cambios del perfil")
            }

            Button(
                onClick = { clearForm() },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF706D6D),
                    contentColor = Color.White
                )
            ) {
                Text("Limpiar formulario")
            }

            if(guardado){
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "guardado",
                    color = Color(0xFF673434),
                    fontSize = 16.sp


                )
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PerfilMatiTheme {
        PantallaPerfil()
    }
}