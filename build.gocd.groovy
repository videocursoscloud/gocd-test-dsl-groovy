/*
 * This file was automatically exported by the GoCD Groovy DSL Plugin.
 */

GoCD.script {
  pipelines {
    pipeline('ep_6') {
      group = 'tests'
      labelTemplate = '${COUNT}'
      lockBehavior = 'none'
      materials {
        git {
          branch = 'master'
          shallowClone = false
          url = 'git@github.com:videocursoscloud/curso_gocd_2019.git'
        }
      }
      stages {
        stage('build') {
          artifactCleanupProhibited = false
          cleanWorkingDir = false
          fetchMaterials = true
          approval {
          }
          jobs {
            job('build') {
              runInstanceCount = '0'
              timeout = 0
              tasks {
                exec {
                  commandLine = ['make', 'build']
                  runIf = 'passed'
                  workingDir = 'ep_6'
                }
                exec {
                  commandLine = ['make', 'tag']
                  runIf = 'passed'
                  workingDir = 'ep_6'
                }
              }
            }
          }
        }
        stage('test') {
          artifactCleanupProhibited = false
          cleanWorkingDir = false
          fetchMaterials = true
          approval {
          }
          jobs {
            job('test') {
              runInstanceCount = '0'
              timeout = 0
              tasks {
                exec {
                  commandLine = ['make', 'test']
                  runIf = 'passed'
                  workingDir = 'ep_6'
                }
                exec {
                  commandLine = ['make', 'test_clean']
                  runIf = 'any'
                  workingDir = 'ep_6'
                }
              }
            }
          }
        }
        stage('push') {
          artifactCleanupProhibited = false
          cleanWorkingDir = false
          fetchMaterials = true
          approval {
          }
          jobs {
            job('push') {
              runInstanceCount = '0'
              timeout = 0
              tasks {
                exec {
                  commandLine = ['make', 'push']
                  runIf = 'passed'
                  workingDir = 'ep_6'
                }
              }
            }
          }
        }
      }
    }
  }
}


