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
                    sh 'echo code compile'
                }
            }
            stage ('code quality'){
                steps {
                    sh 'echo code quality'
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



