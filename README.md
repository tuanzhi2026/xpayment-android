# xpayment-android

#### 使用方法

> /settings.gradle.kts
```gradle
dependencyResolutionManagement {
  ...
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    ...
    mavenCentral()
    maven { url = uri("https://jitpack.io") } // 新增 jitpack
  }
}
```

> ./app/build.gradle.kts
```gradle
dependencies {
  ...
  implementation("com.github.tuanzhi2026:xpayment-android:69a40271fe") // 新增 xpayment
}
```

> ./app/src/main/java/com/paiopener/com/MainActivity.kt
```kotlin
/// 示例代码
package com.example.paiopener

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.paiopener.ui.theme.PaiOpenerTheme
import com.xpayment.app.pay // 支付方法
import com.xpayment.app.Type // 支付类型

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PaiOpenerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val context = this
          Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
          ) {
            Button(
              onClick = {
                val opened = pay( // 拉起支付
                  context,
                  type = Type.Pai, // or Type.Lanton
                  orderId = "2019245607165292545",
                  symbol = "USDT",
                  amount = "20.6",
                  to = "example",
                  appReturnUrl = "https://api.example.com/order/2019245607165292545",
                )

                if (!opened) {
                  Toast.makeText(context, "应用尚未安装", Toast.LENGTH_SHORT).show()
                }
              }
            ) {
              Text(
                text = "To Pay",
              )
            }
          }
        }
      }
    }
  }
}
```
