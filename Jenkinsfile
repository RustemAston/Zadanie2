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
                git branch: 'main', url: 'https://github.com/RustemAston/Zadanie2.git'

                // line to start Maven on Ubuntu
                sh "mvn -DskipTests=true package" 
                }
        }

        stage('Test') {
            steps {
                sh "cp /var/lib/jenkins/workspace/simple_rest.jar /opt/tomcat/webapps/"
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
