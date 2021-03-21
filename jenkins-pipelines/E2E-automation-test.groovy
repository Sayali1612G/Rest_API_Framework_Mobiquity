#!groovy
node {
    stage('Git checkout') { // for display purposes
        git ''
    }
    stage('Smoke') {
        try {
            bat "mvn clean install -Dcucumber.options='--tags @Smoke'"
        } catch (err) {

        } finally {
            //publishHTML 
        }
    }
    stage('API') {
        try {
            bat "mvn clean install -Dcucumber.options='--tags @API_Restassured_Scenario'"
        } catch (err) {

        } finally {
            //publishHTML 
        }
    }
    
    stage('Results') {
        junit '**/target/cucumber-reports/*/*.xml'
    }
}