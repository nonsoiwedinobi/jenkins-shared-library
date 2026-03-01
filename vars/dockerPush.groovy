#!/usr/bin/env groovy

def call(String imageName) {

    echo "Pushing Docker image ${imageName}..."

    sh "docker push ${imageName}"
}
