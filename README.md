<h1 align="center">
Curve RecycerView Of Items Playgrounds by Compose.
</h1>
<p align="center">
<img src="https://www.sixt.tech/assets/jetpack-compose/jetpack-compose.png" width="300" height="200 alt="AndroidLibray"/>
</p>

[![](https://jitpack.io/v/DoaaMosalam/playground_compose.svg)](https://jitpack.io/#DoaaMosalam/playground_compose)
![Message](https://img.shields.io/static/v1?label=Android&message=Library&color=green)

the "playground_compose" library empowers Android developers to create rich, interactive, and visually stunning user interfaces for their applications using Jetpack Compose. Its modular design, customization options, and robust feature set make it an essential tool for building modern Android apps with engaging user experiences ❤️.
- First Library: Curve RecyclerVire Of Items
1. **Dynamic UI Components**: The library provides a wide range of dynamic UI components that can be easily integrated into Android apps. These components include but are not limited to:
   - Animated content transitions
   - Gesture detection for drag and drop interactions
   - Flexible layout options for organizing content
   - Integration with Jetpack Compose's animation capabilities for creating smooth transitions and effects

2. **Customization Options**: Developers can customize the appearance and behavior of UI components to suit their application's branding and design requirements. This includes options to adjust colors, fonts, animations, and other visual elements.

3. **Reusable State Management**: The library offers utilities for managing and preserving the state of UI components across different screens and user interactions. This ensures a consistent and seamless user experience, even when navigating between different parts of the app.

4. **Easy Integration**: Integrating the library into Android projects is straightforward, thanks to its modular and well-documented architecture. Developers can quickly add the desired components to their apps and customize them as needed.

5. **Scalability and Performance**: The library is designed to scale seamlessly with the complexity and size of Android applications. It employs best practices for performance optimization to ensure smooth rendering and responsiveness, even on low-end devices.

6. **Community Support and Maintenance**: The library is actively maintained and supported by a vibrant community of developers. Regular updates and contributions ensure that it stays up-to-date with the latest developments in Android app development and Jetpack Compose.

In summary, the "playground_compose" library empowers Android developers to create rich, interactive, and visually stunning user interfaces for their applications using Jetpack Compose. Its modular design, customization options, and robust feature set make it an essential tool for building modern Android apps with engaging user experiences. 

## Preview
<div align="center">
	

https://github.com/DoaaMosalam/playground_compose/assets/40686512/7fbf9741-7665-4540-9ba1-c73e52146726


Screen 1          |  screen 2    
:-------------------------:|:-------------------------:
<img src="https://github.com/DoaaMosalam/playground_compose/assets/40686512/3dc208db-34b9-4f4a-bafe-bbaa339130ff" width="400" height="400" /> | <img src="https://github.com/DoaaMosalam/playground_compose/assets/40686512/be9c7aa6-db64-49cf-840a-154e43f42039" width="600" height="400" /> 
	
<br/>
</div>

# Installation

## Step 1: Add jitpack in your `settings.gradle`(project)
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri ("https://jitpack.io") }
    }
}
```
## Step 2: Add the dependency in your `build.gradle`(app)

```groovy
dependencies {
    ...
        implementation ("com.github.DoaaMosalam:playground_compose:1.0.0")
	}
}
```

# Getting Started
## Prepare your data: you can call the mathematical operation you want.
```Kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Multi_playground_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ClothesStorePrev()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ClothesStorePrev() {
    // Provide a preview with dummy items
    ListInTemplate(
        items = listOf(
            ListItem(
                0,
                0.9f,
                -0.1f,
                600,
                0f,
                10f,
                "White Shoes",
                15,
                R.drawable.shoe_3
            ),
            ListItem(
                0,
                0.9f,
                -0.1f,
                600,
                0f,
                10f,
                "Yellow Swite Sirt",
                150,
                R.drawable.img_3
            ),
            ListItem(
                1,
                0.4f,
                0.1f,
                400,
                1.5f,
                9f,
                "Baby Boy",
                100,
                R.drawable.img_bayboy_switeshirt
            ),
            ListItem(
                2,
                0.2f,
                0.2f,
                200,
                3f,
                8f,
                "Blazer Man",
                1700,
                R.drawable.img_balzer_man
            ),
            ListItem(
                3,
                0f,
                0f,
                0,
                3f,
                0f,
                "Green Blouse",
                8,
                R.drawable.img_green_blouse
            ),
            ListItem(
                4,
                4f,
                -1f,
                0,
                0f,
                0f,
                "Baby Short and Shirt",
                4,
                R.drawable.img_bayboy_short_shirt
            )
        )
    )
}
```
# License
```MIT License

Copyright (c) 2024 Doaa Mosalam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
