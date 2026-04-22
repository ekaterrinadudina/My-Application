package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.myapplication.ui.theme.MyApplicationTheme




data class Framework(
    val name: String,
    val approach: String,
    val language: String,
    val description: String
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    FrameworkListScreen()
                }
            }
        }
    }
}


@Composable
fun FrameworkListScreen() {
    val frameworks = listOf(
        Framework(
            "Flutter", "Кроссплатформенный",
            "Dart",
            "Единый UI-подход, высокая скорость создания интерфейсов, единая кодовая база для нескольких платформ.Но доступ к спецификациям требует нативных модулей."
        ),
        Framework(
            "React Native",
            "Кроссплатформенный",
            "Java Script",
            "Высокая скорость разработки (если знать веб), набор готовых компонентов. Но для сложных задач требуются нативные модули."
        ),
        Framework(
            "Kotlin Multiplatform",
            "Кроссплатформенный",
            "Kotlin",
            "Язык Kotlin, на каждой платформе можно создать нативный интерфейс, используется если важнее всего бизнес-логика."
        ),
        Framework(
            "Android SDK + Jetpack + Compose",
            "Нативный (только Android)",
            "Kotlin",
            "Используется если нужна глубокая интеграция с Android, современный стек от Google."
        )

    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(frameworks) { framework ->
            Card(
                modifier = Modifier.fillMaxWidth()
                ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = framework.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = "Тип: ${framework.approach}")
                    Text(text = "Язык: ${framework.language}")
                    Text(text = framework.description)
                }
            }
        }
    }
}
