node {

     stage('Initialize')
    {
        def dockerHome = tool 'docker'
        def mavenHome  = tool 'Maven'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }

  stage("Clone the project") {
    git branch: 'dev', url: 'https://github.com/naresh546nk/spring-boot-validator.git'
  }

  stage("Compilation") {
    sh "docker -v"
    sh "chmod +777 mvnw*"
    sh "./mvnw clean install"
  }

  stage("Tests and Deployment") {
    stage("Runing unit tests") {
      sh "./mvnw test"
    }
    stage("Push to dockerHub") {
      sh 'docker -v'
    }
  }
}