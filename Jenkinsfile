pipeline {
	agent any
	stages {
		stage("Clean Workspace") {
			steps {
				echo "Clean Workspace"
				cleanWs()
			}
		}
		stage("Checkout") {
			steps {
				echo "Checkout repository"
				checkout([$class: 'GitSCM', branches: [[name:
					'*/main']], extensions: [],
					userRemoteConfigs: [[url:
					'https://github.com/JoeRabitt/DevOpsDemo.git']]])
			}
		}
		stage("Build") {
			steps {
				sh './backend/gradlew -p backend test'
				nodejs('NodeJS 20.10.0') {
					sh '''npm install --prefix frontend
					    npm run build --prefix frontend'''
				}
			}
		}
	}
}