pipeline{
    agent any
      tools {
        maven 'maven-3.6.3'
      }
        stages{
            stage("build"){
                steps{
                echo "building the application "
                 sh 'mvn clean package'

                }
            }
            stage("test"){
                steps{
                    echo "testing the application "
                }
            }
            stage("deploy"){
                steps{
                    echo "deploying the application "
                }
            }

        }
}