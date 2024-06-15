pipeline {
    agent any

    environment {
        TOMCAT_USER = 'your-tomcat-user'
        TOMCAT_PASS = 'your-tomcat-password'
        TOMCAT_URL = http://localhost:8085
        REPO_URL = https://github.com/RustemAston/Zadanie2
        BRANCH = master
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${env.BRANCH}", url: "${env.REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def warFile = opt/tomcat/webapps/simple_rest.war
                    def tomcatDeployUrl = "${env.TOMCAT_URL}/manager/text/deploy?path=/your-app&update=true"
                    sh """
                            curl -u --upload-file ${warFile} ${tomcatDeployUrl}
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment succeeded!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
