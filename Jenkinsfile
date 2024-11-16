pipeline {
  agent any
  
  tools {
    maven 'Maven'
  }
  
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Construir aplicacion') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Pruebas') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit '**/target/surefire-reports/*.xml'
        }
      }
    }
    stage('Construir imagen') {
      steps {
        sh 'docker build -t java-demo:latest .'
      }
    }
    stage('Despliegue') {
      steps {
        dir('terraform') {
          sh '''
            terraform init
            terraform plan
            terraform apply -auto-approve
          '''
        }
      }
    }
  }
}