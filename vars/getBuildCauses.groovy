import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption
import jenkins.model.*


def call() {
    // https://stackoverflow.com/a/47139746/4763512
    jenkins = Jenkins.instance

    // https://stackoverflow.com/a/47652580/4763512
    Jenkins.instance.getAllItems(AbstractProject.class).each {
        hudson.model.Cause cause = it.getLastBuild().getCause(hudson.model.Cause.class)
        println "Is triggered by user: " + (cause.class == hudson.model.Cause.UserIdCause.class)
    }


    // https://stackoverflow.com/a/49901413/4763512
    Run previousBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    currentBuild.rawBuild.getCauses().each {
        if (cause instanceof Cause.UserIdCause) {
            echo ">> Cause.UserIdCause"
        }
        if (cause instanceof Cause.RemoteCause) {
            echo ">> Cause.RemoteCause"
        }
        if (cause instanceof Cause.UpstreamCause) {
            echo ">> Cause.UpstreamCause"
        }
    }
}
