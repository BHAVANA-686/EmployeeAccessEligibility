pipeline {
    agent any

    stages {

        stage('Checkout Git') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/BHAVANA-686/EmployeeAccessEligibility.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}