pipeline {
    agent any
    environment {
        APP_NAME = "task-management-api"
        COMPOSE_FILE = "docker-compose.yml"
        HEALTH_URL = "http://localhost:8080/actuator/health"
    }
    options {
        timestamps()
        disableConcurrentBuilds()
    }
    stages {
        stage('Checkout') {
            steps {
               echo "cloning repository"
               
               git url: 'https://github.com/vasanthan-hub/task-management-api.git', branch: 'main'
            }
        }
        stage('preparing environment') {
            steps {
                echo "adding permission to script files"
                sh 'chmod +x ./scripts/*.sh'
            }     
        }
        stage('Building Application') {
            steps {
                echo 'Building spring boot application'
                sh './scripts/build.sh'
            }
        }
        stage('Docker Compose deploy') {
            steps {
                echo 'Deploying application using docker compose'
                sh './scripts/deploy.sh'
            }
        }
        stage('Wait for startup'){
            steps {
                echo 'Waiting for application to start'
                sh 'sleep 20'
            }

        }
        stage('Health check'){
            steps {
                echo 'Performing health check'
                sh './scripts/health-check.sh'
            }
        }
        stage('Docker post deployment info'){
            steps {
                echo 'checking running containers'
                sh 'docker ps'

                echo 'checking logs'
                sh 'docker compose logs --tail=50'
            }
        }
        
    }
    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed. Please check the logs for details.'
        }
        always {
            echo 'Pipeline execution completed'
        }
    }
}
