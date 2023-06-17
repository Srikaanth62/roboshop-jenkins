def call() {
    pipeline {
        agent {
            node {
                label 'workstation'
            }
        }
        options {
            ansiColor ('xterm')
        }

        stages {
            stage ('code compile'){
                steps {
                    sh 'mvn compile'
                }
            }
            stage ('code quality') {
                steps {
                    sh 'ls -l'
                    sh 'sonar-scanner -Dsonar.projectKey=${component} -Dsonar.host.url=http://172.31.94.42:9000/ -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.qualitygate.wait=true '
                }
            }
            stage ('Unit test'){
                steps {
                    sh 'echo unit test'
                }
            }
            stage ('checkmarx security scan'){
                steps {
                    sh 'echo checkmarx SAST'
                }
            }
            stage ('checkmarx SCA scan'){
                steps {
                    sh 'echo checkmarx SCA'
                }
            }


        }
        post {
            always {
                cleanWs()
            }
        }

    }
    }



