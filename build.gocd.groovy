import cd.go.contrib.plugins.configrepo.groovy.dsl.GoCD

GoCD.script {
  pipelines {
    pipeline('gocd-groovy-dsl-plugin') {
      group = "tests"

      materials {
        git {
          url = 'git@github.com:videocursoscloud/curso_gocd_2019.git'
        }
      }
      stages {
        stage('build') {
          jobs {
            job('build') {
              tasks {
                bash {
                  commandString = 'echo hello world'
                }
              }
           }
        }
     }
  }
}

