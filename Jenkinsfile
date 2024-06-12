pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/RustemAston/Zadanie2.git'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository from GitHub
                git branch: 'master', url: "${env.GIT_REPO}"
            }
        }

        stage('Build') {
            steps {
                // Build steps here, e.g., using Maven or Gradle
                echo 'Building the project...'
                // sh 'mvn clean install' // Uncomment and modify this line based on your build tool
            }
        }

        stage('Test') {
            steps {
                // Test steps here
                echo 'Running tests...'
                // sh 'mvn test' // Uncomment and modify this line based on your test tool
            }
        }

        stage('Deploy') {
            steps {
                // Deployment steps here
                echo 'Deploying the project...'
                // Add your deployment steps here, e.g., copying files, deploying to a server, etc.
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
