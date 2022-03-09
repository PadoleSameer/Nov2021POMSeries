pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build'
            }
        }
        stage("Run UTs") {
            steps {
                echo 'Run UTs'
            }
        }
        
        stage("Deply to QA") {
            steps {
                echo 'Deply to QA'
            }
        }
        stage("Run Automation Test") {
            steps {
                echo 'Run Automation Test'
            }
        }
        
        stage("Deploy to Stage") {
            steps {
                echo 'Deploy to Stage'
            }
        }
        
         stage("Run Sanity") {
            steps {
                echo 'Run Sanity'
            }
        }
        
         stage("Deploy to prod") {
            steps {
                echo 'Deploy to prod'
            }
        }
        
    }
}
