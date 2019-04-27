/*
 * This file was automatically exported by the GoCD Groovy DSL Plugin.
 */

def gitURL = "https://github.com/grails/grails-core.git"
def command = "git ls-remote -h $gitURL"


def gettags = (command).execute()
return gettags.text.readLines().collect { 
  it.split()[1].replaceAll('refs/heads/', '').replaceAll('refs/tags/', '').replaceAll("\\^\\{\\}", '')
}
