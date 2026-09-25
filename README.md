# End-to-End Automation Testing Framework - Automation Test Store

An automated testing framework built for the [Automation Test Store](https://www.automationteststore.com/) e-commerce platform. This project implements end-to-end (E2E) testing scenarios using Java, Selenium WebDriver, and TestNG, adhering strictly to the **Page Object Model (POM)** design pattern.

---

## 🛠️ Tech Stack & Tools
* **Language:** Java (JDK 21)
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **IDE:** Eclipse

---

## 📋 Test Scenarios Covered (TC_ATS_001 to TC_ATS_015)
The framework automates 15 core test cases, ensuring complete application quality:
1. **Homepage Verification** (TC_ATS_001)
2. **User Registration Process** (TC_ATS_002)
3. **User Login Functionality** (TC_ATS_003)
4. **Product Search** (TC_ATS_004)
5. **Filtering Search Results** (TC_ATS_005)
6. **Viewing Product Details** (TC_ATS_006)
7. **Adding Products to Cart** (TC_ATS_007)
8. **Viewing & Modifying Shopping Cart** (TC_ATS_008)
9. **Proceeding to Checkout** (TC_ATS_009)
10. **Applying Discount Codes** (TC_ATS_010)
11. **Viewing Order History** (TC_ATS_011)
12. **Managing Account Information** (TC_ATS_012)
13. **Submitting Product Reviews** (TC_ATS_013)
14. **Newsletter Subscription** (TC_ATS_014)
15. **Account Logout** (TC_ATS_015)

---

## 🏗️ Project Architecture
```text
AutomationTestStore/
│
├── src/
│   ├── pages/         # Page Object Model classes (UI elements & actions)
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   └── ProductPage.java
│   │
│   └── tests/         # TestNG test scripts
│       ├── HomeTest.java
│       ├── LoginTest.java
│       └── ProductTest.java
│
└── pom.xml            # Maven dependencies