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
                agent { docker { image 'maven:3.9.7-eclipse-temurin-17-alpine' } }
            steps {
                sh 'mvn --version'
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
