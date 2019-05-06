pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn package'
      }
    }
  }
  tools {
    maven 'apache-maven-3.0.1'
  }
}