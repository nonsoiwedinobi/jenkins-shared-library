#!/usr/bin/env groovy

def call(String imageName, String imageTag) {

    echo "Building Docker image ${imageName}:${imageTag}..."

    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-repo',
        passwordVariable: 'PASS',
        usernameVariable: 'USER'
    )]) {

        sh """
        docker build -t ${imageName}:${imageTag} .
        echo \$PASS | docker login -u \$USER --password-stdin
        docker push ${imageName}:${imageTag}
        """
    }
}
