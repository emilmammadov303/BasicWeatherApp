# Content

* Screens
* Technologies
* Get Started

# Get Started

## 1. System Requirements

* Globally Installed node
* Globally Installed react-native CLI and SDK ("Building Projects with Native Code" panel)

## 2. Installation

On the command prompt run the following commands

<code> $ git clone https://github.com/altuga/sliconf-mobil.git </code>

<code> $ npm install </code>

<code> $ react-native link </code>

## 3. Simulate for Android

* Make sure you have an Android emulator installed and running.
* Go to your project file path in terminal.
* Run the following command in your terminal.

<code> cd android </code>

<code> gradlew clean --debug </code>

<code> gradlew clean </code>

<code> cd .. </code>

<code> react-native run-android </code>

* If the application does not work on simulator check BUG title in this ReadMe.

# BUG

Edit YOUR_PROJECT_PATH\node_modules\react-native-navigation\android\app\build.gradle file.

<code> testOptions { 
        unitTests.all { t ->
            reports {
                html.enabled true
            }
            testLogging {
                events "passed", "skipped", "failed", "standardOut", "standardError"
            }
            afterSuite { desc, result ->
                if (!desc.parent) { // will match the outermost suite
                    def output = "      ${result.resultType} (${result.successfulTestCount} successes, ${result.failedTestCount} failures, ${result.skippedTestCount} skipped)     "
                    def repeatLength = output.length()
                    println '\n' + ('-' * repeatLength) + '\n' + output + '\n' + ('-' * repeatLength) + '\n'

                    println "see report at file://${t.reports.html.destination}/index.html"
                }
            }
        }
    }
} </code>