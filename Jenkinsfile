node {
  stage("Clone the project") {
    git branch: 'dev', url: 'https://github.com/naresh546nk/spring-boot-validator.git'
  }

  stage("Compilation") {
    sh "chmod +777 mvnw*"
    sh "./mvnw clean install"
  }

  stage("Tests and Deployment") {
    stage("Runing unit tests") {
      sh "./mvnw test"
    }
    stage("Deployment") {
      sh './mvnw spring-boot:run -Dserver.port=8001 &'
    }
  }
}