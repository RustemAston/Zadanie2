pipeline {
    agent any

    stages {
        stage('SCM Checkout') {
            steps {
                git branch: 'main', credentialsId: 'jk-gh-tk', url: '<https://github.com/**devopscloudbootcamp**/jk-private-gh.git>'
            }
        }
    }
}
