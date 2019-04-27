/*
 * This file was automatically exported by the GoCD Groovy DSL Plugin.
 */

def gitURL = "https://github.com/grails/grails-core.git"
def command = "git ls-remote -h $gitURL"

def branches = proc.in.text.readLines().collect { 
    it.replaceAll(/[a-z0-9]*\trefs\/heads\//, '') 
}

println branches

