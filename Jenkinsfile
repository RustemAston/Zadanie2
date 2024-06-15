pipeline {

    agent any
    
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/RustemAston/Zadanie2'

                // Run Maven on a Unix agent.
                sh "mvn -DskipTests=true package" 
                sh "ls -l target"
                
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('run') {
            steps {
                sh "cp /var/lib/jenkins/workspace/task_aston/target/simple_rest.jar /opt/tomcat/webapps/"
                //sh "sudo systemctl restart tomcat"
            }
        }
    }
}
