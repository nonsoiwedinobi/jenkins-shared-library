def call(String imageTag = 'latest') {
    echo "building the docker image..."

    withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub-repo',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )
    ]) {
        sh "docker build -t devnonso/demo-app:${imageTag} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push devnonso/demo-app:${imageTag}"
    }
}
