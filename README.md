<h1 align="center">Mobile Programming Course</h1>

<details> <summary><h2>📚 Table of Contents</h2></summary>

- [Overview](#-overview)
- [Projects](#-projects)
  - [1. Personal Card](#1-personal-card)
  - [2. Hafez Fal](#2-hafez-fal)
  - [3. Book Reader](#3-book-reader)
  - [4. Currency Exchange](#4-currency-exchange)
  - [5. Weather Forecast](#5-weather-forecast)
- [Technologies Used](%EF%B8%8F-technologies-used)
- [Installation & Setup](#%EF%B8%8F-installation--setup)
- [Learning Outcomes](#-learning-outcomes)
- [Project Information](#%E2%84%B9%EF%B8%8F-project-information)
- [Contact](#-contact)

</details>

## 📘 Overview

A collection of **5 Android applications** developed using **Kotlin** as part of the Mobile Programming course. Each project demonstrates progressive skill development in Android development, from basic UI layouts to advanced features like API integration and MVVM architecture.

**Key Features:**
- Native Android development with Kotlin
- Material Design implementation
- RESTful API integration (Retrofit)
- RecyclerView and custom adapters
- MVVM architecture pattern
- Responsive UI/UX design

[![Kotlin](https://img.shields.io/badge/Kotlin-1.8+-purple.svg)](https://kotlinlang.org/) [![Android](https://img.shields.io/badge/Android-SDK%2033-green.svg)](https://developer.android.com/) [![License](https://img.shields.io/badge/License-Educational-lightgrey.svg)](#license)

## 📱 Projects

### 1. Personal Card
**Description:** A digital business card application displaying personal information with a clean, professional layout.

**Features:**
- Custom UI layout with personal photo
- Material Design components
- Profile information display

**Key Concepts:**
- XML layouts
- ImageView and TextViews
- Basic Android UI components

📁 **Path:** `1- Personal Card/Personal_card/`

<div align="center">
  <img src="1- Personal Card/screen shots/Program_view.png" alt="Personal Card Screenshot" width="300"/>
</div>

---

### 2. Hafez Fal
**Description:** Traditional Persian fortune-telling app using Hafez poetry (Fal-e Hafez).

**Features:**
- Random poem selection
- Persian text display
- Custom splash screen
- Information page about Hafez

**Key Concepts:**
- Multiple activities
- Intent navigation
- String resources (Persian language)
- Random data generation

📁 **Path:** `2- Hafez Fal/Hafez_Fal/`  
📦 **APK:** Available in project folder

<div align="center">
  <img src="2- Hafez Fal/screen shots/intro.png" alt="Hafez Fal Intro" width="250"/>
  <img src="2- Hafez Fal/screen shots/fal1.png" alt="Hafez Fal 1" width="250"/>
  <img src="2- Hafez Fal/screen shots/fal2.png" alt="Hafez Fal 2" width="250"/>
</div>

<div align="center">
  <img src="2- Hafez Fal/screen shots/info.png" alt="Hafez Info" width="250"/>
  <img src="2- Hafez Fal/screen shots/Apps list.png" alt="Apps List" width="250"/>
</div>

---

### 3. Book Reader
**Description:** A book catalog application with grid/list view toggle and detailed book information.

**Features:**
- RecyclerView with custom adapter
- Grid and List layout switching
- Book detail activity
- Custom card layouts
- Hardcoded book database

**Key Concepts:**
- RecyclerView implementation
- ViewHolder pattern
- Intent data passing
- Menu items (layout switcher)
- Data classes (Book model)
- Multiple activities

**Sample Books:**
- Deep Work
- No Excuses
- The Alchemist
- The Zahir
- Parallel Worlds

📁 **Path:** `3- Book Reader/hw3/`  
📦 **APK:** `app-debug.apk`

<div align="center">
  <img src="3- Book Reader/screen shots/sc1.png" alt="Book Reader Grid View" width="250"/>
  <img src="3- Book Reader/screen shots/sc2.png" alt="Book Reader List View" width="250"/>
  <img src="3- Book Reader/screen shots/sc3.png" alt="Book Detail" width="250"/>
</div>

<div align="center">
  <img src="3- Book Reader/screen shots/sc4.png" alt="Book Detail 2" width="250"/>
  <img src="3- Book Reader/screen shots/sc5.png" alt="Book List" width="250"/>
  <img src="3- Book Reader/screen shots/sc6.png" alt="Book Grid" width="250"/>
</div>

---

### 4. Currency Exchange
**Description:** Real-time currency exchange rate application.

**Features:**
- Currency conversion calculator
- Exchange rate display
- Clean, intuitive UI
- MVVM architecture pattern

**Key Concepts:**
- ViewModel implementation
- LiveData
- Data binding
- MVVM pattern
- ExchangeViewModel class

📁 **Path:** `4- Currency Exchange/HW4/`  
📦 **APK:** `app-debug.apk`

<div align="center">
  <img src="4- Currency Exchange/screen shots/1.png" alt="Currency Exchange 1" width="250"/>
  <img src="4- Currency Exchange/screen shots/2.png" alt="Currency Exchange 2" width="250"/>
  <img src="4- Currency Exchange/screen shots/3.png" alt="Currency Exchange 3" width="250"/>
</div>

<div align="center">
  <img src="4- Currency Exchange/screen shots/4.png" alt="Currency Exchange 4" width="250"/>
  <img src="4- Currency Exchange/screen shots/5.png" alt="Currency Exchange 5" width="250"/>
</div>

---

### 5. Weather Forecast
**Description:** Weather forecast application with city search and 5-day forecast display.

**Features:**
- City search with autocomplete
- 5-day weather forecast
- Weather icons and conditions
- Temperature display
- API integration (OpenWeatherMap)

**Key Concepts:**
- Retrofit HTTP client
- RESTful API integration
- JSON parsing (data classes)
- RecyclerView with weather cards
- Dropdown (AutoCompleteTextView)
- Network permissions
- Multiple data classes for API response

**Components:**
- `ApiInterface.kt` - API endpoints
- `RetrofitClient.kt` - Network client
- `WeatherItemAdapter.kt` - RecyclerView adapter
- Multiple data classes for JSON mapping

📁 **Path:** `5- Weather Forecast/HW5/`  
📦 **APK:** `app-debug.apk`  
🎥 **Demo Video:** `record screen.webm`

<div align="center">
  <img src="5- Weather Forecast/screen shots/0.png" alt="Weather Forecast Splash" width="250"/>
  <img src="5- Weather Forecast/screen shots/1.png" alt="Weather Forecast 1" width="250"/>
  <img src="5- Weather Forecast/screen shots/2.png" alt="Weather Forecast 2" width="250"/>
</div>

<div align="center">
  <img src="5- Weather Forecast/screen shots/3.png" alt="Weather Forecast 3" width="250"/>
  <img src="5- Weather Forecast/screen shots/4.png" alt="Weather Forecast 4" width="250"/>
  <img src="5- Weather Forecast/screen shots/5.png" alt="Weather Forecast 5" width="250"/>
</div>

<div align="center">
  <br/>
  <a href="5- Weather Forecast/screen shots/record screen.webm">
    <img src="5- Weather Forecast/screen shots/2.png" alt="Click to watch demo video" width="300"/>
  </a>
  <br/>
  <b>🎥 Click image above to watch full demo video</b>
</div>

## 🛠️ Technologies Used

| Category | Technologies |
|----------|-------------|
| **Language** | Kotlin |
| **Platform** | Android SDK 33+ |
| **Architecture** | MVVM (Projects 4-5) |
| **UI** | Material Design, XML Layouts |
| **Networking** | Retrofit, OkHttp |
| **Data** | LiveData, ViewModel |
| **Views** | RecyclerView, CardView |
| **Build Tool** | Gradle |

## ⚙️ Installation & Setup

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11+
- Android SDK 33+
- Gradle 7.0+

### Clone and Run

```bash
# Clone the repository
git clone https://github.com/zamirmehdi/Mobile-Programming-Course.git
cd Mobile-Programming-Course

# Open individual projects in Android Studio
# Navigate to project folder (e.g., "3- Book Reader/hw3/")
# Open in Android Studio and sync Gradle
```

### Running Individual Projects

1. Open Android Studio
2. Select **File → Open**
3. Navigate to desired project folder (e.g., `3- Book Reader/hw3/`)
4. Wait for Gradle sync to complete
5. Click **Run** or press `Shift + F10`

### Installing APKs

Pre-built APK files are available in some project folders:
- Hafez Fal: `HafezFal.apk`
- Book Reader: `app-debug.apk`
- Currency Exchange: `app-debug.apk`
- Weather Forecast: `app-debug.apk`

**Installation:**
```bash
adb install path/to/app-debug.apk
```

## 🎓 Learning Outcomes

- **Android Fundamentals**
  - Activity lifecycle
  - Intent navigation
  - XML layout design
  - Resource management

- **UI/UX Development**
  - Material Design principles
  - RecyclerView implementation
  - Custom adapters
  - Responsive layouts
  - Grid and List views

- **Architecture Patterns**
  - MVVM architecture
  - ViewModel and LiveData
  - Data binding
  - Separation of concerns

- **Networking**
  - RESTful API integration
  - Retrofit configuration
  - JSON parsing
  - HTTP requests

- **Kotlin Programming**
  - Data classes
  - Extension functions
  - Lambda expressions
  - Null safety

- **Best Practices**
  - Code organization
  - Resource separation
  - ProGuard configuration
  - Testing structure

## ℹ️ Project Information

**Author:** Amirmehdi Zarrinnezhad  
**Course:** Mobile Programming  
**University:** Amirkabir University of Technology (Tehran Polytechnic) - Fall 2022  
**Repository:** [zamirmehdi/Mobile-Programming-Course](https://github.com/zamirmehdi/Mobile-Programming-Course)

## 📧 Contact

Questions or collaborations? Feel free to reach out!

**📧 Email:** amzarrinnezhad@gmail.com  
**🌐 GitHub:** [@zamirmehdi](https://github.com/zamirmehdi)

---

<p align="right">(<a href="#top">back to top</a>)</p>

<div align="center">

⭐ **If you found this project helpful, please consider giving it a star!** ⭐

*Amirmehdi Zarrinnezhad*

</div>
