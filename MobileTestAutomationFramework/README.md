# Mobile Test Automation Framework

A comprehensive framework for mobile app test automation using Appium, TestNG, and Java.

## Features

- Cross-platform support for Android and iOS
- Page Object Model design pattern
- Component-based architecture for reusable UI elements
- TestNG for test execution and reporting
- Log4j2 for logging
- Maven for dependency management and build
- Configurable test environments
- Screenshot capture on test failure

## Project Structure

```
mobile-test-automation-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── components/       # Reusable UI components
│   │   │   ├── constants/        # Application constants
│   │   │   ├── global/           # Base classes and utilities
│   │   │   ├── pages/            # Page objects
│   │   │   └── utilities/        # Helper utilities
│   │   └── resources/
│   │       └── log4j2.xml        # Logging configuration
│   └── test/
│       ├── java/
│       │   ├── base/             # Test base classes
│       │   └── tests/            # Test classes
│       └── resources/
│           ├── testng.xml        # Main TestNG configuration
│           ├── android-testng.xml # Android-specific tests
│           └── ios-testng.xml    # iOS-specific tests
├── properties/
│   └── app.properties            # Application configuration
├── pom.xml                       # Maven configuration
├── setup-github.sh               # GitHub setup script
├── verify-and-run.sh             # Build verification script
└── README.md                     # Project documentation
```

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven 3.8.0 or higher
- Appium Server 2.0 or higher
- Android SDK (for Android testing)
- Xcode (for iOS testing)
- Real devices or emulators/simulators

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/mobile-test-automation-framework.git
   ```

2. Install dependencies:
   ```
   cd mobile-test-automation-framework
   mvn clean install -DskipTests
   ```

### Configuration

1. Update the `properties/app.properties` file with your app details and test environment settings.
2. Place your app files in the appropriate location as specified in the properties file.

### Running Tests

Run all tests:
```
mvn test
```

Run Android tests only:
```
mvn test -Pandroid
```

Run iOS tests only:
```
mvn test -Pios
```

Run smoke tests:
```
mvn test -Psmoke
```

Run regression tests:
```
mvn test -Pregression
```

## Framework Components

### Page Objects

The framework uses the Page Object Model design pattern to represent screens in the mobile app as objects in the test code. Each page object contains:

- WebElement locators
- Methods to interact with the page
- Verification methods

Example:
```java
public class LoginPage extends PageUtils {
    
    @AndroidFindBy(id = "username_input")
    @iOSXCUITFindBy(accessibility = "username_input")
    private WebElement usernameInput;
    
    // Methods to interact with the login page
    public LoginPage enterUsername(String username) {
        sendKeys(usernameInput, username);
        return this;
    }
}
```

### Reusable Components

UI components that appear across multiple screens are implemented as reusable components:

```java
public class ButtonComponent extends PageUtils {
    
    public boolean clickButton(WebElement button, String buttonName) {
        try {
            click(button);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
```

### Test Base Classes

All test classes extend the BaseTest class, which provides:

- Driver initialization
- Common setup and teardown methods
- Screenshot capture on failure

### Utilities

Helper classes for common operations:

- JavaUtils: Common Java operations
- LoggerUtils: Logging utilities

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request
